/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul06;
import javax.swing.*;
/**
 *
 * @author ASUS X441M
 */
public class ContohFlowLayout {
    public static void main(String[] args){
        //1. Membuat Frame (Window)
        JFrame frame = new JFrame("Contoh FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        
        //2. Membuat Panel (Container)
        JPanel panel = new JPanel();
        // panel.setLayout(new FlowLayout(FloyLayout.CENTER); 
        //CENTER, LEFT atau RIGHT
        
        //3. Buat dan Tambahkan komponen
        panel.add(new JButton("Tombol 1"));
        panel.add(new JButton("Tombol 2"));
        panel.add(new JButton("Tombol Tiga"));
        panel.add(new JButton("Tombol Empat Panjang"));
        panel.add(new JButton("Tombol 5"));
        
        //4. Menambahkan Panel ke Frame
        frame.add(panel);
        
        //5. Tampilkan Frame
        frame.setVisible(true);
                
    }
    
    
}
