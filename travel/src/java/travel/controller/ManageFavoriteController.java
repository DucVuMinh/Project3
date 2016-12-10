/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import travel.model.Landscape;
import travel.model.Posts;
import travel.model.User;

/**
 *
 * @author ducvu
 */
@Controller
public class ManageFavoriteController {

    @RequestMapping(value = "/customposts", method = RequestMethod.GET)
    public ModelAndView destination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setView("custommanagefavorite");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            User u = User.getUserByUserName(username);
            Object arrLFavor[] = u.getLandscapeFavorite().toArray();
            Object arrFFavor[] = u.getLandscapeFavorite().toArray();
            Object arrPFavor[] = u.getLandscapeFavorite().toArray();
            ArrayList<Landtemp> listL = new ArrayList<>();
            ArrayList<FestivalTemp> listF = new ArrayList<>();
            ArrayList<PostsTemp> listP = new ArrayList<>();

            for (int i = 0; i < arrLFavor.length; i++) {
                Landscape temp = (Landscape) arrLFavor[i];
                if (temp.getState() == 1) {
                    listL.add(new Landtemp(temp));
                }
            }
            for (int i = 0; i < arrFFavor.length; i++) {
                Festival temp = (Festival) arrFFavor[i];
                if (temp.getState() == 1) {
                    listF.add(new FestivalTemp(temp));
                }
            }
            
            for (int i = 0; i < arrPFavor.length; i++) {
                Posts temp = (Posts) arrPFavor[i];
                if (temp.getState() == 1) {
                    listP.add(new PostsTemp(temp));
                }
            }
            mm.put("listL", listL);
            mm.put("listF", listF);
            mm.put("listP", listP);
        } else {
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }

        return mv;
    }
    
}
