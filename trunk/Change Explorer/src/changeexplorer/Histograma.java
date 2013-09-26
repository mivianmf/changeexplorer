package changeexplorer;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

public class Histograma extends JFrame {

	private TelaMostrarDados dados;

	public Histograma(TelaMostrarDados dados) {

		this.dados = dados;
		criarHistograma();
	}

	public double[] toDouble(Vector x) {

		double[] resposta = new double[x.size()];

		for (int i = 0; i < x.size(); i++) {
			resposta[i] = (int) x.get(i);
		}

		return resposta;
	}

	public void criarHistograma() {

		HistogramDataset dataset = new HistogramDataset();
		dataset.setType(HistogramType.FREQUENCY);
		dataset.addSeries("LSCC", toDouble(dados.veclscc),
				dados.histoLscc.length);
		dataset.addSeries("IN", toDouble(dados.vecin), dados.histoIn.length);
		dataset.addSeries("OUT", toDouble(dados.vecout), dados.histoOut.length);
		//dataset.addSeries("TUBES", toDouble(dados.vectubes),
			//	dados.histoTubes.length);
		dataset.addSeries("TENDRILS", toDouble(dados.vectendrils),
				dados.histoTendrils.length);
		dataset.addSeries("DISCONNECTED", toDouble(dados.vecdisconnected),
				dados.histoDisconnected.length);

		String plotTitle = "Distribuição de Pesos";
		String xaxis = "Peso Modificação";
		String yaxis = "Frequência";
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		boolean show = true;
		boolean toolTips = false;
		boolean urls = false;
		JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, dataset, orientation, show, toolTips, urls);
		int width = 500;
		int height = 300;

		Plot plot = chart.getPlot();
		plot.setForegroundAlpha(0.8F);

		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(400, 300));
		this.setContentPane(panel);
		this.pack();
		this.setVisible(true);

		try {
			ChartUtilities.saveChartAsPNG(new File("./Imagens/histogram.PNG"),
					chart, width, height);
		} catch (IOException e) {
		}
	}

}
