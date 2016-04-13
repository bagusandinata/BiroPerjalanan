package Models;


import Models.Perjalanan;
import Models.Petugas;
import Models.Pelanggan;
import Models.PaketWisata;
import Models.TempatWisata;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuge
 */
import java.util.Scanner;
public class AplikasiKonsol {
    private ArrayList <Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList <Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList <Perjalanan> daftarPerjalanan = new ArrayList<>();
    private ArrayList <PaketWisata> daftarPaketWisata = new ArrayList<>();
    private ArrayList <TempatWisata> daftarTempatWisata = new ArrayList<>();
    
    public void addPetugas(Petugas pet){
        if (daftarPetugas.size() < 3) daftarPetugas.add(pet);
        else System.out.println("Penuh");
    }
    
    public void deletePetugas(String id){
	for (int i = 0; i < daftarPetugas.size(); i++) {
            if (daftarPetugas.get(i).getIdPetugas().equals(id)){
                    daftarPetugas.remove(i);
                    break;
            }
	}
        System.out.println("ID tidak ditemukan");
    }
    public void addPelanggan(Pelanggan p){
        if (daftarPelanggan.size() < 10) daftarPelanggan.add(p);
        else System.out.println("Penuh");
    }
    
    public void deletePelanggan(String id){
	for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getIdPelanggan() == id){
                    daftarPelanggan.remove(i);
                    break;
            }
	}
        System.out.println("ID tidak ditemukan");
    }
    
    public void addPerjalanan(Perjalanan p){
        if (daftarPerjalanan.size() < 10) daftarPerjalanan.add(p);
        else System.out.println("Penuh");
    }
    
    public void deletePerjalanan(String id){
	for (int i = 0; i < daftarPerjalanan.size(); i++) {
            if (daftarPerjalanan.get(i).getIdPerjalanan() == id){
                    daftarPerjalanan.remove(i);
                    break;
            }
	}
        System.out.println("ID tidak ditemukan");
    }
    
    public void addPaketWisata(PaketWisata p){
        if (daftarPaketWisata.size() < 10) daftarPaketWisata.add(p);
        else System.out.println("Penuh");
    }
    
    public void deletePaketWisata(String id){
	for (int i = 0; i < daftarPaketWisata.size(); i++) {
            if (daftarPaketWisata.get(i).getIdPaketWisata() == id){
                    daftarPaketWisata.remove(i);
                    break;
            }
	}
        System.out.println("ID tidak ditemukan");
    }
    
    public void addTempatWisata(TempatWisata p){
        if (daftarTempatWisata.size() < 10) daftarTempatWisata.add(p);
        else System.out.println("Penuh");
    }
    
    public void deleteTempatWisata(String id){
	for (int i = 0; i < daftarTempatWisata.size(); i++) {
            if (daftarTempatWisata.get(i).getIdWst() == id){
                    daftarTempatWisata.remove(i);
                    break;
            }
	}
        System.out.println("ID tidak ditemukan");
    }
    
    public void mainPetugas() {
        int x=0;
        do{
            System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
            System.out.println("==============MENU==============");
            System.out.println("1. Input Data Petugas");
            System.out.println("2. Delete Data Petugas");
            System.out.println("3. Edit Data Petugas");
            System.out.println("4. Display Petugas");
            System.out.println("5. Keluar");

            Scanner scan = new Scanner (System.in);
            System.out.println("Pilih menu ke: ");
            x=scan.nextInt();
            switch(x){
                case 1:
                    System.out.println("----Input Data Petugas----");
                    System.out.print("Masukkan Nama : ");
                    String nama = scan.next();
                    System.out.print("Masukkan ID : ");
                    String idPetugas  = scan.next();
                    System.out.print("Masukkan No HP : ");
                    String noHP = scan.next();
                    Petugas pet = new Petugas(nama,idPetugas,noHP);
                    System.out.print("Masukkan Alamat : ");
                    String alamat = scan.next();
                    pet.setAlamat(alamat);
                    addPetugas(pet);
                    break;

                case 2:
                    System.out.println("----Delete Data Petugas----");
                    System.out.print("Masukkan ID : ");
                    String idPet= scan.next();
                    deletePetugas(idPet);
                    break;
                case 3:

                case 4:
                    for(Petugas ptg :daftarPetugas){
                        ptg.displayInfo();
                        System.out.println();
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }while (x!=5);
    }
    
    public void mainPelanggan() {
        int x=0;
        do{
            System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
            System.out.println("==============MENU==============");
            System.out.println("1. Input Data Pelanggan");
            System.out.println("2. Delete Data Pelanggan");
            System.out.println("3. Edit Data Pelanggan");
            System.out.println("4. Display Pelanggan");
            System.out.println("5. Keluar");

            Scanner scan = new Scanner (System.in);
            System.out.println("Pilih menu ke: ");
            x=scan.nextInt();
            switch(x){
                case 1:
                    System.out.println("----Input Data Pelanggan----");
                    System.out.print("Masukkan Nama : ");
                    String nama = scan.next();
                    System.out.print("Masukkan ID : ");
                    String idPelanggan  = scan.next();
                    System.out.print("Masukkan No HP : ");
                    String noHP = scan.next();
                    Pelanggan pel = new Pelanggan(nama, idPelanggan, noHP);
                    System.out.print("Masukkan Kota : ");
                    String kota = scan.next();
                    pel.setKota(kota);
                    addPelanggan(pel);
                    break;

                case 2:
                    System.out.println("----Delete Data Pelanggan----");
                    System.out.print("Masukkan ID : ");
                    String idPel= scan.next();
                    deletePetugas(idPel);
                    break;
                case 3:

                case 4:
                    for(Pelanggan plg :daftarPelanggan){
                        plg.displayInfo();
                        System.out.println();
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }while (x!=5);
    }
    
    public void mainTempatWisata() {
        int x=0;
        do{
            System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
            System.out.println("==============MENU==============");
            System.out.println("1. Input Data Tempat Wisata");
            System.out.println("2. Delete Data Tempat Wisata");
            System.out.println("3. Edit Data Tempat Wisata");
            System.out.println("4. Display Tempat Wisata");
            System.out.println("5. Keluar");

            Scanner scan = new Scanner (System.in);
            System.out.println("Pilih menu ke: ");
            x=scan.nextInt();
            switch(x){
                case 1:
                    System.out.println("----Input Data Tempat Wisata----");
                    System.out.print("Masukkan Nama Tempat  : ");
                    String nama = scan.next();
                    System.out.print("Masukkan ID           : ");
                    String idWst  = scan.next();
                    System.out.print("Masukkan Nama Daerah  : ");
                    String daerah = scan.next();
                    TempatWisata twis = new TempatWisata(nama, daerah, idWst);
                    System.out.print("Masukkan Harga : ");
                    double harga = scan.nextDouble();
                    twis.setHarga(harga);
                    addTempatWisata(twis);
                    break;

                case 2:
                    System.out.println("----Delete Data Tempat Wisata----");
                    System.out.print("Masukkan ID : ");
                    String idWis = scan.next();
                    deleteTempatWisata(idWis);
                    break;
                case 3:

                case 4:
                    for(TempatWisata tw :daftarTempatWisata){
                        tw.displayInfo();
                        System.out.println();
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }while (x!=5);
    }
    
/*    public void mainPaketWisata() {
        int x=0;
        do{
            System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
            System.out.println("==============MENU==============");
            System.out.println("1. Input Data Paket Wisata");
            System.out.println("2. Delete Data Paket Wisata");
            System.out.println("3. Edit Data Paket Wisata");
            System.out.println("4. Display Paket Wisata");
            System.out.println("5. Keluar");

            Scanner scan = new Scanner (System.in);
            System.out.println("Pilih menu ke: ");
            x=scan.nextInt();
            switch(x){
                case 1:
                    System.out.println("----Input Data Paket Wisata----");
                    System.out.print("Masukkan ID : ");
                    String id = scan.next();
                    System.out.print("Masukkan ID : ");
                    String idPelanggan  = scan.next();
                    System.out.print("Masukkan No HP : ");
                    String noHP = scan.next();
                    Pelanggan pel = new Pelanggan(nama, idPelanggan, noHP);
                    System.out.print("Masukkan Kota : ");
                    String kota = scan.next();
                    pel.setKota(kota);
                    addPelanggan(pel);
                    break;

                case 2:
                    System.out.println("----Delete Data Tempat Wisata----");
                    System.out.print("Masukkan ID : ");
                    String idPel= scan.next();
                    deletePetugas(idPel);
                    break;
                case 3:

                case 4:
                    for(TempatWisata tw :daftarTempatWisata){
                        tw.displayInfo();
                        System.out.println();
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }while (x!=5);
    }
*/    
    public static void main(String[] args){
        AplikasiKonsol ak = new AplikasiKonsol();
        
        int x=0;
        do{
        System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
        System.out.println("===========PILIH MENU===========");
        System.out.println("1. Petugas");
        System.out.println("2. Pelanggan");
        System.out.println("3. Tempat Wisata");
        System.out.println("4. Paket Wisata");
        System.out.println("5. Perjalanan");
        System.out.println("6. Keluar");
        
        Scanner scan = new Scanner (System.in);
        System.out.println("Pilih menu ke: ");
        x=scan.nextInt();
        switch(x){
            case 1:
                ak.mainPetugas();
            case 2:
                ak.mainPelanggan();
            case 3:
                ak.mainTempatWisata();
            case 4:
                
            case 5:
                
            case 6:
               System.exit(0); 
        }
        }while (x!=9);
    }
}