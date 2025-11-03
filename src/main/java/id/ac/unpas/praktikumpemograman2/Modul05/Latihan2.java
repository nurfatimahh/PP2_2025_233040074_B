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
public class Latihan2 {
    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable (){
            public void run() {
                JFrame frame = new JFrame("Jendela dengan Label");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //1. Buat Komponen JLabel
                JLabel label = new JLabel("Ini Adalah JLabel");
                
                //2. Menambahkan JLabel ke JFrame
                // Secara Default. Jfarme menggunakan BorderLayout
                //dan .add menambhaka ke bagian tengah (CENTER)
                frame.add(label);
                frame.setVisible(true);
            }
        
        });
    }
}
