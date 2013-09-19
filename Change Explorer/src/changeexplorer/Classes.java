package changeexplorer;

import java.util.ArrayList;

import simulacaometodos.ObjetoSim;

public class Classes {
	
	public String nome;
	public String componente;
	public int pesoModificacao;
	
	
	public Classes(String nome, String componente, int pesoModificacao) {
		super();
		this.nome = nome;
		this.componente = componente;
		this.pesoModificacao = pesoModificacao;
		
	}

	public String getNome() {
		return nome;
	}

	public int getPesoModificação() {
		return pesoModificacao;
	}
}
