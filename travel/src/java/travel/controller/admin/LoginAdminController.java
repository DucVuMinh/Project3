/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.admin;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.model.Destination;
import travel.model.Festival;
import travel.model.Landscape;
import travel.model.Posts;
import travel.model.User;

/**
 *
 * @author vanduc
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginAdminController {

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String check = (String) session.getAttribute("logged");
        if (check == null) {
            response.sendRedirect("login.htm");
        } else {
            response.sendRedirect("index.htm");
        }
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap mm) {
        long totalUser = User.getCountAll();
        long totalUserFb = User.getCountFb();
        long totalDes = Destination.getCountAll();
        long totalLand = Landscape.getCountAll();
        long totalFes = Festival.getCountAll();
        long totalPosts = Posts.getCountAll();
        mm.put("totalUser", totalUser);
//        mm.put("totalUserFb", totalUserFb);
//        mm.put("totalDes", totalDes);
        mm.put("totalLand", totalLand);
        mm.put("totalFes", totalFes);
        mm.put("totalPosts", totalPosts);
        return "admin/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String check = (String) session.getAttribute("logged");
        if (check == null) {
            return "admin/login";
        } else {
            return "redirect:/admin/index.htm";
        }
    }

    @RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
    public String validateLogin(ModelMap mm, HttpServletRequest request, HttpServletResponse response, final RedirectAttributes redirectAttributes) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("logged", "true");
            return "redirect:/admin/index.htm";
        } else {
            redirectAttributes.addFlashAttribute("username", username);
            redirectAttributes.addFlashAttribute("password", password);
            redirectAttributes.addAttribute("login", "false");
            return "redirect:/admin/login.htm";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "admin/login";
    }
}
