
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuge
 */
import java.lang.*;
import java.util.Scanner;
public class AplikasiKonsol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Perjalanan p = new Perjalanan();
        PaketWisata pw = new PaketWisata();
        
        TempatWisata tw1 = new TempatWisata();
        pw.addDaftarTujuanWisata(tw1);
        
        
        Petugas pet = new Petugas("","","","");
        
	Pelanggan pel1 = new Pelanggan("","","");
	pel1.setKota("");
        p.addPelanggan(pel1);
        p.setPaket(pw);
        p.setHarga(50000);

        /*Pelanggan pel2 = new Pelanggan("Dwiki","C755FA", "081559955105");
	pel2.setKota("Jakarta");
        p.addPelanggan(pel2);
        p.setPaket(pw);
        p.setHarga(70000);
                 System.out.println("Nama                : "+p.getPelangganId("C755FA").getNama());
                 System.out.println("ID                  : "+p.getPelangganId("C755FA").getIdPelanggan());
                 System.out.println("Kota                : "+p.getPelangganId("C755FA").getKota());
                 System.out.println("No. HP              : "+p.getPelangganId("C755FA").getNoHP());
                 System.out.println("Harga Perjalanan    : "+p.getTotalHarga("A305B"));*/
        int x=0;
        do{
        System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
        System.out.println("===========PILIH MENU===========");
        System.out.println("1. Input Data Petugas");
        System.out.println("2. Input Data Pelanggan");
        System.out.println("3. Display Petugas");
        System.out.println("4. Display Pelanggan 1");
        System.out.println("5. Keluar");
        
        Scanner scan = new Scanner (System.in);
        System.out.println("Pilih menu ke: ");
        x=scan.nextInt();
        switch(x){
            case 1:
                System.out.println("----Input Data Petugas----");
                System.out.print("Masukkan Nama : ");
                String nama = scan.next();
                pet.setNama(nama);
                System.out.print("Masukkan ID : ");
                String idPetugas  = scan.next();
                pet.setIdPetugas(idPetugas);
                System.out.print("Masukkan No HP : ");
                String noHP = scan.next();
                pet.setNoHP(noHP);
                System.out.print("Masukkan Alamat : "+pet.getAlamat());
                String alamat = scan.next();
                pet.setAlamat(alamat);
                break;
            
            case 2:
                System.out.println("----Input Data Pelanggan----");
                
                System.out.print("Masukkan Nama : ");
                String name = scan.next();
                pel1.setNama(name);
                
                System.out.print("Masukkan ID : ");
                String idPelanggan = scan.next();
                pel1.setIdPelanggan(idPelanggan);
                
                System.out.println("Masukkan No HP:  ");
                String hp = scan.next();
                pel1.setNoHP(hp);
                
                System.out.println("Masukkan kota : ");
                String kota = scan.next();
                pel1.setKota(kota);
                
                System.out.println("Masukkan Nama Tempat Wisata : ");
                String tempat = scan.next();
                tw1.setNamaTempat(tempat);
                
                System.out.println("Masukkan Nama Daerah : ");
                String daerah = scan.next();
                tw1.setNamaDaerah(daerah);
                
                System.out.println("Masukkan Harga : ");
                double harga = scan.nextDouble();
                tw1.setHarga(harga);
                
                System.out.println("Masukkan Id Tempat Wisata : ");
                String idWst = scan.next();
                tw1.setHarga(harga);
                break;
            case 3:
                pet.displayInfo();
                break;
            case 4:
                pel1.displayInfo();
                tw1.displayInfo();
                break;
            case 5:
                System.exit(0);
        
        }
        }while (x!=9);
        }
}
