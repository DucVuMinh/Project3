/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.model;

import java.util.List;

/**
 *
 * @author DucVu
 */
public interface InterfacePartOfDestination {
    public void addToUserFavorite(User u);
    public void deleteFavorite(User u);
    public float getRank();
    public List getTop(int numberTop);
    public List search(String input);
    
    
}
