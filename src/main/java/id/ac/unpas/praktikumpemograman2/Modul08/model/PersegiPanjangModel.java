/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul08.model;

/**
 *
 * @author ASUS X441M
 */
public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    
    //Latihan2
    private double keliling;

    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    } 
    
    //Latihan2
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    } 
    
  
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    
    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }
}
