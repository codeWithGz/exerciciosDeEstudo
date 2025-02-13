package telas;

import javax.swing.JOptionPane;
import src.FilaDeEspera;

public class Controladora extends javax.swing.JFrame {
   FilaDeEspera pacientesEsperando = new FilaDeEspera();
    
    public Controladora() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        WhitePanel = new javax.swing.JPanel();
        exibirFilaBtn = new javax.swing.JButton();
        adicionarPacienteBTN = new javax.swing.JButton();
        chamarProxBtn = new javax.swing.JButton();
        nomeTxt = new javax.swing.JTextField();
        idTxt = new javax.swing.JTextField();
        idLbl = new javax.swing.JLabel();
        NomeLbl = new javax.swing.JLabel();
        cadastrarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agendamento de Consultas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(1, 28, 102));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1112, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(1576, 24, 1112, 859);

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));
        WhitePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        WhitePanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                WhitePanelFocusGained(evt);
            }
        });
        WhitePanel.setLayout(null);

        exibirFilaBtn.setText("Exibir Fila");
        exibirFilaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exibirFilaBtnMouseClicked(evt);
            }
        });
        WhitePanel.add(exibirFilaBtn);
        exibirFilaBtn.setBounds(760, 270, 260, 220);

        adicionarPacienteBTN.setText("Adicionar Paciente");
        adicionarPacienteBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarPacienteBTNMouseClicked(evt);
            }
        });
        WhitePanel.add(adicionarPacienteBTN);
        adicionarPacienteBTN.setBounds(100, 270, 260, 220);

        chamarProxBtn.setText("Chamar Proximo");
        chamarProxBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chamarProxBtnMouseClicked(evt);
            }
        });
        WhitePanel.add(chamarProxBtn);
        chamarProxBtn.setBounds(430, 270, 260, 220);
        WhitePanel.add(nomeTxt);
        nomeTxt.setBounds(590, 80, 350, 70);

        idTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTxtActionPerformed(evt);
            }
        });
        WhitePanel.add(idTxt);
        idTxt.setBounds(160, 80, 350, 70);

        idLbl.setText("ID");
        WhitePanel.add(idLbl);
        idLbl.setBounds(170, 60, 20, 20);

        NomeLbl.setText("Nome");
        WhitePanel.add(NomeLbl);
        NomeLbl.setBounds(600, 60, 34, 16);

        cadastrarBtn.setText("Cadastrar");
        cadastrarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarBtnMouseClicked(evt);
            }
        });
        cadastrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBtnActionPerformed(evt);
            }
        });
        WhitePanel.add(cadastrarBtn);
        cadastrarBtn.setBounds(840, 160, 100, 28);

        jPanel2.add(WhitePanel);
        WhitePanel.setBounds(10, 10, 1070, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void WhitePanelFocusGained(java.awt.event.FocusEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void adicionarPacienteBTNMouseClicked(java.awt.event.MouseEvent evt) {                                                  

        idTxt.setVisible(true);
        nomeTxt.setVisible(true);
        idLbl.setVisible(true);
        NomeLbl.setVisible(true);
        cadastrarBtn.setVisible(true);

    }                                                 

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  

        idTxt.setVisible(false);
        nomeTxt.setVisible(false);
        idLbl.setVisible(false);
        NomeLbl.setVisible(false);
        cadastrarBtn.setVisible(false);
    }                                 

    private void idTxtActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void cadastrarBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void cadastrarBtnMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        
        pacientesEsperando.adicionarPaciente(Integer.parseInt(idTxt.getText()), nomeTxt.getText());
            
        idTxt.setText(null);
        nomeTxt.setText(null);

        idTxt.setVisible(false);
        nomeTxt.setVisible(false);
        idLbl.setVisible(false);
        NomeLbl.setVisible(false);
        cadastrarBtn.setVisible(false);
            
    }                                         

    private void chamarProxBtnMouseClicked(java.awt.event.MouseEvent evt) {                                           
    	
        pacientesEsperando.chamarProximoPaciente();
    }    
    
    private void exibirFilaBtnMouseClicked(java.awt.event.MouseEvent evt) {                                           
        String resposta = JOptionPane.showInputDialog("Qual ID do paciente você está procurando?");
        pacientesEsperando.procurarPacientePorId(Integer.parseInt(resposta));
    } 
    
                                  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Controladora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controladora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controladora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controladora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controladora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel NomeLbl;
    private javax.swing.JPanel WhitePanel;
    private javax.swing.JButton adicionarPacienteBTN;
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JButton chamarProxBtn;
    private javax.swing.JButton exibirFilaBtn;
    private javax.swing.JLabel idLbl;
    private javax.swing.JTextField idTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nomeTxt;
    // End of variables declaration                   
}