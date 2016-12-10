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
import travel.model.Destination;

/**
 *
 * @author vanduc
 */
@Controller
public class DestinationManageController {

    @RequestMapping(value = "/admin/destinationManage", method = RequestMethod.GET)
    public ModelAndView viewDestinationManage(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/destinationManage");
        List listDes = Destination.getAllListDes();
        mm.put("listDes", listDes);
        return mv;
    }

    @RequestMapping(value = "/admin/detailDestination", method = RequestMethod.GET)
    public ModelAndView viewDetailDestination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView();
        try {
            int idDestination = Integer.parseInt(request.getParameter("idDestination"));
            Destination des = Destination.getDesById(idDestination);
            view.setViewName("admin/detailDestination");
            
            mm.put("detailDes", des);
        } catch(Exception e)  {
            e.printStackTrace();  
        }

        return view;
    }
    
    @RequestMapping(value = "/admin/deleteDestination", method = RequestMethod.GET)
    public String deleteDestination(@RequestParam("idDestination") int idDestination, final RedirectAttributes redirectAttributes){
        Destination des = Destination.getDesById(idDestination);
        try {
            des.delete();
            redirectAttributes.addFlashAttribute("message","Xóa địa điểm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/destinationManage.htm";
    }
    
    @RequestMapping(value = "/admin/addDestination", method = RequestMethod.GET)
    public ModelAndView viewAddDestination(ModelMap mm){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/addDestination");
//        List listDes = Destination.getAllListDes();
//        mm.put("listDes", listDes);
        return mv;
    }
}
