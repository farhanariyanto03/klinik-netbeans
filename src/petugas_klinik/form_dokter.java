
package petugas_klinik;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class form_dokter extends javax.swing.JFrame {

    
    public form_dokter() {
        initComponents();
        datatable();
    }

    public void datatable(){
        
        DefaultTableModel tbl = new DefaultTableModel() {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tbl.addColumn("Nama Dokter");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Alamat");
        tbl.addColumn("PNo HP");
        tbl_dokter.setModel(tbl);
        try{
            Statement statement = (Statement)config.configDB().createStatement();
            ResultSet res = statement.executeQuery("select * from tb_dokter");
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("nama_dokter"),
                    res.getString("jenis_kelamin"),
                    res.getString("Alamat"),
                    res.getString("no_hp")
                });
                tbl_dokter.setModel(tbl);
            }
        }catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void cariData(){
        
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nama Dokter");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Alamat");
        tbl.addColumn("PNo HP");
        
        
        tbl_dokter.setModel(tbl);
        
        String cari = txtCari.getText();
        
        try{
            String sql = "SELECT * FROM tb_dokter where nama_dokter like'%"+cari+"%'";
            java.sql.Connection conn = (Connection)config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next())
            {
                tbl.addRow(new Object[]{
                    res.getString("id_dokter"),
                    res.getString("nama_dokter"),
                    res.getString("jenis_kelamin"),
                    res.getString("alamat"),
                    res.getString("no_hp"),
                    res.getString("password"),
                  
                    
                });
                tbl_dokter.setModel(tbl);
            }
        }catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dokter = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_dokter = new javax.swing.JLabel();
        lbl_pasien = new javax.swing.JLabel();
        lbl_periksa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_dokter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_dokter.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_dokter.setAutoscrolls(false);
        tbl_dokter.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_dokter);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 630, 550));

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
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 145, 160, -1));

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
        getContentPane().add(lbl_dokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 230, 50));

        lbl_pasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pasienMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_pasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 230, 40));

        lbl_periksa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_periksaMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_periksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 240, 40));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 210, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Form dokter.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 800));

        setSize(new java.awt.Dimension(1098, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        cariData();
    }//GEN-LAST:event_txtCariKeyReleased

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
            java.util.logging.Logger.getLogger(form_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_dokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dokter;
    private javax.swing.JLabel lbl_pasien;
    private javax.swing.JLabel lbl_periksa;
    private javax.swing.JTable tbl_dokter;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
