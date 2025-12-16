/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul05;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ASUS X441M
 */
public class Latihan3 {
    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable (){
            public void run() {
                JFrame frame = new JFrame("Jendela dengan Label");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.setLayout(new FlowLayout ());
                
                JLabel label = new JLabel ("Teks Awal");
                JButton button = new JButton("Klik Saya!");
                
                button.addActionListener(e -> {
                    
                    label.setText("Tombol Berhasil diklik!");
                });
                
                frame.add(label);
                frame.add(button);
                
                frame.setVisible(true);

            }
           
        });
        
    }
    
}