/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import java.util.Date;
import travel.model.ImagedetailPosts;
import travel.model.Posts;

/**
 *
 * @author DucVu
 */
public class PostsTemp {

    private String profile;
    private Integer id;
    private String title;
    private String context;
    private String link;
    private Date date;
    private String userWrite;
    private float avgRank;
    private int numberUserRank;
    private int rankOfUser;

    public PostsTemp() {
    }

    public PostsTemp(String profile, Integer id, String title, String context) {
        this.profile = profile;
        this.id = id;
        this.title = title;
        this.context = context;
        this.link = "customposts.htm?id=" + this.id;
    }

    public PostsTemp(Posts p) {
        this.id = p.getIdPosts();
        this.title = p.getTitle();
        this.context = p.getContext();
        this.link = "customposts.htm?id=" + this.id;
        this.date=p.getDatePost();
        int temp=0;
        if(p.getImagedetailPostses().size()>0){
            temp = ((ImagedetailPosts) p.getImagedetailPostses().toArray()[0]).getIdImage();
        }
        this.profile = "img/posts/detail/" + temp + ".png";
        this.avgRank = p.getRank();
        this.numberUserRank = p.getRankingpostses().size();
        this.userWrite=p.getUserPost().getFullname();
   

    }
    public PostsTemp(Posts p,int typeuser) {
        this.id = p.getIdPosts();
        Posts tempp=Posts.getPostsById(p.getIdPosts());
        this.title = p.getTitle();
        this.context = p.getContext();
        this.link = "customposts.htm?id=" + this.id;
        int temp=0;
        this.date=p.getDatePost();
        if(tempp.getImagedetailPostses().size()>0){
            temp = ((ImagedetailPosts) tempp.getImagedetailPostses().toArray()[0]).getIdImage();
        }
        this.profile = "img/posts/detail/" + temp + ".png";
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public float getAvgRank() {
        return avgRank;
    }

    public void setAvgRank(float avgRank) {
        this.avgRank = avgRank;
    }

    public int getNumberUserRank() {
        return numberUserRank;
    }

    public void setNumberUserRank(int numberUserRank) {
        this.numberUserRank = numberUserRank;
    }

    public int getRankOfUser() {
        return rankOfUser;
    }

    public void setRankOfUser(int rankOfUser) {
        this.rankOfUser = rankOfUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserWrite() {
        return userWrite;
    }

    public void setUserWrite(String userWrite) {
        this.userWrite = userWrite;
    }
    

}
