/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.admin;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import travel.model.Comment;
import travel.model.Posts;
import travel.model.Rankingposts;

/**
 *
 * @author vanduc
 */
@Controller
@EnableWebMvc  //Use RedirectAttributes
@RequestMapping(value = "/admin")
public class PostsManageController {

    @RequestMapping(value = "/postsManage", method = RequestMethod.GET)
    public ModelAndView viewPostAdmin(ModelMap mm) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/postsManage");
        List listPosts = Posts.getAll();
        List lPost = new ArrayList();
        for(Object p : listPosts){
            if(((Posts) p).getState() != -1){
                lPost.add(p);
            }
        }
        List listPostsNeedApprove = Posts.getListPostNeedApprove();
        List lPostApp = new ArrayList();
        for(Object p : listPostsNeedApprove){
            if(((Posts) p).getState() == 0){
                lPostApp.add(p);
            }
        }
        mm.put("listPosts", lPost);
        mm.put("lPNeedApprove", lPostApp);
        return view;
    }

    @RequestMapping(value = "/detailPosts", method = RequestMethod.GET)
    public ModelAndView viewDetailPostAdmin(@RequestParam("idPost") int idPost, ModelMap mm) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/detailPosts");
        Posts p = Posts.getPostsById(idPost);
        List cmtAct = new ArrayList();
        for(Object cmt : p.getComments()){
            Comment com = (Comment) cmt;
            com = com.getCommentById(com.getIdComment());
            if(com.getState() != -1){
                cmtAct.add(com);
            }
        }
        String cmtJson = "[";
        int i = 1;
        for(Object cmt : cmtAct){
            if(i != 1)
                cmtJson = cmtJson + "," + ((Comment) cmt).getJson();
            else{
                cmtJson = cmtJson + ((Comment) cmt).getJson();
                i++;
            }
        }
        cmtJson = cmtJson + "]";
        ArrayList<Integer> r = new ArrayList<Integer>();
        for(int j = 0; j < 5; j++){
            r.add(0);
        }
        for(Object rp: p.getRankingpostses()){
            if(((Rankingposts) rp).getRank() == 1){
                r.set(0, r.get(0)+1);
            }
            else if(((Rankingposts) rp).getRank() == 2){
                r.set(1, r.get(1)+1);
            }
            else if(((Rankingposts) rp).getRank() == 3){
                r.set(2, r.get(2)+1);
            }
            else if(((Rankingposts) rp).getRank() == 4){
                r.set(3, r.get(3)+1);
            }
            else{
                r.set(4, r.get(4)+1);
            }
        }
        mm.put("cmtJson", cmtJson);
        mm.put("cmtAct", cmtAct);
        mm.put("rank", r);
        mm.put("p", p);
        return view;
    }

    @RequestMapping(value = "/detailPostsNeedApprove", method = RequestMethod.GET)
    public ModelAndView viewDetailPostNeedApprove(@RequestParam("idPost") int idPost, ModelMap mm) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/detailPostNeedApprove");
        Posts p = Posts.getPostsById(idPost);
        mm.put("p", p);
        return view;
    }
    
    @RequestMapping(value = "/approvePosts", method = RequestMethod.GET)
    public String viewApprovePost(@RequestParam("idPost") int idPost, ModelMap mm, final RedirectAttributes redirectAttributes){
        Posts p = Posts.getPostsById(idPost);
        try {
            p.accept();
            redirectAttributes.addFlashAttribute("message", "Thông báo! Đã chấp nhận bài viết và cho phép hiển thị bài viết lên website.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "redirect:/admin/detailPosts.htm?idPost="+idPost;
    }
    
    @RequestMapping(value = "/deletePosts", method = RequestMethod.GET)
    public String deletePost(@RequestParam("idPost") int idPost, final RedirectAttributes redirectAttributes){
        Posts p = Posts.getPostsById(idPost);
        try {
            p.delete();
            redirectAttributes.addFlashAttribute("message","Xóa bài viết thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/postsManage.htm";
    }
    
    @RequestMapping(value = "/deleteComment", method = RequestMethod.GET)
    public String deleteComment(@RequestParam("idPost") int idPost, @RequestParam("idCmt") int idCmt, final RedirectAttributes redirectAttributes){
        Comment cmt = Comment.getCommentById(idCmt);
        System.out.println(idCmt);
        try {
            cmt.delete();
            redirectAttributes.addFlashAttribute("message","Xóa bình luận thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/detailPosts.htm?idPost="+idPost;
    }
}