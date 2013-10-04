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
		TelaHistograma tela = new TelaHistograma();
		tela.setLocation(100, 200);
		tela.setVisible(true);
		tela.setResizable(false);
		
	}

	public double[] toDouble(Vector x) {

		double[] resposta = new double[x.size()];

		for (int i = 0; i < x.size(); i++) {
			resposta[i] = (int) x.get(i);
		}

		return resposta;
	}

	public void criarHistograma() {

		HistogramDataset lscc = new HistogramDataset();
		lscc.setType(HistogramType.FREQUENCY);
		lscc.addSeries("LSCC", toDouble(dados.veclscc),
				dados.histoLscc.length);
		
		HistogramDataset in = new HistogramDataset();
		in.setType(HistogramType.FREQUENCY);
		in.addSeries("IN", toDouble(dados.vecin), dados.histoIn.length);
		
		HistogramDataset out = new HistogramDataset();
		out.setType(HistogramType.FREQUENCY);
		out.addSeries("OUT", toDouble(dados.vecout), dados.histoOut.length);
		//dataset.addSeries("TUBES", toDouble(dados.vectubes),
			//	dados.histoTubes.length);
		HistogramDataset tendrils = new HistogramDataset();
		tendrils.setType(HistogramType.FREQUENCY);
		tendrils.addSeries("TENDRILS", toDouble(dados.vectendrils),
				dados.histoTendrils.length);
		HistogramDataset disconnected = new HistogramDataset();
		disconnected.setType(HistogramType.FREQUENCY);
		disconnected.addSeries("DISCONNECTED", toDouble(dados.vecdisconnected),
				dados.histoDisconnected.length);

		String plotTitle = "Distribui��o de Pesos";
		String xaxis = "Peso Modifica��o";
		String yaxis = "Frequ�ncia";
		
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		boolean show = true;
		boolean toolTips = false;
		boolean urls = false;
		
		JFreeChart chartlscc = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, lscc, orientation, show, toolTips, urls);
		
		JFreeChart chartin = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, in, orientation, show, toolTips, urls);
		
		JFreeChart chartout = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, out, orientation, show, toolTips, urls);

//		JFreeChart chartubes = ChartFactory.createHistogram(plotTitle, xaxis,
	//			yaxis, tubes, orientation, show, toolTips, urls);
		
		JFreeChart charttendrils = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, tendrils, orientation, show, toolTips, urls);
		
		JFreeChart chartdisconnected = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, disconnected, orientation, show, toolTips, urls);
		
		  try {  
			    ChartUtilities.saveChartAsPNG(new java.io.File("./src/imagens/lscc.png"), chartlscc, 700, 600);
			    ChartUtilities.saveChartAsPNG(new java.io.File("./src/imagens/in.png"), chartin, 700, 600);
			    ChartUtilities.saveChartAsPNG(new java.io.File("./src/imagens/out.png"), chartout, 700, 600);
			    //ChartUtilities.saveChartAsPNG(new java.io.File("./src/imagens/tubes.png"), chartubes, 700, 600);
			    ChartUtilities.saveChartAsPNG(new java.io.File("./src/imagens/tendrils.png"), charttendrils, 700, 600);
			    ChartUtilities.saveChartAsPNG(new java.io.File("./src/imagens/disconnected.png"), chartdisconnected, 700, 600);
			
		  } catch (IOException e) {  
			    // TODO Auto-generated catch block  
			    e.printStackTrace();  
			}  
			      
		
	}

}
