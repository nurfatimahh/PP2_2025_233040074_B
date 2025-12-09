/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul08;

import id.ac.unpas.praktikumpemograman2.Modul08.model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemograman2.Modul08.view.PersegiPanjangView;
import id.ac.unpas.praktikumpemograman2.modul08.controller.PersegiPanjangController;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS X441M
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 1. Instansiasi Model
                PersegiPanjangModel model = new PersegiPanjangModel();

                // 2. Instansiasi View
                PersegiPanjangView view = new PersegiPanjangView();

                // 3. Hubungkan Model & View lewat Controller
                PersegiPanjangController controller = new PersegiPanjangController(model, view);

                // 4. Tampilkan View
                view.setVisible(true);
            }
        });
    }
}
