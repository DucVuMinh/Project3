/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.model.User;

/**
 *
 * @author vanduc
 */
@Controller
@RequestMapping(value = "/admin")
public class UserManageController {
    @RequestMapping(value = "/userManage", method = RequestMethod.GET)
    public String viewLandscapeManage(ModelMap mm) {
        List<User> listUser = User.getAllListUser();
        mm.put("listUser", listUser);
        return "admin/userManage";
    }
    
    @RequestMapping(value = "/lockUser", method = RequestMethod.GET)
    public String lockUser(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        System.out.println(idUser);
        User user = User.getUserById(idUser);
        user.lock();
        List<User> listUser = User.getAllListUser();
        mm.put("listUser", listUser);
        return "redirect:/admin/userManage.htm";
    }
    
    @RequestMapping(value = "/unlockUser", method = RequestMethod.GET)
    public String unlockUser(ModelMap mm, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        System.out.println(idUser);
        User user = User.getUserById(idUser);
        user.unlock();
        List<User> listUser = User.getAllListUser();
        mm.put("listUser", listUser);
        return "redirect:/admin/userManage.htm";
    }
}
