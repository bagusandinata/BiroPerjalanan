/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuge
 */
public class Pelanggan extends Orang{
    private String nama;
    private String idPelanggan;
    private String noHP;
    private String kota;
    
    public Pelanggan(String nama, String idPelanggan, String noHP) {
        super(nama, noHP);
        this.idPelanggan = idPelanggan;
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

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getKota() {
        return kota;
    }
    
    @Override
    public void displayInfo(){
	super.displayInfo();
	System.out.println("ID      : "+getIdPelanggan());
	System.out.println("Alamat  : "+getKota());
    }
}
