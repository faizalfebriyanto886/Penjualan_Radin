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
public class Order{
    
    private Integer NO_ANTRIAN;
    private Pembeli pembeli;
    private String ALAMAT;
    private Integer JUMLAH_PRODUK;
    private Integer TOTAL;
    private ArrayList<Produk> arrProduk;

    public ArrayList<Produk> getArrProduk() {
        return arrProduk;
    }

    public void setArrProduk(ArrayList<Produk> arrProduk) {
        this.arrProduk = arrProduk;
    }

    public Integer getNO_ANTRIAN() {
        return NO_ANTRIAN;
    }

    public void setNO_ANTRIAN(Integer NO_ANTRIAN) {
        this.NO_ANTRIAN = NO_ANTRIAN;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public String getALAMAT() {
        return ALAMAT;
    }

    public void setALAMAT(String ALAMAT) {
        this.ALAMAT = ALAMAT;
    }

    public Integer getJUMLAH_PRODUK() {
        return JUMLAH_PRODUK;
    }

    public void setJUMLAH_PRODUK(Integer JUMLAH_PRODUK) {
        this.JUMLAH_PRODUK = JUMLAH_PRODUK;
    } 

    public Integer getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(Integer TOTAL) {
        this.TOTAL = TOTAL;
    }
}
