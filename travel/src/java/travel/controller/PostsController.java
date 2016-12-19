/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import static com.sun.xml.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.controller.custom.CommentTemp;
import travel.controller.custom.PostsTemp;
import travel.model.Comment;
import travel.model.Destination;
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
@MultipartConfig
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
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
                httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0
                httpResponse.setDateHeader("Expires", 0); // Proxies.
                String username = (String) session.getAttribute("username");
                PostsTemp ptemp;
                if (username != null) {
                    User u = User.getUserByUserName(username);
                    System.out.println("ducvu: user " + username);
                    System.out.println("ducvu: user " + u.getFullname());
                    System.out.println("ducvu: posts " + p.getIdPosts());
                    Rankinglandscape userRank = Rankinglandscape.
                            getRankingLandscapeById(new RankinglandscapeId(p.getIdPosts(), u.getIdUser()));
                    if (userRank != null) {
                        System.out.println("ducvu: rank khac null");
                        ptemp = new PostsTemp(p);
                        ptemp.setRankOfUser(userRank.getRank());
                    } else {
                        System.out.println("ducvu: chua danh gia");
                        ptemp = new PostsTemp(p);
                        ptemp.setRankOfUser(5);
                    }
                } else {
                    System.out.println("user chua dang nhap");
                    ptemp = new PostsTemp(p);
                    ptemp.setRankOfUser(5);
                }
                for (Object c : p.getComments()) {
                    Comment ctemp = (Comment) c;
                    if (ctemp.getState() == 1) {
                        commentSet.add(new CommentTemp(Comment.getCommentById(ctemp.getIdComment())));
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
                        Rankingposts rankp = Rankingposts.getRankingPostById(new RankingpostsId(p.getIdPosts(), u.getIdUser()));
                        Rankingposts userRanking;
                        if (rankp == null) {
                            userRanking
                                    = new Rankingposts(
                                            new RankingpostsId(p.getIdPosts(), u.getIdUser()), p, u, rank);
                            userRanking.add();
                        } else {
                            userRanking = rankp;
                            rankp.setRank(rank);
                            rankp.update();
                        }

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
        } catch (Exception ex) {
            ex.printStackTrace();
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

                            if (u.getFacebookId() == null || u.getFacebookId().isEmpty()) {
                                out.print(u.getFullname() + "|" + arr[1] + "|" + u.getIdUser());
                            } else {
                                out.print(u.getFullname() + "|" + arr[1] + "|" + u.getFacebookId() + "|fb");
                            }
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
                String arr[] = sb.toString().split("=");
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
            Logger
                    .getLogger(LoginController.class
                            .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("http://localhost:8080/travel/requestlogin.htm");
        }
    }
    @Autowired
    private ServletContext context;

    @RequestMapping(value = "/addposts", method = RequestMethod.POST)
    public String addPosts(ModelMap mm, HttpServletRequest request, HttpServletResponse response, final RedirectAttributes redirectAttributes) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User u = User.getUserByUserName(username);
        response.setContentType("text/html;charset=UTF-8");
        String des = request.getParameter("seldes");
        //String des2 = new String(des.getBytes("iso-8859-1"), "utf-8");
        String title = request.getParameter("title");
        //title = new String(title.getBytes("iso-8859-1"), "utf-8");
        String content = request.getParameter("content");
        //context = new String(context.getBytes("iso-8859-1"), "utf-8");
        //System.out.println("ducvu: " + des);
        //System.out.println("ducvu :" + title);
        Destination d = Destination.getDesByTitle(des);
        System.out.println("des " + d.getIdDestination());
        //System.out.println("duc vu: " + d.getTitle());
        Posts p = new Posts(d, u, title, content, 0, new Date());

        int idpost = p.add();
        Collection<Part> fileParts = request.getParts();
        Object arrParts[] = fileParts.toArray();
        int length = arrParts.length;
        System.out.println("lenght parts " + arrParts.length);
        for (int i = 2; i < length; i++) {

            Part filePart = (Part) arrParts[i];
            String fileName = getFileName(filePart);

            OutputStream out = null;
            InputStream filecontent = null;
            if (fileName != null && fileName.length() > 3) {
                try {
                    ImagedetailPosts img = new ImagedetailPosts(p);
                    int idimg = img.add();
                    String absoluteDiskPath = context.getRealPath("img/posts/detail");
                    File fimg = new File(absoluteDiskPath + File.separator
                            + idimg + ".png");
                    out = new FileOutputStream(fimg);
                    filecontent = filePart.getInputStream();

                    int read = 0;
                    final byte[] bytes = new byte[1024];

                    while ((read = filecontent.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                    }
                    LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                            new Object[]{fileName, ""});

                } catch (FileNotFoundException fne) {
                    PrintWriter writer = response.getWriter();
                    writer.println("You either did not specify a file to upload or are "
                            + "trying to upload a file to a protected or nonexistent "
                            + "location.");
                    writer.println("<br/> ERROR: " + fne.getMessage());

                    LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                            new Object[]{fne.getMessage()});
                } finally {
                    if (out != null) {
                        out.close();
                    }
                    if (filecontent != null) {
                        filecontent.close();
                    }
                }
            }
        }
        return "redirect:customposts.htm?id=" + p.getIdPosts();
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
