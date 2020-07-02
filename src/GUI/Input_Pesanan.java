/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controller.Transaksi;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import set_get.Order;
import set_get.Pembeli;
import set_get.Produk;
import set_get.t_Transaksi;

/**
 *
 * @author Mr C
 */
public class Input_Pesanan extends javax.swing.JFrame {

    private Transaksi transaksi;
    private ArrayList<Produk> arrProduk;
    private Integer total;
    private Integer Total_Harga;
     
   
    /**
     * Creates new form Input_Pesanan
     */
    public Input_Pesanan() throws SQLException {
        initComponents();
        transaksi = new Transaksi();
            arrProduk = new ArrayList<>();
            total = 0;
            Total_Harga = 0;
            txtTotal.disable();
            showcbProduk();
            showcbPembeli();
            showTblProduk();
            showTblPesanan();
            showcbJenis();
//            showTotal_Harga();
    }
    
    public void showcbJenis() throws SQLException {
        DefaultComboBoxModel scbJenis = new DefaultComboBoxModel();
            scbJenis.addElement("TUNAI");
            scbJenis.addElement("TRANFER");
            
            cbJenis.removeAllItems();
            cbJenis.setModel(scbJenis);
    }
    
    public void showcbProduk() throws SQLException {
        DefaultComboBoxModel scbProduk = new DefaultComboBoxModel();
        for(Produk p : transaksi.getDataProduk()){
            scbProduk.addElement(p.getNama_produk()+ " "+p.getStock());
        }
        cbNamaProduk.removeAllItems();
        cbNamaProduk.setModel(scbProduk);
    }
    
    public void showcbPembeli() throws SQLException {
        DefaultComboBoxModel scbPembeli = new DefaultComboBoxModel();
        for(Pembeli Pe : transaksi.getDataPembeli()){
            scbPembeli.addElement(Pe.getNAMA_PEMBELI());
        }
        cbNamaPembeli.removeAllItems();
        cbNamaPembeli.setModel(scbPembeli);
    }
    
    public void showTblProduk() throws SQLException {
        DefaultTableModel tabPesan = new DefaultTableModel(new String[] {"No BPOM","Nama Produk","Jenis Produk","Harga Satuan"}, 0);
            for (Produk p : arrProduk) {
                tabPesan.addRow(new String[] {p.getNo_bpom().toString(), p.getNama_produk().toString(), p.getJenis_produk().toString(), p.getHARGA_SATUAN().toString()});
            }
            tblProduk.setModel(tabPesan);
    }
    
    public void showTblPesanan() throws SQLException {
        DefaultTableModel tabPesan2 = new DefaultTableModel(new String[] {"No Antrian","Nama Pembeli","Alamat","Total Harga"}, 0);
            for (Order or : transaksi.getDataOrder()){
                tabPesan2.addRow(new String[] {or.getNO_ANTRIAN().toString(),or.getPembeli().getNAMA_PEMBELI().toString(), or.getALAMAT().toString(), or.getTOTAL().toString()});
            }
        TblPesanan.setModel(tabPesan2);
    }
    
