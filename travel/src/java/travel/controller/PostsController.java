/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import travel.controller.custom.PostsTemp;
import travel.model.Comment;
import travel.model.ImagedetailPosts;
import travel.model.Posts;
import travel.model.Rankinglandscape;
import travel.model.RankinglandscapeId;
import travel.model.Rankingposts;
import travel.model.RankingpostsId;
import travel.model.User;

/**
 *
 * @author DucVu
 */
@Controller
public class PostsController {

    @RequestMapping(value = "/customposts", method = RequestMethod.GET)
    public ModelAndView destination(ModelMap mm, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView();
        try {
            String idl = (String) (request.getParameter("id"));
            Posts p = Posts.getPostsById(Integer.valueOf(idl));
            //System.out.println("ducvu: state" +p.getState());
            if (p.getState() == 1 || p.getState() == 0) {
                ArrayList listImgDetail = new ArrayList<String>();
                ArrayList commentSet = new ArrayList<>();
                if (p.getImagedetailPostses() != null) {
                    for (Object temp : p.getImagedetailPostses()) {
                        ImagedetailPosts imgtemp = (ImagedetailPosts) temp;
                        listImgDetail.add("http://localhost:8080/travel/img/posts/detail/" + imgtemp.getIdImage() + ".png");
                    }
                }
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                PostsTemp ptemp;
                if (username != null) {
                    User u = User.getUserByUserName(username);
                    Rankinglandscape userRank = Rankinglandscape.
                            getRankingLandscapeById(new RankinglandscapeId(p.getIdPosts(), u.getIdUser()));
                    if (userRank != null) {
                        ptemp = new PostsTemp(p);
                        ptemp.setRankOfUser(userRank.getRank());
                    } else {
                        ptemp = new PostsTemp(p);
                        ptemp.setRankOfUser(5);
                    }
                } else {
                    ptemp = new PostsTemp(p);
                    ptemp.setRankOfUser(5);
                }
                for (Object c : p.getComments()) {
                    Comment ctemp = (Comment) c;
                    if (ctemp.getState() == 1) {
                        commentSet.add(Comment.getCommentById(ctemp.getIdComment()));
                    }
                }

                mm.put("infpos", ptemp);
                mm.put("imgDetail", listImgDetail);
                mm.put("comment", commentSet);
                mv.setViewName("customposts");
            } else {
                response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }
        return mv;
    }

    @RequestMapping(value = "/rankingpost", method = RequestMethod.POST)
    public void rankingPosts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            String inputStr = request.getParameter("rankinf");
            BufferedReader br = request.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            String arr[] = sb.toString().split("\\|");
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("text/html;charset=UTF-8");

            if (arr.length == 2) {
                int idpost = Integer.valueOf(arr[0]);
                Posts p = Posts.getPostsById(idpost);
                if (p != null && p.getState() == 1) {
                    System.out.println("ducvu: " + p.getIdPosts());
                    HttpSession session = request.getSession();
                    String username = (String) session.getAttribute("username");
                    if (username != null) {
                        User u = User.getUserByUserName(username);
                        int rank = Integer.valueOf(arr[1]);
                        Rankingposts userRanking
                                = new Rankingposts(
                                        new RankingpostsId(p.getIdPosts(), u.getIdUser()), p, u, rank);
                        userRanking.add();
                        System.out.println(p.getRankingpostses().size());
                        if (p.getRankingpostses().contains(userRanking)) {
                            p.getRankingpostses().remove(userRanking);
                            p.getRankingpostses().add(userRanking);
                        } else {
                            p.getRankingpostses().add(userRanking);
                        }

                        out.print(p.getRank() + "|" + p.getRankingpostses().size());
                    } else {
                        out.print("login");
                    }
                } else {
                    out.print("waitadmin");
                }
            } else {
                out.print("error");
            }

        } catch (IOException ex) {
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/customhandlingcomment", method = RequestMethod.POST)
    public void createaccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
                String arr[] = sb.toString().split("\\|");
                if (arr.length == 2) {
                    User u = User.getUserByUserName(username);
                    int idposts = Integer.valueOf(arr[0]);
                    Posts p = Posts.getPostsById(idposts);
                    if (p != null) {
                        if (p.getState() == 1) {
                            Comment comment = new Comment(p, u, new Date(), 1, arr[1]);
                            comment.add();
                            out.print(u.getFullname() + "|" + arr[1]+"|"+u.getIdUser());
                        } else {
                            out.print("waitadmin");
                        }
                    }

                } else {
                    out.print("error");
                }
            } else {
                out.print("login");
            }

        } catch (IOException ex) {
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(value = "/addfavor", method = RequestMethod.POST)
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
                System.out.println("ducvu: " + sb.toString());
                String arr[]=sb.toString().split("=");
                int idPosts = Integer.valueOf(arr[1]);
                Posts p = Posts.getPostsById(idPosts);
                User u = User.getUserByUserName(username);
                if (p.getState() == 1) {
                    if (p.getUsersFarvorite().contains(u)) {
                        out.print("added");
                    } else {
                        p.addToUserFavorite(u);
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
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }
    }
}
