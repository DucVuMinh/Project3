/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author vanduc
 */
@Controller
public class Test {
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public ModelAndView showcreateaccount(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/index");
        return mv;
    }
}