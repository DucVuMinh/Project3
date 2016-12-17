/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.model.Landscape;

/**
 *
 * @author vanduc
 */
@Controller
@RequestMapping(value = "/admin")
public class LandscapeManageController {

    @RequestMapping(value = "/landscapeManage", method = RequestMethod.GET)
    public ModelAndView viewLandscapeManage(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/landscapeManage");
        List listLand = Landscape.getAllInstance();
        mm.put("listLand", listLand);
        return mv;
    }
    
    @RequestMapping(value = "/deleteLandscape", method = RequestMethod.GET)
    public String deleteLandscape(@RequestParam("idLandscape") int idLandscape, final RedirectAttributes redirectAttributes){
        Landscape land = Landscape.getLandscapeById(idLandscape);
        try {
            land.delete();
            redirectAttributes.addFlashAttribute("message","Xóa thắng cảnh thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/landscapeManage.htm";
    }
    
    @RequestMapping(value = "/detailLandscape", method = RequestMethod.GET)
    public ModelAndView viewDetailLandscape(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            int idLandscape = Integer.parseInt(request.getParameter("idLandscape"));
            Landscape detailLand = Landscape.getLandscapeById(idLandscape);
            view.setViewName("admin/detailLandscape");

            mm.put("detailLand", detailLand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}
