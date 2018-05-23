package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwiki
 */
public class Pelanggan extends Orang{
    private String idPelanggan;
    private String alamat;

    public Pelanggan() {
    }  
    
    public Pelanggan(String idPelanggan, String nama , String alamat, String noHP) {
        super(nama, noHP);
        this.idPelanggan = idPelanggan;
        this.alamat = alamat;
    }

    public Pelanggan(String idPelanggan, String alamat) {
        this.idPelanggan = idPelanggan;
        this.alamat = alamat;
    }
    
    @Override
    public void setNama(String nama) {
        super.setNama(nama);
    }

    @Override
    public void setNoHP(String noHP) {
        super.setNoHP(noHP);
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    @Override
    public void displayInfo(){
	System.out.println("ID	: "+getIdPelanggan());
        System.out.println("Nama	: "+ super.getNama());
	System.out.println("No. HP	: "+ super.getNoHP());
    }

   

   
}
