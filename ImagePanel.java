import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

 import java.awt.*;
  import javax.swing.*;
//javac -cp dependency/core.jar;dependency/mobutil.jar ImagePanel.java && java -cp .;dependency/core.jar;dependency/mobutil.jar ImagePanel
public class ImagePanel extends JPanel{

  public static void main(String [] args){
    JFrame f = new JFrame("My First GUI");  // Create Frame        

    f.setSize(400,300); // Set size of frame
    
    System.out.println("Generating image");
    ImagePanel ip = new ImagePanel();
    f.add(ip);
    ip.setVisible(true);
    f.setVisible(true); // Show the window


    try{
      System.out.println("Sleeping");
      Thread.sleep(2000);

    }
    catch(Exception e){

    }
    System.out.println("Switching image");
    try{
          BitMatrix bitMatrix = (new Code128Writer()).encode("090", BarcodeFormat.CODE_128, 500, 500, (Hashtable)null);
    BufferedImage anImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
    image = anImage;
    ip.repaint();
  }catch (Exception e){}


  }

    public static Image image;

    public ImagePanel() {
      
       try {         
       BitMatrix bitMatrix = (new Code128Writer()).encode("111", BarcodeFormat.CODE_128, 500, 500, (Hashtable)null);
        BufferedImage anImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        //MatrixToImageWriter.writeToFile(bitMatrix,"jpg",new File("Image.jpg"));
        Image image  = ImageIO.read(new File("/images/saved.png")); // Opening again as an Image
        image = anImage;
       } catch (Exception ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}