package travel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import travel.controller.custom.DestinationTemp;
import travel.controller.custom.LisPostsTemp;
import travel.controller.custom.ListFesTemp;
import travel.controller.custom.ListLandTemp;
import travel.model.Destination;
import travel.model.Festival;
import travel.model.ImagedetailDestination;
import travel.model.Landscape;
import travel.model.Posts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DucVu
 */
@Controller
public class DestinationController {

    @RequestMapping(value = "/customdestination", method = RequestMethod.GET)
    public ModelAndView destination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        try {

            String idd = (String) (request.getParameter("id"));
            Destination d = Destination.getDesById(Integer.valueOf(idd));
            DestinationTemp dtemp = new DestinationTemp(d);
            if (d.getState() == 1) {

                Set imgDetail = d.getImagedetailDestinations();
                ArrayList imgdetailLink = new ArrayList();
                for (Object o : imgDetail) {
                    ImagedetailDestination img = (ImagedetailDestination) o;
                    String imglink = "img/destination/detail/" + img.getIdImage() + ".png";
                    imgdetailLink.add(imglink);

                }
                List<ListLandTemp> listLand = new ArrayList<>();
                List<ListFesTemp> listFes = new ArrayList<>();
                List<LisPostsTemp> listPost = new ArrayList<>();

                Object arrl[] = d.getLandscapeInstance().toArray();
                Object arrf[] = d.getFestivalInstance().toArray();
                Object arrp[] = d.getPostsInstance().toArray();

                int sizeLand = arrl.length;

                int loop = 0;
                if (sizeLand >= 2) {
                    if (sizeLand % 2 == 0) {
                        loop = sizeLand / 2;
                    } else {
                        loop = sizeLand / 2 + 1;
                    }
                }
                for (int i = 0; i < loop - 1; i++) {
                    listLand.add(new ListLandTemp((Landscape) arrl[i * 2], (Landscape) arrl[i * 2 + 1]));
                }
                ListLandTemp ltemp = new ListLandTemp();
                if (loop > 0) {
                    for (int i = (loop - 1) * 2; i < sizeLand; i++) {
                        ltemp.add((Landscape) arrl[i]);
                    }
                } else {
                    for (int i = 0; i < sizeLand; i++) {
                        ltemp.add((Landscape) arrl[i]);
                    }
                }
                listLand.add(ltemp);

                int sizeFes = arrf.length;
                loop = 0;
                if (sizeFes >= 2) {
                    if (sizeFes % 2 == 0) {
                        loop = sizeFes / 2;
                    } else {
                        loop = sizeFes / 2 + 1;
                    }
                }
                for (int i = 0; i < loop - 1; i++) {
                    listFes.add(new ListFesTemp((Festival) arrf[i * 2], (Festival) arrf[i * 2 + 1]));
                }
                ListFesTemp ftemp = new ListFesTemp();
                if (loop > 0) {
                    for (int i = (loop - 1) * 2; i < sizeFes; i++) {
                        ftemp.add((Festival) arrf[i]);
                    }
                } else {
                    for (int i = 0; i < sizeFes; i++) {
                        ftemp.add((Festival) arrf[i]);
                    }
                }
                listFes.add(ftemp);

                int sizePos = arrp.length;
                loop = 0;
                if (sizePos >= 2) {
                    if (sizePos % 2 == 0) {
                        loop = sizePos / 2;
                    } else {
                        loop = sizePos / 2 + 1;
                    }
                }
                for (int i = 0; i < loop - 1; i++) {

                    listPost.add(new LisPostsTemp((Posts) arrp[i * 2], (Posts) arrp[i * 2 + 1]));
                }
                LisPostsTemp ptemp = new LisPostsTemp();
                if (loop > 0) {
                    for (int i = (loop - 1) * 2; i < sizePos; i++) {
                        ptemp.add((Posts) arrp[i]);
                    }
                } else {
                    for (int i = 0; i < sizePos; i++) {
                        ptemp.add((Posts) arrp[i]);
                    }
                }
                listPost.add(ptemp);

                mm.put("infdes", dtemp);
                mm.put("imgdes", imgdetailLink);
                mm.put("listLand", listLand);
                mm.put("listFes", listFes);
                mm.put("listPosts", listPost);
            } else {
                response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }
        mv.setViewName("customdestination");
        return mv;
    }
}
