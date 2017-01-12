/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import travel.model.Festival;

/**
 *
 * @author DucVu
 */
public class FestivalTemp {
    private int id;
    private String title;
    private String description;
    private int numberUserRank;
    private float avgRank;
    private int rankOfUser;
    private String link;
    private String profile;

    public FestivalTemp() {
    }

    public FestivalTemp(int id, String title, String desciption, int numberUserRank, float avgRank, int rankOfUser) {
        this.id = id;
        this.title = title;
        this.description = desciption;
        this.numberUserRank = numberUserRank;
        this.avgRank = avgRank;
        this.rankOfUser = rankOfUser;
        this.link="customfestival.htm?id=" + this.id;
        this.profile="img/festival/profile/"+this.id+".png";
    }
    public FestivalTemp(Festival f){
        this.id=f.getIdFestival();
        this.description=f.getDiscription();
        this.title=f.getTitle();
        this.numberUserRank=f.getRankingfestivals().size();
        this.avgRank=f.getRank();
        this.link="customfestival.htm?id=" + this.id;
        this.profile="img/festival/profile/"+this.id+".png";
    }
    public FestivalTemp(Festival f,int typeuse){
        this.id=f.getIdFestival();
        this.description=f.getDiscription();
        this.title=f.getTitle();
        this.link="customfestival.htm?id=" + this.id;
        this.profile="img/festival/profile/"+this.id+".png";
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String desciption) {
        this.description = desciption;
    }

    public int getNumberUserRank() {
        return numberUserRank;
    }

    public void setNumberUserRank(int numberUserRank) {
        this.numberUserRank = numberUserRank;
    }

    public float getAvgRank() {
        return avgRank;
    }

    public void setAvgRank(float avgRank) {
        this.avgRank = avgRank;
    }

    public int getRankOfUser() {
        return rankOfUser;
    }

    public void setRankOfUser(int rankOfUser) {
        this.rankOfUser = rankOfUser;
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
