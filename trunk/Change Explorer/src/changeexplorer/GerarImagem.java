/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Mivian
 */
public class GerarImagem extends JPanel {

	BufferedImage imagem;  
    Rectangle2D retangulo;
	
    public GerarImagem(String nomeImagem) {
    	try {  
            //se você pegar uma imagem dentro do mesmo jar/projeto  
           imagem = ImageIO.read(new File("src\\imagens\\"+nomeImagem));                   
           
           retangulo = new Rectangle(0,0,130,130);                                   
             
       } catch (IOException ex) {  
    	   System.out.println("NAO ACHEI CAMINHO!!");
           ex.printStackTrace(System.err);  
       }  
    }

    public void paintComponent(Graphics g){    
        
    	retangulo = new Rectangle(0,0,this.getWidth(),this.getHeight());  
          
          
        TexturePaint p = new TexturePaint(imagem,retangulo);  
        Graphics2D g2 = (Graphics2D) g;  
        g2.setPaint(p);  
        g2.fillRect(0,0,this.getWidth(),this.getHeight());  

    }
}
