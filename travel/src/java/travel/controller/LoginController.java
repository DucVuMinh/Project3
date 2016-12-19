/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.System.out;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/customlogin", method = RequestMethod.GET)
    public ModelAndView login(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customlogin");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            response.sendRedirect("http://localhost:8080/travel/custommain.htm");
        }
        return mv;
    }

    @RequestMapping(value = "/customhello", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customhello");
        return mv;
    }

    @RequestMapping(value = "/customhandlinglogin", method = RequestMethod.POST)
    public void customHandlingLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if (username == null) {
                StringBuilder sb = new StringBuilder();
                BufferedReader br = request.getReader();
                String str = null;
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
                String arr[] = sb.toString().split("\\|");
                ServletOutputStream out = response.getOutputStream();
                if (arr.length == 2) {
                    int check = User.login(arr[0], arr[1]);
                    if (check == -1) {
                        out.print("username");
                    } else if (check == -2) {
                        out.print("password");
                    } else {
                        User u = User.getUserByUserName(arr[0]);
                        if (u.getState() == 0||u.getState() == -1) {
                            out.print("lock");
                        } else {
                            session.setAttribute("username", arr[0]);
                            out.print("http://localhost:8080/travel/custommain.htm");
                        }
                    }
                } else {
                }
            } else {
                out.print("http://localhost:8080/travel/custommain.htm");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @RequestMapping(value = "/customLoginFb", method = RequestMethod.GET)
    public String customLoginFb(@RequestParam("code") String code, ModelMap mm,
            HttpServletRequest request, HttpServletResponse response,
            final RedirectAttributes redirectAttributes) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            APIWrapper wrapper = new APIWrapper();
            String accessToken = wrapper.getAccessToken(code);
            wrapper.setAccessToken(accessToken);

            User user = wrapper.getUserFB();
            User fbExit = User.checkLoginFb(user.getFacebookId());
            boolean userExist = (fbExit != null);
            if (!userExist) {
                redirectAttributes.addFlashAttribute("name", user.getFullname());
                redirectAttributes.addFlashAttribute("facebookid", user.getFacebookId());
                return "redirect:/creatAccountFb.htm";
            }
            if (fbExit.getState() == 0||fbExit.getState() == -1) {
                return "redirect:/suppostlock.htm";
            } else {

                HttpSession session = request.getSession();
                session.setAttribute("username", user.getFacebookId());
                return "redirect:/custommain.htm";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/custommain.htm";
    }

    @RequestMapping(value = "/customhandlinglogout", method = RequestMethod.POST)
    public void customHandlingLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            ServletOutputStream out = null;
            try {
                session.removeAttribute("username");
                out = response.getOutputStream();
                out.println(1);
                session.invalidate();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("http://localhost:8080/travel/custommain.htm");
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendRedirect("http://localhost:8080/travel/custommain.htm");
                }
            }
        }

    }

}
