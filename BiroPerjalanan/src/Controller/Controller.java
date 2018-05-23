/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Database.Database;
import Models.AplikasiKonsol;
import Models.Pelanggan;
import Models.Petugas;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controller extends MouseAdapter implements ActionListener {

    public AplikasiKonsol app;
    public Database db;
    private int selected;
    private FrameLogin login;
    private FrameMenu menu;
    private FramePetugas petugas;
    private FramePelanggan pelanggan;
    private View view;
    
    public Controller() throws SQLException {
        app = new AplikasiKonsol();
        db = new Database();
        db.connect();
        login = new FrameLogin();
        login.addListener(this);
        login.setVisible(true);
        view = login;
        petugas = new FramePetugas();
        pelanggan = new FramePelanggan();
        petugas.addAdapter(this);
        petugas.addListener(this);
        petugas.viewAll(db.loadAllPetugas());
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Object o = me.getSource();
        if(view instanceof FramePetugas){
            if (o.equals(petugas.getTbPetugas())) {
                try {
                    selected = petugas.getTbPetugas().getSelectedRow();
                    Petugas p = db.loadAllPetugas().get(selected);
                    petugas.view(p);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }else if(view instanceof FramePelanggan){
            if(o.equals(pelanggan.getTbPelanggan())) {
                try {
                    selected = pelanggan.getTbPelanggan().getSelectedRow();
                    Pelanggan p = db.loadAllPelanggan().get(selected);
                    pelanggan.view(p);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    /**
     *
     * @param app
     * @param e
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (view instanceof FrameLogin){
            login = (FrameLogin) view;
            if (src.equals(login.getBtnLogin())){
                menu = new FrameMenu();
                try {
                    ResultSet rs = db.getData("select * from t_petugas where username ='"+login.getTfUsername().getText()+"'");
                    if(rs.next()){
                        if(login.getTfPassword().getText().equals(rs.getString("password"))){
                            menu = new FrameMenu();
                            Petugas p = new Petugas(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));                        
                            menu.setVisible(true);
                            menu.addListener(this);
                            login.dispose();
                            view = menu;
                        }else{
                            JOptionPane.showMessageDialog(menu, "Login Gagal");
                        }
                        }else{
                            JOptionPane.showMessageDialog(menu, "Username Tidak Tersedia");
                        }
                }catch (SQLException ex) {
                        Logger.getLogger(FrameLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if (view instanceof FrameMenu) {
            menu = (FrameMenu) view;
            if (src.equals(menu.getBtnPetugas())) {
                petugas = new FramePetugas();
                petugas.setVisible(true);
                petugas.addListener(this);
                petugas.addAdapter(this);
                try {
                    petugas.viewAll(db.loadAllPetugas());
                    petugas.getBtnHapus().setEnabled(false);
                    petugas.getBtnEdit().setEnabled(false);
                    petugas.getBtnCari().setEnabled(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                menu.dispose();
                view = petugas;
            }else if (src.equals(menu.getBtnPelanggan())) {
                pelanggan = new FramePelanggan();
                pelanggan.setVisible(true);
                pelanggan.addListener(this);
                pelanggan.addAdapter(this);
                try {
                    pelanggan.viewAll(db.loadAllPelanggan());
                    pelanggan.getBtnHapus().setEnabled(false);
                    pelanggan.getBtnEdit().setEnabled(false);
                    pelanggan.getBtnCari().setEnabled(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                menu.dispose();
                view = pelanggan;
            }else if (src.equals(menu.getBtnPerjalanan())){
                
            }else if (src.equals(menu.getBtnPaketWisata())){
                
            }else if (src.equals(menu.getBtnTempatWisata())){
                
            }else if (src.equals(menu.getBtnLogout())){
                
            }
        }else if (view instanceof FramePetugas) {
            petugas = (FramePetugas) view;
            try {
                petugas.viewAll(db.loadAllPetugas());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }//tambah petugas
            if (src.equals(petugas.getBtnTambah())){
                Petugas p = new Petugas(petugas.getTfIdPetugas().getText(),petugas.getTfNamaPetugas().getText(),petugas.getTfAlamatPetugas().getText(), petugas.getTfNoHpPetugas().getText(),petugas.getTfUsername().getText(), petugas.getTfPassword().getText());
                try {
                    db.savePetugas(p);
                    petugas.viewAll(db.loadAllPetugas());
                    petugas.reset();
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                petugas.getBtnHapus().setEnabled(false);
                petugas.getBtnEdit().setEnabled(false);
                petugas.getBtnCari().setEnabled(false);
            }else if (src.equals(petugas.getBtnEdit())) {//edit petugas
                if(petugas.getTfIdPetugas() != null){
                    try {
                        Petugas p = new Petugas(petugas.getTfIdPetugas().getText(),petugas.getTfNamaPetugas().getText(),petugas.getTfAlamatPetugas().getText(), petugas.getTfNoHpPetugas().getText(),petugas.getTfUsername().getText(), petugas.getTfPassword().getText());
                        try {
                            db.updatePetugas(p);
                        } catch (SQLException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        petugas.reset();
                        petugas.viewAll(db.loadAllPetugas());
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        Petugas p = db.loadAllPetugas().get(selected);
                        p.setNama(petugas.getTfNamaPetugas().getText());
                        p.setAlamat(petugas.getTfAlamatPetugas().getText());
                        p.setNoHP(petugas.getTfNoHpPetugas().getText());
                        p.setUsername(petugas.getTfUsername().getText());
                        p.setPassword(petugas.getTfPassword().getText());
                        db.updatePetugas(p);
                        petugas.reset();
                        petugas.viewAll(db.loadAllPetugas());
                    }catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                petugas.getBtnEdit().setEnabled(false);
                petugas.getBtnHapus().setEnabled(false);
                petugas.getBtnCari().setEnabled(false);
            }else if (src.equals(petugas.getBtnHapus())) {
                try {
                    Petugas p = db.loadAllPetugas().get(selected);
                    db.deletePetugas(p);
                    petugas.reset();
                    petugas.viewAll(db.loadAllPetugas());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (src.equals(petugas.getBtnBatal())){
                petugas.reset();
                petugas.getBtnHapus().setEnabled(false);
                petugas.getBtnEdit().setEnabled(false);
                petugas.getBtnCari().setEnabled(false);
                petugas.getTfNamaPetugas().setEditable(true);
                petugas.getTfNoHpPetugas().setEditable(true);
                petugas.getTfAlamatPetugas().setEditable(true);
                petugas.getTfUsername().setEditable(true);
                petugas.getTfPassword().setEditable(true);
            }else if (src.equals(petugas.getBtnCariId())){
                petugas.reset();
                petugas.getBtnCariId().setEnabled(false);
                petugas.getBtnTambah().setEnabled(false);
                petugas.getBtnEdit().setEnabled(false);
                petugas.getBtnHapus().setEnabled(false);
                petugas.getTfNamaPetugas().setEditable(false);
                petugas.getTfNoHpPetugas().setEditable(false);
                petugas.getTfAlamatPetugas().setEditable(false);
                petugas.getTfUsername().setEditable(false);
                petugas.getTfPassword().setEditable(false);
                petugas.getBtnCari().setVisible(true);
            }else if (src.equals(petugas.getBtnCari())){
                try {
                    Petugas p = db.findPetugas(petugas.getTfIdPetugas().getText());
                    petugas.view(p);
                    petugas.getTfNamaPetugas().setEditable(true);
                    petugas.getTfNoHpPetugas().setEditable(true);
                    petugas.getTfAlamatPetugas().setEditable(true);
                    petugas.getTfUsername().setEditable(true);
                    petugas.getTfPassword().setEditable(true);
                    
                }catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                petugas.getBtnTambah().setEnabled(false);
                petugas.getBtnCari().setEnabled(false);
            }      
        }else if(view instanceof FramePelanggan){
            pelanggan = (FramePelanggan) view;
            try {
                pelanggan.viewAll(db.loadAllPelanggan());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }//tambah pelanggan
            if (src.equals(pelanggan.getBtnTambah())){
                Pelanggan p = new Pelanggan(pelanggan.getTfIdPelanggan().getText(),pelanggan.getTfNamaPelanggan().getText(),pelanggan.getTfAlamatPelanggan().getText(), pelanggan.getTfNoHpPelanggan().getText());
                try {
                    db.savePelanggan(p);
                    pelanggan.viewAll(db.loadAllPelanggan());
                    pelanggan.reset();
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
            }else if (src.equals(pelanggan.getBtnEdit())) {//edit pelanggan
                if(pelanggan.getTfIdPelanggan()!= null){
                    try {
                        Pelanggan p = new Pelanggan(pelanggan.getTfIdPelanggan().getText(),pelanggan.getTfNamaPelanggan().getText(),pelanggan.getTfAlamatPelanggan().getText(), pelanggan.getTfNoHpPelanggan().getText());
                        try {
                            db.updatePelanggan(p);
                        } catch (SQLException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        pelanggan.reset();
                        pelanggan.viewAll(db.loadAllPelanggan());
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        Pelanggan p = db.loadAllPelanggan().get(selected);
                        p.setNama(pelanggan.getTfNamaPelanggan().getText());
                        p.setAlamat(pelanggan.getTfAlamatPelanggan().getText());
                        p.setNoHP(pelanggan.getTfNoHpPelanggan().getText());
                        db.updatePelanggan(p);
                        pelanggan.reset();
                        pelanggan.viewAll(db.loadAllPelanggan());
                    }catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
            }else if (src.equals(petugas.getBtnHapus())) {//delete pelanggan
                try {
                    Pelanggan p = db.loadAllPelanggan().get(selected);
                    db.deletePelanggan(p);
                    pelanggan.reset();
                    pelanggan.viewAll(db.loadAllPelanggan());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (src.equals(pelanggan.getBtnBatal())){//cancel
                pelanggan.reset();
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
                pelanggan.getTfNamaPelanggan().setEditable(true);
                pelanggan.getTfNoHpPelanggan().setEditable(true);
                pelanggan.getTfAlamatPelanggan().setEditable(true);
            }else if (src.equals(petugas.getBtnCariId())){//cari pelanggan based on id
                pelanggan.reset();
                pelanggan.getBtnCariId().setEnabled(false);
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
                pelanggan.getTfNamaPelanggan().setEditable(false);
                pelanggan.getTfNoHpPelanggan().setEditable(false);
                pelanggan.getTfAlamatPelanggan().setEditable(false);
                petugas.getBtnCari().setVisible(true);
            }else if (src.equals(pelanggan.getBtnCari())){
                try {
                    Pelanggan p = db.findPelanggan(pelanggan.getTfIdPelanggan().getText());
                    pelanggan.view(p);
                    pelanggan.getTfNamaPelanggan().setEditable(true);
                    pelanggan.getTfNoHpPelanggan().setEditable(true);
                    pelanggan.getTfAlamatPelanggan().setEditable(true);
                    
                }catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                pelanggan.getBtnTambah().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
            }
        }
    }
}
//        //Index
//        if (src.equals(index.getjButtonSignUp())) {
//            index.setVisible(false);
//            signUp.setVisible(true);
//        }
//        if (src.equals(index.getjButtonLogin())) {
//            index.setVisible(false);
//            login.setVisible(true);
        /*
        //SignUp
        if (src.equals(signUp.getjButtonSignUp())) {
            try {
                pelanggan.viewAll(db.loadAllPelanggan());
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (src.equals(pelanggan.getBtnTambah())){
                Pelanggan p = new Pelanggan(pelanggan.getTfIdPelanggan().getText(),pelanggan.getTfNamaPelanggan().getText(),pelanggan.getTfAlamatPelanggan().getText(), pelanggan.getTfNoHpPelanggan().getText());
                try {
                    db.savePelanggan(p);
                    pelanggan.viewAll(db.loadAllPelanggan());
                    pelanggan.reset();
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
            }else if (src.equals(pelanggan.getBtnEdit())) {
                if(pelanggan.getTfIdPelanggan() != null){
                    try {
                        Pelanggan p = new Pelanggan(pelanggan.getTfIdPelanggan().getText(),pelanggan.getTfNamaPelanggan().getText(),pelanggan.getTfAlamatPelanggan().getText(), pelanggan.getTfNoHpPelanggan().getText());
                        try {
                            db.updatePelanggan(p);
                        } catch (SQLException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        pelanggan.reset();
                        pelanggan.viewAll(db.loadAllPelanggan());
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        Pelanggan p = db.loadAllPelanggan().get(selected);
                        p.setNama(pelanggan.getTfNamaPelanggan().getText());
                        p.setAlamat(pelanggan.getTfAlamatPelanggan().getText());
                        p.setNoHP(pelanggan.getTfNoHpPelanggan().getText());
                        db.updatePelanggan(p);
                        pelanggan.reset();
                        pelanggan.viewAll(db.loadAllPelanggan());
                    }catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
            }else if (src.equals(pelanggan.getBtnHapus())) {
                try {
                    Pelanggan p = db.loadAllPelanggan().get(selected);
                    db.deletePelanggan(p);
                    pelanggan.reset();
                    pelanggan.viewAll(db.loadAllPelanggan());
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (src.equals(pelanggan.getBtnBatal())){
                pelanggan.reset();
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
                pelanggan.getTfNamaPelanggan().setEditable(true);
                pelanggan.getTfNoHpPelanggan().setEditable(true);
                pelanggan.getTfAlamatPelanggan().setEditable(true);
            }else if (src.equals(pelanggan.getBtnCariId())){
                pelanggan.reset();
                pelanggan.getBtnCariId().setEnabled(false);
                pelanggan.getBtnTambah().setEnabled(false);
                pelanggan.getBtnEdit().setEnabled(false);
                pelanggan.getBtnHapus().setEnabled(false);
                pelanggan.getTfNamaPelanggan().setEditable(false);
                pelanggan.getTfNoHpPelanggan().setEditable(false);
                pelanggan.getTfAlamatPelanggan().setEditable(false);
                pelanggan.getBtnCari().setVisible(true);
            }else if (src.equals(pelanggan.getBtnCari())){
                try {
                    Pelanggan p = db.findPelanggan(pelanggan.getTfIdPelanggan().getText());
                    pelanggan.view(p);
                    pelanggan.getTfNamaPelanggan().setEditable(true);
                    pelanggan.getTfAlamatPelanggan().setEditable(true);
                    pelanggan.getTfNoHpPelanggan().setEditable(true);
                }catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                pelanggan.getBtnTambah().setEnabled(false);
                pelanggan.getBtnCari().setEnabled(false);
            }        
        }
    }
}*/

