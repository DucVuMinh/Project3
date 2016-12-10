/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import java.util.ArrayList;
import travel.model.Landscape;
import travel.model.Posts;

/**
 *
 * @author DucVu
 */
public class LisPostsTemp {
    private ArrayList listPost;

    public LisPostsTemp() {
        this.listPost=new ArrayList();
    }
    public LisPostsTemp(Posts p1, Posts p2, Posts p3, Posts p4, Posts p5, Posts p6){
        listPost=new ArrayList();
        listPost.add(new PostsTemp(p1,1));
        listPost.add(new PostsTemp(p2,1));
        listPost.add(new PostsTemp(p3,1));
        listPost.add(new PostsTemp(p4,1));
        listPost.add(new PostsTemp(p5,1));
        listPost.add(new PostsTemp(p6,1));
    }
    public LisPostsTemp(Posts p1, Posts p2, Posts p3, Posts p4, Posts p5){
        listPost=new ArrayList();
        listPost.add(new PostsTemp(p1,1));
        listPost.add(new PostsTemp(p2,1));
        listPost.add(new PostsTemp(p3,1));
        listPost.add(new PostsTemp(p4,1));
        listPost.add(new PostsTemp(p5,1));
    }
    public LisPostsTemp(Posts p1, Posts p2, Posts p3, Posts p4){
        listPost=new ArrayList();
        listPost.add(new PostsTemp(p1,1));
        listPost.add(new PostsTemp(p2,1));
        listPost.add(new PostsTemp(p3,1));
        listPost.add(new PostsTemp(p4,1));
    }
    public LisPostsTemp(Posts p1, Posts p2, Posts p3){
        listPost=new ArrayList();
        listPost.add(new PostsTemp(p1,1));
        listPost.add(new PostsTemp(p2,1));
        listPost.add(new PostsTemp(p3,1));
    }
    public LisPostsTemp(Posts p1, Posts p2){
        listPost=new ArrayList();
        listPost.add(new PostsTemp(p1,1));
        listPost.add(new PostsTemp(p2,1));
    }
    public LisPostsTemp(Posts p1){
        listPost=new ArrayList();
        listPost.add(new PostsTemp(p1,1));
    }

    public ArrayList getListPost() {
        return listPost;
    }

    public void setListPost(ArrayList listPost) {
        this.listPost = listPost;
    }
    
    public void add(Posts p){
        if(this.listPost==null){
            this.listPost=new ArrayList();
        }
        this.listPost.add(new PostsTemp(p,1));
    }
}
