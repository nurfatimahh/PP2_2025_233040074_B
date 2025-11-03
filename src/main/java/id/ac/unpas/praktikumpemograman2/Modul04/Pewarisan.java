/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul04;

/**
 *
 * @author ASUS X441M
 */
public class Pewarisan {
// Superclass (Kelas Induk)
   class Hewan {
        String nama;
        
        public Hewan(String nama) {
            this.nama = nama;
        }
        
        public void makan() {
            System.out.println(nama + " sedang makan.");
        }
        
        public void bersuara() {
            System.out.println("Hewan ini bersuara...");
        }
   }
   
   // Subclass (Kelas Anak)
   // Kucing "adalah seekor" Hewan, jadi Kucing extends Hewan
   class Kucing extends Hewan {
   // Constructor Kucing
       public Kucing(String nama) {
   // 'super(nama)' memanggil constructor dari superclass (Hewan)
        super(nama);
    }
}
// Kelas untuk menjalankan
public class Main {
    public static void main(String[] args) {
        Kucing anggora = new Kucing("Milo");
// 'anggora' bisa memanggil method makan()
// walaupun method itu didefinisikan di kelas Hewan.
// Ini adalah pewarisan!
    anggora.makan(); // Output: Milo sedang makan.
    anggora.bersuara(); // Output: Hewan ini bersuara...
    }
   }
}