
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
public class PaketWisata {
    private ArrayList<TempatWisata> daftarTujuanWisata = new ArrayList<>();
    double harga;
            
    public void addDaftarTujuanWisata(TempatWisata w) {
        if (daftarTujuanWisata.size() < 5) daftarTujuanWisata.add(w);
        else System.out.println("Penuh");
    }
    
    public TempatWisata getTempatWisataIndex(int n){
        return daftarTujuanWisata.get(n);
    }
    
    public TempatWisata getTempatWisataId(String idWst){
        TempatWisata tw = null;
	for (TempatWisata w : daftarTujuanWisata) {
            if (w.getIdWst() == idWst) {
		tw = w;
		break;
            }
	}
	return tw;
    }
    
    public double getHargaWisata(){
        TempatWisata tw = null;
        harga = 0;
	for (TempatWisata w : daftarTujuanWisata) {
            harga = harga + w.getHarga();
	}
	return harga;
    }
    
    public void removeTempatWisata(String idWst){
	for (int i = 0; i < daftarTujuanWisata.size(); i++) {
            if (daftarTujuanWisata.get(i).getIdWst() == idWst){
                    daftarTujuanWisata.remove(i);
            }
	}
    }
    
    public void displayInfo(){
        for (TempatWisata w : daftarTujuanWisata) {
            System.out.println("ID          : "+w.getIdWst());
            System.out.println("Nama Tempat : "+w.getNamaTempat());
            System.out.println("Nama Daerah : "+w.getNamaDaerah());
            System.out.println("Harga       : "+w.getHarga());
            break;
        }
    }

    double getHargaWisata(String idWst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
