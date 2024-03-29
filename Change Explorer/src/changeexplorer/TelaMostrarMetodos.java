/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import simulacaometodos.ObjetoSim;

/**
 * 
 * @author Mivian
 */
public class TelaMostrarMetodos extends javax.swing.JFrame implements
		KeyListener {

	private ArrayList<ObjetoSim> objeto;
	private HashMap<String, String> classeComponente;
	private Vector posicoes;
	private int contP;

	public TelaMostrarMetodos(ArrayList<simulacaometodos.ObjetoSim> objeto,
			HashMap<String, String> classeComponente) {

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
		
		this.objeto = this.ordenarMetodos(objeto);
		int qtd = objeto.size();
		
		
		tabela.setModel(new javax.swing.table.DefaultTableModel(
				new Object[qtd][2], new String[] { "Metodo", "Impacto" }));

		jScrollPane2.setViewportView(tabela);
		String classe = objeto.get(0).classe;

		this.nomClass.setText(classe);
		this.nomeComp.setText(classeComponente.get(classe));

		for (int i = 0; i < qtd; i++) {
			ObjetoSim c = objeto.get(i);
			classe = c.classe;
			tabela.setValueAt(c.metodo, i, 0);
			tabela.setValueAt(c.impacto, i, 1);
		}
	}

	
	
	public ArrayList<ObjetoSim> ordenarMetodos(ArrayList<ObjetoSim>metodos) {

		Collections.sort(metodos, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				ObjetoSim a1 = (ObjetoSim) obj1;
				ObjetoSim a2 = (ObjetoSim) obj2;
				if (a1.impacto > a2.impacto)
					return -1;
				else {
					if (a1.impacto < a2.impacto)
						return 1;
					else
						return 0;
				}

			}
		});

		return metodos;
	}

	
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		MostrarNomeClasse = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tabela = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		linhaNomeMetodo = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		nomeComp = new javax.swing.JLabel();
		nomClass = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jButton5 = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Change Explorer");
		setBackground(new java.awt.Color(204, 204, 204));

		jPanel1.setBackground(new java.awt.Color(204, 204, 204));

		jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Métodos");
		jLabel1.setMaximumSize(new java.awt.Dimension(156, 23));
		jLabel1.setMinimumSize(new java.awt.Dimension(156, 23));
		jLabel1.setPreferredSize(new java.awt.Dimension(156, 23));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61,
				Short.MAX_VALUE));

		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(tabela);

		jButton1.setText("Detalhar");
		jButton1.setMaximumSize(new java.awt.Dimension(73, 30));
		jButton1.setMinimumSize(new java.awt.Dimension(73, 30));
		jButton1.setPreferredSize(new java.awt.Dimension(73, 30));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		linhaNomeMetodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		linhaNomeMetodo.setText("Classe:");

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
		jLabel2.setText("Componente:");

		nomeComp.setText("jLabel3");

		nomClass.setText("jLabel4");

		jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/changeexplorer/botaoLupa.png"))); // NOI18N
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap(18, Short.MAX_VALUE)
										.addComponent(
												jTextField3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												207,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jButton5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												25,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(8, 8, 8)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE,
						25, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(jTextField3));

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
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(0,
																		0,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		110,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jScrollPane2)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		MostrarNomeClasse)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										linhaNomeMetodo,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										41,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										nomClass,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										314,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(0,
																										0,
																										Short.MAX_VALUE))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel2,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										75,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(7,
																										7,
																										7)
																								.addComponent(
																										nomeComp,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										267,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										jPanel5,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap()));
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
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jPanel5,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(12,
																		44,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										MostrarNomeClasse,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										23,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(0,
																										0,
																										Short.MAX_VALUE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(0,
																										0,
																										Short.MAX_VALUE)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														jLabel2)
																												.addComponent(
																														nomeComp))
																								.addGap(14,
																										14,
																										14)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.BASELINE)
																												.addComponent(
																														linhaNomeMetodo)
																												.addComponent(
																														nomClass))))
																.addGap(18, 18,
																		18)))
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										309,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(4, 4, 4)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

		int linhaSelecionada = tabela.getSelectedRow();

		if (linhaSelecionada == -1) {
			Erro("ERRO", "Selecione a linha da tabela a ser detalhada");
		} else {

			Vector metodos = objeto.get(linhaSelecionada).caminhoMetodo;
			TelaMostrarCaminho telaCaminho = new TelaMostrarCaminho(metodos);
			telaCaminho.setLocation(500, 200);
			telaCaminho.setVisible(true);
			telaCaminho.setResizable(false);
			System.out.println("Linha " + linhaSelecionada);
		}

	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		String busca = this.jTextField3.getText();

		if (busca == null || busca.isEmpty()) {
			Erro("Erro", "Digite a palavra chave");
		} else {

			String aux1;
			posicoes = new Vector();

			for (int i = 0; i < objeto.size(); i++) {

				aux1 = objeto.get(i).metodo.toUpperCase();
				if (aux1.contains(busca.toUpperCase())) {
					posicoes.add(i);
				}
			}

			mostrarResultados();
		}
	}// GEN-LAST:event_jButton5ActionPerformed

	private void mostrarResultados() {

		this.contP = 0;
		if (posicoes.isEmpty()) {
			Aviso("", "Termo nao encontrado nesta tabela");
		} else {
			int p = (int) posicoes.get(contP);
			this.tabela.setRowSelectionInterval(p, p);
			this.tabela.addKeyListener(this);
			this.jButton5.addKeyListener(this);

			ListSelectionModel selectionModel = tabela.getSelectionModel();
			selectionModel
					.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent event) {
							tabela.scrollRectToVisible(tabela.getCellRect(
									tabela.getSelectedRow(), 0, true));
						}
					});

			contP++;
			Aviso("Aviso", "Pressione F3 para mais resultados");
		}

	}

	public void Erro(String titulo, String mensagem) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
				mensagem, titulo, javax.swing.JOptionPane.ERROR_MESSAGE);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel MostrarNomeClasse;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton5;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tabela;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JLabel linhaNomeMetodo;
	private javax.swing.JLabel nomClass;
	private javax.swing.JLabel nomeComp;

	// End of variables declaration//GEN-END:variables

	public void Aviso(String titulo, String mensagem) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
				mensagem, titulo, javax.swing.JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_F3) {

			if (contP >= posicoes.size()) {
				Aviso("", "Fim da pesquisa");
			} else {
				int p = (int) posicoes.get(contP);
				tabela.setRowSelectionInterval(p, p);
				contP++;
				ListSelectionModel selectionModel = tabela.getSelectionModel();
				selectionModel
						.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent event) {
								tabela.scrollRectToVisible(tabela.getCellRect(
										tabela.getSelectedRow(), 0, true));
							}
						});
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
