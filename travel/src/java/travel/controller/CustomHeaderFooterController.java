/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import travel.controller.custom.ListDesTemp;
import travel.model.Destination;

/**
 *
 * @author DucVu
 */
@Controller
public class CustomHeaderFooterController {

    @RequestMapping(value = "/customheader", method = RequestMethod.GET)
    public ModelAndView header(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String login;
        String createAccount;
        String logout;
        System.out.println("ducvu: " + username);
        if (username != null) {

            login = "hidden";
            createAccount = "hidden";
            logout = "visible";
        } else {
            login = "visible";
            createAccount = "visible";
            logout = "hidden";
        }
        mm.put("login", login);
        mm.put("createAccount", createAccount);
        mm.put("logout", logout);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customheader");
        return mv;
    }

    @RequestMapping(value = "/customfooter", method = RequestMethod.GET)
    public ModelAndView footer(ModelMap mm) {
        ArrayList<ListDesTemp> listRowDesMienBac = new ArrayList();
        List lmienbac = Destination.getLazyAllListDesByRegion(1);
        int length = lmienbac.size();
        int loop = 0;
        if (length >= 3) {
            if (length % 3 == 0) {
                loop = (length / 3);
            } else {
                loop = (length / 3) + 1;
            }
        }
        for (int i = 0; i < loop - 1; i++) {
            ListDesTemp temp = new ListDesTemp((Destination) lmienbac.get(i * 3), (Destination) lmienbac.get(i * 3 + 1), (Destination) lmienbac.get(i * 3 + 2));
            listRowDesMienBac.add(temp);
        }
        ListDesTemp ldesb = new ListDesTemp();
        if (loop > 0) {
            for (int i = (loop - 1) * 3; i < length; i++) {
                ldesb.add((Destination) lmienbac.get(i));
            }
        } else {
            for (int i = 0; i < length; i++) {
                ldesb.add((Destination) lmienbac.get(i));
            }
        }
        listRowDesMienBac.add(ldesb);
        mm.put("mienbac", listRowDesMienBac);

        List lmientrung = Destination.getLazyAllListDesByRegion(2);
        ArrayList<ListDesTemp> listRowDesMienTrung = new ArrayList();
        loop = 0;
        length = lmientrung.size();
        if (length >= 3) {
            if (length % 3 == 0) {
                loop = (length / 3);
            } else {
                loop = (length / 3) + 1;
            }
        }
        for (int i = 0; i < loop - 1; i++) {
            ListDesTemp temp = new ListDesTemp((Destination) lmientrung.get(i * 3), (Destination) lmientrung.get(i * 3 + 1), (Destination) lmientrung.get(i * 3 + 2));
            listRowDesMienTrung.add(temp);
        }
        ListDesTemp ldest = new ListDesTemp();
        if (loop > 0) {
            for (int i = (loop - 1) * 3; i < length; i++) {
                ldest.add((Destination) lmientrung.get(i));
            }
        } else {
            for (int i = 0; i < length; i++) {
                ldest.add((Destination) lmientrung.get(i));
            }
        }
        listRowDesMienTrung.add(ldest);
        mm.put("mientrung", listRowDesMienTrung);

        List lmiennam = Destination.getLazyAllListDesByRegion(3);
        ArrayList<ListDesTemp> listRowDesMienNam = new ArrayList();
        loop = 0;
        length = lmiennam.size();
        if (length >= 3) {
            if (length % 3 == 0) {
                loop = (length / 3);
            } else {
                loop = (length / 3) + 1;
            }
        }
        for (int i = 0; i < loop - 1; i++) {
            ListDesTemp temp = new ListDesTemp((Destination) lmiennam.get(i * 3), (Destination) lmiennam.get(i * 3 + 1), (Destination) lmiennam.get(i * 3 + 2));
            listRowDesMienNam.add(temp);
        }
        ListDesTemp ldesn = new ListDesTemp();
        if (loop >= 0) {
            for (int i = (loop - 1) * 3; i < length; i++) {
                ldesn.add((Destination) lmiennam.get(i));
            }
        } else {
            for (int i = 0; i < length; i++) {
                ldesn.add((Destination) lmiennam.get(i));
            }
        }
        listRowDesMienNam.add(ldesn);
        mm.put("miennam", listRowDesMienNam);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("customfooter");
        return mv;
    }
}
