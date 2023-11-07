
package pemilik_klinik;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petugas_klinik.config;


public class form_pasien extends javax.swing.JFrame {

    
    public form_pasien() {
        initComponents();
        datatable();
        
        panel_detail.setVisible(false);
        panel_detail.setBackground(new Color(0,0,0,200));
    }

    public void datatable(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No RM");
        tbl.addColumn("NIK");
        tbl.addColumn("Nama Pasien");
        tbl.addColumn("TTGL");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Agama");
        tbl.addColumn("Status");
        tbl.addColumn("Pendidikan Terakhir");
        tbl.addColumn("Alamat");
        tbl.addColumn("No HP");
        tbl_pasien.setModel(tbl);
        try{
            Statement statement = (Statement)config.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tb_pasien");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("No_RM"),
                    res.getString("NIK"),
                    res.getString("nama_lengkap"),
                    res.getString("tggl_lahir"),
                    res.getString("jenis_kelamin"),
                    res.getString("agama"),
                    res.getString("status"),
                    res.getString("pendidikan_terakhir"),
                    res.getString("alamat"),
                    res.getString("no_hp")
                });
                tbl_pasien.setModel(tbl);
            }
        }catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void cariData(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("No RM");
        tbl.addColumn("NIK");
        tbl.addColumn("Nama Pasien");
        tbl.addColumn("TTGL");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Agama");
        tbl.addColumn("Status");
        tbl.addColumn("Pendidikan Terakhir");
        tbl.addColumn("Alamat");
        tbl.addColumn("No HP");
        
        
        tbl_pasien.setModel(tbl);
        
        String cari = txtCari.getText();
        
        try{
            String sql = "SELECT * FROM tb_pasien where nama_lengkap like'%"+cari+"%'";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("No_RM"),
                    res.getString("NIK"),
                    res.getString("nama_lengkap"),
                    res.getString("tggl_lahir"),
                    res.getString("jenis_kelamin"),
                    res.getString("agama"),
                    res.getString("status"),
                    res.getString("pendidikan_terakhir"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                  
                    
                });
                tbl_pasien.setModel(tbl);
            }
        }catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_detail = new javax.swing.JPanel();
        lbl_batal2 = new javax.swing.JLabel();
        lblNoHP = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        lblPendidikan = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblAgama = new javax.swing.JLabel();
        lblJK = new javax.swing.JLabel();
        lblTTGL = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblNIK = new javax.swing.JLabel();
        lblNoRM = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pasien = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_petugas = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_laporan = new javax.swing.JLabel();
        lbl_keluar = new javax.swing.JLabel();
        lbldetail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panel_detail.setBackground(new java.awt.Color(0, 0, 0));
        panel_detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_detailMouseEntered(evt);
            }
        });
        panel_detail.setLayout(null);

        lbl_batal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_batal2MouseClicked(evt);
            }
        });
        panel_detail.add(lbl_batal2);
        lbl_batal2.setBounds(490, 600, 100, 30);
        panel_detail.add(lblNoHP);
        lblNoHP.setBounds(410, 553, 150, 20);
        panel_detail.add(lblAlamat);
        lblAlamat.setBounds(420, 510, 210, 20);
        panel_detail.add(lblPendidikan);
        lblPendidikan.setBounds(520, 470, 180, 20);
        panel_detail.add(lblStatus);
        lblStatus.setBounds(420, 430, 220, 20);
        panel_detail.add(lblAgama);
        lblAgama.setBounds(430, 385, 230, 20);
        panel_detail.add(lblJK);
        lblJK.setBounds(475, 345, 240, 20);
        panel_detail.add(lblTTGL);
        lblTTGL.setBounds(570, 305, 180, 20);
        panel_detail.add(lblNama);
        lblNama.setBounds(470, 266, 190, 20);
        panel_detail.add(lblNIK);
        lblNIK.setBounds(400, 220, 260, 20);
        panel_detail.add(lblNoRM);
        lblNoRM.setBounds(420, 186, 250, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form detail pasien.png"))); // NOI18N
        panel_detail.add(jLabel5);
        jLabel5.setBounds(310, 150, 460, 500);

        getContentPane().add(panel_detail);
        panel_detail.setBounds(-1, -2, 1090, 810);

        tbl_pasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_pasien);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(360, 220, 650, 530);

        txtCari.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtCari.setBorder(null);
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        getContentPane().add(txtCari);
        txtCari.setBounds(850, 160, 150, 19);

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

        lbl_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_petugasMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_petugas);
        lbl_petugas.setBounds(50, 330, 250, 40);

        lbl_pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pasienMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_pasien);
        lbl_pasien.setBounds(50, 390, 250, 50);

        lbl_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_laporanMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_laporan);
        lbl_laporan.setBounds(50, 460, 250, 50);

        lbl_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_keluarMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_keluar);
        lbl_keluar.setBounds(70, 730, 130, 40);

        lbldetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldetailMouseClicked(evt);
            }
        });
        getContentPane().add(lbldetail);
        lbldetail.setBounds(340, 160, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form pasien owner.png"))); // NOI18N
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

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased

    private void lbl_batal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_batal2MouseClicked
        panel_detail.setVisible(false);
    }//GEN-LAST:event_lbl_batal2MouseClicked

    private void panel_detailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_detailMouseEntered
        panel_detail.setVisible(true);
    }//GEN-LAST:event_panel_detailMouseEntered

    private void lbldetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldetailMouseClicked
        int baris = tbl_pasien.getSelectedRow();
        if (baris != -1 ) {
            lblNoRM.setText(tbl_pasien.getValueAt(baris, 0).toString());
            lblNIK.setText(tbl_pasien.getValueAt(baris, 1).toString());
            lblNama.setText(tbl_pasien.getValueAt(baris, 2).toString());
            lblTTGL.setText(tbl_pasien.getValueAt(baris, 3).toString());
            lblJK.setText(tbl_pasien.getValueAt(baris, 4).toString());
            lblAgama.setText(tbl_pasien.getValueAt(baris, 5).toString());
            lblStatus.setText(tbl_pasien.getValueAt(baris, 6).toString());
            lblPendidikan.setText(tbl_pasien.getValueAt(baris, 7).toString());
            lblAlamat.setText(tbl_pasien.getValueAt(baris, 8).toString());
            lblNoHP.setText(tbl_pasien.getValueAt(baris, 9).toString());
        }
        panel_detail.setVisible(true);
    }//GEN-LAST:event_lbldetailMouseClicked

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
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgama;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblJK;
    private javax.swing.JLabel lblNIK;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNoHP;
    private javax.swing.JLabel lblNoRM;
    private javax.swing.JLabel lblPendidikan;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTTGL;
    private javax.swing.JLabel lbl_batal2;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dokter;
    private javax.swing.JLabel lbl_keluar;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_petugas;
    private javax.swing.JLabel lbldetail;
    private javax.swing.JPanel panel_detail;
    private javax.swing.JTable tbl_pasien;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
