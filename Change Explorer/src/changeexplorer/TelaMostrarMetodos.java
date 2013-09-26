/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import simulacaometodos.ObjetoSim;

/**
 *
 * @author Mivian
 */
public class TelaMostrarMetodos extends javax.swing.JFrame {

	
	private ArrayList<ObjetoSim> objeto;
	private HashMap<String, String> classeComponente;
	
    /**
     * Creates new form TelaMostrarMetodos
     */
    public TelaMostrarMetodos(ArrayList<simulacaometodos.ObjetoSim> objeto, HashMap<String, String> classeComponente) {
        
    	this.objeto = objeto;
    	this.classeComponente = classeComponente;
    	
    	initComponents();
        try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        iniciarTabelaObjetos();
       
    }
    
    private void iniciarTabelaObjetos() {

    	int qtd = objeto.size();
    	
		tabela.setModel(new javax.swing.table.DefaultTableModel(
				new Object[qtd][4], new String[] { "Componente",
						"Classe", "Metodo", "Impacto" }));

		jScrollPane2.setViewportView(tabela);
		String classe;
		
		for (int i = 0; i < qtd; i++) {
			ObjetoSim c = objeto.get(i);
			classe = c.classe;
			tabela.setValueAt(classeComponente.get(classe), i, 0);
			tabela.setValueAt(classe, i, 1);
			tabela.setValueAt(c.metodo, i, 2);
			tabela.setValueAt(c.caminhoMetodo.size(), i, 3);
		}
	}
	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MostrarNomeClasse = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("M�todos");
        jLabel1.setMaximumSize(new java.awt.Dimension(156, 23));
        jLabel1.setMinimumSize(new java.awt.Dimension(156, 23));
        jLabel1.setPreferredSize(new java.awt.Dimension(156, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabela);

        jButton1.setText("Detalhar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MostrarNomeClasse, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MostrarNomeClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    	int linhaSelecionada = tabela.getSelectedRow();

		if (linhaSelecionada == -1) {
			Erro("ERRO", "Selecione a linha da tabela a ser detalhada");
		} else {
			
			Vector metodos = objeto.get(linhaSelecionada).caminhoMetodo;
			TelaMostrarCaminho  telaCaminho = new TelaMostrarCaminho(metodos);
			telaCaminho.setLocation(500, 200);
			telaCaminho.setVisible(true);
			telaCaminho.setResizable(false);
			System.out.println("Linha " + linhaSelecionada);
		}
    		
    }//GEN-LAST:event_jButton1ActionPerformed

	public void Erro(String titulo, String mensagem) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
				mensagem, titulo, javax.swing.JOptionPane.ERROR_MESSAGE);
	}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MostrarNomeClasse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
