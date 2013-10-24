/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import simulacaometodos.ObjetoSim;
import simulacaometodos.ReferenciasEClasses;

/**
 * 
 * @author Mivian
 */
public class TelaListarPontosCriticos extends javax.swing.JFrame implements KeyListener {

	String nivel;
	int qtd, contP;
	ArrayList<ObjetoSim> objeto;
	ArrayList<Classes> classes;
	HashMap<String, String> classeComponente;
	GerarDados dados;
	Vector posicoes;
	private HSSFWorkbook workbook = new HSSFWorkbook();
	String arq;

	public TelaListarPontosCriticos(ArrayList<ObjetoSim> objeto,
			ArrayList<Classes> classes, int qtd, String nivel, GerarDados dados) {

		this.nivel = nivel;
		this.qtd = qtd;
		this.objeto = objeto;
		this.classes = classes;
		this.dados = dados;
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
		
		gerarExcel();
	}

	public void gerarExcel (){
		
	
		HSSFSheet aba2 = workbook.createSheet("Metodos");
		
		for (int i = 0; i < qtd; i++) {
			Classes c = classes.get(i);
			
			HSSFRow row = aba2.createRow(i);
			row.createCell(0).setCellValue(c.componente);
			row.createCell(1).setCellValue(c.nome);
			row.createCell(2).setCellValue(c.pesoModificacao);
			
		}
	
	HSSFSheet aba1 = workbook.createSheet("Classes");
		
		for (int i = 0; i < qtd; i++) {
			ObjetoSim c = objeto.get(i);
			String classe = c.classe;
			
			HSSFRow row = aba1.createRow(i);
			row.createCell(0).setCellValue(classeComponente.get(classe));
			row.createCell(1).setCellValue(classe);
			row.createCell(2).setCellValue(c.metodo);
			row.createCell(3).setCellValue(c.caminhoMetodo.size());
		}
	
		try {
			FileOutputStream arquivoSaida = new FileOutputStream(new File("pontosCriticos_"+this.arq));
			workbook.write(arquivoSaida);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}
	
	
	
	
	private void iniciarTabelaObjetos() {

		tabela.setModel(new javax.swing.table.DefaultTableModel(
				new Object[qtd][4], new String[] { "Componente", "Classe",
						"Metodo", "Impacto" }));

		jScrollPane1.setViewportView(tabela);
		String classe;

		for (int i = 0; i < qtd; i++) {
			ObjetoSim c = objeto.get(i);
			classe = c.classe;
			tabela.setValueAt(classeComponente.get(classe), i, 0);
			tabela.setValueAt(classe, i, 1);
			tabela.setValueAt(c.metodo, i, 2);
			tabela.setValueAt(c.impacto, i, 3);
		}
	}

	private void iniciarTabelaClasses() {

		tabela.setModel(new javax.swing.table.DefaultTableModel(
				new Object[qtd][3], new String[] { "Componente", "Classe",
						"Impacto" }));

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
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tabela = new javax.swing.JTable();
		detalhar = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jButton5 = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();

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

		tabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tabela);

		detalhar.setText("Detalhar");
		detalhar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				detalharActionPerformed(evt);
			}
		});

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
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														676, Short.MAX_VALUE)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGap(0,
																		0,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						detalhar,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						111,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						jPanel5,
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))))
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
								.addComponent(jPanel5,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										396,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(detalhar,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		String busca = this.jTextField3.getText();

		if (busca == null || busca.isEmpty()) {
			Erro("Erro", "Digite a palavra chave");
		} else {

			String classe, metodo;
			posicoes = new Vector();
			simulacaometodos.ReferenciasEClasses visitado;

			if (nivel.equalsIgnoreCase("classes")) {

				for (int i = 0; i < classes.size(); i++) {
					classe = classes.get(i).nome.toUpperCase();
					if (classe.contains(busca.toUpperCase())) {
						posicoes.add(i);
					}
				}
			} else {

				for (int i = 0; i < objeto.size(); i++) {

					classe = objeto.get(i).classe.toUpperCase();
					metodo = objeto.get(i).metodo.toUpperCase();

					if (metodo.contains(busca.toUpperCase())
							|| classe.contains(busca.toUpperCase())) {
						posicoes.add(i);
					}
				}
			}
		}
		mostrarResultados();

	}// GEN-LAST:event_jButton5ActionPerformed

	private void mostrarResultados() {

		this.contP = 0;
		int tam = posicoes.size();

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
							tabela.scrollRectToVisible(tabela
									.getCellRect(tabela.getSelectedRow(), 0,
											true));
						}
					});

			contP++;
			Aviso("Aviso", "Pressione F3 para mais resultados");
		}

	}

	private void detalharActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botaoDetalharActionPerformed

		int linhaSelecionada = tabela.getSelectedRow();

		if (nivel.equals("metodo")) {

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
		} else {

			if (linhaSelecionada == -1) {
				Erro("ERRO", "Selecione a linha da tabela a ser detalhada");
			} else {

				String nome = classes.get(linhaSelecionada).getNome();
				ArrayList<simulacaometodos.ObjetoSim> metodos = dados.map
						.get(nome);
				TelaMostrarMetodos telaMetodos = new TelaMostrarMetodos(
						metodos, classeComponente);
				telaMetodos.setLocation(500, 200);
				telaMetodos.setVisible(true);
				telaMetodos.setResizable(false);
				System.out.println("Linha " + linhaSelecionada);
			}
		}
	}// GEN-LAST:event_botaoDetalharActionPerformed

	public void Erro(String titulo, String mensagem) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
				mensagem, titulo, javax.swing.JOptionPane.ERROR_MESSAGE);
	}

	public void Aviso(String titulo, String mensagem) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
				mensagem, titulo, javax.swing.JOptionPane.WARNING_MESSAGE);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton detalhar;
	private javax.swing.JButton jButton5;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tabela;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
}
