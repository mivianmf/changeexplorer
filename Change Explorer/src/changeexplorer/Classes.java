package changeexplorer;

import java.util.ArrayList;

import simulacaometodos.ObjetoSim;

public class Classes {
	
	public String nome;
	public int pesoModificação;
	
	public Classes(String nome, int pesoModificação) {
		super();
		this.nome = nome;
		this.pesoModificação = pesoModificação;
		
	}

	public String getNome() {
		return nome;
	}

	public int getPesoModificação() {
		return pesoModificação;
	}
}
