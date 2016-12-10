/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller.custom;

import java.util.ArrayList;
import travel.model.Destination;
import travel.model.Festival;

/**
 *
 * @author DucVu
 */
public class ListDesTemp {

    private ArrayList<DestinationTemp> ldes;

    public ListDesTemp() {
        this.ldes=new ArrayList();
    }

    public ListDesTemp(Destination des1, Destination des2, Destination des3) {
        this.ldes = new ArrayList<>();
        this.ldes.add(new DestinationTemp(des1));
        this.ldes.add(new DestinationTemp(des2));
        this.ldes.add(new DestinationTemp(des3));
    }

    public ListDesTemp(Destination des1) {
        this.ldes = new ArrayList<>();
        this.ldes.add(new DestinationTemp(des1));
    }

    public ListDesTemp(Destination des1, Destination des2) {
        this.ldes = new ArrayList<>();
        this.ldes.add(new DestinationTemp(des1));
        this.ldes.add(new DestinationTemp(des2));
    }

    public ArrayList<DestinationTemp> getLdes() {
        return ldes;
    }

    public void setLdes(ArrayList<DestinationTemp> ldes) {
        this.ldes = ldes;
    }

    public void add(Destination d) {
        if (ldes == null) {
            this.ldes = new ArrayList();
        }
        this.ldes.add(new DestinationTemp(d));
    }

}
