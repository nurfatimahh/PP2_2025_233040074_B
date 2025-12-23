/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul10Tugas.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MahasiswaView extends JFrame {

    public JTextField txtNama, txtNIM, txtJurusan, txtCari;
    public JButton btnSimpan, btnEdit, btnHapus, btnClear, btnCari;
    public JTable table;
    public DefaultTableModel model;

    public MahasiswaView() {

        setTitle("CRUD Mahasiswa MVC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // FORM 
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtNama = new JTextField();
        txtNIM = new JTextField();
        txtJurusan = new JTextField();

        panelForm.add(new JLabel("Nama"));
        panelForm.add(txtNama);
        panelForm.add(new JLabel("NIM"));
        panelForm.add(txtNIM);
        panelForm.add(new JLabel("Jurusan"));
        panelForm.add(txtJurusan);

        // TOMBOL CRUD 
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Clear");

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);

        // CARI
        JPanel panelCari = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtCari = new JTextField(15);
        btnCari = new JButton("Cari");

        panelCari.add(new JLabel("Cari Nama"));
        panelCari.add(txtCari);
        panelCari.add(btnCari);
        
        JPanel panelAtas = new JPanel();
        panelAtas.setLayout(new BoxLayout(panelAtas, BoxLayout.Y_AXIS));
        panelAtas.add(panelForm);
        panelAtas.add(panelTombol);
        panelAtas.add(panelCari);

        add(panelAtas, BorderLayout.NORTH);

        // TABEL
        model = new DefaultTableModel(new String[]{"No", "Nama", "NIM", "Jurusan"}, 0);
        table = new JTable(model);
        table.setRowHeight(24);
        table.setFillsViewportHeight(true);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new MahasiswaView().setVisible(true);
    }
}
