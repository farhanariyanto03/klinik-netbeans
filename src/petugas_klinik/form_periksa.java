
package petugas_klinik;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class form_periksa extends javax.swing.JFrame {

    
    public form_periksa() {
        initComponents();
        datatable();
        tampil_idPasien();
        tampil_idDokter();
        tampil_idPelayanan();
        tampil_idPetugas();
        
        panel_tambah.setVisible(false);
        panel_tambah.setBackground(new Color(0,0,0,200));
        panel_detail.setVisible(false);
        panel_detail.setBackground(new Color(0,0,0,200));
        panel_edit.setVisible(false);
        panel_edit.setBackground(new Color(0,0,0,200));
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
        tbl_periksa.setModel(tbl);

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

        tbl_periksa.setModel(tbl);

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
            tbl_periksa.setModel(tbl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }


    public void tampil_idPasien(){
        try{
        
            String sql = "select * from tb_pasien order by No_RM ASC";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);

            while(res.next()){
                cmb_noRM.addItem(res.getString("tb_pasien.No_RM"));
            }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void tampil_idDokter(){
        try{
        
            String sql = "select * from tb_dokter order by id_dokter ASC";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);

            while(res.next()){
                cmb_dokter.addItem(res.getString("tb_dokter.id_dokter"));
            }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void tampil_idPelayanan(){
        try{
        
            String sql = "select * from tb_jenispelayanan order by id_pelayanan ASC";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);

            while(res.next()){
                cmb_pelayanan.addItem(res.getString("tb_jenispelayanan.id_pelayanan"));
            }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void tampil_idPetugas(){
        try{
        
            String sql = "select * from tb_petugas order by id_petugas ASC";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);

            while(res.next()){
                cmb_petugas.addItem(res.getString("tb_petugas.id_petugas"));
            }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void eksporexcelNew() {
    FileWriter fileWriter;
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File("[B]export_output/excel[/B]"));
    int retrival = chooser.showSaveDialog(null);
    if (retrival == JFileChooser.APPROVE_OPTION) {
        try {
            if (tbl_periksa != null) {
                TableModel tModel = tbl_periksa.getModel();
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

        panel_tambah = new javax.swing.JPanel();
        txt_namaPasien = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_noHP = new javax.swing.JTextField();
        txt_namaDokter = new javax.swing.JTextField();
        txt_namaPelayanan = new javax.swing.JTextField();
        txt_noPeriksa = new javax.swing.JTextField();
        txt_namaPetugas = new javax.swing.JTextField();
        txt_JK = new javax.swing.JTextField();
        cmb_pelayanan = new javax.swing.JComboBox<>();
        cmb_noRM = new javax.swing.JComboBox<>();
        cmb_dokter = new javax.swing.JComboBox<>();
        cmb_petugas = new javax.swing.JComboBox<>();
        lbl_batal = new javax.swing.JLabel();
        lbl_tambah = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_periksa = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_periksa = new javax.swing.JLabel();
        lbledit = new javax.swing.JLabel();
        lblhapus = new javax.swing.JLabel();
        lbltambah = new javax.swing.JLabel();
        lbl_dashboard1 = new javax.swing.JLabel();
        lbl_dokter1 = new javax.swing.JLabel();
        lbl_pasien1 = new javax.swing.JLabel();
        lbl_periksa1 = new javax.swing.JLabel();
        lbldetail = new javax.swing.JLabel();
        lblKeluar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_edit = new javax.swing.JPanel();
        txt_namaPasien1 = new javax.swing.JTextField();
        txt_alamat1 = new javax.swing.JTextField();
        txt_noHP1 = new javax.swing.JTextField();
        txt_namaDokter1 = new javax.swing.JTextField();
        txt_namaPelayanan1 = new javax.swing.JTextField();
        txt_noPeriksa1 = new javax.swing.JTextField();
        txt_namaPetugas1 = new javax.swing.JTextField();
        cmb_pelayanan1 = new javax.swing.JComboBox<>();
        cmb_JK1 = new javax.swing.JComboBox<>();
        cmb_noRM1 = new javax.swing.JComboBox<>();
        cmb_dokter1 = new javax.swing.JComboBox<>();
        cmb_petugas1 = new javax.swing.JComboBox<>();
        lbl_batal1 = new javax.swing.JLabel();
        lbl_tambah1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_tambah.setBackground(new java.awt.Color(51, 51, 51));
        panel_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_tambahMouseEntered(evt);
            }
        });
        panel_tambah.setLayout(null);

        txt_namaPasien.setBorder(null);
        txt_namaPasien.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        panel_tambah.add(txt_namaPasien);
        txt_namaPasien.setBounds(300, 210, 240, 30);

        txt_alamat.setBorder(null);
        txt_alamat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        panel_tambah.add(txt_alamat);
        txt_alamat.setBounds(300, 320, 240, 30);

        txt_noHP.setBorder(null);
        txt_noHP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        panel_tambah.add(txt_noHP);
        txt_noHP.setBounds(600, 320, 240, 30);

        txt_namaDokter.setBorder(null);
        panel_tambah.add(txt_namaDokter);
        txt_namaDokter.setBounds(600, 430, 240, 30);

        txt_namaPelayanan.setBorder(null);
        panel_tambah.add(txt_namaPelayanan);
        txt_namaPelayanan.setBounds(600, 520, 240, 30);

        txt_noPeriksa.setBorder(null);
        panel_tambah.add(txt_noPeriksa);
        txt_noPeriksa.setBounds(290, 110, 240, 30);

        txt_namaPetugas.setBorder(null);
        panel_tambah.add(txt_namaPetugas);
        txt_namaPetugas.setBounds(590, 620, 240, 30);

        txt_JK.setBorder(null);
        panel_tambah.add(txt_JK);
        txt_JK.setBounds(600, 212, 240, 30);

        cmb_pelayanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH ID PELAYANAN----->" }));
        cmb_pelayanan.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_pelayananPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_tambah.add(cmb_pelayanan);
        cmb_pelayanan.setBounds(280, 510, 260, 40);

        cmb_noRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH NO RM PASIEN----->" }));
        cmb_noRM.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_noRMPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_tambah.add(cmb_noRM);
        cmb_noRM.setBounds(600, 100, 260, 40);

        cmb_dokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH ID DOKTER" }));
        cmb_dokter.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_dokterPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_tambah.add(cmb_dokter);
        cmb_dokter.setBounds(280, 410, 260, 40);

        cmb_petugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH ID PETUGAS----->" }));
        cmb_petugas.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_petugasPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_tambah.add(cmb_petugas);
        cmb_petugas.setBounds(280, 610, 260, 40);

        lbl_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_batalMouseClicked(evt);
            }
        });
        panel_tambah.add(lbl_batal);
        lbl_batal.setBounds(580, 690, 100, 30);

        lbl_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tambahMouseClicked(evt);
            }
        });
        panel_tambah.add(lbl_tambah);
        lbl_tambah.setBounds(450, 690, 100, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form input periksa.png"))); // NOI18N
        panel_tambah.add(jLabel4);
        jLabel4.setBounds(250, 40, 640, 710);

        getContentPane().add(panel_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

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

        getContentPane().add(panel_detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

        tbl_periksa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_periksa.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_periksa.setRowHeight(40);
        tbl_periksa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_periksaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_periksa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 650, 520));

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

        lbledit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbleditMouseClicked(evt);
            }
        });
        getContentPane().add(lbledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 165, 80, 30));

        lblhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblhapusMouseClicked(evt);
            }
        });
        getContentPane().add(lblhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 80, 40));

        lbltambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbltambahMouseClicked(evt);
            }
        });
        getContentPane().add(lbltambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 165, 80, 30));

        lbl_dashboard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboard1MouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 230, 40));

        lbl_dokter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dokter1MouseClicked(evt);
            }
        });
        getContentPane().add(lbl_dokter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 230, 40));

        lbl_pasien1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pasien1MouseClicked(evt);
            }
        });
        getContentPane().add(lbl_pasien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 240, 40));

        lbl_periksa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_periksa1MouseClicked(evt);
            }
        });
        getContentPane().add(lbl_periksa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 230, 40));

        lbldetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldetailMouseClicked(evt);
            }
        });
        getContentPane().add(lbldetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 80, 30));

        lblKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKeluarMouseClicked(evt);
            }
        });
        getContentPane().add(lblKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 730, 210, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form Periksa1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_edit.setBackground(new java.awt.Color(51, 51, 51));
        panel_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_editMouseEntered(evt);
            }
        });
        panel_edit.setLayout(null);

        txt_namaPasien1.setBorder(null);
        txt_namaPasien1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        panel_edit.add(txt_namaPasien1);
        txt_namaPasien1.setBounds(300, 210, 240, 30);

        txt_alamat1.setBorder(null);
        txt_alamat1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        panel_edit.add(txt_alamat1);
        txt_alamat1.setBounds(300, 320, 240, 30);

        txt_noHP1.setBorder(null);
        txt_noHP1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        panel_edit.add(txt_noHP1);
        txt_noHP1.setBounds(600, 320, 240, 30);

        txt_namaDokter1.setBorder(null);
        panel_edit.add(txt_namaDokter1);
        txt_namaDokter1.setBounds(600, 430, 240, 30);

        txt_namaPelayanan1.setBorder(null);
        panel_edit.add(txt_namaPelayanan1);
        txt_namaPelayanan1.setBounds(600, 520, 240, 30);

        txt_noPeriksa1.setBorder(null);
        panel_edit.add(txt_noPeriksa1);
        txt_noPeriksa1.setBounds(290, 110, 240, 30);

        txt_namaPetugas1.setBorder(null);
        panel_edit.add(txt_namaPetugas1);
        txt_namaPetugas1.setBounds(590, 620, 240, 30);

        cmb_pelayanan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH ID PELAYANAN----->" }));
        cmb_pelayanan1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_pelayanan1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_edit.add(cmb_pelayanan1);
        cmb_pelayanan1.setBounds(280, 510, 260, 40);

        cmb_JK1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH JENIS KELAMIN----->", "Laki - Laki", "Perempuan" }));
        panel_edit.add(cmb_JK1);
        cmb_JK1.setBounds(600, 210, 260, 40);

        cmb_noRM1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH NO RM PASIEN----->" }));
        cmb_noRM1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_noRM1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_edit.add(cmb_noRM1);
        cmb_noRM1.setBounds(600, 100, 260, 40);

        cmb_dokter1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH ID DOKTER" }));
        cmb_dokter1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_dokter1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_edit.add(cmb_dokter1);
        cmb_dokter1.setBounds(280, 410, 260, 40);

        cmb_petugas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<-----PILIH ID PETUGAS----->" }));
        cmb_petugas1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_petugas1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        panel_edit.add(cmb_petugas1);
        cmb_petugas1.setBounds(280, 610, 260, 40);

        lbl_batal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_batal1MouseClicked(evt);
            }
        });
        panel_edit.add(lbl_batal1);
        lbl_batal1.setBounds(580, 690, 100, 30);

        lbl_tambah1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_tambah1MouseClicked(evt);
            }
        });
        panel_edit.add(lbl_tambah1);
        lbl_tambah1.setBounds(460, 690, 90, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form input periksa1.png"))); // NOI18N
        panel_edit.add(jLabel6);
        jLabel6.setBounds(250, 40, 640, 710);

        getContentPane().add(panel_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

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

    private void lbltambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltambahMouseClicked
        panel_tambah.setVisible(true);
    }//GEN-LAST:event_lbltambahMouseClicked

    private void lbl_dashboard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboard1MouseClicked
        this.setVisible(false);
        new form_dashboard().setVisible(true);
    }//GEN-LAST:event_lbl_dashboard1MouseClicked

    private void lbl_dokter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dokter1MouseClicked
        this.setVisible(false);
        new form_dokter().setVisible(true);
    }//GEN-LAST:event_lbl_dokter1MouseClicked

    private void lbl_pasien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pasien1MouseClicked
        this.setVisible(false);
        new form_pasien().setVisible(true);
    }//GEN-LAST:event_lbl_pasien1MouseClicked

    private void lbl_periksa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_periksa1MouseClicked
        this.setVisible(false);
        new form_periksa().setVisible(true);
    }//GEN-LAST:event_lbl_periksa1MouseClicked

    private void lblKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKeluarMouseClicked
        this.setVisible(false);
        new form_login().setVisible(true);
    }//GEN-LAST:event_lblKeluarMouseClicked

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased

    private void cmb_noRMPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_noRMPopupMenuWillBecomeInvisible
        String sql = "select nama_lengkap, jenis_kelamin, alamat, no_hp from tb_pasien where No_RM ='"+cmb_noRM.getSelectedItem()+"'";
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            if(res.next()){
            txt_namaPasien.setText(res.getString("tb_pasien.nama_lengkap"));
            txt_JK.setText(res.getString("tb_pasien.jenis_kelamin"));
            txt_alamat.setText(res.getString("tb_pasien.alamat"));
            txt_noHP.setText(res.getString("tb_pasien.no_hp"));
            txt_namaPasien.disable();
            txt_alamat.disable();
            txt_noHP.disable();
            txt_JK.disable();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cmb_noRMPopupMenuWillBecomeInvisible

    private void panel_tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_tambahMouseEntered
        panel_tambah.setVisible(true);
    }//GEN-LAST:event_panel_tambahMouseEntered

    private void lbl_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_batalMouseClicked
        panel_tambah.setVisible(false);
    }//GEN-LAST:event_lbl_batalMouseClicked

    private void cmb_dokterPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_dokterPopupMenuWillBecomeInvisible
        String sql = "select nama_dokter from tb_dokter where id_dokter ='"+cmb_dokter.getSelectedItem()+"'";
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            if(res.next()){
            txt_namaDokter.setText(res.getString("tb_dokter.nama_dokter"));
            txt_namaDokter.disable();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cmb_dokterPopupMenuWillBecomeInvisible

    private void cmb_pelayananPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_pelayananPopupMenuWillBecomeInvisible
        String sql = "select jenis_pelayanan from tb_jenispelayanan where id_pelayanan ='"+cmb_pelayanan.getSelectedItem()+"'";
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            if(res.next()){
            txt_namaPelayanan.setText(res.getString("tb_jenispelayanan.jenis_pelayanan"));
            txt_namaPelayanan.disable();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cmb_pelayananPopupMenuWillBecomeInvisible

    private void lbl_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tambahMouseClicked
        try {
            
            String sql= "INSERT INTO tb_pemeriksaan VALUES ('"+txt_noPeriksa.getText()+"','"+cmb_noRM.getSelectedItem()+"','"+cmb_dokter.getSelectedItem()+"', "
                    + "'"+cmb_pelayanan.getSelectedItem()+"', '"+cmb_petugas.getSelectedItem()+"', NOW())";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            
            panel_tambah.setVisible(false);
            JOptionPane.showMessageDialog(null, "DATA PASIEN BERHASIL DITAMBAHKAN");
            try {
                System.out.println(txt_noPeriksa.getText());
                String query = "select tb_pemeriksaan.id_pemeriksaan, tggl_periksa FROM tb_pemeriksaan  where id_pemeriksaan = '"+txt_noPeriksa.getText()+"'";
                String path = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\klinik\\src\\iReport\\klinik1.jrxml";
                Statement pstCek = conn.createStatement();
                ResultSet res = pstCek.executeQuery(query);
                JasperDesign design = JRXmlLoader.load(path);
                JasperReport jr = JasperCompileManager.compileReport(design);
                JRResultSetDataSource rsDataSource = new JRResultSetDataSource(res);
                JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<>(), rsDataSource);
                JasperViewer.viewReport(jp);
            } catch (Exception e) {
                System.out.println(e);
        }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        datatable();
    }//GEN-LAST:event_lbl_tambahMouseClicked

    private void lblhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblhapusMouseClicked
        try{
            int row = tbl_periksa.getSelectedRow();
            String id_periksa = tbl_periksa.getModel().getValueAt(row, 0).toString();
            String resultSet = "DELETE FROM tb_pemeriksaan WHERE id_pemeriksaan='"+id_periksa+"'";

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

    private void lblKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKembaliMouseClicked
        panel_detail.setVisible(false);
    }//GEN-LAST:event_lblKembaliMouseClicked

    private void lbldetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldetailMouseClicked
        int baris = tbl_periksa.getSelectedRow();
        if (baris != -1 ) {
            lblNoperiksa.setText(tbl_periksa.getValueAt(baris, 0).toString());
            lblNoRM.setText(tbl_periksa.getValueAt(baris, 1).toString());
            lblNamaPasien.setText(tbl_periksa.getValueAt(baris, 2).toString());
            lblJK.setText(tbl_periksa.getValueAt(baris, 3).toString());
            lblAlamat.setText(tbl_periksa.getValueAt(baris, 4).toString());
            lblNohp.setText(tbl_periksa.getValueAt(baris, 5).toString());
            lblNamaDokter.setText(tbl_periksa.getValueAt(baris, 6).toString());
            lblJenisPlyn.setText(tbl_periksa.getValueAt(baris, 7).toString());
            lbltgglPeriksa.setText(tbl_periksa.getValueAt(baris, 8).toString());
            lblNamaPetugas.setText(tbl_periksa.getValueAt(baris, 9).toString());
        }
        panel_detail.setVisible(true);
    }//GEN-LAST:event_lbldetailMouseClicked

    private void tbl_periksaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_periksaMouseClicked
