package changeexplorer;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GerarImagem extends javax.swing.JPanel {
	BufferedImage imagem;
	Rectangle2D retangulo;

	public GerarImagem(String nomeImagem) {
		try {
			imagem = ImageIO.read(new File("src\\imagens\\" + nomeImagem));

		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}

	@Override
	public void paintComponent(Graphics g) {

		retangulo = new Rectangle(0, 0, this.getWidth(), this.getHeight());

		TexturePaint p = new TexturePaint(imagem, retangulo);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(p);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());

	}
}