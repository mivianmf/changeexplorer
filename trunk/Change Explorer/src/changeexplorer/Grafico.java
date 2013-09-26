package changeexplorer;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico extends JFrame {

	static int[] histograma;
	static int x, y;
	static String title;

	public Grafico(int[] histograma, String title, int x, int y) {
		this.title = title;
		this.histograma = histograma;
		this.x = x;
		this.y = y;
		CategoryDataset dataset = Grafico.createDataset();
		JFreeChart chart = Grafico.createBarChart(dataset);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(600, 600));
		setContentPane(panel);
		//this.pack();
		//this.setVisible(true);
	}

	private static CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < histograma.length; i++) {
			dataset.addValue(histograma[i], "", ""+i);
		}

		histograma.toString();

		return dataset;
	}

	private static  JFreeChart createBarChart(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart(
				title, // Titulo
				"Passos de Modificação", // Eixo X
				"Total de Classes", // Eixo Y
				dataset, // Dados para o grafico
				PlotOrientation.VERTICAL, // Orientacao do grafico
				false, false, false); // exibir: legendas, tooltips, url
				
				try {
					File f = new File ("./Imagens/"+title+".jpeg");
					ChartUtilities.saveChartAsJPEG(f, chart, 800, 300);
					//Desktop.getDesktop().open(f);
					//f.deleteOnExit();
				} catch (IOException e) {
					System.err.println("Problem occurred creating chart.");
				}
				
				return chart;
	}

}