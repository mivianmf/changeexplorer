package changeexplorer;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Timer;

import javax.swing.tree.DefaultMutableTreeNode;

import simulacaometodos.ObjetoSim;

public class GerarDados {

	public ArrayList<ObjetoSim> metodos;
	public ArrayList<String> classes;
	public ArrayList<Integer> componentes;
	public ArrayList<Classes> objetosClasses, lscc, in, out, tubes, tendrils,
			disconnected;
	public HashMap<String, ArrayList<ObjetoSim>> map;
	public HashMap<String, String> classeComponente;

	public GerarDados(ArrayList<ObjetoSim> metodos, ArrayList<String> classes,
			ArrayList<Integer> componentes) {

		this.classes = classes;
		this.componentes = componentes;
		this.metodos = metodos;

		lscc = new ArrayList<Classes>();
		in = new ArrayList<Classes>();
		out = new ArrayList<Classes>();
		tubes = new ArrayList<Classes>();
		tendrils = new ArrayList<Classes>();
		disconnected = new ArrayList<Classes>();

		mapearMetodos();
		mapearClasses();
		iniciarHash();
		ordenarArrays();

	}

	public void iniciarHash() {

		this.classeComponente = new HashMap<String, String>();

		for (Classes classe : this.objetosClasses) {

			this.classeComponente.put(classe.nome, classe.componente);
		}
	}

	public void iniciarMap() {

		map = new HashMap<String, ArrayList<ObjetoSim>>();
		ArrayList<ObjetoSim> aux;

		for (int i = 0; i < classes.size(); i++) {
			aux = new ArrayList<ObjetoSim>();
			map.put(classes.get(i), aux);
		}
	}

	public void mapearMetodos() {

		iniciarMap();

		// variaveis auxiliares
		ArrayList<ObjetoSim> aux;
		String classe;
		ObjetoSim obj;

		for (int i = 0; i < metodos.size(); i++) {
			obj = metodos.get(i);
			classe = obj.classe;
			aux = map.get(classe);
			aux.add(obj);
			map.put(classe, aux);
		}

		// tenho os m�todos mapeados nas classes
		gerarValoresClasses();
	}

	/*
	 * Metodo para gerar um array com as Classes
	 */
	private void gerarValoresClasses() {

		String classe, componente;
		int passos;
		objetosClasses = new ArrayList<Classes>();

		for (int i = 0; i < classes.size(); i++) {
			classe = classes.get(i);
			componente = this.codigoComponente(componentes.get(i));
			passos = map.get(classe).size();
			objetosClasses.add(new Classes(classe, componente, passos));
		}
	}

	private void mapearClasses() {

		Integer componente;
		String classe;
		for (int i = 0; i < objetosClasses.size(); i++) {
			componente = componentes.get(i);
			classe = objetosClasses.get(i).getNome();
			inserirArray(componente, objetosClasses.get(i));
		}

	}
	
	private void inserirArray(Integer componente, Classes objetosClasses) {

		switch (componente) {
		case 1:
			lscc.add(objetosClasses);
			break;

		case 2:
			in.add(objetosClasses);
			break;

		case 3:
			out.add(objetosClasses);
			break;

		case 4:
			tubes.add(objetosClasses);
			break;

		case 5:
			tendrils.add(objetosClasses);
			break;

		case 0:
			disconnected.add(objetosClasses);
			break;

		default:
			break;
		}
	}

	private String codigoComponente(int codigo) {

		String componente = null;

		switch (codigo) {
		case 1:
			componente = "LSCC";
			break;

		case 2:
			componente = "IN";
			break;

		case 3:
			componente = "OUT";
			break;

		case 4:
			componente = "TUBES";
			break;

		case 5:
			componente = "TENDRILS";
			break;

		case 0:
			componente = "DISCONNECTED";
			break;

		default:
			break;
		}

		return componente;
	}

	private void ordenarArrays() {

		// ordenar os arrays dos componentes
		lscc = this.ordenarClasses(lscc);
		in = this.ordenarClasses(in);
		out = this.ordenarClasses(out);
		tubes = this.ordenarClasses(tubes);
		tendrils = this.ordenarClasses(tendrils);
		disconnected = this.ordenarClasses(disconnected);

		// ordenar vetor de classes ()
		objetosClasses = this.ordenarClasses(objetosClasses);

		// ordenar array de m�todos
		metodos = this.ordenarMetodos();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Classes> ordenarClasses(ArrayList<Classes> objetos) {

		Collections.sort(objetos, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				Classes a1 = (Classes) obj1;
				Classes a2 = (Classes) obj2;
				if (a1.pesoModificacao > a2.pesoModificacao)
					return -1;
				else {
					if (a1.pesoModificacao < a2.pesoModificacao)
						return 1;
					else
						return 0;
				}
			}
		});

		return objetos;
	}

	public ArrayList<ObjetoSim> ordenarMetodos() {

		Collections.sort(this.metodos, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				ObjetoSim a1 = (ObjetoSim) obj1;
				ObjetoSim a2 = (ObjetoSim) obj2;
				if (a1.caminhoMetodo.size() > a2.caminhoMetodo.size())
					return -1;
				else {
					if (a1.caminhoMetodo.size() < a2.caminhoMetodo.size())
						return 1;
					else
						return 0;
				}

			}
		});

		return metodos;
	}

	// Gets

	public ArrayList<Classes> getLscc() {
		return lscc;
	}

	public ArrayList<Classes> getIn() {
		return in;
	}

	public ArrayList<Classes> getOut() {
		return out;
	}

	public ArrayList<Classes> getTubes() {
		return tubes;
	}

	public ArrayList<Classes> getTendrils() {
		return tendrils;
	}

	public ArrayList<Classes> getDisconnected() {
		return disconnected;
	}

	public ArrayList<Classes> getObjetosClasses() {
		return objetosClasses;
	}

	public ArrayList<ObjetoSim> getMetodos() {
		return metodos;
	}

	public HashMap<String, ArrayList<ObjetoSim>> getMap() {
		return map;
	}

}

/*
 * "Legenda Clu"
 * 
 * 1 - LSSC: Largest Strongly Connected Component 2 - IN 3 - OUT 4 - TUBES 5 -
 * TENDRILS 0 - OTHERS
 */