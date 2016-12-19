/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import java.util.Date;
import travel.model.Comment;
import travel.model.Posts;
import travel.model.User;

/**
 *
 * @author ducvu
 */
public class CommentTemp {
    private Integer idComment;
    private Posts posts;
    private User user;
    private Date dateWrite;
    private int state;
    private String context;
    private String profileUser;

    public CommentTemp() {
    }
    public CommentTemp(Comment c) {
        this.idComment=c.getIdComment();
        this.dateWrite=c.getDateWrite();
        this.posts=c.getPosts();
        this.user=c.getUser();
        this.state=c.getState();
        this.context=c.getContext();
        if(user.getFacebookId()==null||user.getFacebookId().isEmpty()){
            profileUser="img/users/profile/"+user.getIdUser()+".png";
        }else{
            profileUser="http://graph.facebook.com/"+user.getFacebookId()+"/picture";
        }
    }
    
    public CommentTemp(Comment c,int type) {
    }

    public CommentTemp(Integer idComment, Posts posts, User user, Date dateWrite, int state, String context, String profileUser) {
        this.idComment = idComment;
        this.posts = posts;
        this.user = user;
        this.dateWrite = dateWrite;
        this.state = state;
        this.context = context;
        this.profileUser = profileUser;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(Date dateWrite) {
        this.dateWrite = dateWrite;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getProfileUser() {
        return profileUser;
    }

    public void setProfileUser(String profileUser) {
        this.profileUser = profileUser;
    }
    
}
