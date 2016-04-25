package Models;


import Database.Database;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class AplikasiKonsol {
    private ArrayList <Petugas> daftarPetugas = new ArrayList<>();
    private ArrayList <Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList <Perjalanan> daftarPerjalanan = new ArrayList<>();
    private ArrayList <PaketWisata> daftarPaketWisata = new ArrayList<>();
    private ArrayList <TempatWisata> daftarTempatWisata = new ArrayList<>();
    
    Database db = new Database();
}