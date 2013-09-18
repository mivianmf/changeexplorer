package changeexplorer;

import org.jfree.chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Grafico extends ApplicationFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param title
	 */
	public Grafico(String title,double[] media, double[] maximo) {
		super(title);
		plotarGrafico(title, media, maximo);
	}

	public  void plotarGrafico(String title,double[] media, double[] maximo){
		ChartPanel chartPanel2;
		JFreeChart chart2 = criarChart2(title, media, maximo);
		
		chartPanel2 = new ChartPanel(chart2);
		
        chartPanel2.setPreferredSize(new java.awt.Dimension(700, 450));
        
        this.setContentPane(chartPanel2);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
	}

	   private  JFreeChart criarChart2(String title,double[] media, double[] maximo) {

	    	// Create a single plot containing both the scatter and lines
	        XYPlot plot = new XYPlot();

	        
	        //axis
	        ValueAxis domain1 = new NumberAxis("Gerações");
	        ValueAxis range1 = new NumberAxis("Valores");
	        
	        
	        //****************** SETUP média

	        // Create the média data and renderer
	        XYDataset collection1 = criarDataset3(media);
	        XYItemRenderer renderer1 = new XYLineAndShapeRenderer(true, false);   // lines only
	        renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
//	        renderer1.setSeriesPaint(0, Color.black); //cor do traço
	        
	        // Set the média data, renderer, and axis into plot
	        plot.setDataset(0, collection1);
	        plot.setRenderer(0, renderer1);
	        plot.setDomainAxis(0, domain1);
	        plot.setRangeAxis(0, range1);
	        
	        
	        //****************** SETUP máximo

	        // Create the máximo data and renderer
	        XYDataset collection2 = criarDataset4(maximo);
	        XYItemRenderer renderer2 = new XYLineAndShapeRenderer(true, false);   // lines only
	        renderer2.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
//	        renderer2.setSeriesPaint(0, Color.black); //cor do traço

	        // Set the máximo data, renderer, and axis into plot
	        plot.setDataset(1, collection2);
	        plot.setRenderer(1, renderer2);
	        plot.setDomainAxis(1, domain1);
	        plot.setRangeAxis(1, range1);
	        

	        // Create the chart with the plot and a legend
	        JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
	        return chart;
	    	
		}
	   
	   /** Dataset para a média das gerações. */
	    private  XYDataset criarDataset3 (double [] media) {
	    	
	    	//mudar vetor media para o formato de duas linhas e num_indiv colunas
	    	//primeira linha são os valores para o eixo X, na segunda linha são os valores para o eixo Y
	    	double [][] media2 = new double[2][media.length];
	    	
	    	for (int i = 0; i < media.length; i++) { //colunas de media
	    		
	    		media2[0][i] = i;
	    		media2[1][i] = media[i];
				
			}
	    	
	    	
	    	DefaultXYDataset data = new DefaultXYDataset();
	    	
	    	data.addSeries("Média", media2);
	    	    	
	    	return data;
	        
	    }
	    
	    
	    /** Dataset para o máximo das gerações. */
	    private  XYDataset criarDataset4 (double [] maximo) {
	    	
	    	//mudar vetor maximo para o formato de duas linhas e num_indiv colunas
	    	//primeira linha são os valores para o eixo X, na segunda linha são os valores para o eixo Y
	    	double [][] max2 = new double[2][maximo.length];
	    	
	    	for (int i = 0; i < maximo.length; i++) { //colunas de media
	    		
	    		max2[0][i] = i;
	    		max2[1][i] = maximo[i];
				
			}
	    	
	    	
	    	DefaultXYDataset data = new DefaultXYDataset();
	    	
	    	data.addSeries("Máximo", max2);
	    	    	
	    	return data;
	        
	    }
}



/*import java.awt.*;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

class Grafico {
	
	private XYSeriesCollection dataset;
	String t ;
	
	public void add(String titulo, double[] eixo_x, double[] eixo_y) {
	
		
		XYSeries series = new XYSeries(titulo);
		if(eixo_x.length != eixo_y.length) {
			throw new RuntimeException("Erro ao reproduzir graficos: eixos x e y diferem no tamanho.");
		}
		else {
			// Cria series
			for (int i = 0; i < eixo_x.length; i++) {
				series.add(eixo_x[i], eixo_y[i]);
			}
		}
		dataset.addSeries(series);
	}
	
	public void create(String titulo, String xtitulo, String ytitulo, int largura, int altura) {
		
		JFreeChart chart = ChartFactory.createXYLineChart(
			titulo, // Title
			xtitulo, // x-axis Label
			ytitulo, // y-axis Label
			dataset, // Dataset
			PlotOrientation.VERTICAL, // Plot Orientation
			true, // Show Legend
			true, // Use tooltips
			false // Configure chart to generate URLs?
		);
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.WHITE);
		
		plot.getRenderer().setSeriesStroke(0, new BasicStroke(1.0f, BasicStroke.CAP_ROUND,
BasicStroke.JOIN_ROUND, 1.0f, new float[] {6.0f, 6.0f}, 0.0f));
		try {
			System.out.println(t);
			File f = new File (t);
			ChartUtilities.saveChartAsJPEG(f, chart, largura, altura);
			Desktop.getDesktop().open(f);
			//f.deleteOnExit();
		} catch (IOException e) {
			System.err.println("Problem occurred creating chart.");
		}
	}
	
	public Grafico() {
		dataset = new XYSeriesCollection();
	}
	
	public void setnome (String nome){
		t = nome;
	}

}
*/