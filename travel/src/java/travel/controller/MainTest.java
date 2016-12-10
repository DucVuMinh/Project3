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

/**
 *
 * @author DucVu
 */
public class MainTest {

    public static void main(String args[]) throws IOException {
//        Landscape l=Landscape.getLandscapeById(1);
//        User u=User.getUserById(1);
//        Rankinglandscape rank=Rankinglandscape.getRankingLandscapeById(new RankinglandscapeId(l.getIdLandscape(), u.getIdUser()));
//        System.out.println(rank.getRank());
        InputStream in = null;
        OutputStream out = null;
        try {
            try {
                in = new FileInputStream(new File("/home/ducvu/Desktop/download.jpg"));
                BufferedImage img = ImageIO.read(in);
                out = new FileOutputStream(new File("/home/ducvu/Desktop/download2.jpg"));

                ImageIO.write(img, "png", out);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
