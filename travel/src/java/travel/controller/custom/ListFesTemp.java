/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import java.util.ArrayList;
import travel.model.Festival;

/**
 *
 * @author DucVu
 */
public class ListFesTemp {

    private ArrayList<FestivalTemp> listfes;

    public ListFesTemp() {
        this.listfes=new ArrayList();
    }

    public ListFesTemp(Festival f1) {
        listfes = new ArrayList();
        listfes.add(new FestivalTemp(f1,1));
    }

    public ListFesTemp(Festival f1, Festival f2, Festival f3, Festival f4, Festival f5, Festival f6) {
        listfes = new ArrayList();
        listfes.add(new FestivalTemp(f1,1));
        listfes.add(new FestivalTemp(f2,1));
        listfes.add(new FestivalTemp(f3,1));
        listfes.add(new FestivalTemp(f4,1));
        listfes.add(new FestivalTemp(f5,1));
        listfes.add(new FestivalTemp(f6,1));
    }

    public ListFesTemp(Festival f1, Festival f2, Festival f3, Festival f4, Festival f5) {
        listfes = new ArrayList();
        listfes.add(new FestivalTemp(f1,1));
        listfes.add(new FestivalTemp(f2,1));
        listfes.add(new FestivalTemp(f3,1));
        listfes.add(new FestivalTemp(f4,1));
        listfes.add(new FestivalTemp(f5,1));
    }

    public ListFesTemp(Festival f1, Festival f2, Festival f3, Festival f4) {
        listfes = new ArrayList();
        listfes.add(new FestivalTemp(f1,1));
        listfes.add(new FestivalTemp(f2,1));
        listfes.add(new FestivalTemp(f3,1));
        listfes.add(new FestivalTemp(f4,1));
    }

    public ListFesTemp(Festival f1, Festival f2, Festival f3) {
        listfes = new ArrayList();
        listfes.add(new FestivalTemp(f1,1));
        listfes.add(new FestivalTemp(f2,1));
        listfes.add(new FestivalTemp(f3,1));
    }

    public ListFesTemp(Festival f1, Festival f2) {
        listfes = new ArrayList();

        listfes.add(new FestivalTemp(f1,1));
        listfes.add(new FestivalTemp(f2,1));
    }

    public ArrayList<FestivalTemp> getListfes() {
        return listfes;
    }

    public void setListfes(ArrayList<FestivalTemp> listfes) {
        this.listfes = listfes;
    }
    public void add(Festival f){
        if(listfes==null){
            this.listfes=new ArrayList();
        }
        this.listfes.add(new FestivalTemp(f,1));
    }

}
