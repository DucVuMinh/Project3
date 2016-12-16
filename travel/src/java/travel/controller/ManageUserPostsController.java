/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import travel.controller.custom.ImageDetailTemp;
import travel.controller.custom.PostsTemp;
import travel.model.Destination;
import travel.model.Festival;
import travel.model.ImagedetailPosts;
import travel.model.Landscape;
import travel.model.Posts;
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class ManageUserPostsController {

    @RequestMapping(value = "/custommanageposts", method = RequestMethod.GET)
    public ModelAndView showManagePosts(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("custommanageposts");
        String username = (String) session.getAttribute("username");
        if (username != null) {
            User u = User.getUserByUserName(username);
            Object arrp[] = u.getPosts().toArray();
            ArrayList<PostsTemp> listp = new ArrayList();
            for (int i = 0; i < arrp.length; i++) {
                Posts ptemp = (Posts) arrp[i];
                if (ptemp.getState() != -1) {
                    listp.add(new PostsTemp(ptemp,1));
                }
            }
            mm.put("listp", listp);
            mm.put("user", u.getFullname());
        } else {
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }

        return mv;
    }

    @RequestMapping(value = "/writeposts", method = RequestMethod.GET)
    public ModelAndView showWritePosts(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("writeposts");
        String username = (String) session.getAttribute("username");
        if (username != null) {
            List lisDes = Destination.getLazyAllListDes();
            mm.put("lisDes", lisDes);
            System.out.println("ducvu: " + lisDes.size());

        } else {
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }

        return mv;
    }



    @RequestMapping(value = "/customeditposts", method = RequestMethod.GET)
    public ModelAndView showEditPosts(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        try {
            String idl = (String) (request.getParameter("id"));
            Posts p = Posts.getPostsById(Integer.valueOf(idl));
            ArrayList listImgDetail = new ArrayList<String>();
            ArrayList commentSet = new ArrayList<>();
            if (p.getImagedetailPostses() != null) {
                for (Object temp : p.getImagedetailPostses()) {
                    ImagedetailPosts imgtemp = (ImagedetailPosts) temp;
                    listImgDetail.add(new ImageDetailTemp(imgtemp.getIdImage(), 3));
                }
            }
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            User u = User.getUserByUserName(username);
            PostsTemp ptemp;
            ptemp = new PostsTemp(p);
            if (u.getIdUser() == p.getUserPost().getIdUser()) {
                mm.put("infpos", ptemp);
                mm.put("imgDetail", listImgDetail);
            } else {
                response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }
        mv.setViewName("customeditposts");
        return mv;
    }

    @RequestMapping(value = "/deleteimgposts", method = RequestMethod.POST)
    public void deletePostsImg(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            int idimg = Integer.valueOf(sb.toString());
            ServletOutputStream out = response.getOutputStream();
            ImagedetailPosts imgdetail = ImagedetailPosts.getImageDetailPostsId(idimg);
            imgdetail.delete();
            out.println("ok");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @RequestMapping(value = "/cusdeleteposts", method = RequestMethod.POST)
    public void deleteFavor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ServletOutputStream out = response.getOutputStream();
        try {
            String username = (String) session.getAttribute("username");
            if (username != null) {
                User u = User.getUserByUserName(username);
                StringBuilder sb = new StringBuilder();
                BufferedReader br = request.getReader();
                String str = null;
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
                String arr[] = sb.toString().split("=");
                int idPosts = Integer.valueOf(arr[1]);
                Posts p = Posts.getPostsById(idPosts);
                System.out.println("ducvu: " + sb.toString());
                p.delete();

                out.println("done");
            } else {
                out.println("login");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("requestlogin.htm");
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("requestlogin.htm");
        }
    }
}
