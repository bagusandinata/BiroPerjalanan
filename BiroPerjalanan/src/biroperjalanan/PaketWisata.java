package biroperjalanan;

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
    private TempatWisata[] daftarTujuanWisata;
    private int jmlWst;
    
    public PaketWisata() {
        daftarTujuanWisata = new TempatWisata[100];
        jmlWst = 0;
    }

    public void addDaftarTujuanWisata(TempatWisata w) {
        daftarTujuanWisata[jmlWst] = w;
        jmlWst++;
    }
    
    public TempatWisata getTempatWisataIndex(int n){
        return daftarTujuanWisata[n];
    }
    
    public TempatWisata getTempatWisataId(String idWst){
        int i;
        for( i=0; i<jmlWst; i++){
            if (daftarTujuanWisata[i].getIdWst() == idWst){
                break;
            }
        }            
        return daftarTujuanWisata[i];
    }
    
    public double getHargaWisata(String idWst){
        int i;
        for( i=0; i<jmlWst; i++){
            if (daftarTujuanWisata[i].getIdWst() == idWst){
                break;
            }
        }            
        return daftarTujuanWisata[i].getHarga();
    }
    
    public void removeTempatWisata(String idWst){
        int i;
        for( i=0; i<jmlWst; i++){
            if (daftarTujuanWisata[i].getIdWst() == idWst){
                for(int j = i; j<jmlWst; j++){
                    daftarTujuanWisata[j] = daftarTujuanWisata[j+1];
                }
            }
        }  
        jmlWst--;
    }

    boolean getPelangganId(String b3685A) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
