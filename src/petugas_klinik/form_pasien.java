
package petugas_klinik;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class form_pasien extends javax.swing.JFrame {

    
    public form_pasien() {
        initComponents();
        datatable();
        
        //===========================Setting Panel===========================//
        panel_tambah.setVisible(false);
        panel_tambah.setBackground(new Color(0,0,0,200));
        panel_edit.setVisible(false);
        panel_edit.setBackground(new Color(0,0,0,200));
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

        panel_tambah = new javax.swing.JPanel();
        txt_noHP = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_status = new javax.swing.JTextField();
        txt_noKTP = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_ttgl = new javax.swing.JTextField();
        txt_pendidikan = new javax.swing.JTextField();
        cmb_agama = new javax.swing.JComboBox<>();
        cmb_jenisKelamin = new javax.swing.JComboBox<>();
        lbl_batal = new javax.swing.JLabel();
        lbl_tambah = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        panel_edit = new javax.swing.JPanel();
        txt_noHP1 = new javax.swing.JTextField();
        txt_alamat1 = new javax.swing.JTextField();
        txt_status1 = new javax.swing.JTextField();
        txt_noKTP1 = new javax.swing.JTextField();
        txt_nama1 = new javax.swing.JTextField();
        txt_ttgl1 = new javax.swing.JTextField();
        txt_pendidikan1 = new javax.swing.JTextField();
        txt_noRM1 = new javax.swing.JTextField();
        cmb_agama1 = new javax.swing.JComboBox<>();
        cmb_jenisKelamin1 = new javax.swing.JComboBox<>();
        lbl_batal1 = new javax.swing.JLabel();
        lbl_edit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pasien = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_periksa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbledit = new javax.swing.JLabel();
        lblhapus = new javax.swing.JLabel();
        lbltambah = new javax.swing.JLabel();
        lbldetail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_tambah.setBackground(new java.awt.Color(0, 0, 0));
        panel_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_tambahMouseEntered(evt);
            }
        });
        panel_tambah.setLayout(null);

        txt_noHP.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_noHP.setBorder(null);
        txt_noHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noHPActionPerformed(evt);
            }
        });
        panel_tambah.add(txt_noHP);
        txt_noHP.setBounds(570, 530, 250, 19);

        txt_alamat.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_alamat.setBorder(null);
        txt_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatActionPerformed(evt);
            }
        });
        panel_tambah.add(txt_alamat);
        txt_alamat.setBounds(270, 530, 230, 19);

        txt_status.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_status.setBorder(null);
        txt_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_statusActionPerformed(evt);
            }
        });
        panel_tambah.add(txt_status);
        txt_status.setBounds(270, 440, 230, 19);

        txt_noKTP.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_noKTP.setBorder(null);
        txt_noKTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noKTPActionPerformed(evt);
            }
        });
        panel_tambah.add(txt_noKTP);
        txt_noKTP.setBounds(420, 169, 250, 30);

        txt_nama.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_nama.setBorder(null);
        panel_tambah.add(txt_nama);
        txt_nama.setBounds(270, 260, 230, 19);

        txt_ttgl.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_ttgl.setBorder(null);
        panel_tambah.add(txt_ttgl);
        txt_ttgl.setBounds(570, 260, 250, 19);

        txt_pendidikan.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_pendidikan.setBorder(null);
        panel_tambah.add(txt_pendidikan);
        txt_pendidikan.setBounds(580, 440, 240, 19);

        cmb_agama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----AGAMA----->", "Islam", "Kristen", "Khatolik", "Hindu", "Budha" }));
        panel_tambah.add(cmb_agama);
        cmb_agama.setBounds(550, 340, 290, 40);

        cmb_jenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH JENIS---->", "Laki - Laki", "Perempuan" }));
        panel_tambah.add(cmb_jenisKelamin);
        cmb_jenisKelamin.setBounds(240, 340, 290, 40);

        lbl_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_batalMouseClicked(evt);
            }
        });
        panel_tambah.add(lbl_batal);
        lbl_batal.setBounds(570, 600, 80, 40);

        lbl_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tambahMouseClicked(evt);
            }
        });
        panel_tambah.add(lbl_tambah);
        lbl_tambah.setBounds(420, 600, 100, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form input pasien.png"))); // NOI18N
        panel_tambah.add(jLabel3);
        jLabel3.setBounds(230, 110, 640, 560);

        getContentPane().add(panel_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

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

        getContentPane().add(panel_detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

        panel_edit.setBackground(new java.awt.Color(0, 0, 0));
        panel_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_editMouseEntered(evt);
            }
        });
        panel_edit.setLayout(null);

        txt_noHP1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_noHP1.setBorder(null);
        txt_noHP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noHP1ActionPerformed(evt);
            }
        });
        panel_edit.add(txt_noHP1);
        txt_noHP1.setBounds(570, 530, 250, 19);

        txt_alamat1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_alamat1.setBorder(null);
        txt_alamat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamat1ActionPerformed(evt);
            }
        });
        panel_edit.add(txt_alamat1);
        txt_alamat1.setBounds(270, 530, 230, 19);

        txt_status1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_status1.setBorder(null);
        txt_status1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_status1ActionPerformed(evt);
            }
        });
        panel_edit.add(txt_status1);
        txt_status1.setBounds(270, 440, 230, 19);

        txt_noKTP1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_noKTP1.setBorder(null);
        panel_edit.add(txt_noKTP1);
        txt_noKTP1.setBounds(570, 170, 250, 19);

        txt_nama1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_nama1.setBorder(null);
        panel_edit.add(txt_nama1);
        txt_nama1.setBounds(270, 260, 230, 19);

        txt_ttgl1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_ttgl1.setBorder(null);
        panel_edit.add(txt_ttgl1);
        txt_ttgl1.setBounds(570, 260, 250, 19);

        txt_pendidikan1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_pendidikan1.setBorder(null);
        panel_edit.add(txt_pendidikan1);
        txt_pendidikan1.setBounds(580, 440, 240, 19);

        txt_noRM1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_noRM1.setBorder(null);
        panel_edit.add(txt_noRM1);
        txt_noRM1.setBounds(270, 170, 220, 19);

        cmb_agama1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----AGAMA----->", "Islam", "Kristen", "Khatolik", "Hindu", "Budha" }));
        panel_edit.add(cmb_agama1);
        cmb_agama1.setBounds(550, 340, 290, 40);

        cmb_jenisKelamin1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH JENIS---->", "Laki - Laki", "Perempuan" }));
        panel_edit.add(cmb_jenisKelamin1);
        cmb_jenisKelamin1.setBounds(240, 340, 290, 40);

        lbl_batal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_batal1MouseClicked(evt);
            }
        });
        panel_edit.add(lbl_batal1);
        lbl_batal1.setBounds(570, 600, 80, 40);

        lbl_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_editMouseClicked(evt);
            }
        });
        panel_edit.add(lbl_edit);
        lbl_edit.setBounds(440, 600, 80, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form edit pasien.png"))); // NOI18N
        panel_edit.add(jLabel4);
        jLabel4.setBounds(230, 110, 640, 560);

        getContentPane().add(panel_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

        tbl_pasien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
        tbl_pasien.setRowHeight(40);
        tbl_pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pasien);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 640, 520));

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
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 160, 20));

        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 230, 40));

        lbl_dokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dokterMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 230, 40));

        lbl_pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pasienMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 240, 40));

        lbl_periksa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_periksaMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_periksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 230, 40));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 730, 210, 40));

        lbledit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbleditMouseClicked(evt);
            }
        });
        getContentPane().add(lbledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 80, 30));

        lblhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhapusMouseClicked(evt);
            }
        });
        getContentPane().add(lblhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 80, 40));

        lbltambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbltambahMouseClicked(evt);
            }
        });
        getContentPane().add(lbltambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 80, 30));

        lbldetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldetailMouseClicked(evt);
            }
        });
        getContentPane().add(lbldetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form Pasien.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

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

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased

    private void lbltambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltambahMouseClicked
        panel_tambah.setVisible(true);
    }//GEN-LAST:event_lbltambahMouseClicked

    private void txt_noHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noHPActionPerformed

    private void lbl_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_batalMouseClicked
        panel_tambah.setVisible(false);
    }//GEN-LAST:event_lbl_batalMouseClicked

    private void lbl_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tambahMouseClicked
        try {
            
            String sql = "INSERT INTO tb_pasien (NIK, nama_lengkap, tggl_lahir, jenis_kelamin, agama, status, pendidikan_terakhir, alamat, no_hp) " +
             "VALUES ('" + txt_noKTP.getText() + "', '" + txt_nama.getText() + "', '" + txt_ttgl.getText() + "', '" + cmb_jenisKelamin.getSelectedItem() + "', " +
             "'" + cmb_agama.getSelectedItem() + "', '" + txt_status.getText() + "', '" + txt_pendidikan.getText() + "', " +
             "'" + txt_alamat.getText() + "', '" + txt_noHP.getText() + "')";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            
            panel_tambah.setVisible(false);
            JOptionPane.showMessageDialog(null, "DATA PASIEN BERHASIL DITAMBAHKAN");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
    }//GEN-LAST:event_lbl_tambahMouseClicked

    private void txt_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_statusActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void txt_noHP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noHP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noHP1ActionPerformed

    private void txt_alamat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamat1ActionPerformed

    private void txt_status1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_status1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_status1ActionPerformed

    private void lbl_batal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_batal1MouseClicked
        panel_edit.setVisible(false);
    }//GEN-LAST:event_lbl_batal1MouseClicked

    private void lbl_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_editMouseClicked
        try{
            String sql = "UPDATE tb_pasien "
                    +"SET NIK ='"+txt_noKTP1.getText()+"', nama_lengkap = '"+txt_nama1.getText()+"', tggl_lahir = '"+txt_ttgl1.getText()+"', jenis_kelamin = '"
                    +cmb_jenisKelamin1.getSelectedItem()+"', agama = '"+cmb_agama1.getSelectedItem()+"', status = '"+txt_status1.getText()+"', pendidikan_terakhir = '"
                    +txt_pendidikan1.getText()+"', alamat = '"+txt_alamat1.getText()+"', no_hp = '"+txt_noHP1.getText()
                    +"'WHERE tb_pasien.No_RM = '"+txt_noRM1.getText()+"'";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIEDIT");
            panel_edit.setVisible(false);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();      
    }//GEN-LAST:event_lbl_editMouseClicked

    private void lbleditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbleditMouseClicked
        panel_edit.setVisible(true);
    }//GEN-LAST:event_lbleditMouseClicked

    private void tbl_pasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pasienMouseClicked
        int baris = tbl_pasien.getSelectedRow();
        if (baris != -1 ) {
            txt_noRM1.enable(false);
            txt_noRM1.setText(tbl_pasien.getValueAt(baris, 0).toString());
            txt_noKTP1.setText(tbl_pasien.getValueAt(baris, 1).toString());
            txt_nama1.setText(tbl_pasien.getValueAt(baris, 2).toString());
            txt_ttgl1.setText(tbl_pasien.getValueAt(baris, 3).toString());
            cmb_jenisKelamin1.setSelectedItem(tbl_pasien.getValueAt(baris, 4).toString());
            cmb_agama1.setSelectedItem(tbl_pasien.getValueAt(baris, 5).toString());
            txt_status1.setText(tbl_pasien.getValueAt(baris, 6).toString());
            txt_pendidikan1.setText(tbl_pasien.getValueAt(baris, 7).toString());
            txt_alamat1.setText(tbl_pasien.getValueAt(baris, 8).toString());
            txt_noHP1.setText(tbl_pasien.getValueAt(baris, 9).toString());
        }
    }//GEN-LAST:event_tbl_pasienMouseClicked

    private void lblhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhapusMouseClicked
        try{
            int row = tbl_pasien.getSelectedRow();
            String No_RM = tbl_pasien.getModel().getValueAt(row, 0).toString();
            String resultSet = "DELETE FROM tb_pasien WHERE No_RM='"+No_RM+"'";

            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(resultSet);
            pst.execute();

            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHASPUS");
            datatable();
 
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_lblhapusMouseClicked

    private void lbl_batal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_batal2MouseClicked
        panel_detail.setVisible(false);
    }//GEN-LAST:event_lbl_batal2MouseClicked

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

    private void panel_detailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_detailMouseEntered
        panel_detail.setVisible(true);
    }//GEN-LAST:event_panel_detailMouseEntered

    private void panel_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_editMouseEntered
        panel_edit.setVisible(true);
    }//GEN-LAST:event_panel_editMouseEntered

    private void panel_tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_tambahMouseEntered
        panel_tambah.setVisible(true);
    }//GEN-LAST:event_panel_tambahMouseEntered

    private void txt_noKTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noKTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noKTPActionPerformed

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
    private javax.swing.JComboBox<String> cmb_agama;
    private javax.swing.JComboBox<String> cmb_agama1;
    private javax.swing.JComboBox<String> cmb_jenisKelamin;
    private javax.swing.JComboBox<String> cmb_jenisKelamin1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel lbl_batal;
    private javax.swing.JLabel lbl_batal1;
    private javax.swing.JLabel lbl_batal2;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dokter;
    private javax.swing.JLabel lbl_edit;
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_periksa;
    private javax.swing.JLabel lbl_tambah;
    private javax.swing.JLabel lbldetail;
    private javax.swing.JLabel lbledit;
    private javax.swing.JLabel lblhapus;
    private javax.swing.JLabel lbltambah;
    private javax.swing.JPanel panel_detail;
    private javax.swing.JPanel panel_edit;
    private javax.swing.JPanel panel_tambah;
    private javax.swing.JTable tbl_pasien;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_alamat1;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nama1;
    private javax.swing.JTextField txt_noHP;
    private javax.swing.JTextField txt_noHP1;
    private javax.swing.JTextField txt_noKTP;
    private javax.swing.JTextField txt_noKTP1;
    private javax.swing.JTextField txt_noRM1;
    private javax.swing.JTextField txt_pendidikan;
    private javax.swing.JTextField txt_pendidikan1;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_status1;
    private javax.swing.JTextField txt_ttgl;
    private javax.swing.JTextField txt_ttgl1;
    // End of variables declaration//GEN-END:variables
}
