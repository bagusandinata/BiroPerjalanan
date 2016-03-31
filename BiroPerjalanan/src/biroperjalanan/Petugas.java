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
public class Petugas extends Orang {
    private String nama;
    private String idPetugas;
    private String noHP;
    private String alamat;

    public Petugas(String nama, String idPetugas, String noHP, String alamat) {
        super(nama, noHP);
        this.idPetugas = idPetugas;
        this.alamat = alamat;
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
		System.out.println("Nama	: "+super.getNama());
		System.out.println("ID	: "+getIdPetugas());
		System.out.println("No. HP	: "+super.getNoHP());
		System.out.println("Alamat	: "+getAlamat());
	}
}
