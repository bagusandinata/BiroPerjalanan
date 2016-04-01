package biroperjalanan;
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
    private String nama;
    private String idPelanggan;
    private String noHP;
    private String kota;
    
    public Pelanggan(String nama, String idPelanggan, String noHP) {
        super(nama, noHP);
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
	System.out.println("Nama	: "+ super.getNama());
	System.out.println("ID	: "+getIdPelanggan());
	System.out.println("No. HP	: "+ super.getNoHP());
    }

    void setIdPelanggan(String idPelanggan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
