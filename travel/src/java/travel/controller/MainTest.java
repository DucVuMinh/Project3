/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.util.ArrayList;
import java.util.List;
import travel.model.Destination;
import travel.model.Landscape;
import travel.model.Rankinglandscape;
import travel.model.RankinglandscapeId;
import travel.model.User;

/**
 *
 * @author DucVu
 */
public class MainTest {

    public static void main(String args[]) {
//        Landscape l=Landscape.getLandscapeById(1);
//        User u=User.getUserById(1);
//        Rankinglandscape rank=Rankinglandscape.getRankingLandscapeById(new RankinglandscapeId(l.getIdLandscape(), u.getIdUser()));
//        System.out.println(rank.getRank());
        List listDes = Destination.getAllListDes();
        for (Object obj : listDes) {
            String discription = ((Destination)obj).getDiscription();
            System.out.println(discription);
        }
        ArrayList<Destination> a = new ArrayList<>();
        a = (ArrayList<Destination>) listDes;
        for(int i=0;i< a.size();i++){
            System.out.println(a.get(i).getTitle());
        }
    }
}
