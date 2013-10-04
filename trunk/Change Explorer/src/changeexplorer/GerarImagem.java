/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Mivian
 */
public class GerarImagem extends JPanel {

    public GerarImagem() {
        // alterando algumas propriedades do objeto
        this.setFocusable(true); // pode assumir foco
        //this.setBackground(Color.WHITE); // alterando a cor do fundo

    }

    // Este método é invocado para desenhar o Painel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharImagem(g);
    }

    private void desenharImagem(Graphics g) {
        BufferedImage img = null;
        try {
                       
        	img = ImageIO.read(getClass().getResource("imagens/lscc.png"));
                       
        } catch (Exception e) {
            System.out.println("BackGround nao encontrado");
        }
       g.drawImage(img, 0, 0, null);
       // Graphics2D g2 = (Graphics2D) this.getGraphics();


    }
}
