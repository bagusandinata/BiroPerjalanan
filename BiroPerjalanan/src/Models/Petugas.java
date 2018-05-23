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
    private String username;
    private String password;

    public Petugas() {
    }
    
    public Petugas(String idPetugas, String nama,String alamat, String noHP, String username, String password) {
        super(nama, noHP);
        this.idPetugas = idPetugas;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
    }

    public Petugas(String nama, String alamat, String noHP, String username, String password) {
     super(nama,noHP);
     this.alamat = alamat;
     this.username = username;
     this.password = password;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getIdPetugas() {
        return idPetugas;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
   
    @Override
    public void displayInfo(){
	super.displayInfo();
	System.out.println("ID      : "+getIdPetugas());
	System.out.println("Alamat  : "+getAlamat());
    }
}
