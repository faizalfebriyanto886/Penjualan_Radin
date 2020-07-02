/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set_get;

import java.util.ArrayList;

/**
 *
 * @author Mr C
 */
public class t_Transaksi {
    private Integer NO_TRANSAKSI;
    private Order ORDER; 
    private String JENIS_TRANSAKSI;
    private Integer HARGA_TOTAL;
    
    public Integer getNo_transaksi(){
        return NO_TRANSAKSI;
    }
    
    public void setNo_transaksi(Integer No_transaksi){
        this.NO_TRANSAKSI = No_transaksi;        
    }
    
    public Order getOrder(){
        return ORDER;
    }
    
    public void setOrder(Order order){
        this.ORDER = order;
    }
    
    public String getJenis_transaksi(){
        return JENIS_TRANSAKSI;
    }
    
    public void setJenis_transaksi(String Jenis_transaksi){
        this.JENIS_TRANSAKSI = Jenis_transaksi;
    }
    
     public Integer getHarga_total(){
        return HARGA_TOTAL;
    }
    
    public void setHarga_total(Integer Harga_total){
        this.HARGA_TOTAL = Harga_total;        
    }
}
