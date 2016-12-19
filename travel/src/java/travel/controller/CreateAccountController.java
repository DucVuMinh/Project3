/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class CreateAccountController {

    @RequestMapping(value = "/customcreateaccount", method = RequestMethod.GET)
    public ModelAndView showcreateaccount(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customcreateaccount");
        return mv;
    }

    @RequestMapping(value = "/customhandlingcreateaccount", method = RequestMethod.POST)
    public void createaccount(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            String arr[] = sb.toString().split("\\|");
            ServletOutputStream out = response.getOutputStream();
            if (arr.length == 4) {
                System.out.println("ducvu: " + arr[1] + " " + arr[3]);
                User u1 = User.getUserByUserName(arr[1]);
                User u2 = User.getUserByEmail(arr[3]);
                if (u1 != null || u2 != null) {
                    if (u1 != null && u2 == null) {
                        out.print("username");
                    } else if (u2 != null && u1 == null) {
                        out.print("email");
                    } else {
                        out.print("username");
                    }

                } else {
                    User u = new User(arr[0], arr[1], arr[2], arr[3], 1, 1);
                    u.add();
                    u.update();
                    User un=User.getUserById(u.getIdUser());
                    HttpSession session = request.getSession();
                    String absoluteDiskPathNew = session.getServletContext().getRealPath("img/users/profile");
                    File newProfile = new File(absoluteDiskPathNew + File.separator + "0.png");
                    File oldProfile = new File(absoluteDiskPathNew + File.separator + un.getIdUser() + ".png");
                    Files.copy(newProfile.toPath(), oldProfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    
                    session.setAttribute("username", un.getUsername());
                    out.print("http://localhost:8080/travel/custommain.htm");
                }
            } else {

            }
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/creatAccountFb", method = RequestMethod.GET)
    public String createAccountFb(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("name") String name,
            @ModelAttribute("facebookid") String facebookid) throws IOException {
        User u = new User(name, 1, 1, facebookid);
        u.add();
        u.update();
        System.out.println("Ducvu: "+u.getIdUser());
        User u2=User.getUserById(u.getIdUser());
        System.out.println("userlogin fb create "+u2.getIdUser());
        HttpSession session = request.getSession();
        String absoluteDiskPathNew = session.getServletContext().getRealPath("img/users/profile");
        File newProfile = new File(absoluteDiskPathNew + File.separator + "0.png");
        File oldProfile = new File(absoluteDiskPathNew + File.separator + u2.getIdUser() + ".png");
        Files.copy(newProfile.toPath(), oldProfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        session.setAttribute("username", facebookid);
        return "redirect:/custommain.htm";
    }
}
