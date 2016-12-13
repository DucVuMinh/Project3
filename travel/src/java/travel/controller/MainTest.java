/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import travel.model.Destination;
import travel.model.ImagedetailDestination;

/**
 *
 * @author DucVu
 */
public class MainTest {

    public static void main(String args[]) throws IOException {
        Destination des = Destination.getDesById(1);
        des.setTitle("Van Duc");
        des.update();
    }
}
