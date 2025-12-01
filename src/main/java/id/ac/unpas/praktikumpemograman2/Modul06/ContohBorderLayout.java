/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul06;
import javax.swing.*;
import java.awt.BorderLayout;
/**
 *
 * @author ASUS X441M
 */
public class ContohBorderLayout {
    public static void main(String[] args ){
        //1. membuat Frame
        JFrame frame = new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        //JFrame sudah menggunakn Border Layout secara default
        
        //Menbuat dan Menambahkan komponen ke 5 wilayah 
        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);
        
        //3. Menampilkan frame
        frame.setVisible(true);
        
    }
}
