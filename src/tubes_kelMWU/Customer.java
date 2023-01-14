/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_kelMWU;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yani
 */
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        load_table();
        Fid_customer.setEditable(false);
    }
    
    public void load_table(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Customer");
        model.addColumn("Nama");
        model.addColumn("No Telp");
        model.addColumn("Alamat");
        
        try {
            int no=1;
            String sql = "SELECT * FROM customer";
            Statement stm= (Statement) koneksi.getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            tabel_customer.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cari(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Customer");
        model.addColumn("Nama");
        model.addColumn("No Telp");
        model.addColumn("Alamat");
        
        try {
            int no=1;
            String sql = "SELECT * FROM customer WHERE id_customer LIKE '%"+Fcari.getText()+"%'OR nama_customer LIKE'%"+Fcari.getText()+"%'";
            Statement stm= (Statement) koneksi.getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            tabel_customer.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void kosong(){
        Fid_customer.setText("");
        Fnama_customer.setText("");
        Fnotelp_cust.setText("");
        Falamat_cust.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Bedit = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Falamat_cust = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_customer = new javax.swing.JTable();
        Fid_customer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Fnotelp_cust = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Fnama_customer = new javax.swing.JTextField();
        Btambah = new javax.swing.JButton();
        Breset = new javax.swing.JButton();
        Fcari = new javax.swing.JTextField();
        Bcari = new javax.swing.JButton();
        Bback = new javax.swing.JButton();
        Border = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bedit.setText("Edit");
        Bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditActionPerformed(evt);
            }
        });
        jPanel1.add(Bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 307, 79, -1));

        Bhapus.setText("Hapus");
        Bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhapusActionPerformed(evt);
            }
        });
        jPanel1.add(Bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 269, 78, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nama Customer    : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 99, -1, 19));

        Falamat_cust.setColumns(20);
        Falamat_cust.setRows(5);
        jScrollPane1.setViewportView(Falamat_cust);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 155, 230, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Customer");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 26));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Alamat Customer  : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 155, -1, 22));

        tabel_customer.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_customerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_customer);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 68, -1, 321));

        Fid_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fid_customerActionPerformed(evt);
            }
        });
        jPanel1.add(Fid_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 68, 229, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("No Telp Customer :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 126, -1, 22));
        jPanel1.add(Fnotelp_cust, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 126, 229, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Id Customer          :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 70, -1, 19));

        Fnama_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fnama_customerActionPerformed(evt);
            }
        });
        jPanel1.add(Fnama_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 97, 229, -1));

        Btambah.setText("Tambah");
        Btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtambahActionPerformed(evt);
            }
        });
        jPanel1.add(Btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 269, -1, -1));

        Breset.setText("Reset");
        Breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresetActionPerformed(evt);
            }
        });
        jPanel1.add(Breset, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 307, 78, -1));
        jPanel1.add(Fcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 37, 191, -1));

        Bcari.setText("Cari");
        Bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcariActionPerformed(evt);
            }
        });
        jPanel1.add(Bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 36, -1, -1));

        Bback.setText("Back");
        Bback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BbackActionPerformed(evt);
            }
        });
        jPanel1.add(Bback, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));

        Border.setText("Tambah order");
        Border.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorderActionPerformed(evt);
            }
        });
        jPanel1.add(Border, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 339, 187, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes_kelMWU/Customer.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhapusActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM customer WHERE id_customer='"+Fid_customer.getText()+"'";
        try{
            Connection conn = koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus di database");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        load_table();
        kosong();
    }//GEN-LAST:event_BhapusActionPerformed

    private void Fid_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fid_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fid_customerActionPerformed

    private void Fnama_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fnama_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fnama_customerActionPerformed

    private void BtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtambahActionPerformed
        // TODO add your handling code here:
        String nama = Fnama_customer.getText();
        String noTelp= Fnotelp_cust.getText();
        String alamat= Falamat_cust.getText();
        
        try {
            String sql = "INSERT INTO customer VALUES ('"+0+"','"+nama+"','"+noTelp+"','"+alamat+"')";
            Connection conn= koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        load_table();
        kosong();
    }//GEN-LAST:event_BtambahActionPerformed

    private void BcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_BcariActionPerformed

    private void BbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BbackActionPerformed
        // TODO add your handling code here:
        MenuAdmin menuAdmin = new MenuAdmin();
        menuAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BbackActionPerformed

    private void tabel_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_customerMouseClicked
        // TODO add your handling code here:
        int baris = tabel_customer.rowAtPoint(evt.getPoint());
        String id_cust =tabel_customer.getValueAt(baris, 1).toString();
        Fid_customer.setText(id_cust);
        String nama = tabel_customer.getValueAt(baris,2).toString();
        Fnama_customer.setText(nama);
        String notelp = tabel_customer.getValueAt(baris, 3).toString();
        Fnotelp_cust.setText(notelp);
        String alamat = tabel_customer.getValueAt(baris, 4).toString();
        Falamat_cust.setText(alamat);
    }//GEN-LAST:event_tabel_customerMouseClicked

    private void BresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresetActionPerformed
        // TODO add your handling code here:
        kosong();
        load_table();
    }//GEN-LAST:event_BresetActionPerformed

    private void BeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditActionPerformed
        // TODO add your handling code here:
        String id_cust = Fid_customer.getText();
        String nama = Fnama_customer.getText();
        String noTelp= Fnotelp_cust.getText();
        String alamat= Falamat_cust.getText();
        
        String sql = "UPDATE customer SET id_customer='"+id_cust+"',nama_customer='"+nama+"',noTelp_cust='"+noTelp+"',alamat_cust='"+alamat+"' WHERE id_customer='"+id_cust+"'";
        try{
            Connection conn = koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di-update di database");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        load_table();
        kosong();
    }//GEN-LAST:event_BeditActionPerformed

    private void BorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorderActionPerformed
        // TODO add your handling code here:
        if("".equals(Fid_customer.getText())){
            JOptionPane.showMessageDialog(null, "pilih customer terlebih dahulu");
        }else{
            Order order = new Order();
            order.Fid_customer.setText(Fid_customer.getText());
            order.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_BorderActionPerformed

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bback;
    private javax.swing.JButton Bcari;
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Border;
    private javax.swing.JButton Breset;
    private javax.swing.JButton Btambah;
    private javax.swing.JTextArea Falamat_cust;
    private javax.swing.JTextField Fcari;
    private javax.swing.JTextField Fid_customer;
    private javax.swing.JTextField Fnama_customer;
    private javax.swing.JTextField Fnotelp_cust;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_customer;
    // End of variables declaration//GEN-END:variables
}