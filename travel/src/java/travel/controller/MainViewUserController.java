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
import travel.controller.custom.LisPostsTemp;
import travel.controller.custom.ListFesTemp;
import travel.controller.custom.ListLandTemp;
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
                listTopLandtemp.add(new Landtemp(temp, 1));
            }

            Festival f = new Festival();
            List listTopFestival = f.getTop(4);
            ArrayList listTopFesTemp = new ArrayList();
            int siezF = listTopFestival.size();
            for (int i = 0; i < siezF; i++) {
                Festival temp = (Festival) listTopFestival.get(i);
                listTopFesTemp.add(new FestivalTemp(temp, 1));
            }

            Posts p = new Posts();
            List listTopPosts = p.getTop(4);
            ArrayList listTopPostsTemp = new ArrayList<PostsTemp>();
            for (int i = 0; i < listTopPosts.size(); i++) {
                Posts temp = (Posts) listTopPosts.get(i);
                listTopPostsTemp.add(new PostsTemp(temp, 1));
            }
            List listD = Destination.getLazyAllListDesInstance();
            mm.put("lisD", listD);
            System.out.println("ducvu: list fes " + listTopFesTemp.size());
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

    @RequestMapping(value = "/detailland", method = RequestMethod.GET)
    public ModelAndView detailland(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        try {
            List<ListLandTemp> listLand = new ArrayList<>();
            List allLand = Landscape.getAllInstance();
            Object arrl[] = allLand.toArray();
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
            mm.put("listLand", listLand);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mv.setViewName("detailland");
        return mv;
    }
    @RequestMapping(value = "/detailfes", method = RequestMethod.GET)
    public ModelAndView detailfes(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        try {
            List<ListFesTemp> listFes = new ArrayList<>();
            List allFes = Festival.getAllInstance();
            Object arrf[] = allFes.toArray();
            int sizeFes = arrf.length;
            int loop = 0;
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
            ListFesTemp ltemp = new ListFesTemp();
            if (loop > 0) {
                for (int i = (loop - 1) * 2; i < sizeFes; i++) {
                    ltemp.add((Festival) arrf[i]);
                }
            } else {
                for (int i = 0; i < sizeFes; i++) {
                    ltemp.add((Festival) arrf[i]);
                }
            }
            listFes.add(ltemp);
            mm.put("listFes", listFes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mv.setViewName("detailfes");
        return mv;
    }
     @RequestMapping(value = "/detailpost", method = RequestMethod.GET)
    public ModelAndView detailpost(ModelMap mm) {
        ModelAndView mv = new ModelAndView();
        try {
            List<LisPostsTemp> listPos= new ArrayList<>();
            List allPos = Posts.getAllInstance();
            System.out.println("ducvu: size post : "+allPos.size());
            Object arrp[] = allPos.toArray();
            int sizePos = arrp.length;
            int loop = 0;
            if (sizePos >= 2) {
                if (sizePos % 2 == 0) {
                    loop = sizePos / 2;
                } else {
                    loop = sizePos / 2 + 1;
                }
            }
            for (int i = 0; i < loop - 1; i++) {
                listPos.add(new LisPostsTemp((Posts) arrp[i * 2], (Posts) arrp[i * 2 + 1]));
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
            listPos.add(ptemp);
            System.out.println("ducvu: size post : "+listPos.size());
            mm.put("listPost", listPos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mv.setViewName("detailpost");
        return mv;
    }

}
