/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul06;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

/**
 *
 * @author ASUS X441M
 */
public class ContohActionListener {
     public static void main(String[] args ){
         JFrame frame = new JFrame("Contoh ActionListener");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(300, 150);
         frame.setLayout(new FlowLayout());
         
         //
         JLabel label = new JLabel("Hallo, klik tombol dibawah!");
         JButton button = new JButton("Klik Saya!");
         
         //2. 
         //
         ActionListener listener = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e ) {
                 //3. 
                 ;label.setText("Tombol telah diklik!");
      
             }
         };
         
         //4. 
         button.addActionListener(listener);
         
         //Tambahkan 
         frame.add(label);
         frame.add(button);
         frame.setVisible(true);
   
     }
}
