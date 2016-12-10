/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import travel.model.Landscape;

/**
 *
 * @author DucVu
 */
public class Landtemp {

    private int id;
    private String title;
    private String desciption;
    private int numberUserRank;
    private float avgRank;
    private int rankOfUser;
    private String link;
    private String profile;

    public Landtemp() {
    }

    public Landtemp(int id, String title, String desciption, int numberUserRank, float avgRank, int rankOfUser) {
        this.id = id;
        this.title = title;
        this.desciption = desciption;
        this.numberUserRank = numberUserRank;
        this.avgRank = avgRank;
        this.rankOfUser = rankOfUser;
        this.link = "http://localhost:8080/travel/customlandscape.htm?id=" + this.id;
        this.profile="http://localhost:8080/travel/img/landscape/profile/"+this.id+".png";
    }
    public Landtemp(Landscape l){
        this.id=l.getIdLandscape();
        this.title=l.getTitle();
        this.desciption=l.getDiscription();
        this.numberUserRank=l.getRankinglandscapes().size();
        this.avgRank=l.getRank();
        this.link="http://localhost:8080/travel/customlandscape.htm?id=" + this.id;
        this.profile="http://localhost:8080/travel/img/landscape/profile/"+this.id+".png";
    }
    public Landtemp(Landscape l,int typeuse){
        this.id=l.getIdLandscape();
        this.title=l.getTitle();
        this.desciption=l.getDiscription();
        this.link="http://localhost:8080/travel/customlandscape.htm?id=" + this.id;
        this.profile="http://localhost:8080/travel/img/landscape/profile/"+this.id+".png";
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
