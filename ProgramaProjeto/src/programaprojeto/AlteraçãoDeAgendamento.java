/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package programaprojeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sueli
 */
public class AlteraçãoDeAgendamento extends javax.swing.JFrame {

    /**
     * Creates new form AlteraçãoDeAgendamento
     */
    public AlteraçãoDeAgendamento() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdAgendamento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cmbHorario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(43, 39, 10, 16);

        jLabel2.setText("Horario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 110, 40, 16);
        getContentPane().add(txtIdAgendamento);
        txtIdAgendamento.setBounds(80, 40, 64, 22);

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 170, 72, 23);

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00" }));
        getContentPane().add(cmbHorario);
        cmbHorario.setBounds(120, 110, 72, 22);

        setSize(new java.awt.Dimension(236, 272));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String u, c;
u = txtIdAgendamento.getText();
c = cmbHorario.getSelectedItem().toString();

   try{
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection conectado = DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/projeto","root","admin");
   PreparedStatement st = conectado.prepareStatement
        ("UPDATE agendamentos SET horario=? WHERE agendamento_id=?"); 
	st.setString(1, c);
        st.setString(2, u);

	st.executeUpdate();
	JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");	
	
	dispose();
   } catch (ClassNotFoundException ex){
        JOptionPane.showMessageDialog(null, "Driver mão colocado na library");
   } catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro nos dados do banco de dados");
    } 
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AlteraçãoDeAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraçãoDeAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraçãoDeAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraçãoDeAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraçãoDeAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtIdAgendamento;
    // End of variables declaration//GEN-END:variables
}
