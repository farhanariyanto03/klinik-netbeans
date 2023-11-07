
package pemilik_klinik;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import petugas_klinik.config;


public class form_laporan extends javax.swing.JFrame {

    
    public form_laporan() {
        initComponents();
        datatable();
        
        panel_detail.setVisible(false);
        panel_detail.setBackground(new Color(0,0,0,200));
    }

    public void datatable() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Periksaan");
        tbl.addColumn("No RM");
        tbl.addColumn("Nama Pasien");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Alamat");
        tbl.addColumn("No HP");
        tbl.addColumn("Nama Dokter");
        tbl.addColumn("Jenis pelayanan");
        tbl.addColumn("Tanggal Periksa");
        tbl.addColumn("Nama Petugas");
        tbl_laporan.setModel(tbl);

        try {
            Connection conn = config.configDB();
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT tb_pemeriksaan.id_pemeriksaan, tb_pasien.No_RM, tb_pasien.nama_lengkap, tb_pasien.jenis_kelamin, \n" +
"                                                tb_pasien.alamat, tb_pasien.no_hp, tb_dokter.nama_dokter, \n" +
"                                                tb_jenispelayanan.jenis_pelayanan, tb_pemeriksaan.tggl_periksa, tb_petugas.nama_petugas\n" +
"                                                FROM tb_pemeriksaan \n" +
"                                                JOIN tb_pasien ON tb_pemeriksaan.No_RM = tb_pasien.No_RM\n" +
"                                                JOIN tb_dokter ON tb_pemeriksaan.id_dokter = tb_dokter.id_dokter\n" +
"                                                JOIN tb_jenispelayanan ON tb_pemeriksaan.id_pelayanan = tb_jenispelayanan.id_pelayanan\n" +
"                                                JOIN tb_petugas ON tb_pemeriksaan.id_petugas = tb_petugas.id_petugas\n" +
"                                                ORDER BY tb_pemeriksaan.tggl_periksa DESC");

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("id_pemeriksaan"),
                    res.getString("No_RM"),
                    res.getString("nama_lengkap"), 
                    res.getString("jenis_kelamin"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("nama_dokter"),
                    res.getString("jenis_pelayanan"),
                    res.getString("tggl_periksa"),
                    res.getString("nama_petugas")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void cariData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Periksa");
        tbl.addColumn("No RM");
        tbl.addColumn("Nama Pasien");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Alamat");
        tbl.addColumn("No HP");
        tbl.addColumn("Nama Dokter");
        tbl.addColumn("Jenis pelayanan");
        tbl.addColumn("Tanggal Periksa");
        tbl.addColumn("Nama Petugas");

        tbl_laporan.setModel(tbl);

        String cari = txtCari.getText();

        try {
            String sql = "SELECT tb_pemeriksaan.id_pemeriksaan, tb_pasien.No_RM, tb_pasien.nama_lengkap, "
                    + "tb_pasien.jenis_kelamin, tb_pasien.alamat, tb_pasien.no_hp, tb_dokter.nama_dokter, "
                    + "tb_jenispelayanan.jenis_pelayanan, tb_pemeriksaan.tggl_periksa, tb_petugas.nama_petugas "
                    + "FROM tb_pemeriksaan "
                    + "JOIN tb_pasien ON tb_pemeriksaan.No_RM = tb_pasien.No_RM "
                    + "JOIN tb_dokter ON tb_pemeriksaan.id_dokter = tb_dokter.id_dokter "
                    + "JOIN tb_jenispelayanan ON tb_pemeriksaan.id_pelayanan = tb_jenispelayanan.id_pelayanan "
                    + "JOIN tb_petugas ON tb_pemeriksaan.id_petugas = tb_petugas.id_petugas "
                    + "WHERE tb_pasien.nama_lengkap LIKE '%" + cari + "%' "
                    + "ORDER BY tb_pemeriksaan.tggl_periksa DESC;";

            java.sql.Connection conn = (Connection) config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                tbl.addRow(new Object[]{
                        res.getString("id_pemeriksaan"),
                        res.getString("No_RM"),
                        res.getString("nama_lengkap"),
                        res.getString("jenis_kelamin"),
                        res.getString("alamat"),
                        res.getString("no_hp"),
                        res.getString("nama_dokter"),
                        res.getString("jenis_pelayanan"),
                        res.getString("tggl_periksa"),
                        res.getString("nama_petugas")
                });
            }
            // Set the model to the table after the loop
            tbl_laporan.setModel(tbl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public void eksporexcelNew() {
    FileWriter fileWriter;
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File("[B]export_output/excel[/B]"));
    int retrival = chooser.showSaveDialog(null);
    if (retrival == JFileChooser.APPROVE_OPTION) {
        try {
            if (tbl_laporan != null) {
                TableModel tModel = tbl_laporan.getModel();
                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".xls"));
                // write header
                if (tModel != null) {
                    for (int i = 0; i < tModel.getColumnCount(); i++) {
                        fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");
                    }
                }
                fileWriter.write("\n");
                // write record
                for (int i = 0; i < tModel.getRowCount(); i++) {
                    for (int j = 0; j < tModel.getColumnCount(); j++) {
                        fileWriter.write(tModel.getValueAt(i, j).toString() + "\t");
                    }
                    fileWriter.write("\n");
                }
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "Data berhasil di ekspor");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_laporan = new javax.swing.JTable();
        tggl_awal = new com.toedter.calendar.JDateChooser();
        tggl_akhir = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_petugas = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_laporan = new javax.swing.JLabel();
        lbl_keluar = new javax.swing.JLabel();
        lbldetail = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btn_pdf = new javax.swing.JButton();
        btn_excel = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel_detail = new javax.swing.JPanel();
        lbltgglPeriksa = new javax.swing.JLabel();
        lblKembali = new javax.swing.JLabel();
        lblJenisPlyn = new javax.swing.JLabel();
        lblNamaDokter = new javax.swing.JLabel();
        lblNohp = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblJK = new javax.swing.JLabel();
        lblNoRM = new javax.swing.JLabel();
        lblNoperiksa = new javax.swing.JLabel();
        lblNamaPasien = new javax.swing.JLabel();
        lblNamaPetugas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tbl_laporan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_laporan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(360, 220, 650, 500);
        getContentPane().add(tggl_awal);
        tggl_awal.setBounds(340, 160, 130, 22);
        getContentPane().add(tggl_akhir);
        tggl_akhir.setBounds(500, 160, 120, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(480, 160, 10, 20);

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
        lbldetail.setBounds(750, 150, 80, 40);

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
        txtCari.setBounds(890, 160, 150, 20);

        btn_pdf.setText("Print PDF");
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pdf);
        btn_pdf.setBounds(920, 730, 85, 25);

        btn_excel.setText("Print Excel");
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_excel);
        btn_excel.setBounds(810, 730, 91, 25);

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari);
        btn_cari.setBounds(630, 160, 55, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form laporan owner.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1080, 800);

