
package petugas_klinik;

import java.sql.Connection;
import javax.swing.JOptionPane;
import static petugas_klinik.form_dashboard.lbl_nama;


public class form_login extends javax.swing.JFrame {

    
    public form_login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_pass = new javax.swing.JPasswordField();
        lbl_login = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_idPetugas.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_idPetugas.setBorder(null);
        getContentPane().add(txt_idPetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 355, 270, 30));

        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_pass.setBorder(null);
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 270, 30));

        lbl_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_loginMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

        setSize(new java.awt.Dimension(1098, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_loginMouseClicked
        try{
            String sql = "SELECT * FROM tb_petugas "
            + "where id_petugas = '"+txt_idPetugas.getText()+"' "
            + "AND password = '"+txt_pass.getText()+"'";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            
            if(rs.next()){
                if(txt_idPetugas.getText().equals(rs.getString("id_petugas"))
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
    public static final javax.swing.JTextField txt_idPetugas = new javax.swing.JTextField();
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}
