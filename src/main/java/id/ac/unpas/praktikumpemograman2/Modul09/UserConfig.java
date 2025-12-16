/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul09;

import java.io.Serializable;
/**
 *
 * @author ASUS X441M
 */
public class UserConfig implements Serializable {
    private String username;
    private int fontsize;
    
    //Latihan 3
    public UserConfig() {}
    
    public UserConfig(String username, int fontsize) {
        this.username = username;
        this.fontsize = fontsize;
    }
    
    public String getUsername () {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getFontsize() {
        return fontsize;
    }
    
    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }
    
    //Latiahn 3
    @Override
    public String toString(){
        return "UserConfig{username='" + username + "', fontSize=" + fontsize + "}";
    } 

    int getFontSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
