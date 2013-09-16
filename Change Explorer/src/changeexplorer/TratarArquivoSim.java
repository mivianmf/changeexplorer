package changeexplorer;

import java.io.*;
import java.util.ArrayList;

import simulacaometodos.ObjetoSim;

public class TratarArquivoSim {

	private String caminhoArquivo;
	private ArrayList<ObjetoSim> listaObjetos;

	public TratarArquivoSim(String caminhoArquivo) {

		this.caminhoArquivo = caminhoArquivo;
		gerarArray();
		// mostrarArray();

	}

	private void gerarArray() {
		try {

			ObjectInputStream arquivo = new ObjectInputStream(
					new FileInputStream(caminhoArquivo));
			
			listaObjetos = new ArrayList<ObjetoSim>(); 

			int tamArray = arquivo.readInt();
			int cont = 0;

			while (cont < tamArray) {

				ObjetoSim objeto = (ObjetoSim) arquivo.readObject();
				this.listaObjetos.add(objeto);

				cont++;
			}
			

		} catch (Exception e) {
			System.out.println("ENTREI CATCH");
			System.out.println("" + e.toString()+"\n");
			e.printStackTrace();
		}
	}

	private void mostrarArray() {

		for (ObjetoSim obj : listaObjetos) {
			obj.mostrar();
		}
	}
	
	public ArrayList<ObjetoSim> getArraySim (){
		return this.listaObjetos;
		
	}

}
