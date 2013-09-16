package simulacaometodos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import javax.sound.midi.Soundbank;

/**
 *
 * @author Mivian
 */
public class ObjetoSim implements Serializable{
    
    public String classe;
    public String metodo;
    public Vector caminhoMetodo;
    
    public String getClasse() {
        return classe;
    }

    public Vector getCaminhoMetodo() {
        return caminhoMetodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    
    public void setCaminhoMetodo(Vector caminhoMetodo) {
        this.caminhoMetodo = caminhoMetodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    
    public void mostrar (){
        System.out.println("\n\nClasse ="+this.classe);
        System.out.println("Método ="+this.metodo);
        System.out.println("Caminho");
        for (int i = 0; i < this.caminhoMetodo.size(); i++) {
            ReferenciasEClasses ref = (ReferenciasEClasses)caminhoMetodo.elementAt(i);
            System.out.println("**"+ref.getNomeClasseMetodo()+" "+ref.getNomeMetodo());
            
        }
    
    }
            
            
            
    
    
    
    
}
