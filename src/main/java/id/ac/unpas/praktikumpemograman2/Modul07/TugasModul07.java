/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul07;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author ASUS X441M
 */
public class TugasModul07 extends JFrame {
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    // Method untuk membuat TabInput
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //Komponen Nama
        panel.add(new JLabel("Nama Siswa:"));
        txtNama = new JTextField();
        panel.add(txtNama);
        
        //Komponen Mata Pelajaran
        panel.add(new JLabel("Mata Pelajaran:"));
        String[] matkul  = {"Matematika Dasar", "Bahasa Indonesia", 
            "Algoritma dan Pemograman", "Praktikum Pemograman"};
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);
        
        //Komponen Nilai
        panel.add(new JLabel("Nilai (0-100):"));
        txtNilai = new JTextField();
        panel.add(txtNilai);
        
        //Tombol Reset
        JButton btnReset = new JButton("Reset");
        panel.add(btnReset);

        //Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(btnSimpan);
        
        //Event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                prosesSimpan();
            }
        });

        // Event tombol reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtNilai.setText("");
                cmbMatkul.setSelectedIndex(0);
            }
        });

        return panel;
    }

    // Method untuk membuat desain Tab Tabel
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        //Setup Model Tabel Kolom
        String[] kolom = {"Nama Siswa", "Mata Pelajaran" , "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        //Membungkus tabel dengan scroll
        JScrollPane scroll = new JScrollPane(tableData);
        panel.add(scroll, BorderLayout.CENTER);

        // Tombol hapus
        JButton btnHapus = new JButton("Hapus Data");
        panel.add(btnHapus, BorderLayout.SOUTH);

        // Event Hapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableData.getSelectedRow();

                if (row >= 0) {
                    tableModel.removeRow(row);
                    JOptionPane.showMessageDialog(null, 
                            "Data berhasil dihapus!");
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Pilih data dulu yang akan dihapus!");
                }
            }
        });

        return panel;
    }

    // Logika Validisi dan Penyimpanan Data
    private void prosesSimpan() {
        //1. Ambil data input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();
        
        //2. Validasi input
        
        //Validasi nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!",
                    "Error validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi minimal 3 karakter
        if (nama.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Nama minimal 3 karakter!",
                    "Error validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Validasi nilai harus angka & range benar
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
            if (nilai < 0 || nilai > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus 0 - 100.", 
                        "Error validasi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", 
                    "Error validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //3. Logika Grade menggunakan switch
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:
            case 8:
                grade = "A";
                break;
            case 7:
                grade = "AB";
                break;
            case 6:
                grade = "B";
                break;
            case 5:
                grade = "BC";
                break;
            default:
                grade = "E";
        }
        
        //4. Masukkan Ke tabel
        Object[] dataBaris = {nama, matkul, nilai, grade};
        tableModel.addRow(dataBaris);
        
        //5. Reset Form dan pindah tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);
       
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        tabbedPane.setSelectedIndex(1);
    }

   
    public TugasModul07() {
        //1. Konfigurasi Frame Utama
        setTitle("Aplikasi Manajemen Nilai Siswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //2. Inisialisasi Tabbed Panel
        tabbedPane = new JTabbedPane();
        
        //3. Membuat Panel untuk Tab 1
        JPanel panelInput = createInputPanel();
        tabbedPane.addTab("Input Data", panelInput);
        
        //4. Membuat Panel untuk Tab 2
        JPanel panelTabel = createTablePanel();
        tabbedPane.addTab("Daftar Nilai", panelTabel);

        add(tabbedPane);
    }

    // Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasModul07().setVisible(true);
        });
    }
}
