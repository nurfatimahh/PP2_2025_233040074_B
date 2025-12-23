/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul10Tugas;

import id.ac.unpas.praktikumpemograman2.Modul10Tugas.view.MahasiswaView;
import id.ac.unpas.praktikumpemograman2.Modul10Tugas.controller.MahasiswaController;
/**
 *
 * @author ASUS X441M
 */
public class Main {
    public static void main(String[] args) {
        MahasiswaView view = new MahasiswaView();
        new MahasiswaController(view);
        view.setVisible(true);
    }
}
