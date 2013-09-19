/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 * 
 * @author Mivian
 */
public class TelaMostrarDados extends javax.swing.JFrame {

	JTable tabelaLSCC, tabelaIN, tabelaOUT, tabelaTENDRILS, tabelaTUBES,
			tabelaDISCONNECTED;
	GerarDados dados;

	/**
	 * Creates new form TelaMostrarDados
	 */
	public TelaMostrarDados(GerarDados dados) {

		this.dados = dados;

		initComponents();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		tabelaLSCC = new javax.swing.JTable();
		tabelaIN = new javax.swing.JTable();
		tabelaOUT = new javax.swing.JTable();
		tabelaTUBES = new javax.swing.JTable();
		tabelaTENDRILS = new javax.swing.JTable();
		tabelaDISCONNECTED = new javax.swing.JTable();

		gerarLSCC();
		gerarIN();
		gerarOUT();
		gerarTUBES();
		gerarTENDRILS();
		gerarDISCONNECTED();
	}

	public void gerarLSCC() {

		ArrayList<Classes> lscc = dados.getLscc();

		int x = lscc.get(0).pesoModificacao;
		System.out.println("$" + x);
		// vetorLscc = new int [x+1];

		tabelaLSCC.setModel(new javax.swing.table.DefaultTableModel(
				new Object[lscc.size()][3], new String[] { "", "Classe",
						"Impacto" }));

		jScrollPane1.setViewportView(tabelaLSCC);
		jTabbedPane1.addTab("LSCC - " + lscc.size(), jScrollPane1);

		for (int i = 0; i < lscc.size(); i++) {
			Classes c = lscc.get(i);
			tabelaLSCC.setValueAt(i, i, 0);
			tabelaLSCC.setValueAt(c.nome, i, 1);
			tabelaLSCC.setValueAt(c.pesoModificacao, i, 2);
		}

	}

	public void gerarIN() {

		ArrayList<Classes> in = dados.getIn();

		tabelaIN.setModel(new javax.swing.table.DefaultTableModel(new Object[in
				.size()][3], new String[] { "Classe", "Impacto" }));

		JScrollPane pane2 = new JScrollPane();

		pane2.setViewportView(tabelaIN);
		jTabbedPane1.addTab("IN - " + in.size(), pane2);

		for (int i = 0; i < in.size(); i++) {
			tabelaIN.setValueAt(in.get(i).nome, i, 0);
			tabelaIN.setValueAt(in.get(i).pesoModificacao, i, 1);
		}
	}

