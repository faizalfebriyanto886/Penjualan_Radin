/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set_get;

/**
 *
 * @author Mr C
 */
public class Produk {
    private Integer ID_PRODUK;
    private Integer NO_BPOM;
    private String NAMA_PRODUK;
    private String JENIS_PRODUK;
    private Integer STOCK;
    private Integer HARGA_SATUAN;
    
    public Integer getId_produk(){
        return ID_PRODUK;
    }
    
    public void setId_produk(Integer Id_produk){
        this.ID_PRODUK = Id_produk;
    }
    
    public Integer getNo_bpom(){
        return NO_BPOM;
    }
    
    public void setNo_bpom(Integer No_bpom){
        this.NO_BPOM = No_bpom;
    }
    
    public String getNama_produk(){
        return NAMA_PRODUK;
    }
    
    public void setNama_produk(String Nama_produk){
        this.NAMA_PRODUK = Nama_produk;
    }
    
    public String getJenis_produk(){
        return JENIS_PRODUK;
    }
    
    public void setJenis_produk(String Jenis_produk){
        this.JENIS_PRODUK = Jenis_produk;
    }
    
    public Integer getStock(){
        return STOCK;
    }
    
    public void setStock(Integer Stock){
        this.STOCK = Stock;
    }

    public Integer getHARGA_SATUAN() {
        return HARGA_SATUAN;
    }

    public void setHARGA_SATUAN(Integer HARGA_SATUAN) {
        this.HARGA_SATUAN = HARGA_SATUAN;
    }
 
}
