/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul05;
import javax.swing.*;


/**
 *
 * @author ASUS X441M
 */
public class Latihan1 {
    public static void main(String [] args) {
    // Menjalankan kode GUI di Event Dispatch Thread (EDT)
    // Ini adalah praktik terbaik untuk menghindari masalah tread
        SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                // 1. Buat objek Frame
                JFrame frame = new JFrame("Jendela Pertamaku");
                
                // 2. Atur ukuran jendela 
                frame.setSize(400, 300);
                
                //3. Atur 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
