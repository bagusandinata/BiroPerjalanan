
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
public class AplikasiKonsol {
    private ArrayList<TempatWisata> daftarTujuanWisata = new ArrayList<>();
    private ArrayList<Pelanggan> pelanggan = new ArrayList<>();
    private ArrayList<Petugas> petugas = new ArrayList<>();
    private ArrayList<Perjalanan> perjalanan = new ArrayList<>();
    private ArrayList<PaketWisata> daftarPaketWisata = new ArrayList<>();
    private ArrayList<TempatWisata> daftarTempatWisata = new ArrayList<>();
    
    
    
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);
        int menu;
        int admin;
        
        System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
        System.out.println("===========PILIH MENU===========");
        System.out.println("1. Admin");
        System.out.println("2. Petugas");
        System.out.println("Pilih menu ke: ");
        menu=scan.nextInt();
        switch(menu){
            case 1:
                System.out.println("SISTEM INFORMASI BIRO PERJALANAN");
                System.out.println("===========MENU ADMIN===========");
                System.out.println("1. Tambah Petugas");
                System.out.println("2. Tambah Pelanggan");
                System.out.println("Pilih menu ke: ");
                admin=scan.nextInt();
                
                switch(admin){
                    case 1:
                        
                    case 2:
                        
                }    
            case 2:
        }    
    }
}
