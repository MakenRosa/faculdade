/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.tela;

import br.com.senac.dao.HibernateUtil;
import br.com.senac.dao.PerfilDAO;
import br.com.senac.dao.PerfilDAOImpl;
import br.com.senac.dao.UsuarioDAO;
import br.com.senac.dao.UsuarioDAOImpl;
import br.com.senac.entidade.Perfil;
import br.com.senac.entidade.Usuario;
import static br.com.senac.util.Gerador.*;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maken.rosa
 */
public class CadastroUsuario extends javax.swing.JFrame {
    private Usuario user;
    private final UsuarioDAO usuarioDAO;
    private Session sessao;
    private List<Perfil> perfis;
    

    /**
     * Creates new form CadastroUsuario
     */
    public CadastroUsuario() {
        initComponents();
        usuarioDAO = new UsuarioDAOImpl();
        carregarComboPerfil();
    }

    public CadastroUsuario(Usuario usuario) {
        initComponents();
        usuarioDAO = new UsuarioDAOImpl();
        this.lblCadUser.setText("Alterar Usuário");
        this.varLogin.setText(usuario.getLogin());
        this.varNome.setText(usuario.getNome());
        this.varPerfil.setSelectedItem(usuario.getPerfil().getNome());
        user = usuario;
    }
    
    
    public final void carregarComboPerfil(){
        try {
            PerfilDAO perfilDAO = new PerfilDAOImpl();
            sessao = HibernateUtil.abrirConexao();
            perfis = perfilDAO.pesquisarTodos(sessao);
            perfis.forEach(perfil -> {
                varPerfil.addItem(perfil.getNome());
            });
        } catch (HibernateException ex){
        } finally {
            sessao.close();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadUser = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        varLogin = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        lblPerfil = new javax.swing.JLabel();
        varPerfil = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de usuário");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);

        lblCadUser.setFont(new java.awt.Font("Swis721 Blk BT", 0, 24)); // NOI18N
        lblCadUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadUser.setText("Cadastro de Usuário");
        lblCadUser.setToolTipText("");

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome:");

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLogin.setText("Login:");

        lblPerfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPerfil.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPerfil.setText("Perfil:");

        varPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um perfil" }));
        varPerfil.setName(""); // NOI18N

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
            .addComponent(lblCadUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(varLogin)
                    .addComponent(varNome, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(varPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblCadUser, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerfil)
                    .addComponent(varPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        varPerfil.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here: 
        sessao = HibernateUtil.abrirConexao();
        if (validarFormulario()){
            if (user == null){
                user = new Usuario(varNome.getText(), varLogin.getText(), gerarSenha(5));
            } else {
                user.setLogin(varLogin.getText());
                user.setNome(varNome.getText());
            }
            Perfil perfil = setarPerfil();
            try {
                user.setPerfil(perfil);
                usuarioDAO.salvarOuAlterar(user, sessao);
                JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
                user = null;
                this.dispose();
            } catch(HibernateException e){
                JOptionPane.showMessageDialog(null, "Erro ao salvar usuário!");
            } finally{
                sessao.close();
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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCadUser;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JTextField varLogin;
    private javax.swing.JTextField varNome;
    private javax.swing.JComboBox<String> varPerfil;
    // End of variables declaration//GEN-END:variables

    private boolean validarFormulario() {
        if (varNome != null && varNome.getText().length() > 1){
            if (varLogin != null && varLogin.getText().length() > 1){
                if (varPerfil.getSelectedIndex() > 0){
                    if (!perfis.get(varPerfil.getSelectedIndex()).isAtivo()){
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Esse perfil está inativo!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha um perfil válido!");
                }
            } else{
                JOptionPane.showMessageDialog(null, "Login inválido!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
        }
        return false;
    }
    public Perfil setarPerfil(){
        int index = varPerfil.getSelectedIndex();
        if (index > 0){
            return perfis.get(index-1);
        }
        return null;
    }

    public JTextField getVarLogin() {
        return varLogin;
    }

    public JTextField getVarNome() {
        return varNome;
    }

    public JComboBox<String> getVarPerfil() {
        return varPerfil;
    }

    public void setVarLogin(JTextField varLogin) {
        this.varLogin = varLogin;
    }

    public void setVarNome(JTextField varNome) {
        this.varNome = varNome;
    }

    public void setVarPerfil(JComboBox<String> varPerfil) {
        this.varPerfil = varPerfil;
    }
}
