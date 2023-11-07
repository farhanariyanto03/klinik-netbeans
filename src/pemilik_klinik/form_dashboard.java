
package pemilik_klinik;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import petugas_klinik.config;


public class form_dashboard extends javax.swing.JFrame {

    
    public form_dashboard() {
        initComponents();
        jumlahDokter();
        jumlahPasien();
        jumlahPetugas();
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
    
    public void jumlahPetugas(){
        try{
            java.sql.Connection conn = (Connection)config.configDB();
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("select count(*) as jumlah from tb_petugas");
            
            while (result.next()) {
     
                lbl_totalPegawai.setText(result.getString("jumlah"));
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

        lbl_totalDokter = new javax.swing.JLabel();
        lbl_totalPegawai = new javax.swing.JLabel();
        lbl_totalPasien = new javax.swing.JLabel();
        lbl_laporan = new javax.swing.JLabel();
        lbl_petugas = new javax.swing.JLabel();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_keluar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbl_nama.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbl_nama.setText(".");
        getContentPane().add(lbl_nama);
        lbl_nama.setBounds(710, 460, 130, 25);

        lbl_totalDokter.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_totalDokter.setText("20");
        getContentPane().add(lbl_totalDokter);
        lbl_totalDokter.setBounds(460, 210, 40, 37);

        lbl_totalPegawai.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_totalPegawai.setText("20");
        getContentPane().add(lbl_totalPegawai);
        lbl_totalPegawai.setBounds(710, 210, 40, 37);

        lbl_totalPasien.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbl_totalPasien.setText("20");
        getContentPane().add(lbl_totalPasien);
        lbl_totalPasien.setBounds(950, 205, 40, 37);

        lbl_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_laporanMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_laporan);
        lbl_laporan.setBounds(50, 460, 250, 50);

        lbl_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_petugasMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_petugas);
        lbl_petugas.setBounds(50, 330, 250, 40);

        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dashboard);
        lbl_dashboard.setBounds(50, 190, 250, 50);

        lbl_dokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dokterMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dokter);
        lbl_dokter.setBounds(50, 260, 250, 50);

        lbl_pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pasienMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_pasien);
        lbl_pasien.setBounds(50, 390, 250, 50);

        lbl_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_keluarMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_keluar);
        lbl_keluar.setBounds(70, 730, 130, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form Dashboard owner.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 800);

        setSize(new java.awt.Dimension(1098, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        this.setVisible(false);
        new form_dashboard().setVisible(true);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_dokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dokterMouseClicked
        this.setVisible(false);
        new form_dokter().setVisible(true);
    }//GEN-LAST:event_lbl_dokterMouseClicked

    private void lbl_petugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_petugasMouseClicked
        this.setVisible(false);
        new form_petugas().setVisible(true);
    }//GEN-LAST:event_lbl_petugasMouseClicked

    private void lbl_pasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pasienMouseClicked
        this.setVisible(false);
        new form_pasien().setVisible(true);
    }//GEN-LAST:event_lbl_pasienMouseClicked

    private void lbl_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_laporanMouseClicked
        this.setVisible(false);
        new form_laporan().setVisible(true);
    }//GEN-LAST:event_lbl_laporanMouseClicked

    private void lbl_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_keluarMouseClicked
        this.setVisible(false);
        new form_login().setVisible(true);
    }//GEN-LAST:event_lbl_keluarMouseClicked

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
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dokter;
    private javax.swing.JLabel lbl_keluar;
    private javax.swing.JLabel lbl_laporan;
    public static final javax.swing.JLabel lbl_nama = new javax.swing.JLabel();
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_petugas;
    private javax.swing.JLabel lbl_totalDokter;
    private javax.swing.JLabel lbl_totalPasien;
    private javax.swing.JLabel lbl_totalPegawai;
    // End of variables declaration//GEN-END:variables
}
