/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import simulacaometodos.ObjetoSim;

/**
 * 
 * @author Mivian
 */
public class TelaListarPontosCriticos extends javax.swing.JFrame {

	String nivel;
	int qtd;
	ArrayList<ObjetoSim> objeto;
	ArrayList<Classes> classes;
	HashMap<String, String> classeComponente;

	public TelaListarPontosCriticos(ArrayList<ObjetoSim> objeto,
			ArrayList<Classes> classes, int qtd, String nivel) {

		this.nivel = nivel;
		this.qtd = qtd;
		this.objeto = objeto;
		this.classes = classes;
		iniciarHash();
		
		initComponents();
		if (nivel.equalsIgnoreCase("classes")) {
			this.iniciarTabelaClasses();
		} else {
			this.iniciarTabelaObjetos();
		}
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
	}

	private void iniciarTabelaObjetos() {

		tabela.setModel(new javax.swing.table.DefaultTableModel(
				new Object[qtd][4], new String[] { "Componente",
						"Classe", "Metodo", "Impacto" }));

		jScrollPane1.setViewportView(tabela);
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

	private void iniciarTabelaClasses() {

		tabela.setModel(new javax.swing.table.DefaultTableModel(
				new Object[qtd][3], new String[] { "Componente",
						"Classe", "Impacto" }));

		jScrollPane1.setViewportView(tabela);

		for (int i = 0; i < qtd; i++) {
			Classes c = classes.get(i);
			tabela.setValueAt(c.componente, i, 0);
			tabela.setValueAt(c.nome, i, 1);
			tabela.setValueAt(c.pesoModificacao, i, 2);
		}
	}

	public void iniciarHash() {

		this.classeComponente = new HashMap<String, String>();

		for (Classes classe : this.classes) {

			this.classeComponente.put(classe.nome, classe.componente);
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tabela = new javax.swing.JTable();
	

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(204, 204, 204));
		jPanel1.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Lista de Pontos Cr�ticos");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										505, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										390, Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tabela;
	// End of variables declaration//GEN-END:variables
}
