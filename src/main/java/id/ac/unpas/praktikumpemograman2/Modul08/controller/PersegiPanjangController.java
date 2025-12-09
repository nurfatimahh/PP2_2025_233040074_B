/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.modul08.controller;

import id.ac.unpas.praktikumpemograman2.Modul08.model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemograman2.Modul08.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS X441M
 */
public class PersegiPanjangController {
    // Model dan View sebagai atribut kelas
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;

        // Menghubungkan tombol di View dengan logic di Controller
        this.view.addHitungListener(new HitungListener());
        this.view.addResetListener(new ResetListener());
    }

    // Inner class untuk menangani event klik tombol
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil data dari View
                double p = view.getPanjang();
                double l = view.getLebar();

                // 2. Kirim data ke Model
                model.setPanjang(p);
                model.setLebar(l);

                // 3. Jalankan logika bisnis di Model
                model.hitungLuas();
                
                //latihan2
                model.hitungKeliling();

                view.setHasilLuas(model.getLuas());
                view.setHasilKeliling(model.getKeliling());
                
            } catch (NumberFormatException ex) {
                // Handle jika input bukan angka
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }
    
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetInput();
        }
    }
}