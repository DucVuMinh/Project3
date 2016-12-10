/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
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
import travel.controller.custom.FestivalTemp;
import travel.controller.custom.Landtemp;
import travel.controller.custom.PostsTemp;
import travel.model.Festival;
import travel.model.ImagedetailPosts;
import travel.model.Landscape;
import travel.model.Posts;
import travel.model.User;

/**
 *
 * @author ducvu
 */
@Controller
public class ManageFavoriteController {

    @RequestMapping(value = "/custommanagefavorite", method = RequestMethod.GET)
    public ModelAndView destination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setView("custommanagefavorite");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            User u = User.getUserByUserName(username);
            Object arrLFavor[] = u.getLandscapeFavorite().toArray();
            Object arrFFavor[] = u.getFestivalFavorite().toArray();
            Object arrPFavor[] = u.getPostsFavorite().toArray();
            ArrayList<Landtemp> listL = new ArrayList<>();
            ArrayList<FestivalTemp> listF = new ArrayList<>();
            ArrayList<PostsTemp> listP = new ArrayList<>();

            for (int i = 0; i < arrLFavor.length; i++) {
                Landscape temp = (Landscape) arrLFavor[i];
                if (temp.getState() == 1) {
                    listL.add(new Landtemp(temp,1));
                }
            }
            for (int i = 0; i < arrFFavor.length; i++) {
                Festival temp = (Festival) arrFFavor[i];
                if (temp.getState() == 1) {
                    listF.add(new FestivalTemp(temp,1));
                }
            }

            for (int i = 0; i < arrPFavor.length; i++) {
                Posts temp = (Posts) arrPFavor[i];
                if (temp.getState() == 1) {
                    Posts ptemp = Posts.getPostsById(temp.getIdPosts());
                    listP.add(new PostsTemp(ptemp,1));
                }
            }
            System.out.println("ducvu: size " + listL.size() + " " + listF.size() + listP.size());
            mm.put("listL", listL);
            mm.put("listF", listF);
            mm.put("listP", listP);
        } else {
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }

        return mv;
    }

    @RequestMapping(value = "/deletefavor", method = RequestMethod.POST)
    public void deleteFavor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ServletOutputStream out = response.getOutputStream();
        System.out.println("ducvu: delete favor");
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
                String arr[] = sb.toString().split("_");
                if (arr[0].compareTo("land") == 0) {
                    u.getLandscapeFavorite().remove(Landscape.getLandscapeById(Integer.valueOf(arr[1])));
                } else if (arr[0].compareTo("fes") == 0) {
                    u.getFestivalFavorite().remove(Festival.getFestivalById(Integer.valueOf(arr[1])));
                } else {
                    u.getPostsFavorite().remove(Posts.getPostsById(Integer.valueOf(arr[1])));
                }
                u.update();

                out.println("ok");
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