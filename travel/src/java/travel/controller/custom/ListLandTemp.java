/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import java.util.ArrayList;
import travel.model.Landscape;

/**
 *
 * @author DucVu
 */
public class ListLandTemp {
    private ArrayList<Landtemp> listLand;
    public ListLandTemp(){
        this.listLand=new ArrayList();
    }
    public ListLandTemp(Landscape l1, Landscape l2, Landscape l3, Landscape l4, Landscape l5, Landscape l6){
        listLand =new ArrayList();
        listLand.add(new Landtemp(l1,1));
        listLand.add(new Landtemp(l2,1));
        listLand.add(new Landtemp(l3,1));
        listLand.add(new Landtemp(l4,1));
        listLand.add(new Landtemp(l5,1));
        listLand.add(new Landtemp(l6,1));
    }
    public ListLandTemp(Landscape l1, Landscape l2, Landscape l3, Landscape l4, Landscape l5){
        listLand =new ArrayList();
        listLand.add(new Landtemp(l1,1));
        listLand.add(new Landtemp(l2,1));
        listLand.add(new Landtemp(l3,1));
        listLand.add(new Landtemp(l4,1));
        listLand.add(new Landtemp(l5,1));
    }
    public ListLandTemp(Landscape l1, Landscape l2, Landscape l3, Landscape l4){
        listLand =new ArrayList();
        listLand.add(new Landtemp(l1,1));
        listLand.add(new Landtemp(l2,1));
        listLand.add(new Landtemp(l3,1));
        listLand.add(new Landtemp(l4,1));
    }
    public ListLandTemp(Landscape l1, Landscape l2, Landscape l3){
        listLand =new ArrayList();
        listLand.add(new Landtemp(l1,1));
        listLand.add(new Landtemp(l2,1));
        listLand.add(new Landtemp(l3,1));
    }
    public ListLandTemp(Landscape l1, Landscape l2){
        listLand =new ArrayList();
        listLand.add(new Landtemp(l1,1));
        listLand.add(new Landtemp(l2,1));
    }
    public ListLandTemp(Landscape l1){
        listLand =new ArrayList();
        listLand.add(new Landtemp(l1,1));
    }

    public ArrayList<Landtemp> getListLand() {
        return listLand;
    }

    public void setListLand(ArrayList<Landtemp> listLand) {
        this.listLand = listLand;
    }
    public void add(Landscape l){
        if(this.listLand==null){
            this.listLand=new ArrayList();
        }
        this.listLand.add(new Landtemp(l,1));
    }
    
}
