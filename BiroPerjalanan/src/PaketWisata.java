
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
    private int jmlWst;

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
    
    public double getHargaWisata(String idWst){
        TempatWisata tw = null;
	for (TempatWisata w : daftarTujuanWisata) {
            if (w.getIdWst() == idWst) {
		tw = w;
		break;
            }
	}
	return tw.getHarga();
    }
    
    public void removeTempatWisata(String idWst){
	for (int i = 0; i < daftarTujuanWisata.size(); i++) {
            if (daftarTujuanWisata.get(i).getIdWst() == idWst){
                    daftarTujuanWisata.remove(i);
            }
	}
    }
}