        panel_detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_detailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_detailMouseEntered(evt);
            }
        });
        panel_detail.setLayout(null);

        lbltgglPeriksa.setText("PMR000002");
        panel_detail.add(lbltgglPeriksa);
        lbltgglPeriksa.setBounds(510, 525, 180, 16);

        lblKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKembaliMouseClicked(evt);
            }
        });
        panel_detail.add(lblKembali);
        lblKembali.setBounds(500, 610, 110, 30);

        lblJenisPlyn.setText("PMR000002");
        panel_detail.add(lblJenisPlyn);
        lblJenisPlyn.setBounds(520, 485, 120, 16);

        lblNamaDokter.setText("PMR000002");
        panel_detail.add(lblNamaDokter);
        lblNamaDokter.setBounds(490, 445, 120, 16);

        lblNohp.setText("PMR000002");
        panel_detail.add(lblNohp);
        lblNohp.setBounds(440, 403, 120, 16);

        lblAlamat.setText("PMR000002");
        panel_detail.add(lblAlamat);
        lblAlamat.setBounds(450, 362, 120, 16);

        jLabel10.setText(":");
        panel_detail.add(jLabel10);
        jLabel10.setBounds(490, 320, 10, 16);

        lblJK.setText("PMR000002");
        panel_detail.add(lblJK);
        lblJK.setBounds(510, 320, 120, 16);

        lblNoRM.setText("PMR000002");
        panel_detail.add(lblNoRM);
        lblNoRM.setBounds(440, 240, 120, 16);

        lblNoperiksa.setText("PMR000002");
        panel_detail.add(lblNoperiksa);
        lblNoperiksa.setBounds(470, 200, 120, 16);

        lblNamaPasien.setText("PMR000002");
        panel_detail.add(lblNamaPasien);
        lblNamaPasien.setBounds(490, 280, 120, 16);

        lblNamaPetugas.setText("FARHAN");
        panel_detail.add(lblNamaPetugas);
        lblNamaPetugas.setBounds(460, 568, 160, 16);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form Periksa.png"))); // NOI18N
        panel_detail.add(jLabel5);
        jLabel5.setBounds(330, 160, 460, 500);

        getContentPane().add(panel_detail);
        panel_detail.setBounds(0, 0, 1080, 800);

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

    private void lbldetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldetailMouseClicked
        int baris = tbl_laporan.getSelectedRow();
        if (baris != -1 ) {
            lblNoperiksa.setText(tbl_laporan.getValueAt(baris, 0).toString());
            lblNoRM.setText(tbl_laporan.getValueAt(baris, 1).toString());
            lblNamaPasien.setText(tbl_laporan.getValueAt(baris, 2).toString());
            lblJK.setText(tbl_laporan.getValueAt(baris, 3).toString());
            lblAlamat.setText(tbl_laporan.getValueAt(baris, 4).toString());
            lblNohp.setText(tbl_laporan.getValueAt(baris, 5).toString());
            lblNamaDokter.setText(tbl_laporan.getValueAt(baris, 6).toString());
            lblJenisPlyn.setText(tbl_laporan.getValueAt(baris, 7).toString());
            lbltgglPeriksa.setText(tbl_laporan.getValueAt(baris, 8).toString());
            lblNamaPetugas.setText(tbl_laporan.getValueAt(baris, 9).toString());
        }
        panel_detail.setVisible(true);
    }//GEN-LAST:event_lbldetailMouseClicked

    private void lblKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKembaliMouseClicked
        panel_detail.setVisible(false);
    }//GEN-LAST:event_lblKembaliMouseClicked

    private void panel_detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_detailMouseClicked

    }//GEN-LAST:event_panel_detailMouseClicked

    private void panel_detailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_detailMouseEntered
        panel_detail.setVisible(true);
    }//GEN-LAST:event_panel_detailMouseEntered

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
        MessageFormat judul = new MessageFormat ("LAPORAN DATA PASIEN PERIKSA");
        MessageFormat footer = new MessageFormat ("page(0,number,integer");
        try{
            tbl_laporan.print(JTable.PrintMode.FIT_WIDTH, judul, footer);
        }catch(PrinterException e) {
            System.out.println("Eror Print");
        }
        tbl_laporan.setEnabled(true);
    }//GEN-LAST:event_btn_pdfActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        eksporexcelNew();
    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
            java.sql.Connection conn = (Connection) config.configDB();
            Statement stm = conn.createStatement();

            String format_tgl = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(format_tgl);

            DefaultTableModel model = (DefaultTableModel) tbl_laporan.getModel();
            model.setRowCount(0);

            if (tggl_awal.getDate() != null && tggl_akhir.getDate() != null) {
                String tanggal1 = fm.format(tggl_awal.getDate());
                String tanggal2 = fm.format(tggl_akhir.getDate());

                String query = "SELECT tb_pemeriksaan.id_pemeriksaan, tb_pasien.No_RM, tb_pasien.nama_lengkap, tb_pasien.jenis_kelamin, tb_pasien.alamat, tb_pasien.no_hp, " +
                               "tb_dokter.nama_dokter, tb_jenispelayanan.jenis_pelayanan, tb_pemeriksaan.tggl_periksa, tb_petugas.nama_petugas " +
                               "FROM tb_pemeriksaan " +
                               "INNER JOIN tb_pasien ON tb_pemeriksaan.No_RM = tb_pasien.No_RM " +
                               "INNER JOIN tb_dokter ON tb_pemeriksaan.id_dokter = tb_dokter.id_dokter " +
                               "INNER JOIN tb_jenispelayanan ON tb_pemeriksaan.id_pelayanan = tb_jenispelayanan.id_pelayanan " +
                               "INNER JOIN tb_petugas ON tb_pemeriksaan.id_petugas = tb_petugas.id_petugas " +
                               "WHERE tb_pemeriksaan.tggl_periksa BETWEEN '" + tanggal1 + "' AND '" + tanggal2 + "'";

                ResultSet result = stm.executeQuery(query);

                while (result.next()) {
                    // Ambil data dari ResultSet dan tambahkan ke model tabel
                    String id_pemeriksaan = result.getString("id_pemeriksaan");
                    String No_RM = result.getString("No_RM");
                    String nama_lengkap = result.getString("nama_lengkap");
                    String jenis_kelamin = result.getString("jenis_kelamin");
                    String alamat = result.getString("alamat");
                    String no_hp = result.getString("no_hp");
                    String nama_dokter = result.getString("nama_dokter");
                    String jenis_pelayanan = result.getString("jenis_pelayanan");
                    String tggl_periksa = result.getString("tggl_periksa");
                    String nama_petugas = result.getString("nama_petugas");

                    model.addRow(new Object[]{id_pemeriksaan, No_RM, nama_lengkap, jenis_kelamin, alamat, no_hp, nama_dokter, jenis_pelayanan, tggl_periksa, nama_petugas});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
}

    }//GEN-LAST:event_btn_cariActionPerformed

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
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_pdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblJK;
    private javax.swing.JLabel lblJenisPlyn;
    private javax.swing.JLabel lblKembali;
    private javax.swing.JLabel lblNamaDokter;
    private javax.swing.JLabel lblNamaPasien;
    private javax.swing.JLabel lblNamaPetugas;
    private javax.swing.JLabel lblNoRM;
    private javax.swing.JLabel lblNohp;
    private javax.swing.JLabel lblNoperiksa;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dokter;
    private javax.swing.JLabel lbl_keluar;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_petugas;
    private javax.swing.JLabel lbldetail;
    private javax.swing.JLabel lbltgglPeriksa;
    private javax.swing.JPanel panel_detail;
    private javax.swing.JTable tbl_laporan;
    private com.toedter.calendar.JDateChooser tggl_akhir;
    private com.toedter.calendar.JDateChooser tggl_awal;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
