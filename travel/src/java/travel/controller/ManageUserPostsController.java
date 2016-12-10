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
import travel.model.ImagedetailPosts;
import travel.model.Posts;
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class ManageUserPostsController {
    @RequestMapping(value = "/writeposts", method = RequestMethod.GET)
    public ModelAndView showWritePosts(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        List lisDes=Destination.getLazyAllListDes();
        mm.put("lisDes",lisDes);
        System.out.println("ducvu: "+lisDes.size());
        mv.setViewName("writeposts");
        return mv;
    }
    @RequestMapping(value = "/customuserposts", method = RequestMethod.GET)
    public ModelAndView showManagePosts(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        List lisDes=Destination.getLazyAllListDes();
        mm.put("lisDes",lisDes);
        System.out.println("ducvu: "+lisDes.size());
        mv.setViewName("customuserposts");
        return mv;
    }
    @RequestMapping(value = "/customeditposts", method = RequestMethod.GET)
    public ModelAndView showEditPosts(ModelMap mm,HttpServletRequest request, HttpServletResponse response) {
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
            PostsTemp ptemp;
            ptemp = new PostsTemp(p);
            mm.put("infpos", ptemp);
            mm.put("imgDetail", listImgDetail);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        mv.setViewName("customeditposts");
        return mv;
    }
    @RequestMapping(value = "/deleteimgposts", method = RequestMethod.POST)
    public void deletePostsImg(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("call delete img ");
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            int idimg =Integer.valueOf(sb.toString());
            ServletOutputStream out = response.getOutputStream();
            ImagedetailPosts imgdetail = ImagedetailPosts.getImageDetailPostsId(idimg);
            imgdetail.delete();
            out.println("ok");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
