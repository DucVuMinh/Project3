/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.admin;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.model.Festival;

/**
 *
 * @author vanduc
 */
@Controller
@RequestMapping(value = "/admin")
public class FestivalManageController {
    
    @RequestMapping(value = "/festivalManage", method = RequestMethod.GET)
    public ModelAndView viewFestivalManage(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/festivalManage");
        List listFes = Festival.getAll();
        mm.put("listFes", listFes);
        return mv;
    }
    
    @RequestMapping(value = "/deleteFestival", method = RequestMethod.GET)
    public String deleteFestival(@RequestParam("idFestival") int idFestival, final RedirectAttributes redirectAttributes){
        Festival fes = Festival.getFestivalById(idFestival);
        try {
            fes.delete();
            redirectAttributes.addFlashAttribute("message","Xóa thắng cảnh thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/festivalManage.htm";
    }
}
