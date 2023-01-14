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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yani
 */
public class Order extends javax.swing.JFrame {

    /**
     * Creates new form Order
     */
    public Order() {
        initComponents();
        load_table();
        load_combo();
        Fid_customer.setEditable(false);
        Fid_paket.setEditable(false);
    }
    
    public void load_table(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID paket");
        model.addColumn("ID customer");
        model.addColumn("Nama pengirim");
        model.addColumn("Jarak");
        model.addColumn("Jenis service");
        model.addColumn("Harga barang");
        model.addColumn("Nama penerima");
        model.addColumn("noHP penerima");
        model.addColumn("Alamat tujuan");
        model.addColumn("Biaya pengiriman");
        
        try {
            int no=1;
            String sql = "SELECT order_paket.*, customer.*, service.* FROM order_paket "
                    + "JOIN customer ON (order_paket.id_customer = customer.id_customer)"
                    + "JOIN service ON (order_paket.id_service = service.id_service)";
            Statement stm= (Statement) koneksi.getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString("id_paket"),res.getString("id_customer"),res.getString("nama_customer"),res.getString("jarak"),res.getString("title_service"),res.getString("harga_barang"),res.getString("nama_penerima"),res.getString("noHp_penerima"),res.getString("alamat_tujuan"),res.getString("biaya_pengiriman")});
            }
            tabel_order.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cari(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID paket");
        model.addColumn("ID customer");
        model.addColumn("Nama pengirim");
        model.addColumn("Jarak");
        model.addColumn("Jenis service");
        model.addColumn("Harga barang");
        model.addColumn("Nama penerima");
        model.addColumn("noHP penerima");
        model.addColumn("Alamat tujuan");
        model.addColumn("Biaya pengiriman");
        
        try {
            int no=1;
            String sql = "SELECT order_paket.*, customer.*, service.* FROM order_paket "
                    + "JOIN customer ON (order_paket.id_customer = customer.id_customer)"
                    + "JOIN service ON (order_paket.id_service = service.id_service) "
                    + "WHERE order_paket.id_paket LIKE '%"+Fcari.getText()+"%'OR customer.nama_customer LIKE'%"+Fcari.getText()+"%'";
            Statement stm= (Statement) koneksi.getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString("id_paket"),res.getString("id_customer"),res.getString("nama_customer"),res.getString("jarak"),res.getString("title_service"),res.getString("harga_barang"),res.getString("nama_penerima"),res.getString("noHp_penerima"),res.getString("alamat_tujuan"),res.getString("biaya_pengiriman")});
            }
            tabel_order.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void kosong(){
        Fid_customer.setText("");
        Fid_paket.setText("");
        Fjarak.setText("");
        Cjenis_service.setSelectedItem(this);
        Fharga_barang.setText("");
        Fnama_penerima.setText("");
        Fnohp_penerima.setText("");
        Talamat_tujuan.setText("") ;
        Fbiaya_pengiriman.setText("") ;
    }
    
    public boolean pengecekan(){
        if("".equals(Fid_customer.getText()) || "".equals(Fjarak.getText())|| "".equals(Fharga_barang.getText())|| "".equals(Fnama_penerima.getText())|| "".equals(Fnohp_penerima.getText())|| "".equals(Talamat_tujuan.getText())|| "".equals(Fbiaya_pengiriman.getText())){
            return false;
        }else{
            return true;
        }
    }
    
    public void load_combo(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            String sql = "SELECT * FROM service";
            Statement stm= (Statement) koneksi.getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addElement(res.getString("title_service"));
            }
            Cjenis_service.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        Bback = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_order = new javax.swing.JTable();
        Bcari = new javax.swing.JButton();
        Fcari = new javax.swing.JTextField();
        Fid_customer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Fid_paket = new javax.swing.JTextField();
        Fjarak = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Cjenis_service = new javax.swing.JComboBox<>();
        Fharga_barang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Talamat_tujuan = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        Fbiaya_pengiriman = new javax.swing.JTextField();
        Bcek = new javax.swing.JButton();
        Btambah = new javax.swing.JButton();
        Bhapus = new javax.swing.JButton();
        Breset = new javax.swing.JButton();
        Bedit = new javax.swing.JButton();
        Bkirim = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Fnama_penerima = new javax.swing.JTextField();
        Fnohp_penerima = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bback.setText("Back");
        Bback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BbackActionPerformed(evt);
            }
        });
        jPanel1.add(Bback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order Paket");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, 48));

        tabel_order.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_orderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_order);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        Bcari.setText("Cari");
        Bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcariActionPerformed(evt);
            }
        });
        jPanel1.add(Bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));
        jPanel1.add(Fcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 191, -1));

        Fid_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fid_customerActionPerformed(evt);
            }
        });
        jPanel1.add(Fid_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 255, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id customer      :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Paket            :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        Fid_paket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fid_paketActionPerformed(evt);
            }
        });
        jPanel1.add(Fid_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 255, -1));

        Fjarak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FjarakActionPerformed(evt);
            }
        });
        jPanel1.add(Fjarak, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 255, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jarak                :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jenis Service     :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        Cjenis_service.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cjenis_serviceActionPerformed(evt);
            }
        });
        jPanel1.add(Cjenis_service, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 255, -1));

        Fharga_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fharga_barangActionPerformed(evt);
            }
        });
        jPanel1.add(Fharga_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 255, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Harga Barang    :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alamat Tujuan  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        Talamat_tujuan.setColumns(20);
        Talamat_tujuan.setRows(5);
        jScrollPane1.setViewportView(Talamat_tujuan);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 255, 70));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Biaya pengiriman :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        Fbiaya_pengiriman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fbiaya_pengirimanActionPerformed(evt);
            }
        });
        jPanel1.add(Fbiaya_pengiriman, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 197, -1));

        Bcek.setText("cek");
        Bcek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcekActionPerformed(evt);
            }
        });
        jPanel1.add(Bcek, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        Btambah.setText("Tambah");
        Btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtambahActionPerformed(evt);
            }
        });
        jPanel1.add(Btambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        Bhapus.setText("Hapus");
        Bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BhapusActionPerformed(evt);
            }
        });
        jPanel1.add(Bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 78, -1));

        Breset.setText("Reset");
        Breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresetActionPerformed(evt);
            }
        });
        jPanel1.add(Breset, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 78, -1));

        Bedit.setText("Edit");
        Bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditActionPerformed(evt);
            }
        });
        jPanel1.add(Bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 79, -1));

        Bkirim.setText("Kirim");
        Bkirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BkirimActionPerformed(evt);
            }
        });
        jPanel1.add(Bkirim, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 187, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nama penerima   :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        Fnama_penerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fnama_penerimaActionPerformed(evt);
            }
        });
        jPanel1.add(Fnama_penerima, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 255, -1));

        Fnohp_penerima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fnohp_penerimaActionPerformed(evt);
            }
        });
        jPanel1.add(Fnohp_penerima, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 255, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("NoHP penerima   :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes_kelMWU/order.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 580));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Fharga_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fharga_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fharga_barangActionPerformed

    private void FjarakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FjarakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FjarakActionPerformed

    private void Fid_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fid_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fid_customerActionPerformed

    private void Cjenis_serviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cjenis_serviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cjenis_serviceActionPerformed

    private void Fid_paketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fid_paketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fid_paketActionPerformed

    private void BcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_BcariActionPerformed

    private void BtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtambahActionPerformed
        // TODO add your handling code here:
        String id_customer = Fid_customer.getText();
        String id_paket = Fid_paket.getText();
        String jarak = Fjarak.getText();
        String jenis_service = Cjenis_service.getSelectedItem().toString();
        String harga_barang = Fharga_barang.getText();
        String nama_penerima = Fnama_penerima.getText();
        String noHp_penerima = Fnohp_penerima.getText();
        String alamat_tujuan = Talamat_tujuan.getText();
        String biaya_pengiriman = Fbiaya_pengiriman.getText();
        
        if(pengecekan()){
            try {
                String sql1 = "SELECT * FROM service WHERE title_service='"+jenis_service+"'";
                Statement stm= (Statement) koneksi.getConnection().createStatement();
                ResultSet res=stm.executeQuery(sql1);
                while(res.next()){
                    jenis_service = res.getString("id_service");
                }
                String sql = "INSERT INTO order_paket VALUES ('"+id_customer+"','"+0+"','"+jarak+"','"+jenis_service+"','"+harga_barang+"','"+nama_penerima+"','"+noHp_penerima+"','"+alamat_tujuan+"','"+biaya_pengiriman+"')";
                Connection conn= koneksi.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } 
            load_table();
            kosong();
        }else{
            JOptionPane.showMessageDialog(null, "semua data harus di isi");
        }
    }//GEN-LAST:event_BtambahActionPerformed

    private void BhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BhapusActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM order_paket WHERE id_paket='"+Fid_paket.getText()+"'";
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

    private void BresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresetActionPerformed
        // TODO add your handling code here:
        kosong();
        load_table();
        load_combo();
    }//GEN-LAST:event_BresetActionPerformed

    private void BeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditActionPerformed
        // TODO add your handling code here:
        String id_customer = Fid_customer.getText();
        String id_paket = Fid_paket.getText();
        String jarak = Fjarak.getText();
        String jenis_service = Cjenis_service.getSelectedItem().toString();
        String harga_barang = Fharga_barang.getText();
        String nama_penerima = Fnama_penerima.getText();
        String noHp_penerima = Fnohp_penerima.getText();
        String alamat_tujuan = Talamat_tujuan.getText();
        String biaya_pengiriman = Fbiaya_pengiriman.getText();
        
        if(pengecekan()){
            try{
                String sql1 = "SELECT * FROM service WHERE title_service='"+jenis_service+"'";
                Statement stm= (Statement) koneksi.getConnection().createStatement();
                ResultSet res=stm.executeQuery(sql1);
                while(res.next()){
                    jenis_service = res.getString("id_service");
                }
                String sql = "UPDATE order_paket SET id_paket='"+id_paket+"',id_customer='"+id_customer+"',jarak='"+jarak+"',id_service='"+jenis_service+"',harga_barang='"+harga_barang+"',nama_penerima='"+nama_penerima+"',noHp_penerima='"+noHp_penerima+"',alamat_tujuan='"+alamat_tujuan+"',biaya_pengiriman='"+biaya_pengiriman+"' WHERE id_paket='"+id_paket+"'";
                Connection conn = koneksi.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Data berhasil di-update di database");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            load_table();
            kosong();
        }else{
            JOptionPane.showMessageDialog(null, "semua data harus di isi");
        }
        
        
    }//GEN-LAST:event_BeditActionPerformed

    private void BbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BbackActionPerformed
        // TODO add your handling code here:
        MenuAdmin menuAdmin = new MenuAdmin();
        menuAdmin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BbackActionPerformed

    private void tabel_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_orderMouseClicked
        // TODO add your handling code here:
        int baris = tabel_order.rowAtPoint(evt.getPoint());
        String id_customer =tabel_order.getValueAt(baris, 2).toString();
        Fid_customer.setText(id_customer);
        String id_paket = tabel_order.getValueAt(baris,1).toString();
        Fid_paket.setText(id_paket);
        String jarak = tabel_order.getValueAt(baris, 4).toString();
        Fjarak.setText(jarak);
        String jenis_service =tabel_order.getValueAt(baris, 5).toString();
        Cjenis_service.setSelectedItem(jenis_service);
        String harga_barang = tabel_order.getValueAt(baris, 6).toString();
        Fharga_barang.setText(harga_barang);
        String nama_penerima = tabel_order.getValueAt(baris, 7).toString();
        Fnama_penerima.setText(nama_penerima);
        String noHp_penerima = tabel_order.getValueAt(baris, 8).toString();
        Fnohp_penerima.setText(noHp_penerima);
        String alamat_tujuan = tabel_order.getValueAt(baris,9).toString();
        Talamat_tujuan.setText(alamat_tujuan);
        String biaya_pengiriman = tabel_order.getValueAt(baris, 10).toString();
        Fbiaya_pengiriman.setText(biaya_pengiriman);
    }//GEN-LAST:event_tabel_orderMouseClicked

    private void Fbiaya_pengirimanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fbiaya_pengirimanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fbiaya_pengirimanActionPerformed

    private void BcekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcekActionPerformed
        // TODO add your handling code here:
        double jarak = Integer.parseInt(Fjarak.getText());
        String jenis_service = Cjenis_service.getSelectedItem().toString();
        double harga_barang = Integer.parseInt(Fharga_barang.getText());
        double harga = 0.0;
        try{
            String sql1 = "SELECT * FROM service WHERE title_service='"+jenis_service+"'";
            Statement stm= (Statement) koneksi.getConnection().createStatement();
            ResultSet res=stm.executeQuery(sql1);
            while(res.next()){
                harga = Integer.parseInt(res.getString("price"));
            }
            double biaya_pengiriman = (jarak*harga)+(harga_barang*(1.5/100));
            Fbiaya_pengiriman.setText(Double.toString(biaya_pengiriman));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_BcekActionPerformed

    private void BkirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BkirimActionPerformed
        // TODO add your handling code here:
        Shipment shipment = new Shipment();
        shipment.setVisible(true);
        this.setVisible(false);
        shipment.Fid_paket.setText(this.Fid_paket.getText());
        shipment.Fbiayapengiriman.setText(this.Fbiaya_pengiriman.getText());
        shipment.Fstatus.setText("Pengiriman");
    }//GEN-LAST:event_BkirimActionPerformed

    private void Fnama_penerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fnama_penerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fnama_penerimaActionPerformed

    private void Fnohp_penerimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fnohp_penerimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fnohp_penerimaActionPerformed

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bback;
    private javax.swing.JButton Bcari;
    private javax.swing.JButton Bcek;
    private javax.swing.JButton Bedit;
    private javax.swing.JButton Bhapus;
    private javax.swing.JButton Bkirim;
    private javax.swing.JButton Breset;
    private javax.swing.JButton Btambah;
    private javax.swing.JComboBox<String> Cjenis_service;
    private javax.swing.JTextField Fbiaya_pengiriman;
    private javax.swing.JTextField Fcari;
    private javax.swing.JTextField Fharga_barang;
    protected javax.swing.JTextField Fid_customer;
    private javax.swing.JTextField Fid_paket;
    private javax.swing.JTextField Fjarak;
    private javax.swing.JTextField Fnama_penerima;
    private javax.swing.JTextField Fnohp_penerima;
    private javax.swing.JTextArea Talamat_tujuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_order;
    // End of variables declaration//GEN-END:variables
}
