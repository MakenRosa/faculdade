/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.UsuarioDAO;
import br.com.senac.dao.UsuarioDAOImpl;
import br.com.senac.entidade.Usuario;
import java.awt.Window;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maken.rosa
 */
public class MudarSenha extends javax.swing.JFrame {
    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private Session session;
    private TelaPrincipal mae;

    /**
     * Creates new form MudarSenha
     */
    public MudarSenha() {
        initComponents();
        usuarioDAO = new UsuarioDAOImpl();
    }
    
    public MudarSenha(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        usuarioDAO = new UsuarioDAOImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChangePassword = new javax.swing.JLabel();
        lblSenhaAntiga = new javax.swing.JLabel();
        lblNovaSenha = new javax.swing.JLabel();
        lblConfirmarSenha = new javax.swing.JLabel();
        varSenhaAntiga = new javax.swing.JPasswordField();
        varNovaSenha = new javax.swing.JPasswordField();
        varConfirmarSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar senha");

        lblChangePassword.setFont(new java.awt.Font("Swis721 Blk BT", 0, 24)); // NOI18N
        lblChangePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangePassword.setText("Mudar senha");
        lblChangePassword.setToolTipText("");

        lblSenhaAntiga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSenhaAntiga.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSenhaAntiga.setText("Senha antiga:");

        lblNovaSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNovaSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNovaSenha.setText("Nova Senha:");

        lblConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConfirmarSenha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConfirmarSenha.setText("Confirmar Senha");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNovaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSenhaAntiga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(varSenhaAntiga)
                            .addComponent(varNovaSenha)
                            .addComponent(varConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaAntiga)
                    .addComponent(varSenhaAntiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNovaSenha)
                    .addComponent(varNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmarSenha)
                    .addComponent(varConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(validarInformacoes()){
            usuario.setSenha(String.valueOf(varNovaSenha.getPassword()));
            try {
                session = HibernateUtil.abrirConexao();
                usuarioDAO.salvarOuAlterar(usuario, session);
                JOptionPane.showMessageDialog(null, "Senha alterada!");
                this.dispose();
                Window[] windows = Window.getWindows();
                for (Window window : windows) {
                    window.dispose();
                }
                new Login().setVisible(true);
            } catch (HibernateException ex){
                JOptionPane.showMessageDialog(null, "Erro ao alterar senha!");
            } finally{
                session.close();
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(MudarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MudarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MudarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MudarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MudarSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblChangePassword;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JLabel lblSenhaAntiga;
    private javax.swing.JPasswordField varConfirmarSenha;
    private javax.swing.JPasswordField varNovaSenha;
    private javax.swing.JPasswordField varSenhaAntiga;
    // End of variables declaration//GEN-END:variables

    private boolean validarInformacoes() {
        if(String.valueOf(varSenhaAntiga.getPassword()).equals(usuario.getSenha())){
            if(String.valueOf(varNovaSenha.getPassword()).equals(String.valueOf(varConfirmarSenha.getPassword()))){
                if(String.valueOf(varNovaSenha.getPassword()).length() > 5){
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "A senha deve ter no mínimo 6 caracteres!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "As senhas não coincidem!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
        }
        return false;
    }
}
