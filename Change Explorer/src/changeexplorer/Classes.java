package changeexplorer;

import java.util.ArrayList;

import simulacaometodos.ObjetoSim;

public class Classes {
	
	public String nome;
	public int pesoModifica��o;
	
	public Classes(String nome, int pesoModifica��o) {
		super();
		this.nome = nome;
		this.pesoModifica��o = pesoModifica��o;
		
	}

	public String getNome() {
		return nome;
	}

	public int getPesoModifica��o() {
		return pesoModifica��o;
	}
}
