
package pemilik_klinik;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import petugas_klinik.config;


public class form_petugas extends javax.swing.JFrame {

    
    public form_petugas() {
        initComponents();
        datatable();
    }

    public void datatable(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Petugas");
        tbl.addColumn("Nama Petugas");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Alamat");
        tbl.addColumn("no_hp");
        tbl.addColumn("password");
        tbl_petugas.setModel(tbl);
        try{
            Statement statement = (Statement)config.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tb_petugas");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("id_petugas"),
                    res.getString("nama_petugas"),
                    res.getString("jenis_kelamin"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("password")
                });
                tbl_petugas.setModel(tbl);
            }
        }catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void cariData(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("ID Petugas");
        tbl.addColumn("Nama Petugas");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Alamat");
        tbl.addColumn("no_hp");
        tbl.addColumn("password");
        tbl_petugas.setModel(tbl);
        
        String cari = txt_cari.getText();
        
        try{
            String sql = "SELECT * FROM tb_petugas where nama_petugas like'%"+cari+"%'";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("id_petugas"),
                    res.getString("nama_petugas"),
                    res.getString("jenis_kelamin"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("password")
                  
                    
                });
                tbl_petugas.setModel(tbl);
            }
        }catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_idPetugas = new javax.swing.JTextField();
        txt_Nama = new javax.swing.JTextField();
        cmb_JK = new javax.swing.JComboBox<>();
        txt_pass = new javax.swing.JTextField();
        txt_noHp = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        lbl_tambah = new javax.swing.JLabel();
        lbl_edit = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        lbl_hapus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_petugas = new javax.swing.JTable();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_petugas = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_laporan = new javax.swing.JLabel();
        lbl_keluar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txt_idPetugas.setBorder(null);
        getContentPane().add(txt_idPetugas);
        txt_idPetugas.setBounds(390, 180, 170, 16);

        txt_Nama.setBorder(null);
        getContentPane().add(txt_Nama);
        txt_Nama.setBounds(610, 180, 170, 16);

        cmb_JK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----JENIS KELAMIN---->", "Laki - Laki", "Perempuan" }));
        cmb_JK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_JKActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_JK);
        cmb_JK.setBounds(820, 175, 185, 30);

        txt_pass.setBorder(null);
        getContentPane().add(txt_pass);
        txt_pass.setBounds(830, 255, 160, 16);

        txt_noHp.setBorder(null);
        getContentPane().add(txt_noHp);
        txt_noHp.setBounds(620, 255, 160, 16);

        txt_alamat.setBorder(null);
        getContentPane().add(txt_alamat);
        txt_alamat.setBounds(390, 255, 170, 16);

        lbl_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tambahMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_tambah);
        lbl_tambah.setBounds(600, 310, 80, 30);

        lbl_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_editMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_edit);
        lbl_edit.setBounds(700, 310, 80, 30);

        txt_cari.setBorder(null);
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });
        getContentPane().add(txt_cari);
        txt_cari.setBounds(860, 415, 160, 20);

        lbl_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hapusMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_hapus);
        lbl_hapus.setBounds(360, 410, 90, 30);

        tbl_petugas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_petugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_petugas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(370, 480, 650, 270);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form petugas owner.png"))); // NOI18N
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

    private void cmb_JKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_JKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_JKActionPerformed

    private void lbl_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tambahMouseClicked
        try {

            String sql = "INSERT INTO tb_petugas (id_petugas, nama_petugas, jenis_kelamin, alamat, no_hp, password) " +
            "VALUES ('" + txt_idPetugas.getText() + "', '" + txt_Nama.getText() + "', '" + cmb_JK.getSelectedItem() + "', " +
            "'" + txt_alamat.getText() + "', '" + txt_noHp.getText() + "', '" + txt_pass.getText() + "')";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "DATA DOKTER BERHASIL DITAMBAHKAN");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
    }//GEN-LAST:event_lbl_tambahMouseClicked

    private void lbl_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_editMouseClicked
        try{
            String sql = "UPDATE tb_petugas "
            +"SET id_petugas ='"+txt_idPetugas.getText()+"', nama_petugas = '"+txt_Nama.getText()+"', jenis_kelamin = '"+cmb_JK.getSelectedItem()+"', alamat = '"
            +txt_alamat.getText()+"', no_hp = '"+txt_noHp.getText()+"', password = '"+txt_pass.getText()
            +"'WHERE tb_petugas.id_petugas = '"+txt_idPetugas.getText()+"'";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIEDIT");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
    }//GEN-LAST:event_lbl_editMouseClicked

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        cariData();
    }//GEN-LAST:event_txt_cariKeyReleased

    private void lbl_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hapusMouseClicked
        try{
            int row = tbl_petugas.getSelectedRow();
            String id_petugas = tbl_petugas.getModel().getValueAt(row, 0).toString();
            String resultSet = "DELETE FROM tb_petugas WHERE id_petugas ='"+id_petugas+"'";

            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(resultSet);
            pst.execute();

            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHASPUS");
            datatable();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_lbl_hapusMouseClicked

    private void tbl_petugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_petugasMouseClicked
        int baris = tbl_petugas.getSelectedRow();
        if (baris != -1 ) {
            txt_idPetugas.enable(false);
            txt_idPetugas.setText(tbl_petugas.getValueAt(baris, 0).toString());
            txt_Nama.setText(tbl_petugas.getValueAt(baris, 1).toString());
            cmb_JK.setSelectedItem(tbl_petugas.getValueAt(baris, 2).toString());
            txt_alamat.setText(tbl_petugas.getValueAt(baris, 3).toString());
            txt_noHp.setText(tbl_petugas.getValueAt(baris, 4).toString());
            txt_pass.setText(tbl_petugas.getValueAt(baris, 5).toString());
        }
    }//GEN-LAST:event_tbl_petugasMouseClicked

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
            java.util.logging.Logger.getLogger(form_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_petugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_JK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dokter;
    private javax.swing.JLabel lbl_edit;
    private javax.swing.JLabel lbl_hapus;
    private javax.swing.JLabel lbl_keluar;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_petugas;
    private javax.swing.JLabel lbl_tambah;
    private javax.swing.JTable tbl_petugas;
    private javax.swing.JTextField txt_Nama;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_idPetugas;
    private javax.swing.JTextField txt_noHp;
    private javax.swing.JTextField txt_pass;
    // End of variables declaration//GEN-END:variables
}
