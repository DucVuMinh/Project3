/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author ducvu
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "requestlogin", method = RequestMethod.GET)
    public ModelAndView showrequestlogin(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("requestlogin");
        return mv;
    }
    @RequestMapping(value = "suppostlock", method = RequestMethod.GET)
    public ModelAndView showsuppostlock(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("suppostlock");
        return mv;
    }
}
