/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import travel.controller.custom.FestivalTemp;
import travel.controller.custom.Landtemp;
import travel.controller.custom.PostsTemp;
import travel.model.Destination;
import travel.model.Festival;
import travel.model.ImagedetailPosts;
import travel.model.Landscape;
import travel.model.Posts;

/**
 *
 * @author DucVu
 */
@Controller
public class MainViewUserController {

    @RequestMapping(value = "/custommain", method = RequestMethod.GET)
    public ModelAndView login(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        try {
            Landscape l = new Landscape();
            List listTopLandscape = l.getTop(4);
            ArrayList listTopLandtemp = new ArrayList();
            int sizeL = listTopLandscape.size();
            for (int i = 0; i < sizeL; i++) {
                Landscape temp = (Landscape) listTopLandscape.get(i);
                listTopLandtemp.add(new Landtemp(temp,1));
            }

            Festival f = new Festival();
            List listTopFestival = f.getTop(4);
            ArrayList listTopFesTemp = new ArrayList();
            int siezF = listTopFestival.size();
            for (int i = 0; i < siezF; i++) {
                Festival temp = (Festival) listTopFestival.get(i);
                listTopFesTemp.add(new FestivalTemp(temp,1));
            }

            Posts p = new Posts();
            List listTopPosts = p.getTop(4);
            ArrayList listTopPostsTemp = new ArrayList<PostsTemp>();
            for (int i = 0; i < listTopPosts.size(); i++) {
                Posts temp = (Posts) listTopPosts.get(i);
                listTopPostsTemp.add(new PostsTemp(temp,1));
            }
            List listD = Destination.getLazyAllListDesInstance();
            mm.put("lisD", listD);
            System.out.println("ducvu: list fes "+listTopFesTemp.size());
            mm.put("topland1", listTopLandtemp.subList(0, 2));
            mm.put("topland2", listTopLandtemp.subList(2, 4));
            mm.put("topFes1", listTopFesTemp.subList(0, 2));
            mm.put("topFes2", listTopFesTemp.subList(2, 4));
            mm.put("topPost1", listTopPostsTemp.subList(0, 2));
            mm.put("topPost2", listTopPostsTemp.subList(2, 4));
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mv.setViewName("custommain");
        return mv;
    }

}
