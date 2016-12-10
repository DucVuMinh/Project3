/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import travel.controller.custom.FestivalTemp;
import travel.controller.custom.Landtemp;
import travel.model.Festival;
import travel.model.ImagedetailFestival;
import travel.model.ImagedetailLandscape;
import travel.model.Landscape;
import travel.model.Rankingfestival;
import travel.model.RankingfestivalId;
import travel.model.Rankinglandscape;
import travel.model.RankinglandscapeId;
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class FestivalController {
    @RequestMapping(value = "/customfestival", method = RequestMethod.GET)
    public ModelAndView destination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        try {
            String idl = (String) (request.getParameter("id"));
            Festival f = Festival.getFestivalById(Integer.valueOf(idl));
            ArrayList listImgDetail = new ArrayList<String>();
            for (Object temp : f.getImagedetailFestivals()) {
                ImagedetailFestival imgtemp = (ImagedetailFestival) temp;
                listImgDetail.add("http://localhost:8080/travel/img/festival/detail/" + imgtemp.getIdImage() + ".png");
            }
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            FestivalTemp ftemp;
            if (username != null) {
                User u = User.getUserByUserName(username);
                Rankingfestival userRank = Rankingfestival.
                        getRankingFestivalById(new RankingfestivalId(f.getIdFestival(), u.getIdUser()));
                if (userRank != null) {
                    ftemp = new FestivalTemp(f);
                    ftemp.setRankOfUser(userRank.getRank());
                } else {
                    ftemp = new FestivalTemp(f);
                    ftemp.setRankOfUser(5);
                }
            } else {
                ftemp = new FestivalTemp(f);
                ftemp.setRankOfUser(5);
            }
            mm.put("inffes", ftemp);
            mm.put("imgDetail", listImgDetail);
            mv.setViewName("customfestival");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    @RequestMapping(value = "/rankingfes", method = RequestMethod.POST)
    public void rankingLand(HttpServletRequest request, HttpServletResponse response){
        try {
            StringBuilder sb = new StringBuilder();
            String inputStr=request.getParameter("rankinf");
            BufferedReader br = request.getReader();
            System.out.println("ducvu: rankinf "+inputStr);
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            String arr[]=sb.toString().split("\\|");
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("text/html;charset=UTF-8");
            if(arr.length==2){
                int idfes=Integer.valueOf(arr[0]);
                Festival f=Festival.getFestivalById(idfes);
                if(f!=null){
                    HttpSession session = request.getSession();
                    String username = (String) session.getAttribute("username");
                    if(username!=null){
                        User u = User.getUserByUserName(username);
                        int rank=Integer.valueOf(arr[1]);
                        Rankingfestival userRankingfes=
                                new Rankingfestival(
                                        new RankingfestivalId(f.getIdFestival(), u.getIdUser()), f, u,rank );
                        userRankingfes.add();
                        
                        if(f.getRankingfestivals().contains(userRankingfes)){
                            f.getRankingfestivals().remove(userRankingfes);
                            f.getRankingfestivals().add(userRankingfes);
                        }else{
                            f.getRankingfestivals().add(userRankingfes);
                        }
                        
                        out.print(f.getRank()+"|"+f.getRankingfestivals().size());
                    }else{
                        out.print("login");
                    }
                }else{
                    System.out.println("landscape null");
                }
            }else{
                out.print("error");
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
