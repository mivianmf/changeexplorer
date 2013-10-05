/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import simulacaometodos.ReferenciasEClasses;

/**
 * 
 * @author Mivian
 */
public class TelaMostrarCaminho extends javax.swing.JFrame implements KeyListener {

	Vector caminho,posicoes;
	int contP;
	JTable tabelaAux;

	/**
	 * Creates new form TelaMostrarCaminho
	 */
	public TelaMostrarCaminho(Vector caminho) {
		this.caminho = caminho;

		initComponents();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		iniciarTabelaCaminho();

	}

	public void iniciarTabelaCaminho() {


		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[caminho.size()][2], new String[] { "Classe", "Metodo"}));

		jScrollPane1.setViewportView(jTable1);
		
		ReferenciasEClasses visitado;
		String classe, metodo;
		
		for (int i = 0; i < caminho.size(); i++) {
			visitado = (ReferenciasEClasses)caminho.elementAt(i);
            classe = visitado.getNomeClasseMetodo();
            metodo = visitado.getNomeMetodo();
            this.jTable1.setValueAt(classe, i, 0);
            this.jTable1.setValueAt(classe, i, 1);
		}
	}

	private void mostrarResultados() {

		this.contP = 0; 
			int tam = posicoes.size();
		
		if (posicoes.isEmpty()) {
			Aviso("Aviso", "Termo nao encontrado nesta tabela");
		} else {
			int p = (int) posicoes.get(contP);
			this.tabelaAux.setRowSelectionInterval(p, p);
			this.tabelaAux.addKeyListener(this);
			this.jButton3.addKeyListener(this);
			
			ListSelectionModel selectionModel = tabelaAux.getSelectionModel();  
			selectionModel.addListSelectionListener(new ListSelectionListener() {  
			    public void valueChanged(ListSelectionEvent event) {  
			        tabelaAux.scrollRectToVisible(tabelaAux.getCellRect(  
			                tabelaAux.getSelectedRow(), 0, true));  
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

	public void Aviso(String titulo, String mensagem) {
		javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(),
				mensagem, titulo, javax.swing.JOptionPane.WARNING_MESSAGE);
	}
	
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descreverMetodo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nomMetod = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeClasse = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeCompo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Change Explorer");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caminho de Propagação");

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

        descreverMetodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descreverMetodo.setText("Método:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        nomMetod.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Classe:");

        nomeClasse.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Componente:");

        nomeCompo.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Dados do Detalhamento");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/changeexplorer/botaoLupa.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField3)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descreverMetodo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomMetod, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeClasse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeCompo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nomeCompo)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeClasse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomMetod)
                    .addComponent(descreverMetodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    	String busca = this.jTextField3.getText();

		if (busca == null || busca.isEmpty()) {
			Erro("Erro","Digite a palavra chave");
		} else {
						
			String classe, metodo;
			posicoes = new Vector();
			simulacaometodos.ReferenciasEClasses visitado;
			
			for (int i = 0; i < caminho.size(); i++) {
				
				
					visitado = (ReferenciasEClasses)caminho.elementAt(i);
		            classe = visitado.getNomeClasseMetodo().toUpperCase();
		            metodo = visitado.getNomeMetodo().toUpperCase();
		            
				if (metodo.contains(busca.toUpperCase()) || classe.contains(busca.toUpperCase())) {				
					posicoes.add(i);
				}
			}

			mostrarResultados();
		}    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descreverMetodo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel nomMetod;
    private javax.swing.JLabel nomeClasse;
    private javax.swing.JLabel nomeCompo;
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
				jTable1.setRowSelectionInterval(p, p);
				contP++;
				ListSelectionModel selectionModel = jTable1.getSelectionModel();
				selectionModel
						.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent event) {
								jTable1.scrollRectToVisible(jTable1.getCellRect(
										jTable1.getSelectedRow(), 0, true));
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
