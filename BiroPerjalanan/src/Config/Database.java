/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Models.Pelanggan;
import Models.Perjalanan;
import Models.Petugas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author IPutuAdi
 */
public class Database {

    private String server = "jdbc:mysql://localhost:3306/db_tubes", dbuser = "root", dbpass = "";
    private Statement st;
    private Connection con;
    private Perjalanan perl;

    public void connect() {
        try {
            con = DriverManager.getConnection(server, dbuser, dbpass);
            st = con.createStatement();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public void disconnect()
    {
        try {
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean manipulasiData(String query)throws SQLException{
        try {
            if (st.executeUpdate(query) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     public ResultSet getData(String query)
    {
        try {
            return st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void savePelanggan(Pelanggan pelanggan) throws SQLException {
        String query = "insert into tbpelanggan(idpelanggan, namapelanggan, nohppelanggan) values('"+pelanggan.getIdPelanggan()+"','"+pelanggan.getNama()+"','"+pelanggan.getNoHP()+"')";
        st.execute(query);
    }
    
    public ArrayList<Pelanggan> loadAllPelanggan() throws SQLException {
        ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
        String query = "select * from tbpelanggan";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Pelanggan pel = new Pelanggan(rs.getString(1),rs.getString(2),rs.getString(3));
            listPelanggan.add(pel);
        }
        return listPelanggan;
    }
    
    public void updatePelanggan(Pelanggan pelanggan) throws SQLException {
        String query = "update tbpelanggan set namapelanggan = '"+pelanggan.getNama()+"', nohppelanggan = '"+pelanggan.getNoHP()+"' where idpelanggan = "+pelanggan.getIdPelanggan();
        st.executeUpdate(query);
    }
    public void deletePelanggan(Pelanggan pelanggan) throws SQLException{
        String query = "delete from tbpelanggan where idpelanggan ='"+pelanggan.getIdPelanggan()+"'";
        st.execute(query);
    }
    public void savePetugas(Petugas petugas) throws SQLException {
        String query = "insert into tbpetugas(idpetugas, namapetugas, alamatpetugas, nohppetugas) values('"+petugas.getIdPetugas()+"','"+petugas.getNama()+"','"+petugas.getAlamat()+"','"+petugas.getNoHP()+"')";
        st.execute(query);
    }
    
    public ArrayList<Petugas> loadAllPetugas() throws SQLException {
        ArrayList<Petugas> listPetugas = new ArrayList<>();
        String query = "select * from tbpetugas";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Petugas pet = new Petugas(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
            listPetugas.add(pet);
        }
        return listPetugas;
    }
    
    public void updatePetugas(Petugas petugas) throws SQLException {
        String query = "update tbpetugas set namapetugas= '"+petugas.getNama()+"',alamatpetugas='"+petugas.getAlamat()+"',nohppetugas='"+petugas.getNoHP()+"' where idpetugas = '"+petugas.getIdPetugas()+"'";
        st.executeUpdate(query);
    }
    public void deletePetugas(Petugas petugas) throws SQLException{
        String query = "delete from tbpetugas where idpetugas='"+petugas.getIdPetugas()+"'";
        st.execute(query);
    }
    
    public void savePerjalanan(Perjalanan perjalanan) throws SQLException {
        String query = "insert into tbperjalanan(harga, idPerjalanan, totalHarga) values('"+perjalanan.getHarga()+"','"+perjalanan.getIdPerjalanan()+"','"+perjalanan.getTotalHarga()+"')";
        st.execute(query);
    }
    
    public ArrayList<Perjalanan> loadAllPerjalanan() throws SQLException {
        ArrayList<Perjalanan> listPerjalanan = new ArrayList<>();
        String query = "select * from tbperjalanan";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Perjalanan per1 = new Perjalanan (rs.getDouble(1),rs.getDouble(2),rs.getString(3));
            listPerjalanan.add(perl);
        }
        return listPerjalanan;
    }
    
    public void updatePerjalanan(Perjalanan perjalanan) throws SQLException {
        String query = "update tbperjalanan set harga = '"+perjalanan.getHarga()+"',  = '"+perjalanan.getTotalHarga()+"' where idPerjalanan = "+perjalanan.getIdPerjalanan();
        st.executeUpdate(query);
    }
    public void deletePerjalanan(Perjalanan perjalanan) throws SQLException{
        String query = "delete from tbpelanggan where idPerjalanan ='"+perjalanan.getIdPerjalanan()+"'";
        st.execute(query);
    }
    
//       public void savePetugas(Petugas p) {
//
//        try {
//
//            String query = "INSERT INTO pelanggan(idpetugas, namapetugas, nohppetugas) VALUES ("
//                    + "'" + p.getIdPetugas()+ "',"
//                    + "'" + p.getNama()+ "',"
//                    + "'" + p.getNoHP()+"')";
//            st.execute(query, Statement.RETURN_GENERATED_KEYS);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//    public Pelanggan getPelanggan(String Pelanggan) {
//        Pelanggan p = null;
//        try {
//            String query = "SELECT * FROM `pelanggan` WHERE `idPelanggan` = " + p.getIdPelanggan();
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                p = new Pelanggan(rs.getString(1), rs.getString(2), rs.getString(3));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return p;
//    }
//
//    public void updatePelanggan(Pelanggan p) {
//        try {
//            String query = "update pelanggan set nama ='"
//                    + p.getNama() + "', No HP= '"
//                    + p.getNoHP()+ "' where idPelanggan = "
//                    + p.getIdPelanggan();
//            st.executeUpdate(query);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public String[] getListIDPelanggan() {
//        ArrayList<String> listId = new ArrayList<>();
//        try {
//            //Query?
//            String query = "SELECT idPelanggan FROM `pelanggan`";
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                listId.add(rs.getString(1));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return listId.toArray(new String[0]);
//    }
//    
    
    
    
}