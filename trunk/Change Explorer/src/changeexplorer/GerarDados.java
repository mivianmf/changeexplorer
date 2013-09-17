package changeexplorer;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.tree.DefaultMutableTreeNode;

import simulacaometodos.ObjetoSim;

public class GerarDados {

	private ArrayList<simulacaometodos.ObjetoSim> objetos;
	private ArrayList<String> classes, lscc, in, out, tubes, tendrils,
			disconnected;
	private ArrayList<Integer> componentes;
	private int numeroClasses, totalLSSC = 0, totalIN = 0, totalOUT = 0,
			totalTUBES = 0, totalTENDRILS = 0, totalDISCONNECTED = 0;
	private HashMap<String, ArrayList<ObjetoSim>> mapMetodos;

	public GerarDados(ArrayList<simulacaometodos.ObjetoSim> objetos,
			ArrayList<String> classes, ArrayList<Integer> componentes) {
		this.objetos = objetos;
		this.classes = classes;
		this.componentes = componentes;
		this.numeroClasses = classes.size();
		inicializarArrays();
		mapearMetodos();
	}

	private void inicializarArrays() {
		this.lscc = new ArrayList<String>();
		this.in = new ArrayList<String>();
		this.out = new ArrayList<String>();
		this.tubes = new ArrayList<String>();
		this.tendrils = new ArrayList<String>();
		this.disconnected = new ArrayList<String>();

		classesEComponentes();
	}

	/*
	 * Classe destinada a distribuir as classes em seus respectivos componentes
	 */
	public void classesEComponentes() {

		String classe;
		Integer codigo;
		for (int i = 0; i < classes.size(); i++) {
			classe = classes.get(i);
			System.out.println("" + classe);
			codigo = componentes.get(i);
			codigosComponentes(codigo, classe);
		}
	}

	private void mapearMetodos() {

		ArrayList<ObjetoSim> aux;
		String classe;
		ObjetoSim obj;

		for (int i = 0; i < objetos.size(); i++) {
			obj = objetos.get(i);
			classe = obj.classe;
			aux = this.mapMetodos.get(classe);
			aux.add(obj);
			mapMetodos.put(classe, aux);
		}
	}
	
	public void codigosComponentes(int codigo, String classe) {

		switch (codigo) {
		case 1:
			this.lscc.add(classe);
			this.totalLSSC++;
			break;

		case 2:
			this.in.add(classe);
			totalIN++;
			break;

		case 3:
			this.out.add(classe);
			totalOUT++;
			break;

		case 4:
			this.tubes.add(classe);
			totalTUBES++;
			break;

		case 5:
			this.tendrils.add(classe);
			totalTENDRILS++;
			break;

		case 0:
			this.disconnected.add(classe);
			totalDISCONNECTED++;
			break;

		default:
			break;
		}

	}

	private void iniciarMap() {
		ArrayList<ObjetoSim> aux;

		for (int i = 0; i < classes.size(); i++) {
			aux = new ArrayList<ObjetoSim>();
			mapMetodos.put(classes.get(i), aux);
		}

	}

	public ArrayList<String> getDisconnected() {
		return disconnected;
	}

	public ArrayList<String> getIn() {
		return in;
	}

	public ArrayList<String> getLscc() {
		return lscc;
	}

	public ArrayList<String> getOut() {
		return out;
	}

	public ArrayList<String> getTendrils() {
		return tendrils;
	}

	public ArrayList<String> getTubes() {
		return tubes;
	}

	public int getTotalDISCONNECTED() {
		return totalDISCONNECTED;
	}

	public int getTotalIN() {
		return totalIN;
	}

	public int getTotalLSSC() {
		return totalLSSC;
	}

	public int getTotalOUT() {
		return totalOUT;
	}

	public int getTotalTUBES() {
		return totalTUBES;
	}

	public int getTotalTENDRILS() {
		return totalTENDRILS;
	}

}

/*
 * "Legenda Clu"
 * 
 * 1 - LSSC: Largest Strongly Connected Component 2 - IN 3 - OUT 4 - TUBES 5 -
 * TENDRILS 0 - OTHERS
 */