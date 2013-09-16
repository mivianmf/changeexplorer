package changeexplorer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TratarArquivoClu {

	private String caminhoArquivo;
	private ArrayList<Integer> componentes;

	public TratarArquivoClu(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
		gerarArray();
	}

	private void gerarArray() {

		try {
			BufferedReader arquivo = new BufferedReader(new FileReader(
					this.caminhoArquivo));

			String aux = arquivo.readLine();

			while (!aux.contains("Vertices")) {

				aux = arquivo.readLine();
			}

			int numeroComponentes = Integer.parseInt((aux.split(" "))[1]);
			int contador = 0;
			this.componentes = new ArrayList<Integer>();

			while (contador < numeroComponentes) {
				componentes.add(Integer.parseInt(arquivo.readLine()));
				contador++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mostrarArray() {

		for (Integer e : componentes) {
			System.out.println("" + e);
		}
	}

	public ArrayList<Integer> getArrayClu() {
		return this.componentes;
	}

}

/*
 * "Legenda Clu"
 * 
 * 1 - LSSC: Largest Strongly Connected Component 2 - IN 3 - OUT 4 - TUBES 5 -
 * TENDRILS 0 - OTHERS
 */
