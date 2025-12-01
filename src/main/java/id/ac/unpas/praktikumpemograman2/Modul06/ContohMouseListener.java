/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul06;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ASUS X441M
 */
public class ContohMouseListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(300, 150);
         
         //1. 
         JPanel panel = new JPanel();
         panel.setBackground(Color.LIGHT_GRAY);
         panel.setPreferredSize(new Dimension(200,200));
         
         //2. 
         MouseAdapter adapter = new MouseAdapter() {
             @Override
             public void mouseEntered(MouseEvent e ) {
                 //
                 panel.setBackground(Color.CYAN);
             }
             
             @Override 
             public void mouseExited(MouseEvent e ) {
                 //
                 panel.setBackground(Color.LIGHT_GRAY);
             }
             
             @Override 
             public void mouseClicked(MouseEvent e ) {
                 //
                System.out.println("Mouse di klik di: x= "+ e.getX() + ", y=" +e.getY()) ;
             }
         };
         
         //3. 
         panel.addMouseListener(adapter);
         
         frame.add(panel);
         frame.setVisible(true);
    
    }
}
