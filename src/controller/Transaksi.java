/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Koneksi_db.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import set_get.Order;
import set_get.Pembeli;
import set_get.Produk;
import set_get.t_Transaksi;

/**
 *
 * @author Mr C
 */
public class Transaksi {
    Koneksi koneksi;
    ArrayList<Pembeli> arrPembeli;
    ArrayList<Order> arrOrder;
    ArrayList<t_Transaksi> arrTransaksi;
    ArrayList<Produk> arrProduk;
    
    public Transaksi() throws SQLException {
        koneksi = new Koneksi();
        arrPembeli = new ArrayList<>();
        arrOrder = new ArrayList<>();
        arrTransaksi = new ArrayList<>();
        arrProduk = new ArrayList<>();
    }
    
    
    public ArrayList<Pembeli> getDataPembeli() throws SQLException {
        arrPembeli.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM PEMBELI_06995");
        while (rs.next()) {
            Pembeli pembeli = new Pembeli();
            pembeli.setID_PEMBELI(rs.getInt("ID_PEMBELI"));
            pembeli.setNAMA_PEMBELI(rs.getString("NAMA_PEMBELI_06995"));
            pembeli.setNO_TELP(rs.getString("NO_TELP"));
            arrPembeli.add(pembeli);
        }
        return arrPembeli;
    }

//    public ArrayList<t_Transaksi> getDataTransaksi() throws SQLException {
//        arrTransaksi.clear();
//        ResultSet rs = koneksi.GetData("SELECT * FROM TRANSAKSI JOIN ORDER_06995 ON TRANSAKSI.NO_ANTRIAN = ORDER_06995.NO_ANTRIAN JOIN PRODUK ON ORDER_06995.ID_PRODUK = PRODUK.ID_PRODUK JOIN PEMBELI_06995 ON ORDER_06995.ID_PEMBELI = PEMBELI_06995.ID_PEMBELI;");
//        while (rs.next()) {
//
//            Pembeli pembeli = new Pembeli();
//                pembeli.setID_PEMBELI(rs.getInt("ID_PEMBELI"));
//                pembeli.setNAMA_PEMBELI(rs.getString("NAMA_PEMBELI_06995"));
//                pembeli.setNO_TELP(rs.getString("NO_TELP"));
//                        
//            Order order = new Order();
//                order.setNO_ANTRIAN(rs.getInt("NO_ANTRIAN"));
//                order.setPembeli(pembeli);
//                order.setALAMAT(rs.getString("ALAMAT"));
//                order.setJUMLAH_PRODUK(rs.getInt("JML_PRODUK"));
//                order.setArrProduk(arrProduk);
//                
//            t_Transaksi transaksi = new t_Transaksi();
//                transaksi.setNo_transaksi(rs.getInt("NO_TRANSAKSI"));
//                transaksi.setOrder(order);
//                transaksi.setJenis_transaksi(rs.getString("JENIS_TRANSAKSI"));
//                transaksi.setHarga_total(rs.getInt("HARGA_TOTAL"));
//            
//            Produk produk = new Produk();
//                produk.setId_produk(rs.getInt("ID_PRODUK"));
//                produk.setNo_bpom(rs.getInt("NO_BPOM"));
//                produk.setNama_produk(rs.getString("NAMA_PRODUK"));
//                produk.setHARGA_SATUAN(rs.getInt("HARGA_SATUAN"));
//                produk.setStock(rs.getInt("STOCK"));
//                produk.setJenis_produk(rs.getString("JENIS_TRANSAKSI"));
//                
//                arrTransaksi.add(transaksi);
//        }
//        return arrTransaksi;
//    }
    
    
    public ArrayList<t_Transaksi> getDataTransaksi() throws SQLException {
        arrTransaksi.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM TRANSAKSI JOIN ORDER_06995 ON TRANSAKSI.NO_ANTRIAN = ORDER_06995.NO_ANTRIAN JOIN PEMBELI_06995 ON ORDER_06995.ID_PEMBELI = PEMBELI_06995.ID_PEMBELI");
        while (rs.next()) {
            Pembeli p = new Pembeli();
            p.setID_PEMBELI(rs.getInt("ID_PEMBELI"));
            p.setNAMA_PEMBELI(rs.getString("NAMA_PEMBELI_06995"));
            p.setNO_TELP(rs.getString("NO_TELP"));
            
            Order O = new Order();
            O.setNO_ANTRIAN(rs.getInt("NO_ANTRIAN"));
            O.setPembeli(p);
            O.setALAMAT(rs.getString("ALAMAT"));
            O.setJUMLAH_PRODUK(rs.getInt("JML_PRODUK"));
            O.setTOTAL(rs.getInt("TOTAL"));
            
            t_Transaksi transaksi = new t_Transaksi();
                transaksi.setNo_transaksi(rs.getInt("NO_TRANSAKSI"));
                transaksi.setOrder(O);
                transaksi.setJenis_transaksi(rs.getString("JENIS_TRANSAKSI"));
                transaksi.setHarga_total(rs.getInt("HARGA_TOTAL"));
         
                arrTransaksi.add(transaksi);
        }
        return arrTransaksi;
    }
    