//        int baris = tbl_periksa.getSelectedRow();
//        if (baris != -1 ) {
//            lblNoperiksa.setText(tbl_periksa.getValueAt(baris, 0).toString());
//            lblNoRM.setText(tbl_periksa.getValueAt(baris, 1).toString());
//            lblNamaPasien.setText(tbl_periksa.getValueAt(baris, 2).toString());
//            lblJK.setText(tbl_periksa.getValueAt(baris, 3).toString());
//            lblAlamat.setText(tbl_periksa.getValueAt(baris, 4).toString());
//            lblNohp.setText(tbl_periksa.getValueAt(baris, 5).toString());
//            lblNamaDokter.setText(tbl_periksa.getValueAt(baris, 6).toString());
//            lblJenisPlyn.setText(tbl_periksa.getValueAt(baris, 7).toString());
//            lbltgglPeriksa.setText(tbl_periksa.getValueAt(baris, 8).toString());
//        }
//        panel_detail.setVisible(true);
    }//GEN-LAST:event_tbl_periksaMouseClicked

    private void panel_detailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_detailMouseClicked
        
    }//GEN-LAST:event_panel_detailMouseClicked

    private void panel_detailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_detailMouseEntered
        panel_detail.setVisible(true);
    }//GEN-LAST:event_panel_detailMouseEntered

    private void cmb_petugasPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_petugasPopupMenuWillBecomeInvisible
        String sql = "select nama_petugas from tb_petugas where id_petugas ='"+cmb_petugas.getSelectedItem()+"'";
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            if(res.next()){
            txt_namaPetugas.setText(res.getString("tb_petugas.nama_petugas"));
            txt_namaPetugas.disable();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cmb_petugasPopupMenuWillBecomeInvisible

    private void cmb_pelayanan1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_pelayanan1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_pelayanan1PopupMenuWillBecomeInvisible

    private void cmb_noRM1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_noRM1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_noRM1PopupMenuWillBecomeInvisible

    private void cmb_dokter1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_dokter1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_dokter1PopupMenuWillBecomeInvisible

    private void cmb_petugas1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_petugas1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_petugas1PopupMenuWillBecomeInvisible

    private void lbl_batal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_batal1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_batal1MouseClicked

    private void lbl_tambah1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_tambah1MouseClicked
        
    }//GEN-LAST:event_lbl_tambah1MouseClicked

    private void panel_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_editMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_editMouseEntered

    private void lbleditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbleditMouseClicked
