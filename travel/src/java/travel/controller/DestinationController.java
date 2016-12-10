package travel.controller;


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
    public ModelAndView destination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        try{
            String idd = (String) (request.getParameter("id"));
            Destination d=Destination.getDesById(Integer.valueOf(idd));
            DestinationTemp dtemp=new DestinationTemp(d);
            Set imgDetail=d.getImagedetailDestinations();
            ArrayList imgdetailLink=new ArrayList();
            for(Object o:imgDetail){
                ImagedetailDestination img=(ImagedetailDestination)o;
                String imglink="img/destination/detail/"+img.getIdImage()+".png";
                imgdetailLink.add(imglink);
                
            }
            List<ListLandTemp> listLand=new ArrayList<>();
            List<ListFesTemp> listFes=new ArrayList<>();
            List<LisPostsTemp> listPost=new ArrayList<>();
            
            Object arrl[]=d.getLandscapeInstance().toArray();
            Object arrf[]=d.getFestivalInstance().toArray();
            Object arrp[]=d.getPostsInstance().toArray();
            

            int sizeLand=d.getLandscapes().size();
            
            int loop;
            if(sizeLand%6==0){
                loop=sizeLand/6;
            }else{
                loop=sizeLand/6+1;
            }
            for(int i=0;i<loop-1;i++){
                
                listLand.add(new ListLandTemp((Landscape)arrl[i*6],(Landscape) arrl[i*6+1], (Landscape)arrl[i*6+2],  (Landscape) arrl[i*6+3],
                        (Landscape)arrl[i*6+4],(Landscape) arrl[i*6+5]));
            }
            ListLandTemp ltemp=new ListLandTemp();
            for(int i=(loop-1)*6;i<sizeLand;i++){
                ltemp.add((Landscape)arrl[i]);
            }
            listLand.add(ltemp);
            
            int sizeFes=d.getFestivals().size();
            
            if(sizeFes%6==0){
                loop=sizeFes/6;
            }else{
                loop=sizeFes/6+1;
            }
            for(int i=0;i<loop-1;i++){
                
                listFes.add(new ListFesTemp((Festival)arrf[i*6],(Festival) arrf[i*6+1], (Festival)arrf[i*6+2],  (Festival) arrf[i*6+3],
                        (Festival)arrf[i*6+4],(Festival) arrf[i*6+5]));
            }
            ListFesTemp ftemp=new ListFesTemp();
            for(int i=(loop-1)*6;i<sizeFes;i++){
                ftemp.add((Festival)arrf[i]);
            }
            listFes.add(ftemp);
            
            
            int sizePos=d.getPostses().size();
            
            
            if(sizePos%6==0){
                loop=sizePos/6;
            }else{
                loop=sizePos/6+1;
            }
            for(int i=0;i<loop-1;i++){
                
                listPost.add(new LisPostsTemp((Posts)arrp[i*6],(Posts) arrp[i*6+1], (Posts)arrp[i*6+2],  (Posts) arrp[i*6+3],
                        (Posts)arrp[i*6+4],(Posts) arrp[i*6+5]));
            }
            LisPostsTemp ptemp=new LisPostsTemp();
            for(int i=(loop-1)*6;i<sizePos;i++){
                ptemp.add((Posts)arrp[i]);
            }
            listPost.add(ptemp);
            
            mm.put("infdes",dtemp);
            mm.put("imgdes", imgdetailLink);
            mm.put("listLand", listLand);
            mm.put("listFes", listFes);
            mm.put("listPosts", listPost);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        mv.setViewName("customdestination");
        return mv;
    }
}
