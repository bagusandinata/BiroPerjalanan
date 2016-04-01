
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuge
 */
public class Perjalanan {
    private Pelanggan[] pelanggan;
    private PaketWisata paket;
    private int jmlPlg;
    private double totalHarga;
    private double harga;

    public Perjalanan() {
        pelanggan = new Pelanggan[100];
        jmlPlg = 0;
    }
    
    public void addPelanggan(Pelanggan p){
        pelanggan[jmlPlg] = p;
        jmlPlg++;
    }
    
    public Pelanggan getPelangganIndex(int n){
        return pelanggan[n];
    }
    
    public Pelanggan getPelangganId(String idPlg){
        int i;
        for( i=0; i<jmlPlg; i++){
            if (pelanggan[i].getIdPelanggan() == idPlg){
                break;
            }
        }            
        return pelanggan[i];
    }
    
    public void setPaket(PaketWisata p){
        paket = p;
    }
    
    public PaketWisata getPaket(){
        return paket;
    }
    
    public void setHarga(double harga){
        this.harga = harga;
    }
    
    public double getHarga(){
        return harga;
    }
    
    public double getTotalHarga(String idWst) {
        return totalHarga = harga + getPaket().getHargaWisata(idWst);
    }
    
    public void display(){
        System.out.println(pelanggan[0]);
    }
}
