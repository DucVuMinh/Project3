/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

/**
 *
 * @author ducvu
 */
public class ImageDetailTemp {
    private int idimg;
    private String link;
    private int type;

    public ImageDetailTemp() {
    }

    public ImageDetailTemp(int idimg, int type) {
        this.idimg = idimg;
        this.type = type;
        if(type==1){
            this.link="img/landscape/detail/" + idimg + ".png";
        }else if(type==2){
            this.link="img/festival/detail/" + idimg + ".png";
        }else{
            this.link="img/posts/detail/" + idimg + ".png";
        }
        
    }

    public int getIdimg() {
        return idimg;
    }

    public void setIdimg(int idimg) {
        this.idimg = idimg;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
