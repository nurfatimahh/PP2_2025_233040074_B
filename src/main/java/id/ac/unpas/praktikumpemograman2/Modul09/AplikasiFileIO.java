/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul09;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author ASUS X441M
 */
public class AplikasiFileIO extends JFrame {

    //Komponen UI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JButton btnAppendText; //Latihan 4
    private JButton btnSaveObject, btnLoadObject; //Latihan 3
    private JFileChooser fileChooser;

    public AplikasiFileIO() {
        super("Tutorial File IO & Exception Handling");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi Komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();

        // Panel Tombol
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka Teks");
        btnSaveText = new JButton("Simpan Teks");
        btnSaveBinary = new JButton("Simpan Config (Binary)");
        btnLoadBinary = new JButton("Muat Config (Binary)");
        btnAppendText = new JButton("Tambah Teks (Append)"); //Latihan 4
        btnSaveObject = new JButton("Simpan Object"); //Latihan 3
        btnLoadObject = new JButton("Muat Object"); //Latihan 3

        // Tambah tombol ke panel
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnAppendText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        buttonPanel.add(btnSaveObject);
        buttonPanel.add(btnLoadObject);

        // Layout
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event Handling
        btnOpenText.addActionListener(e -> bukaFileTeks());
        btnSaveText.addActionListener(e -> simpanFileTeks());
        btnAppendText.addActionListener(e -> appendFileTeks()); // Latihan 4
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        btnSaveObject.addActionListener(e -> simpanObject());   // Latihan 3
        btnLoadObject.addActionListener(e -> muatObject());     // Latihan 3

        // Latihan 2
        bacaLastNotes();
    }

    private void bukaFileTeks() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                String line;

                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file!");
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    private void simpanFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan file!");
            }
        }
    }

    // Latihan 4
    // Menyimpan teks dengan mode APPEND
    private void appendFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedWriter writer =
                         new BufferedWriter(new FileWriter(file, true))) {

                writer.newLine();
                writer.write(textArea.getText());

                JOptionPane.showMessageDialog(this,
                        "Teks berhasil ditambahkan (append)!");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Gagal append file!");
            }
        }
    }
    
    private void simpanConfigBinary() {
        try (DataOutputStream out =
                     new DataOutputStream(new FileOutputStream("config.bin"))) {

            int fontSize = textArea.getFont().getSize();
            out.writeInt(fontSize);

            JOptionPane.showMessageDialog(this,
                    "Ukuran font disimpan ke config.bin");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan konfigurasi!");
        }
    }

    private void muatConfigBinary() {
        try (DataInputStream in =
                     new DataInputStream(new FileInputStream("config.bin"))) {

            int fontSize = in.readInt();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));

            JOptionPane.showMessageDialog(this,
                    "Config dimuat, ukuran font = " + fontSize);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Gagal membaca config!");
        }
    }

    // Latihan 
    // Menyimpan Objek Java menggunakan Serializable
    private void simpanObject() {
        UserConfig config =
                new UserConfig("Nurfatimah", textArea.getFont().getSize());

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("userconfig.obj"))) {

            out.writeObject(config);
            JOptionPane.showMessageDialog(this,
                    "Object UserConfig berhasil disimpan!");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal menyimpan object!");
        }
    }

    // Membaca kembali Objek Java dari file
    private void muatObject() {
        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("userconfig.obj"))) {

            UserConfig config = (UserConfig) in.readObject();

            textArea.setFont(new Font(
                    "Monospaced",
                    Font.PLAIN,
                    config.getFontSize()));

            JOptionPane.showMessageDialog(this,
                    "Object dimuat!\nUser: " + config.getUsername());

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "Gagal membaca object!");
        }
    }

    //Latiahn 2
    private void bacaLastNotes() {
        File file = new File("last_notes.txt");
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            textArea.setText("");
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiFileIO().setVisible(true);
        });
    }
}
