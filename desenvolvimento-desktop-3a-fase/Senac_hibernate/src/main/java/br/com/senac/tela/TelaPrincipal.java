/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.entidade.Usuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maken.rosa
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private final PesquisaUsuario pesqUser;
    private final CadastroUsuario cadUser;
    private final CadastroPerfil cadPerfil;
    private final PesquisaPerfil pesqPerfil;
    private MudarSenha mudarSenha;
    

    /**
     * Creates new form TelaPrincipal
     * @param user
     */
    
    public TelaPrincipal(Usuario user) {
        this.pesqUser = new PesquisaUsuario();
        this.cadUser = new CadastroUsuario();
        this.cadPerfil = new CadastroPerfil();
        this.pesqPerfil = new PesquisaPerfil();
        this.mudarSenha = new MudarSenha(user);
        initComponents();
        varWelcome.setText("Seja bem vindo, " + user.getNome()+ "!");
    }
    
    public TelaPrincipal() {
        this.pesqUser = new PesquisaUsuario();
        this.cadUser = new CadastroUsuario();
        this.cadPerfil = new CadastroPerfil();
        this.pesqPerfil = new PesquisaPerfil();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        varWelcome = new javax.swing.JLabel();
        iconeCadUser = new javax.swing.JLabel();
        iconePesqUser = new javax.swing.JLabel();
        iconePesqPerfil = new javax.swing.JLabel();
        iconeCadPerfil = new javax.swing.JLabel();
        varMenu = new javax.swing.JMenuBar();
        varMenuCad = new javax.swing.JMenu();
        varCadUser = new javax.swing.JMenuItem();
        varCadPerfil = new javax.swing.JMenuItem();
        varMenuPesq = new javax.swing.JMenu();
        varPesqUser = new javax.swing.JMenuItem();
        varPesqPerfil = new javax.swing.JMenuItem();
        varMenuConta = new javax.swing.JMenu();
        varMudarSenha = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Senac");

        varWelcome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        iconeCadUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cadUsuario.png"))); // NOI18N
        iconeCadUser.setLabelFor(iconeCadUser);
        iconeCadUser.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Adicionar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        iconeCadUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconeCadUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconeCadUserMouseClicked(evt);
            }
        });

        iconePesqUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pesqUsuario.png"))); // NOI18N
        iconePesqUser.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pesquisar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        iconePesqUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconePesqUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconePesqUserMouseClicked(evt);
            }
        });

        iconePesqPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconePesqPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pesqPerfil.png"))); // NOI18N
        iconePesqPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pesquisar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        iconePesqPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconePesqPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconePesqPerfilMouseClicked(evt);
            }
        });

        iconeCadPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconeCadPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cadPerfil.png"))); // NOI18N
        iconeCadPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Adicionar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        iconeCadPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconeCadPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconeCadPerfilMouseClicked(evt);
            }
        });

        varMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        varMenuCad.setText("Cadastro");

        varCadUser.setText("Usuario");
        varCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varCadUserActionPerformed(evt);
            }
        });
        varMenuCad.add(varCadUser);

        varCadPerfil.setText("Perfil");
        varCadPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varCadPerfilActionPerformed(evt);
            }
        });
        varMenuCad.add(varCadPerfil);

        varMenu.add(varMenuCad);

        varMenuPesq.setText("Pesquisa");

        varPesqUser.setText("Usuario");
        varPesqUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varPesqUserActionPerformed(evt);
            }
        });
        varMenuPesq.add(varPesqUser);

        varPesqPerfil.setText("Perfil");
        varPesqPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                varPesqPerfilMouseClicked(evt);
            }
        });
        varPesqPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varPesqPerfilActionPerformed(evt);
            }
        });
        varMenuPesq.add(varPesqPerfil);

        varMenu.add(varMenuPesq);

        varMenuConta.setText("Conta");

        varMudarSenha.setText("Mudar senha");
        varMudarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varMudarSenhaActionPerformed(evt);
            }
        });
        varMenuConta.add(varMudarSenha);

        varMenu.add(varMenuConta);

        setJMenuBar(varMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 424, Short.MAX_VALUE)
                        .addComponent(varWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iconeCadPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconePesqPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iconeCadUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconePesqUser)))
                        .addContainerGap(524, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(varWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconeCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(iconePesqUser, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconePesqPerfil)
                    .addComponent(iconeCadPerfil))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void varCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varCadUserActionPerformed
        // TODO add your handling code here:
        abrirCadUser();
    }//GEN-LAST:event_varCadUserActionPerformed

    private void iconePesqUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconePesqUserMouseClicked
        // TODO add your handling code here:
        abrirPesqUser();
    }//GEN-LAST:event_iconePesqUserMouseClicked

    private void iconeCadUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconeCadUserMouseClicked
        // TODO add your handling code here:
        abrirCadUser();
    }//GEN-LAST:event_iconeCadUserMouseClicked
    private void abrirCadUser(){
        cadUser.getVarPerfil().setSelectedIndex(0);
        cadUser.carregarComboPerfil();
        cadUser.getVarNome().setText("");
        cadUser.getVarLogin().setText("");
        cadUser.setVisible(true);
    }
    private void abrirPesqUser(){
        DefaultTableModel modelo = (DefaultTableModel) pesqUser.getTableUsuarios().getModel();
        pesqUser.getVarNome().setText("");
        modelo.setNumRows(0);
        pesqUser.setVisible(true);
    }
    private void varPesqUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varPesqUserActionPerformed
        // TODO add your handling code here:
        abrirPesqUser();
    }//GEN-LAST:event_varPesqUserActionPerformed
    
    private void iconeCadPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconeCadPerfilMouseClicked
        // TODO add your handling code here:
        abrirCadPerfil();
    }//GEN-LAST:event_iconeCadPerfilMouseClicked

    private void iconePesqPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconePesqPerfilMouseClicked
        // TODO add your handling code here:
        abrirPesqPerfil();
    }//GEN-LAST:event_iconePesqPerfilMouseClicked
    
    private void abrirPesqPerfil(){
        DefaultTableModel modelo = (DefaultTableModel) pesqPerfil.getTablePerfis().getModel();
        modelo.setNumRows(0);
        pesqPerfil.setVisible(true);
        pesqPerfil.pesquisarPerfis();
    }
    private void varCadPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varCadPerfilActionPerformed
        // TODO add your handling code here:
        abrirCadPerfil();
    }//GEN-LAST:event_varCadPerfilActionPerformed

    private void varPesqPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_varPesqPerfilMouseClicked
        // TODO add your handling code here:
        abrirPesqPerfil();
    }//GEN-LAST:event_varPesqPerfilMouseClicked

    private void varPesqPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varPesqPerfilActionPerformed
        // TODO add your handling code here:
        abrirPesqPerfil();
    }//GEN-LAST:event_varPesqPerfilActionPerformed

    private void varMudarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varMudarSenhaActionPerformed
        // TODO add your handling code here:
        mudarSenha.setVisible(true);
    }//GEN-LAST:event_varMudarSenhaActionPerformed

    private void abrirCadPerfil(){
        cadPerfil.getVarNome().setText("");
        cadPerfil.getVarDescricao().setText("");
        cadPerfil.setVisible(true);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconeCadPerfil;
    private javax.swing.JLabel iconeCadUser;
    private javax.swing.JLabel iconePesqPerfil;
    private javax.swing.JLabel iconePesqUser;
    private javax.swing.JMenuItem varCadPerfil;
    private javax.swing.JMenuItem varCadUser;
    private javax.swing.JMenuBar varMenu;
    private javax.swing.JMenu varMenuCad;
    private javax.swing.JMenu varMenuConta;
    private javax.swing.JMenu varMenuPesq;
    private javax.swing.JMenuItem varMudarSenha;
    private javax.swing.JMenuItem varPesqPerfil;
    private javax.swing.JMenuItem varPesqUser;
    private javax.swing.JLabel varWelcome;
    // End of variables declaration//GEN-END:variables
}
