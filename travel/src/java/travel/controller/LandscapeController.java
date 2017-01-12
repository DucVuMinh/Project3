/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import travel.controller.custom.Landtemp;
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
import travel.model.ImagedetailLandscape;
import travel.model.Landscape;
import travel.model.Posts;
import travel.model.Rankinglandscape;
import travel.model.RankinglandscapeId;
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class LandscapeController {

    @RequestMapping(value = "/customlandscape", method = RequestMethod.GET)
    public ModelAndView destination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        try {
            String idl = (String) (request.getParameter("id"));
            Landscape l = Landscape.getLandscapeById(Integer.valueOf(idl));
            if (l.getState() == 1) {
                ArrayList listImgDetail = new ArrayList<String>();
                for (Object temp : l.getImagedetailLandscapes()) {
                    ImagedetailLandscape imgtemp = (ImagedetailLandscape) temp;
                    listImgDetail.add("img/landscape/detail/" + imgtemp.getIdImage() + ".png");
                }

                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                Landtemp ltemp;
                if (username != null) {
                    User u = User.getUserByUserName(username);
                    Rankinglandscape userRank = Rankinglandscape.
                            getRankingLandscapeById(new RankinglandscapeId(l.getIdLandscape(), u.getIdUser()));
                    if (userRank != null) {
                        ltemp = new Landtemp(l.getIdLandscape(), l.getTitle(), l.getDiscription(),
                                l.getRankinglandscapes().size(), (int) l.getRank(), userRank.getRank());
                    } else {
                        ltemp = new Landtemp(l.getIdLandscape(), l.getTitle(), l.getDiscription(),
                                l.getRankinglandscapes().size(), (int) l.getRank(), 5);
                    }
                } else {
                    ltemp = new Landtemp(l.getIdLandscape(), l.getTitle(), l.getDiscription(),
                            l.getRankinglandscapes().size(), (int) l.getRank(), 5);
                }
                mm.put("infland", ltemp);
                mm.put("imgDetail", listImgDetail);
                System.out.println("ducvu" + ltemp.getTitle());
                mv.setViewName("customlandscape");
            } else {
                response.sendRedirect("requestlogin.htm");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("requestlogin.htm");
        }
        
        return mv;
    }

    @RequestMapping(value = "/rankingland", method = RequestMethod.POST)
    public void rankingLand(HttpServletRequest request, HttpServletResponse response) {
        try {
            StringBuilder sb = new StringBuilder();
            String inputStr = request.getParameter("rankinf");
            BufferedReader br = request.getReader();
            System.out.println("ducvu: rankinf " + inputStr);
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            String arr[] = sb.toString().split("\\|");
            ServletOutputStream out = response.getOutputStream();
            System.out.println("ducvu: test ranking landscape " + sb.toString());
            response.setContentType("text/html;charset=UTF-8");
            if (arr.length == 2) {
                int idLand = Integer.valueOf(arr[0]);
                Landscape l = Landscape.getLandscapeById(idLand);
                if (l != null) {
                    System.out.println("ducvu: " + l.getIdLandscape());
                    HttpSession session = request.getSession();
                    String username = (String) session.getAttribute("username");
                    if (username != null) {
                        User u = User.getUserByUserName(username);
                        int rank = Integer.valueOf(arr[1]);
                        Rankinglandscape userRankingLand
                                = new Rankinglandscape(
                                        new RankinglandscapeId(l.getIdLandscape(), u.getIdUser()), l, u, rank);
                        userRankingLand.add();
                        System.out.println(l.getRankinglandscapes().size());
                        if (l.getRankinglandscapes().contains(userRankingLand)) {
                            l.getRankinglandscapes().remove(userRankingLand);
                            l.getRankinglandscapes().add(userRankingLand);
                        } else {
                            l.getRankinglandscapes().add(userRankingLand);
                        }

                        out.print(l.getRank() + "|" + l.getRankinglandscapes().size());
                    } else {
                        out.print("login");
                    }
                } else {
                    System.out.println("landscape null");
                }
            } else {
                out.print("error");
            }

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @RequestMapping(value = "/addlandfavor", method = RequestMethod.POST)
    public void handlingAddFavor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = request.getReader();
            String str = null;
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if (username != null) {

                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
                //System.out.println("ducvu: " + sb.toString());
                String arr[]=sb.toString().split("=");
                int idLand = Integer.valueOf(arr[1]);
                Landscape l = Landscape.getLandscapeById(idLand);
                User u = User.getUserByUserName(username);
                if (l.getState() == 1) {
                    if (l.getUsersFavorite().contains(u)) {
                        out.print("added");
                    } else {
                        l.addToUserFavorite(u);
                        out.print("done");
                    }
                } else {
                    out.print("waitadmin");
                }
            } else {
                out.print("login");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            response.sendRedirect("requestlogin.htm");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("requestlogin.htm");
        }
    }

}