    public void showTotal() throws SQLException {
        txtTotal.setText(total.toString());
    }
    
//    public void showTotal_Harga() throws SQLException{
//        txtHgTotal.setText(Total_Harga.toString());
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbJenis = new javax.swing.JComboBox<>();
        btnBayar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPesanan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtAlamat = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        txtJmlProduk = new javax.swing.JTextField();
        btnProduk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbNamaPembeli = new javax.swing.JComboBox<>();
        cbNamaProduk = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnOrderan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Transaksi");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Order");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Masukkan Transaksi"));

        jLabel9.setText("Jenis Transaksi : ");

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBayar)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBayar)
                    .addComponent(jLabel9)
                    .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lihat Orderan"));

        TblPesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        TblPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblPesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblPesanan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Masukkan Pesanan"));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnProduk.setText("Tambah Produk");
        btnProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdukActionPerformed(evt);
            }
        });

        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblProduk);

        jLabel2.setText("Nama Pembeli : ");

        jLabel3.setText("Nama Produk : ");

        jLabel4.setText("Alamat : ");

        cbNamaPembeli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbNamaPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaPembeliActionPerformed(evt);
            }
        });

        cbNamaProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Jumlah Produk : ");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnOrderan.setText("Tambah Pesanan");
        btnOrderan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderanActionPerformed(evt);
            }
        });

        jLabel6.setText("Total :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtJmlProduk, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbNamaProduk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbNamaPembeli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnHapus)
                                .addGap(29, 29, 29)
                                .addComponent(btnProduk))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOrderan)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbNamaPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtJmlProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProduk)
                    .addComponent(btnHapus))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnOrderan))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addContainerGap(445, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdukActionPerformed
        try {
            cbNamaPembeli.disable();
            Produk pro = new Produk();
            pro.setNama_produk(transaksi.getDataProduk().get(cbNamaProduk.getSelectedIndex()).getNama_produk());
            pro.setJenis_produk(transaksi.getDataProduk().get(cbNamaProduk.getSelectedIndex()).getJenis_produk());
            pro.setNo_bpom(transaksi.getDataProduk().get(cbNamaProduk.getSelectedIndex()).getNo_bpom());
            pro.setHARGA_SATUAN(transaksi.getDataProduk().get(cbNamaProduk.getSelectedIndex()).getHARGA_SATUAN());
            pro.setStock(transaksi.getDataProduk().get(cbNamaProduk.getSelectedIndex()).getStock());
            arrProduk.add(pro);
            
            if (arrProduk.isEmpty()){
                total = pro.getHARGA_SATUAN() * Integer.parseInt(txtJmlProduk.getText().toString());
            } else {
                total += pro.getHARGA_SATUAN() * Integer.parseInt(txtJmlProduk.getText().toString());
            }
            showTotal();
            showTblProduk();                       
//            Order order = new Order();
//            order.setALAMAT(txtAlamat.getText());
//            order.setJUMLAH_PRODUK(Integer.parseInt(txtJmlProduk.getText()));
//            //zorder.set
//            
//            arrProduk.add(order);
//            showTblPesanan();
//            txtAlamat.setText("");
//            txtJmlProduk.setText("");
        } catch (Exception ex) {
            Logger.getLogger(Input_Pesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProdukActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnOrderanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderanActionPerformed
        cbNamaPembeli.disable();
        Order o = new Order();
        try {
               o.setPembeli(transaksi.getDataPembeli().get(cbNamaPembeli.getSelectedIndex()));
               o.setALAMAT(txtAlamat.getText());
               o.setJUMLAH_PRODUK(Integer.parseInt(txtJmlProduk.getText()));
               o.setArrProduk(arrProduk);
               o.setTOTAL(Integer.parseInt(txtTotal.getText()));
               transaksi.InsertOrder(o);
               showTblPesanan();
               showTblProduk();
               arrProduk = new ArrayList<>();
               total = 0;
               showTotal();
         } catch (SQLException ex) { 
            Logger.getLogger(Input_Pesanan.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnOrderanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        txtAlamat.setText("");
        txtJmlProduk.setText("");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        try {
            t_Transaksi tran = new t_Transaksi();
            tran.setJenis_transaksi(cbJenis.getSelectedItem().toString());
            tran.setOrder(transaksi.getDataOrder().get(TblPesanan.getSelectedRow()));
//            int harga = Integer.parseInt(txtHgTotal.toString());
            Total_Harga = transaksi.getDataOrder().get(TblPesanan.getSelectedRow()).getTOTAL();
            tran.setHarga_total(transaksi.getDataOrder().get(TblPesanan.getSelectedRow()).getTOTAL());
            transaksi.InsertTransaksi(tran);
//            showTotal_Harga();
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil");
        } catch (SQLException ex) {
            
            Logger.getLogger(Input_Pesanan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnBayarActionPerformed

    private void cbNamaPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaPembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNamaPembeliActionPerformed

    private void TblPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblPesananMouseClicked
//        Integer baris = TblPesanan.getSelectedRow();
//        this.txtHgTotal.setText(TblPesanan.getValueAt(baris,3).toString());
        //this.txt
    }//GEN-LAST:event_TblPesananMouseClicked

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
            java.util.logging.Logger.getLogger(Input_Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_Pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Input_Pesanan().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblPesanan;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnOrderan;
    private javax.swing.JButton btnProduk;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JComboBox<String> cbNamaPembeli;
    private javax.swing.JComboBox<String> cbNamaProduk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtJmlProduk;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
