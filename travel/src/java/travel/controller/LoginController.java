/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
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
public class LoginController {

    @RequestMapping(value = "/customlogin", method = RequestMethod.GET)
    public ModelAndView login(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customlogin");
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
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            String arr[]=sb.toString().split("\\|");
            ServletOutputStream out = response.getOutputStream();
            if(arr.length==2){
                int check=User.login(arr[0], arr[1]);
                if(check==-1){
                    out.print("username");
                }else if(check==-2){
                    out.print("password");
                }else{
                    HttpSession session = request.getSession();
                    session.setAttribute("username",arr[0] );
                    out.print("http://localhost:8080/travel/custommain.htm");
                }
            }else{
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