	public void gerarOUT() {

		ArrayList<Classes> out = dados.getOut();

		tabelaOUT
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[out.size()][2], new String[] { "Classe",
								"Impacto" }));

		JScrollPane pane3 = new JScrollPane();

		pane3.setViewportView(tabelaOUT);
		jTabbedPane1.addTab("OUT - " + out.size(), pane3);

		for (int i = 0; i < out.size(); i++) {
			tabelaOUT.setValueAt(out.get(i).nome, i, 0);
			tabelaOUT.setValueAt(out.get(i).pesoModificacao, i, 1);
		}
	}

	public void gerarTUBES() {

		ArrayList<Classes> tubes = dados.getTubes();

		tabelaTUBES.setModel(new javax.swing.table.DefaultTableModel(
				new Object[tubes.size()][2],
				new String[] { "Classe", "Impacto" }));

		JScrollPane pane4 = new JScrollPane();

		pane4.setViewportView(tabelaTUBES);
		jTabbedPane1.addTab("TUBES - " + tubes.size(), pane4);

		for (int i = 0; i < tubes.size(); i++) {
			tabelaIN.setValueAt(tubes.get(i).nome, i, 0);
			tabelaIN.setValueAt(tubes.get(i).pesoModificacao, i, 1);
		}

	}

	public void gerarTENDRILS() {

		ArrayList<Classes> tendrils = dados.getTendrils();

		tabelaTENDRILS.setModel(new javax.swing.table.DefaultTableModel(
				new Object[tendrils.size()][2], new String[] { "Classe",
						"Impacto" }));

		JScrollPane pane5 = new JScrollPane();

		pane5.setViewportView(tabelaTENDRILS);
		jTabbedPane1.addTab("TENDRILS - " + tendrils.size(), pane5);

		for (int i = 0; i < tendrils.size(); i++) {
			tabelaTENDRILS.setValueAt(tendrils.get(i).nome, i, 0);
			tabelaTENDRILS.setValueAt(tendrils.get(i).pesoModificacao, i, 1);
		}
	}

	public void gerarDISCONNECTED() {

		ArrayList<Classes> disconnected = dados.getDisconnected();

		tabelaDISCONNECTED.setModel(new javax.swing.table.DefaultTableModel(
				new Object[disconnected.size()][2], new String[] { "Classe",
						"Impacto" }));

		JScrollPane pane3 = new JScrollPane();

		pane3.setViewportView(tabelaDISCONNECTED);
		jTabbedPane1.addTab("DISCONNECTED - " + disconnected.size(), pane3);

		for (int i = 0; i < disconnected.size(); i++) {
			tabelaDISCONNECTED.setValueAt(disconnected.get(i).nome, i, 0);
			tabelaDISCONNECTED.setValueAt(disconnected.get(i).pesoModificacao,
					i, 1);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JSeparator();
		jSeparator3 = new javax.swing.JSeparator();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jSeparator1 = new javax.swing.JSeparator();
		botaoDetalhar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(204, 204, 204));

		jButton1.setText("Gerar Gráficos");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Exibir Pontos Críticos");
		jButton2.setMaximumSize(new java.awt.Dimension(101, 23));
		jButton2.setMinimumSize(new java.awt.Dimension(101, 23));
		jButton2.setPreferredSize(new java.awt.Dimension(101, 23));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jPanel2.setBackground(new java.awt.Color(204, 204, 204));
		jPanel2.setBorder(javax.swing.BorderFactory
				.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Resultados Obtidos");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54,
				Short.MAX_VALUE));

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel2.setText("Localizar:");

		jButton3.setText("Localizar");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(jTable1);

		jTabbedPane1.addTab("tab1", jScrollPane1);

		botaoDetalhar.setText("Detalhar");
		botaoDetalhar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				botaoDetalharActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jTabbedPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										562,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jSeparator3)
																.addGap(18, 18,
																		18))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jButton3,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField1,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jSeparator2,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel2)
																								.addGap(0,
																										0,
																										Short.MAX_VALUE))
																				.addComponent(
																						jSeparator1,
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jButton1,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						180,
																						Short.MAX_VALUE)
																				.addComponent(
																						jButton2,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						botaoDetalhar,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addContainerGap()))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(24, 24, 24)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(26, 26,
																		26)
																.addComponent(
																		jSeparator2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		10,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jTextField1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		25,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		30,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		botaoDetalhar,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		30,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jSeparator1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		10,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		30,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		30,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		jSeparator3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		10,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jTabbedPane1))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		TelaPontosCriticos telaCritico = new TelaPontosCriticos(dados);
		telaCritico.setLocation(500, 200);
		telaCritico.setVisible(true);
		telaCritico.setResizable(false);
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jButton1ActionPerformed

	private void botaoDetalharActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoDetalharActionPerformed

		JTable tabAux = new JTable();
		ArrayList<Classes> classes = null;

		if (tabelaLSCC.isShowing()) {
			tabAux = tabelaLSCC;
			classes = dados.lscc;
			System.out.println("LSCC ON");
		} else {
			if (tabelaIN.isShowing()) {
				tabAux = tabelaIN;
				classes = dados.in;
				System.out.println("IN ON");
			} else {
				if (tabelaOUT.isShowing()) {
					tabAux = tabelaOUT;
					classes = dados.out;
					System.out.println("OUT ON");
				} else {
					if (tabelaTUBES.isShowing()) {
						tabAux = tabelaTUBES;
						classes = dados.tubes;
						System.out.println("TUBES ON");
					} else {
						if (tabelaTENDRILS.isShowing()) {
							tabAux = tabelaTENDRILS;
							classes = dados.tendrils;
							System.out.println("TENDRILS ON");
						} else {
							if (tabelaDISCONNECTED.isShowing()) {
								tabAux = tabelaDISCONNECTED;
								classes = dados.disconnected;
								System.out.println("DISCONNECTED ON");
							}
						}
					}
				}
			}
		}

		int linhaSelecionada = tabAux.getSelectedRow();

		if (linhaSelecionada == -1) {
			Erro("ERRO", "Selecione a linha da tabela a ser detalhada");
		} else {
			
			String nome = classes.get(linhaSelecionada).getNome();
			ArrayList<simulacaometodos.ObjetoSim> metodos = dados.map.get(nome);
			TelaMostrarMetodos  telaMetodos = new TelaMostrarMetodos(metodos,dados.classeComponente);
			telaMetodos.setLocation(500, 200);
			telaMetodos.setVisible(true);
			telaMetodos.setResizable(false);
			System.out.println("Linha " + linhaSelecionada);
		}

	}// GEN-LAST:event_botaoDetalharActionPerformed

	public void Erro(String titulo, String mensagem) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
				mensagem, titulo, javax.swing.JOptionPane.ERROR_MESSAGE);
	}

	/*
	 * public void expandAll(boolean expand) { TreeNode root = (TreeNode)
	 * arv.getModel().getRoot();
	 * 
	 * expandAll(new TreePath(root), expand); }
	 * 
	 * private void expandAll(TreePath parent, boolean expand) {
	 * 
	 * TreeNode no = (TreeNode) parent.getLastPathComponent(); if
	 * (no.getChildCount() >= 0) { for (Enumeration e = no.children();
	 * e.hasMoreElements();) { TreeNode n = (TreeNode) e.nextElement(); TreePath
	 * path = parent.pathByAddingChild(n); expandAll(path, expand); } }
	 * 
	 * // Expansion or collapse must be done bottom-up if (expand) {
	 * arv.expandPath(parent); } else { arv.collapsePath(parent); } }
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton botaoDetalhar;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables
}
