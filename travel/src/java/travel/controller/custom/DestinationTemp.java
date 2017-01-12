/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import travel.model.Destination;

/**
 *
 * @author DucVu
 */
public class DestinationTemp {

    private int id;
    private String title;
    private String desciption;
    private String profile;
    private String link;

    public DestinationTemp() {
        
    }

    public DestinationTemp(int id, String title, String desciption) {
        this.id = id;
        this.title = title;
        this.desciption = desciption;
        this.profile="img/destination/profile/"+this.id+".png";
        this.link="customdestination.htm?id=" + this.id;
    }
    public DestinationTemp(Destination d){
        this.id=d.getIdDestination();
        this.title=d.getTitle();
        this.desciption=d.getDiscription();
        this.profile="img/destination/profile/"+this.id+".png";
        this.link="customdestination.htm?id=" + this.id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    
    
}
