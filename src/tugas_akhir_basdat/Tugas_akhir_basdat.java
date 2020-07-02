/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_akhir_basdat;


import GUI.*;
import Koneksi_db.Koneksi;
import java.sql.SQLException;

/**
 *
 * @author Mr C
 */
public class Tugas_akhir_basdat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        new Login().show();
        //new Input_Pesanan().show();
    }
    
} 
