/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import javax.swing.JScrollPane;
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

		gerarLSCC();
		gerarIN();
		gerarOUT();
		gerarTUBES();
		gerarTENDRILS();
		gerarDISCONNECTED();
		
	}

	public void gerarLSCC() {

		tabelaLSCC = new javax.swing.JTable();

		tabelaLSCC.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null } }, 
						
						new String[] { "Classe", "Impacto"}));
		
		jScrollPane1.setViewportView(tabelaLSCC);

		jTabbedPane1.addTab("LSCC - " + dados.getTotalLSSC(), jScrollPane1);

	}

	public void gerarTUBES() {

		tabelaTUBES = new javax.swing.JTable();

		tabelaTUBES.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, 
		
						new String[] { "Classe", "Impacto"}));
		
		JScrollPane pane2 = new JScrollPane();

		pane2.setViewportView(tabelaTUBES);

		jTabbedPane1.addTab("TUBES - " + dados.getTotalTUBES(), pane2);

	}

	public void gerarTENDRILS() {

		tabelaTENDRILS = new javax.swing.JTable();

		tabelaTENDRILS.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, 
						
						new String[] { "Classe", "Impacto"}));
		
		JScrollPane pane3 = new JScrollPane();

		pane3.setViewportView(tabelaTENDRILS);

		jTabbedPane1.addTab("TENDRILS - " + dados.getTotalTENDRILS(), pane3);

	}

	public void gerarIN() {

		tabelaIN = new javax.swing.JTable();

		tabelaIN.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } },
		
						new String[] { "Classe", "Impacto"}));

		JScrollPane pane4 = new JScrollPane();

		pane4.setViewportView(tabelaIN);

		jTabbedPane1.addTab("IN - " + dados.getTotalIN(), pane4);

	}

	public void gerarOUT() {

		tabelaOUT = new javax.swing.JTable();

		tabelaOUT.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, 
						
						new String[] { "Classe", "Impacto"}));
		

		JScrollPane pane5 = new JScrollPane();
		pane5.setViewportView(tabelaOUT);

		jTabbedPane1.addTab("OUT - " + dados.getTotalOUT(), pane5);

	}

	public void gerarDISCONNECTED() {

		tabelaDISCONNECTED = new javax.swing.JTable();

		tabelaDISCONNECTED.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, 
						
						new String[] { "Classe", "Impacto"}));
		

		JScrollPane pane6 = new JScrollPane();
		pane6.setViewportView(tabelaDISCONNECTED);

		jTabbedPane1.addTab("DISCONNECTED - " + dados.getTotalDISCONNECTED(), pane6);

	}

	@SuppressWarnings("unchecked")
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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(204, 204, 204));

		jButton1.setText("Gerar Gráficos");

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
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														180, Short.MAX_VALUE)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(0,
																		0,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton3))
												.addComponent(jTextField1)
												.addComponent(jSeparator2)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addComponent(
														jSeparator3,
														javax.swing.GroupLayout.Alignment.TRAILING))
								.addContainerGap()));
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
																.addComponent(
																		jSeparator2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		10,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel2)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jTextField1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton3)
																.addGap(130,
																		130,
																		130)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton1)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		jSeparator3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		10,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jTabbedPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														456, Short.MAX_VALUE))
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		TelaPontosCriticos telaCritico = new TelaPontosCriticos();
		telaCritico.setLocation(500, 200);
		telaCritico.setVisible(true);
		telaCritico.setResizable(false);

	}// GEN-LAST:event_jButton2ActionPerformed

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
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables
}
