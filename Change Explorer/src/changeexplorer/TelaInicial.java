/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package changeexplorer;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mivian
 */
class TelaInicial extends javax.swing.JFrame {

    private String caminhoArqSim;
    private String caminhoArqClu;
    private String caminhoArqNet;
    
    public TelaInicial() {
        initComponents();
        this.setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        
        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Analisar Propaga��o");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Selecionar Arquivo .sim");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Selecionar Arquivo .clu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("Gerar Dados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Selecionar Arquivo .net");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser arquivo = new JFileChooser();

        arquivo.setMultiSelectionEnabled(true);
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        arquivo.setFileFilter(new FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sim");
            }

            public String getDescription() {
                return "Arquivo .sim";
            }
        });

        int returnVal = arquivo.showOpenDialog(this);

        if (returnVal == arquivo.APPROVE_OPTION) {

            caminhoArqSim = arquivo.getSelectedFile().getPath();
            System.out.println("Pegando caminho clu: "+caminhoArqSim);
            
            String nomeBonito = arquivo.getSelectedFile().getName();

            jTextField1.setText(nomeBonito);

        }

    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser arquivo = new JFileChooser();

        arquivo.setMultiSelectionEnabled(true);
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        arquivo.setFileFilter(new FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".clu");
            }

            public String getDescription() {
                return "Arquivo .clu";
            }
        });

        int returnVal = arquivo.showOpenDialog(this);

        if (returnVal == arquivo.APPROVE_OPTION) {

            caminhoArqClu = arquivo.getSelectedFile().getPath();
            
            String nomeBonito = arquivo.getSelectedFile().getName();
            jTextField2.setText(nomeBonito);

        }
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
               
    	this.caminhoArqSim = "C:/Users/Mivian/Documents/Arquivos .sim/logisim.sim";
    	this.caminhoArqClu = "C:/Users/Mivian/Documents/Arquivos .clu/logisim.clu";
    	this.caminhoArqNet = "C:/Users/Mivian/Documents/Arquivos .net/logisim.net";
    	
    	
    	
        if (this.caminhoArqSim.contains(".sim")){
        TratarArquivoSim tratarSim = new TratarArquivoSim(caminhoArqSim);
        TratarArquivoNet tratarNet = new TratarArquivoNet(caminhoArqNet);
        TratarArquivoClu tratarClu = new TratarArquivoClu(caminhoArqClu);
        
        ArrayList<simulacaometodos.ObjetoSim> objetosSim = tratarSim.getArraySim();
        ArrayList<Integer> componentes = tratarClu.getArrayClu();
        ArrayList<String> classes = tratarNet.getArrayNet();
        
        GerarDados gerarDados = new GerarDados(objetosSim, classes, componentes);
        
        
        TelaMostrarDados telaDados = new TelaMostrarDados(gerarDados);
        telaDados.setVisible(true);
        telaDados.setLocation(350,5);
        telaDados.setResizable(false);
        
        
        }
        else{
        	Erro ("Arquivo Inválido", "O arquivo selecionado não é um arquivo .sim");
        }
        
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser arquivo = new JFileChooser();

        arquivo.setMultiSelectionEnabled(true);
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        arquivo.setFileFilter(new FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".net");
            }

            public String getDescription() {
                return "Arquivo .net";
            }
        });

        int returnVal = arquivo.showOpenDialog(this);

        if (returnVal == arquivo.APPROVE_OPTION) {

            caminhoArqNet = arquivo.getSelectedFile().getPath();
            System.out.println("Pegando caminho clu: "+caminhoArqNet);
            String nomeBonito = arquivo.getSelectedFile().getName();

            jTextField3.setText(nomeBonito);

        }
    }                                        

    public void Erro(String titulo, String mensagem){
        javax.swing.JOptionPane.showMessageDialog(new javax.swing.JFrame(), mensagem, 
                                    titulo, javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration                   
}
