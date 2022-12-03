package br.com.suportempt.tela;

import br.com.suportempt.dao.ChamadoDao;
import br.com.suportempt.dao.ChamadoDaoImpl;
import br.com.suportempt.dao.HibernateUtil;
import br.com.suportempt.entidade.Chamado;
import bt.com.suportempt.exceptions.ChamadoAtivoException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CadastrarChamado extends javax.swing.JFrame {

    private Chamado chamado;
    private final ChamadoDao chamadoDAO;
    private Session sessao;

    /**
     * Creates new form CadastroChamado
     */
    public CadastrarChamado() {
        initComponents();
        chamadoDAO = new ChamadoDaoImpl();
        lb_situacao.setVisible(false);
        btSituacao.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_titulo = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        lb_patrimonio = new javax.swing.JLabel();
        varPatrimonio = new javax.swing.JTextField();
        lb_equipamento = new javax.swing.JLabel();
        varEquipamento = new javax.swing.JComboBox<>();
        lb_observacao = new javax.swing.JLabel();
        lb_local = new javax.swing.JLabel();
        varSala = new javax.swing.JTextField();
        lb_problema = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varProblema = new javax.swing.JTextArea();
        lb_situacao = new javax.swing.JLabel();
        btSituacao = new javax.swing.JToggleButton();
        btCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Chamado");

        lb_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Cadastro de Chamado");

        lb_email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_email.setText("E-mail:");

        lb_patrimonio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_patrimonio.setText("Código do Patrimônio:");

        lb_equipamento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_equipamento.setText("Tipo do Equipamento:");

        varEquipamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um tipo...", "Computador", "Monitor", "Teclado", "Mouse", "Rede/Internet", "Impressora", "Projetor", "Áudio", "Software", "Outro..." }));

        lb_observacao.setForeground(new java.awt.Color(204, 0, 0));
        lb_observacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_observacao.setText("* Caso selecione \"outro\", informar equipamento na descrição do problema!");

        lb_local.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_local.setText("Sala do equipamento:");

        lb_problema.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_problema.setText("Descrição do Problema:");

        varProblema.setColumns(20);
        varProblema.setRows(5);
        jScrollPane1.setViewportView(varProblema);

        lb_situacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_situacao.setText("Situação:");

        btSituacao.setText("Aberto");
        btSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSituacaoActionPerformed(evt);
            }
        });

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_observacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_problema, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_situacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSituacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(varSala, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_equipamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_patrimonio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varEquipamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(varPatrimonio)
                            .addComponent(varEmail))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_email)
                    .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_patrimonio)
                    .addComponent(varPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_equipamento)
                    .addComponent(varEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_observacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_local)
                    .addComponent(varSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_problema)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCadastrar)
                        .addComponent(lb_situacao))
                    .addComponent(btSituacao))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSituacaoActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        // TODO add your handling code here:
        if (validarFormulario()) {
            try {
                chamado = new Chamado(varEmail.getText().trim().toLowerCase(),
                        varPatrimonio.getText().trim(),
                        varEquipamento.getSelectedItem().toString(),
                        varSala.getText().trim(), varProblema.getText().trim());

                sessao = HibernateUtil.abrirConexao();

                chamadoDAO.salvarOuAlterar(chamado, sessao);
            } catch (ChamadoAtivoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao emitir chamado!");
            } finally {
                sessao.close();
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarChamado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarChamado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JToggleButton btSituacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_equipamento;
    private javax.swing.JLabel lb_local;
    private javax.swing.JLabel lb_observacao;
    private javax.swing.JLabel lb_patrimonio;
    private javax.swing.JLabel lb_problema;
    private javax.swing.JLabel lb_situacao;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTextField varEmail;
    private javax.swing.JComboBox<String> varEquipamento;
    private javax.swing.JTextField varPatrimonio;
    private javax.swing.JTextArea varProblema;
    private javax.swing.JTextField varSala;
    // End of variables declaration//GEN-END:variables

    private boolean validarFormulario() {
        if (!varEmail.getText().toLowerCase().contains("alunos.sc.senac.br")) {
            JOptionPane.showMessageDialog(null, "Digite um email institucional Senac!");
            return false;
        } else if (varEquipamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de equipamento!");
            return false;
        } else if (varPatrimonio.getText().trim().length() < 6) {
            JOptionPane.showMessageDialog(null, "Digite o código do equipamento!");
            return false;
        } else if (varProblema.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Descreva o defeito que o equipamento apresenta!");
            return false;
        } else if (varSala.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite o número, ou o nome da sala!");
            return false;
        }
        try {
            sessao = HibernateUtil.abrirConexao();
            List<Chamado> ativosPatrimonio = chamadoDAO.pesquisarPorPatrimonioEAtivo(varPatrimonio.getText().trim(), sessao);
            if (ativosPatrimonio.size() > 0) {
                throw new ChamadoAtivoException();
            }
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar se código do patrimônio está ativo!");
        } catch (ChamadoAtivoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally{
            sessao.close();
        }
        return true;
    }
}
