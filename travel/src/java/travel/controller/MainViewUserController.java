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
        
        Landscape l = new Landscape();
        List listTopLandscape = l.getTop(6);
        ArrayList listTopLandtemp=new ArrayList();
        int sizeL = listTopLandscape.size();
        for (int i = 0; i < sizeL; i++) {
            Landscape temp = (Landscape) listTopLandscape.get(i);
            listTopLandtemp.add(new Landtemp(temp));
        }
        
        Festival f = new Festival();
        List listTopFestival = f.getTop(6);
        ArrayList listTopFesTemp =new ArrayList();
        int siezF = listTopFestival.size();
        for (int i = 0; i < siezF; i++) {
            Festival temp = (Festival) listTopFestival.get(i);
            listTopFesTemp.add(new FestivalTemp(temp));
        }
        
        Posts p = new Posts();
        List listTopPosts = p.getTop(6);
        ArrayList listTopPostsTemp = new ArrayList<PostsTemp>();
        for (int i = 0; i < listTopPosts.size(); i++) {
            Posts temp = (Posts) listTopPosts.get(i);
            listTopPostsTemp.add(new PostsTemp(temp));
        }
        List listD=Destination.getLazyAllListDesInstance();
        mm.put("lisD", listD);
        mm.put("topland", listTopLandtemp);
        mm.put("topFes", listTopFesTemp);
        mm.put("topPost", listTopPostsTemp);
        mv.setViewName("custommain");
        return mv;
    }


        
}
