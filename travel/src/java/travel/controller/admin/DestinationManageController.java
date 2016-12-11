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
@RequestMapping(value = "/admin")
public class DestinationManageController {

    @RequestMapping(value = "/destinationManage", method = RequestMethod.GET)
    public ModelAndView viewDestinationManage(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/destinationManage");
        List listDes = Destination.getAllListDes();
        mm.put("listDes", listDes);
        return mv;
    }

    @RequestMapping(value = "/detailDestination", method = RequestMethod.GET)
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
    
    @RequestMapping(value = "/deleteDestination", method = RequestMethod.GET)
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
    
    @RequestMapping(value = "/addDestination", method = RequestMethod.GET)
    public ModelAndView viewAddDestination(ModelMap mm, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/addDestination");
//        List listDes = Destination.getAllListDes();
//        mm.put("listDes", listDes);
        if (request.getParameterMap().isEmpty()) {
            System.out.println("rong");
        }else{
            String name = request.getParameter("name-destination");
            String domain = request.getParameter("name-domain");
            String desciption = request.getParameter("desciption");
            String profile = request.getParameter("profile");
            System.out.println(name);
            System.out.println(domain);
            System.out.println(desciption);
            Destination des = new Destination(name, domain, desciption, profile, 1);
//            if (des.add() == -1) {
//                System.out.println("cos loi");
//            }else{
//                System.out.println("Thanh cong!");
//            }
        }
        
        return mv;
    }
    
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public ModelAndView viewAddDestination(ModelMap mm){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("admin/addDestination");
////        List listDes = Destination.getAllListDes();
////        mm.put("listDes", listDes);
//        return mv;
//    }
}
