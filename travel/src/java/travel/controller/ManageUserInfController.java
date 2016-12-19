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
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class ManageUserInfController {

    @RequestMapping(value = "/customupdateinfuser", method = RequestMethod.GET)
    public ModelAndView updateinf(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customupdateinfuser");
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            HttpServletResponse httpResponse = (HttpServletResponse) response;
            if (username != null) {
                User u = User.getUserByUserName(username);
                if (u.getFacebookId() == null || u.getFacebookId().isEmpty()) {
                    System.out.println("ducvu: user name " + u.getFacebookId());
                    String profile = "img/users/profile/" + u.getIdUser() + ".png";
                    mm.put("profile", profile);
                    mm.put("user", u);
                }else{
                    response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
                }
            } else {
                response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "/customupdateinf", method = RequestMethod.POST)
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
            if (arr.length == 2) {
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                if (username != null) {
                    User u = User.getUserByUserName(username);
                    u.setFullname(arr[0]);
                    u.setPassword(arr[1]);
                    u.update();
                    request.removeAttribute("username");
                    String absoluteDiskPath = session.getServletContext().getRealPath("img/users/temp");
                    String absoluteDiskPathNew = session.getServletContext().getRealPath("img/users/profile");
                    File newProfile = new File(absoluteDiskPath + File.separator + u.getIdUser() + ".png");
                    File oldProfile = new File(absoluteDiskPathNew + File.separator + u.getIdUser() + ".png");
                    System.out.println("ducvu: file path " + newProfile.getPath());
                    if (newProfile.exists()) {
                        System.out.println("ducvu: copy file to new" + oldProfile.getPath());
                        Files.copy(newProfile.toPath(), oldProfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    out.print("http://localhost:8080/travel/customlogin.htm");
                }
            } else {

            }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
