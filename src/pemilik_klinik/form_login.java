
package pemilik_klinik;

import java.sql.Connection;
import javax.swing.JOptionPane;
import static pemilik_klinik.form_dashboard.lbl_nama;
import petugas_klinik.config;


public class form_login extends javax.swing.JFrame {

    
    public form_login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_login = new javax.swing.JLabel();
        txt_idDokter = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbl_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_loginMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_login);
        lbl_login.setBounds(770, 530, 140, 40);

        txt_idDokter.setBorder(null);
        getContentPane().add(txt_idDokter);
        txt_idDokter.setBounds(720, 355, 280, 30);

        txt_pass.setBorder(null);
        getContentPane().add(txt_pass);
        txt_pass.setBounds(720, 460, 280, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form login owner.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 800);

        setSize(new java.awt.Dimension(1098, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_loginMouseClicked
        try{
            String sql = "SELECT * FROM tb_dokter "
            + "where id_dokter = '"+txt_idDokter.getText()+"' "
            + "AND password = '"+txt_pass.getText()+"'";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            
            if(rs.next()){
                if(txt_idDokter.getText().equals(rs.getString("id_dokter"))
                    && txt_pass.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "BERHASIL LOGIN");
                this.setVisible(false);
                new form_dashboard().setVisible(true);
                lbl_nama.setText(rs.getString(2));
                }
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_lbl_loginMouseClicked

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
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JTextField txt_idDokter;
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}
