/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Models.Pelanggan;
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

    public void connect() {
        try {
            con = DriverManager.getConnection(server, dbuser, dbpass);
            st = con.createStatement();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
//save
    public void savePelanggan(Pelanggan p) {

        try {

            String query = "INSERT INTO `tbpelanggan`(`idpelanggan`,`namapelanggan`,`nohppelanggan`) VALUES ("
                    + "'" + p.getIdPelanggan()+ "',"
                    + "'" + p.getNama()+ "',"
                    + "'" + p.getNoHP()+"')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        public void savePetugas(Petugas pet) {

        try {

            String query = "INSERT INTO `tbpetugas`(`idpelanggan`,`nama`,`nohp`) VALUES ("
                    + "'" + pet.getIdPetugas()+ "',"
                    + "'" + pet.getNama()+ "',"
                    + "'" + pet.getNoHP()+"')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Pelanggan getPelanggan(String Pelanggan) {
        Pelanggan p = null;
        try {
            String query = "SELECT * FROM `pelanggan` WHERE `idPelanggan` = " + p.getIdPelanggan();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pelanggan(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public void updatePelanggan(Pelanggan p) {
        try {
            String query = "update pelanggan set nama ='"
                    + p.getNama() + "', No HP= '"
                    + p.getNoHP()+ "' where idPelanggan = "
                    + p.getIdPelanggan();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String[] getListIDPelanggan() {
        ArrayList<String> listId = new ArrayList<>();
        try {
            //Query?
            String query = "SELECT idPelanggan FROM `pelanggan`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listId.toArray(new String[0]);
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
    
    
}