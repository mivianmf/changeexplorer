package changeexplorer;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Script {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader arquivo = new BufferedReader(new FileReader("caminhos.txt"));
			ArrayList<String> diretorios = new ArrayList<String>();
			
			while (arquivo.ready()){
				diretorios.add(arquivo.readLine());
			}
			
		System.out.println("Li");	
			
			
		for (String c : diretorios) {
			
			TratarArquivoSim tratarSim = new TratarArquivoSim(c+".sim");
	        TratarArquivoNet tratarNet = new TratarArquivoNet(c+".net");
	        TratarArquivoClu tratarClu = new TratarArquivoClu(c+".clu");
	        
	        ArrayList<simulacaometodos.ObjetoSim> objetosSim = tratarSim.getArraySim();
	        ArrayList<Integer> componentes = tratarClu.getArrayClu();
	        ArrayList<String> classes = tratarNet.getArrayNet();
	        
	        GerarDados gerarDados = new GerarDados(objetosSim, classes, componentes);
	        
	        String [] auz = c.split("/");
	        
	        TelaMostrarDados telaDados = new TelaMostrarDados(gerarDados, auz[auz.length-1]);
			
			Histograma histo = new Histograma(telaDados);
			
			TelaListarPontosCriticos tela = new TelaListarPontosCriticos(gerarDados.getMetodos(), gerarDados.getObjetosClasses(), 0, "classe", gerarDados);
			
		}
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
