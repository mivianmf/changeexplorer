/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

/**
 *
 * @author Mivian
 */
public class ChangeExplorer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setLocation(500,200);
                telaInicial.setEnabled(true);
                telaInicial.setVisible(true);
                telaInicial.setResizable(false);
            }
        });
    }
}