    public ArrayList<Order> getDataOrder() throws SQLException {
        arrOrder.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM ORDER_06995 JOIN PEMBELI_06995 ON ORDER_06995.ID_PEMBELI = PEMBELI_06995.ID_PEMBELI");
        while (rs.next()) {
            Pembeli p = new Pembeli();
            p.setID_PEMBELI(rs.getInt("ID_PEMBELI"));
            p.setNAMA_PEMBELI(rs.getString("NAMA_PEMBELI_06995"));
            p.setNO_TELP(rs.getString("NO_TELP"));
            
            Order O = new Order();
            O.setNO_ANTRIAN(rs.getInt("NO_ANTRIAN"));
            O.setPembeli(p);
            O.setALAMAT(rs.getString("ALAMAT"));
            O.setJUMLAH_PRODUK(rs.getInt("JML_PRODUK"));
            O.setTOTAL(rs.getInt("TOTAL"));
            
        ResultSet rsProduk = koneksi.GetData("SELECT * FROM PRODUK");
        ArrayList<Produk> ap = new ArrayList<>();
          while (rsProduk.next()){
            Produk pr = new Produk();
            pr.setId_produk(rsProduk.getInt("ID_PRODUK"));
            pr.setNo_bpom(rsProduk.getInt("NO_BPOM"));
            pr.setNama_produk(rsProduk.getString("NAMA_PRODUK"));
            pr.setHARGA_SATUAN(rsProduk.getInt("HARGA_SATUAN"));
            pr.setStock(rsProduk.getInt("STOCK"));
            pr.setJenis_produk(rsProduk.getString("JENIS_PRODUK"));
            
            
            ap.add(pr);
          }
          O.setArrProduk(ap);
          arrOrder.add(O);
        }
        return arrOrder;
    }
    
    
        public ArrayList<Produk> getDataProduk() throws SQLException {
        arrProduk.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM PRODUK");
        while (rs.next()) {
            Produk pr = new Produk();
            pr.setId_produk(rs.getInt("ID_PRODUK"));
            pr.setNo_bpom(rs.getInt("NO_BPOM"));
            pr.setNama_produk(rs.getString("NAMA_PRODUK"));
            pr.setHARGA_SATUAN(rs.getInt("HARGA_SATUAN"));
            pr.setStock(rs.getInt("STOCK"));
            pr.setJenis_produk(rs.getString("JENIS_PRODUK"));
            arrProduk.add(pr);
        }
        return arrProduk;
    }
    
        public void InsertOrder(Order order){
        try {
            koneksi.ManipulasiData("INSERT INTO ORDER_06995 VALUES (NO_ANTRIAN.NEXTVAL," +order.getPembeli().getID_PEMBELI()+ ",'" +order.getALAMAT()+ "'," +order.getJUMLAH_PRODUK()+ "," +order.getTOTAL()+ ")");
            ResultSet rs = koneksi.GetData("SELECT NO_ANTRIAN.CURRVAL FROM DUAL");
            System.out.println(rs);
            rs.next();
            for(Produk p : order.getArrProduk()){
                for(Produk pr : arrProduk){
                    if(pr.getId_produk().equals(pr.getId_produk())){
                        koneksi.ManipulasiData("UPDATE PRODUK SET STOCK = STOCK - " +order.getJUMLAH_PRODUK()+ "WHERE ID_PRODUK = " +pr.getId_produk());
                    }
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
       public void Insert_Produk(Produk produk){
        try {
            koneksi.ManipulasiData("INSERT INTO PRODUK VALUES (ID_PRODUK.NEXTVAL," +produk.getNo_bpom()+ ",'" +produk.getNama_produk()+"'," +produk.getHARGA_SATUAN()+"," +produk.getStock()+",'" +produk.getJenis_produk()+"')");
            ResultSet rs = koneksi.GetData("SELECT ID_PRODUK.CURRVAL FROM DUAL");
            System.out.println(rs);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
       
       public void Update_Produk(Produk produk, int No_BPOM, String Nama_Produk, int HARGA_SATUAN, int Stock, String Jenis_Produk){
          koneksi.ManipulasiData("UPDATE PRODUK SET NO_BPOM = " + No_BPOM +  ",NAMA_PRODUK = '"+ Nama_Produk +
                  "',HARGA_SATUAN = " + HARGA_SATUAN +",STOCK = " + Stock +",JENIS_PRODUK = '"+ Jenis_Produk + 
                  "' WHERE ID_PRODUK = " + produk.getId_produk());
       }
    
       
       public void Delete_Produk(Produk produk){
           koneksi.ManipulasiData("DELETE FROM PRODUK WHERE ID_PRODUK = "+ produk.getId_produk());
       }
       
       public void InsertPembeli(Pembeli pembeli){
           koneksi.ManipulasiData("INSERT INTO PEMBELI_06995 VALUES (ID_PEMBELI.NEXTVAL,'"+pembeli.getNAMA_PEMBELI()+"',"+pembeli.getNO_TELP()+")");
       }
       public void InsertTransaksi(t_Transaksi tran){
        try {
            koneksi.ManipulasiData("INSERT INTO TRANSAKSI VALUES (NO_TRANSAKSI.NEXTVAL," +tran.getOrder().getNO_ANTRIAN()+ ",'" +tran.getJenis_transaksi()+ "'," +tran.getHarga_total()+ ")");
            ResultSet rs = koneksi.GetData("SELECT NO_TRANSAKSI.CURRVAL FROM DUAL");
            System.out.println(rs);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}   