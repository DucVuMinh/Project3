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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import travel.controller.custom.FestivalTemp;
import travel.controller.custom.Landtemp;
import travel.controller.custom.PostsTemp;
import travel.model.Festival;
import travel.model.Landscape;
import travel.model.Posts;

/**
 *
 * @author DucVu
 */
@Controller
public class SearchController {

    @RequestMapping(value = "/customresultsearch", method = RequestMethod.GET)
    public ModelAndView login(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        String query = (String) (request.getParameter("query"));
        query=query.replace("_", " ");
        Landscape l = new Landscape();
        List listLand = l.search(query);
        
        Festival f = new Festival();
        List listFest = f.search(query);

        Posts p = new Posts();
        List listPost = p.search(query);

        int sizeL = listLand.size();
        ArrayList listLandTemp=new ArrayList();
        for (int i = 0; i < sizeL; i++) {
            Landscape temp = (Landscape) listLand.get(i);
            listLandTemp.add(new Landtemp(temp));
        }
        ArrayList listFestTemp=new ArrayList();
        int siezF = listFest.size();
        for (int i = 0; i < siezF; i++) {
            Festival temp = (Festival) listFest.get(i);
            listFestTemp.add(new FestivalTemp(temp));
        }
        ArrayList listTopPostsTemp = new ArrayList<PostsTemp>();
        for (int i = 0; i < listPost.size(); i++) {
            Posts temp = (Posts) listPost.get(i);
            listTopPostsTemp.add(new PostsTemp(temp));
            
        }
        System.out.println("ducvu: "+listLandTemp.size());
        mm.put("land", listLandTemp);
        mm.put("fes", listFestTemp);
        mm.put("posts", listTopPostsTemp);
        mm.put("query", query);
        mv.setViewName("customresultsearch");
        return mv;
    }

}
