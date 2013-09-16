package changeexplorer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import simulacaometodos.ObjetoSim;

public class TratarArquivoNet {
	
	private String caminhoArquivo;
	private ArrayList<String> nomeClasses;
	
	public TratarArquivoNet (String caminhoArquivo){
		this.caminhoArquivo = caminhoArquivo;
		gerarArray();
	}

	private void gerarArray() {
		
		try {
			BufferedReader arquivo = new BufferedReader (new FileReader(this.caminhoArquivo) );
			
			String aux = arquivo.readLine();
			
			while (!aux.contains("Vertices")){
				
				aux = arquivo.readLine();
			}
			
				
			int numeroClasses = Integer.parseInt((aux.split(" "))[1]);
			int contador = 0;
			this.nomeClasses = new ArrayList<String>();
			
			
			while (contador < numeroClasses) {
				
				nomeClasses.add((arquivo.readLine().split(" ")[1]));
				contador++;
				
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void mostrarArray() {

		for (String e : nomeClasses) {
			System.out.println(""+e);
		}
	}

	public ArrayList<String> getArrayNet() {
		
		return this.nomeClasses;
	}
	

}
