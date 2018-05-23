/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Models.*;
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

    private String server = "jdbc:mysql://localhost:3306/db_biroperjalanan", dbuser = "root", dbpass = "";
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
        String query = "insert into t_pelanggan(idPelanggan, namaPelanggan, alamatPelanggan, noHpPelanggan) values('"+pelanggan.getIdPelanggan()+"','"+pelanggan.getNama()+"','"+pelanggan.getAlamat()+"','"+pelanggan.getNoHP()+"')";
        st.execute(query);
    }
    
    public ArrayList<Pelanggan> loadAllPelanggan() throws SQLException {
        ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
        String query = "select * from t_pelanggan";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Pelanggan pel = new Pelanggan(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
            listPelanggan.add(pel);
        }
        return listPelanggan;
    }
    
    public Pelanggan findPelanggan(String idPelanggan) throws SQLException {
        String query = "select * from t_pelanggan where idPelanggan='"+idPelanggan+"'";
        ResultSet rs = st.executeQuery(query);
        Pelanggan p = null;
        while (rs.next()) {
            Pelanggan pel = new Pelanggan(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4));
            p = pel;
        }
        return p;
    }
    
    public void updatePelanggan(Pelanggan pelanggan) throws SQLException {
        String query = "update t_pelanggan set namaPelanggan = '"+pelanggan.getNama()+"', alamatPelanggan = '"+pelanggan.getAlamat()+"', noHpPelanggan = '"+pelanggan.getNoHP()+"' where idPelanggan = "+pelanggan.getIdPelanggan();
        st.executeUpdate(query);
    }
    public void deletePelanggan(Pelanggan pelanggan) throws SQLException{
        String query = "delete from t_pelanggan where idPelanggan ='"+pelanggan.getIdPelanggan()+"'";
        st.execute(query);
    }
    
    
    public void savePetugas(Petugas petugas) throws SQLException {
        String query = "insert into t_petugas(idpetugas, namapetugas, alamatpetugas, nohppetugas, username, password) values('"+petugas.getIdPetugas()+"','"+petugas.getNama()+"','"+petugas.getAlamat()+"','"+petugas.getNoHP()+"','"+petugas.getUsername()+"','"+petugas.getPassword()+"')";
        st.execute(query);
    }
    
    public ArrayList<Petugas> loadAllPetugas() throws SQLException {
        ArrayList<Petugas> listPetugas = new ArrayList<>();
        String query = "select * from t_petugas";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Petugas pet = new Petugas(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            listPetugas.add(pet);
        }
        return listPetugas;
    }
    
    public Petugas findPetugas(String idPetugas) throws SQLException {
        String query = "select * from t_petugas where idPetugas='"+idPetugas+"'";
        ResultSet rs = st.executeQuery(query);
        Petugas p = null;
        while (rs.next()) {
            Petugas pet = new Petugas(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            p = pet;
        }
        return p;
    }
    
    public void updatePetugas(Petugas petugas) throws SQLException {
        String query = "update t_petugas set namapetugas= '"+petugas.getNama()+"',alamatpetugas='"+petugas.getAlamat()+"',nohppetugas='"+petugas.getNoHP()+"',username='"+petugas.getUsername()+"',password='"+petugas.getPassword()+"' where idpetugas = '"+petugas.getIdPetugas()+"'";
        st.executeUpdate(query);
    }
    public void deletePetugas(Petugas petugas) throws SQLException{
        String query = "delete from t_petugas where idpetugas='"+petugas.getIdPetugas()+"'";
        st.execute(query);
    }
    
//    public void saveTempatWisata(TempatWisata tempatwisata) throws SQLException {
//        String query = "insert into tbtempatwisata(namaTempat, namaDaerah, idWst, harga) values('"+tempatwisata.getNamaTempat()+"','"+tempatwisata.getNamaDaerah()+"','"+tempatwisata.getIdWst()+"'"+tempatwisata.getHarga())";
//        st.execute(query);
//    }
    
//    public ArrayList<TempatWisata> loadAllTempatWisatas() throws SQLException {
//        ArrayList<TempatWisata> listTempatWisata = new ArrayList<>();
//        String query = "select * from tbtempatwisata";
//        ResultSet rs = st.executeQuery(query);
//        while (rs.next()) {
//            TempatWisata tw = new TempatWisata(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
//            listTempatWisata.add(tw);
//        }
//        return listTempatWisata;
//    }
    
//    public void updateTempatWisata(TempatWisata tempatwisata) throws SQLException {
//        String query = "update tbtempatwisata set harga = '"+tempatwisata.getHarga()+"',  = '"+tempatwisata.getTotalHarga()+"' where idWst = "+tempatwisata.getIdWst();
//        st.executeUpdate(query);
//    }
    public void deleteTempatWisata(TempatWisata tempatwisata) throws SQLException{
        String query = "delete from tbtempatwisata where idWst ='"+tempatwisata.getIdWst()+"'";
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