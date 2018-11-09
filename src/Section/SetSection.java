/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Section;

import Controllers.LevelController;
import Models.Levels;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;


/**
 *
 * @author Eunar B. Dayangco
 */
public class SetSection {

    public SetSection() {
    }
    
    
    
    public static void displayComponents(Container cont,Container con){
        cont.removeAll();
        cont.add(con);
        cont.revalidate();
        cont.repaint();
    }
    public static Image turnToImage(byte[] imagebytes){
    
        Image image = null;
        InputStream in = new ByteArrayInputStream(imagebytes);
        try {
            BufferedImage bImageFromConvert = ImageIO.read(in);
            
            image = bImageFromConvert.getScaledInstance(bImageFromConvert.getWidth(), bImageFromConvert.getHeight(), Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            Logger.getLogger(CreateSection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return image;
    }
    
    public static ByteArrayInputStream  turnToBytes(Image image){
        
        
        BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        ByteArrayOutputStream baos = null;
      
            baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "png", baos);
        } catch (IOException ex) {
            Logger.getLogger(CreateSection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        return bais;
    }
    
     public static void displayLevelList(JComboBox cbox){
         
        cbox.removeAllItems();
        for(Levels level:new LevelController().getAllLevels()){            
           cbox.addItem(level.getLevelName());         
        }
    }
  
  
}
