package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuge
 */
public class Petugas extends Orang {
    private String idPetugas;
    private String alamat;

    public Petugas(String nama, String idPetugas,String alamat, String noHP) {
        super(nama, noHP);
        this.idPetugas = idPetugas;
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

    public void setIdPetugas(String idPetugas) {
        this.idPetugas = idPetugas;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getIdPetugas() {
        return idPetugas;
    }

    public String getAlamat() {
        return alamat;
    }
   
    @Override
    public void displayInfo(){
	super.displayInfo();
	System.out.println("ID      : "+getIdPetugas());
	System.out.println("Alamat  : "+getAlamat());
    }
}
