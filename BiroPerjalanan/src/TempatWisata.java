/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuge
 */
public class TempatWisata {
    private String namaTempat;
    private String namaDaerah;
    private String idWst;
    private double harga;
    
    public TempatWisata(String namaTempat, String namaDaerah, double harga, String idWst) {
        this.namaTempat = namaTempat;
        this.namaDaerah = namaDaerah;
        this.harga = harga;
        this.idWst = idWst;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public void setNamaDaerah(String namaDaerah) {
        this.namaDaerah = namaDaerah;
    }

    public void setIdWst(String idWst) {
        this.idWst = idWst;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public String getNamaDaerah() {
        return namaDaerah;
    }

    public double getHarga() {
        return harga;
    }

    public String getIdWst() {
        return idWst;
    }
}

