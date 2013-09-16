package simulacaometodos;
import java.io.*;

public class ReferenciasEClasses implements Serializable {
    private String nomeMetodo;
    private String nomeClasseMetodo;

    public ReferenciasEClasses(String nomeMetodo, String nomeClasseMetodo) {
        this.nomeMetodo = nomeMetodo;
        this.nomeClasseMetodo = nomeClasseMetodo;
    }

    public String getNomeClasseMetodo() {
        return nomeClasseMetodo;
    }

    public void setNomeClasseMetodo(String nomeClasseMetodo) {
        this.nomeClasseMetodo = nomeClasseMetodo;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    public void imprime(){
        System.out.println("Nome metodo: " + this.getNomeMetodo() + 
                " Nome classe: " + this.getNomeClasseMetodo() /*" Assinatura: " + this.assinatura*/);
    }

}
