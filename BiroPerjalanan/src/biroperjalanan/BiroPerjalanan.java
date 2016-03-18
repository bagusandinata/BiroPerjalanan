/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biroperjalanan;

/**
 *
 * @author anuge
 */
public class BiroPerjalanan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Perjalanan p = new Perjalanan();
        PaketWisata pw = new PaketWisata();
        
        TempatWisata tw1 = new TempatWisata("Pulau Seribu", "jakarta", 100000, "A304B");
        TempatWisata tw2 = new TempatWisata("Batu", "Malang", 150000, "A305B");
        pw.addDaftarTujuanWisata(tw1);
        pw.addDaftarTujuanWisata(tw2);
        
        Petugas pet1 = new Petugas("Bagus","A201B", "081559955105");
        pet1.setAlamat("perumahan guru");
        
	Pelanggan pel1 = new Pelanggan("Anugerah","B3685A", "081559955105");
	pel1.setKota("Surabaya");
        p.addPelanggan(pel1);
        p.setPaket(pw);
        p.setHarga(50000);
        System.out.println("Nama                : "+p.getPelangganId("B3685A").getNama());
        System.out.println("ID                  : "+p.getPelangganId("B3685A").getIdPelanggan());
        System.out.println("Kota                : "+p.getPelangganId("B3685A").getKota());
        System.out.println("No. HP              : "+p.getPelangganId("B3685A").getNoHP());
        System.out.println("Harga Perjalanan    : "+p.getTotalHarga("A304B"));
        
        System.out.println();
        
        Pelanggan pel2 = new Pelanggan("Dinata","C755FA", "081559955105");
	pel2.setKota("Jakarta");
        p.addPelanggan(pel2);
        p.setPaket(pw);
        p.setHarga(70000);
        System.out.println("Nama                : "+p.getPelangganId("C755FA").getNama());
        System.out.println("ID                  : "+p.getPelangganId("C755FA").getIdPelanggan());
        System.out.println("Kota                : "+p.getPelangganId("C755FA").getKota());
        System.out.println("No. HP              : "+p.getPelangganId("C755FA").getNoHP());
        System.out.println("Harga Perjalanan    : "+p.getTotalHarga("A305B"));
    }
    
}
