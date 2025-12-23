/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package id.ac.unpas.praktikumpemograman2.Modul10Tugas.controller;

/**
 *
 * @author ASUS X441M
 */

import id.ac.unpas.praktikumpemograman2.Modul10.KoneksiDB;
import id.ac.unpas.praktikumpemograman2.Modul10Tugas.model.Mahasiswa;
import id.ac.unpas.praktikumpemograman2.Modul10Tugas.view.MahasiswaView;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaController {

    private MahasiswaView view;

    public MahasiswaController(MahasiswaView view) {
        this.view = view;
        initController();
        loadData();
    }

    private void initController() {
        view.btnSimpan.addActionListener(e -> simpan());
        view.btnEdit.addActionListener(e -> edit());
        view.btnHapus.addActionListener(e -> hapus());
        view.btnCari.addActionListener(e -> cari());
    }

    // ===== LOAD DATA =====
    private void loadData() {
        view.model.setRowCount(0);
        int no = 1;
        for (Mahasiswa m : getAllMahasiswa()) {
            view.model.addRow(new Object[]{
                    no++, m.getNama(), m.getNim(), m.getJurusan()
            });
        }
    }

    // ===== CRUD =====
    private void simpan() {
        try {
            tambah(new Mahasiswa(
                    view.txtNama.getText(),
                    view.txtNIM.getText(),
                    view.txtJurusan.getText()
            ));
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(view, "Data berhasil disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void edit() {
        try {
            update(new Mahasiswa(
                    view.txtNama.getText(),
                    view.txtNIM.getText(),
                    view.txtJurusan.getText()
            ));
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(view, "Data berhasil diupdate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void hapus() {
        try {
            delete(view.txtNIM.getText());
            loadData();
            clearForm();
            JOptionPane.showMessageDialog(view, "Data berhasil dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void cari() {
        view.model.setRowCount(0);
        int no = 1;
        for (Mahasiswa m : cari(view.txtCari.getText())) {
            view.model.addRow(new Object[]{
                    no++, m.getNama(), m.getNim(), m.getJurusan()
            });
        }
    }

    private void clearForm() {
        view.txtNama.setText("");
        view.txtNIM.setText("");
        view.txtJurusan.setText("");
    }

    // ===== METHOD DB (punya kamu, TETAP) =====
    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> list = new ArrayList<>();
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM mahasiswa");
            while (rs.next()) {
                list.add(new Mahasiswa(
                        rs.getString("nama"),
                        rs.getString("nim"),
                        rs.getString("jurusan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void tambah(Mahasiswa mhs) throws Exception {
        String sql = "INSERT INTO mahasiswa VALUES (?, ?, ?)";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getNim());
        pst.setString(3, mhs.getJurusan());
        pst.execute();
    }

    public void update(Mahasiswa mhs) throws Exception {
        String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getJurusan());
        pst.setString(3, mhs.getNim());
        pst.executeUpdate();
    }

    public void delete(String nim) throws Exception {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        Connection conn = KoneksiDB.configDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, nim);
        pst.executeUpdate();
    }

    public List<Mahasiswa> cari(String keyword) {
        List<Mahasiswa> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Mahasiswa(
                        rs.getString("nama"),
                        rs.getString("nim"),
                        rs.getString("jurusan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
