/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul06;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ASUS X441M
 */
public class KonverterSuhu {
    public static void main(String[] args) {
        // 1. Membuat Frame
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2, 5, 5)); // 3 baris, 2 kolom
        
        // 2. Tambahkan Komponen ke Frame
        JLabel labelCelcius = new JLabel("Celcius:");
        JTextField textCelcius = new JTextField(10);
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JLabel labelHasil = new JLabel("");
        
        frame.add(labelCelcius);
        frame.add(textCelcius);
        frame.add(new JLabel(""));
        frame.add(tombolKonversi);
        frame.add(labelFahrenheit);
        frame.add(labelHasil);
        
        // 3. Menambahkan ActionListener pada tombol
        tombolKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(textCelcius.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    
                    // Menampilkan hasil langsung
                    labelHasil.setText(fahrenheit + " °F");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Harus berupa angka.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    textCelcius.setText("");
                    labelHasil.setText("");
                }
            }
        });
        
        // 4. Tampilkan Frame
        frame.setVisible(true);
    }
}
