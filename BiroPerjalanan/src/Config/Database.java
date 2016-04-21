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
    
       public void savePetugas(Petugas p) {

        try {

            String query = "INSERT INTO pelanggan(namapetugas, alamatpetugas) VALUES ("
                    + "'" + p.getIdPetugas()+ "',"
                    + "'" + p.getNama()+ "',"
                    + "'" + p.getNoHP()+"')";
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
    
    
    
    
}