//        int baris = tbl_periksa.getSelectedRow();
//        if (baris != -1 ) {
//            txt_noPeriksa1.setText(tbl_periksa.getValueAt(baris, 0).toString());
//            cmb_noRM1.setSelectedItem(tbl_periksa.getValueAt(baris, 1).toString());
//            cmb_dokter1.setSelectedItem(tbl_periksa.getValueAt(baris, 6).toString());
//            cmb_pelayanan1.setSelectedItem(tbl_periksa.getValueAt(baris, 7).toString());
//        }
        int baris = tbl_periksa.getSelectedRow();
        if (baris != -1) {
            // Mengambil data nama pasien dan ID pasien dari tabel
            String namaPasien = tbl_periksa.getValueAt(baris, 2).toString(); // Indeks 2 adalah kolom nama pasien
            String idPasien = tbl_periksa.getValueAt(baris, 1).toString(); // Indeks 1 adalah kolom No_RM (ID pasien)

            // Menampilkan data dalam form edit
            txt_noPeriksa1.setText(tbl_periksa.getValueAt(baris, 0).toString());
            cmb_noRM1.setSelectedItem(idPasien); // Mengatur combo box dengan ID pasien
            // Anda mungkin ingin menampilkan nama pasien sebagai label atau teks terpisah di form edit
            txt_namaPasien1.setText(namaPasien);
        }
        panel_edit.setVisible(true);
    }//GEN-LAST:event_lbleditMouseClicked

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
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_periksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_periksa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_JK1;
    private javax.swing.JComboBox<String> cmb_dokter;
    private javax.swing.JComboBox<String> cmb_dokter1;
    private javax.swing.JComboBox<String> cmb_noRM;
    private javax.swing.JComboBox<String> cmb_noRM1;
    private javax.swing.JComboBox<String> cmb_pelayanan;
    private javax.swing.JComboBox<String> cmb_pelayanan1;
    private javax.swing.JComboBox<String> cmb_petugas;
    private javax.swing.JComboBox<String> cmb_petugas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblJK;
    private javax.swing.JLabel lblJenisPlyn;
    private javax.swing.JLabel lblKeluar;
    private javax.swing.JLabel lblKembali;
    private javax.swing.JLabel lblNamaDokter;
    private javax.swing.JLabel lblNamaPasien;
    private javax.swing.JLabel lblNamaPetugas;
    private javax.swing.JLabel lblNoRM;
    private javax.swing.JLabel lblNohp;
    private javax.swing.JLabel lblNoperiksa;
    private javax.swing.JLabel lbl_batal;
    private javax.swing.JLabel lbl_batal1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dashboard1;
    private javax.swing.JLabel lbl_dokter;
    private javax.swing.JLabel lbl_dokter1;
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_pasien1;
    private javax.swing.JLabel lbl_periksa;
    private javax.swing.JLabel lbl_periksa1;
    private javax.swing.JLabel lbl_tambah;
    private javax.swing.JLabel lbl_tambah1;
    private javax.swing.JLabel lbldetail;
    private javax.swing.JLabel lbledit;
    private javax.swing.JLabel lblhapus;
    private javax.swing.JLabel lbltambah;
    private javax.swing.JLabel lbltgglPeriksa;
    private javax.swing.JPanel panel_detail;
    private javax.swing.JPanel panel_edit;
    private javax.swing.JPanel panel_tambah;
    private javax.swing.JTable tbl_periksa;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txt_JK;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_alamat1;
    private javax.swing.JTextField txt_namaDokter;
    private javax.swing.JTextField txt_namaDokter1;
    private javax.swing.JTextField txt_namaPasien;
    private javax.swing.JTextField txt_namaPasien1;
    private javax.swing.JTextField txt_namaPelayanan;
    private javax.swing.JTextField txt_namaPelayanan1;
    private javax.swing.JTextField txt_namaPetugas;
    private javax.swing.JTextField txt_namaPetugas1;
    private javax.swing.JTextField txt_noHP;
    private javax.swing.JTextField txt_noHP1;
    private javax.swing.JTextField txt_noPeriksa;
    private javax.swing.JTextField txt_noPeriksa1;
    // End of variables declaration//GEN-END:variables
}
