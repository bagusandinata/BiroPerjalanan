/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

/**
 *
 * @author Dwiki Bayu
 */
public abstract class Orang {
    private String nama;
    private String noHP;

    public Orang(String nama, String noHP) {
        this.nama = nama;
        this.noHP = noHP;
    }
    
    public String getNama() {
        return nama;
    }

    public String getNoHP() {
        return noHP;
    }
    
    public void displayInfo(){
	System.out.println("Nama	: "+getNama());
	System.out.println("No. HP	: "+getNoHP());
    }
}
