
package petugas_klinik;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class form_dashboard extends javax.swing.JFrame {

    
    public form_dashboard() {
        initComponents();
        jumlahDokter();
       jumlahPasien();
    }

    public void jumlahDokter(){
        try{
            java.sql.Connection conn = (Connection)config.configDB();
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("select count(*) as jumlah from tb_dokter");
            
            while (result.next()) {
     
                lbl_totalDokter.setText(result.getString("jumlah"));
            }
             
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    public void jumlahPasien(){
        try{
            java.sql.Connection conn = (Connection)config.configDB();
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("select count(*) as jumlah from tb_pasien");
            
            while (result.next()) {
     
                lbl_totalPasien.setText(result.getString("jumlah"));
            }
             
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_periksa = new javax.swing.JLabel();
        lbl_totalDokter = new javax.swing.JLabel();
        lbl_totalPasien = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 210, 40));

        lbl_pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pasienMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 220, 50));

        lbl_dokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dokterMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 230, 40));

        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 230, 40));

        lbl_periksa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_periksaMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_periksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 220, 40));

        lbl_nama.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_nama.setText(".");
        getContentPane().add(lbl_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 90, -1));

        lbl_totalDokter.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_totalDokter.setText(".");
        getContentPane().add(lbl_totalDokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 40, -1));

        lbl_totalPasien.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_totalPasien.setText(".");
        getContentPane().add(lbl_totalPasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 50, -1));

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 730, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form Dashboard.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

        setSize(new java.awt.Dimension(1098, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_dokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dokterMouseClicked
        this.setVisible(false);
        new form_dokter().setVisible(true);
    }//GEN-LAST:event_lbl_dokterMouseClicked

    private void lbl_pasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pasienMouseClicked
        this.setVisible(false);
        new form_pasien().setVisible(true);
    }//GEN-LAST:event_lbl_pasienMouseClicked

    private void lbl_periksaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_periksaMouseClicked
        this.setVisible(false);
        new form_periksa().setVisible(true);
    }//GEN-LAST:event_lbl_periksaMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        new form_login().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        this.setVisible(false);
        new form_dashboard().setVisible(true);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        this.setVisible(false);
        new form_login().setVisible(true);
    }//GEN-LAST:event_lblKeluarMouseClicked

    
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
            java.util.logging.Logger.getLogger(form_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dokter;
    public static final javax.swing.JLabel lbl_nama = new javax.swing.JLabel();
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_periksa;
    private javax.swing.JLabel lbl_totalDokter;
    private javax.swing.JLabel lbl_totalPasien;
    // End of variables declaration//GEN-END:variables
}
