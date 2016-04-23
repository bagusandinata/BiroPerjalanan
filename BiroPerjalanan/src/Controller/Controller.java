/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Config.Database;
import Models.AplikasiKonsol;
import Models.Pelanggan;
import Models.Petugas;
import View.InputPelanggan;
import View.InputPetugas;
import View.MenuUtama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Controller extends MouseAdapter implements ActionListener {

    public AplikasiKonsol app;
    public Database db;
    public InputPetugas petugas;
    public InputPelanggan pelanggan;
    public Petugas pet;
    private int selected;
    private MenuUtama main;
    public Controller() throws SQLException {
        
        app = new AplikasiKonsol();
        db = new Database();
        db.connect();
        petugas = new InputPetugas();
        pelanggan = new InputPelanggan();
        petugas.addAdapter(this);
        petugas.addListener(this);
        petugas.viewAll(db.loadAllPetugas());
        main = new MenuUtama();
        main.addListener(this);
        main.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        Object o = me.getSource();
        if (o.equals(petugas.getTbPetugas())) {
            try {
                selected = petugas.getTbPetugas().getSelectedRow();
                Petugas p = db.loadAllPetugas().get(selected);
                petugas.view(p);
            } catch (SQLException ex) {
                ex.printStackTrace();
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
            if (src.equals(main.getBtnPetugas())){
                main.setVisible(false);
                petugas.setVisible(true);
                if (src.equals(petugas.getBtnAdd())){//add petugas
                    Petugas p = new Petugas(petugas.getIdPetugas(),petugas.getTxtNmPetugas().getText(),petugas.getAlamatPetugas(), petugas.getNoHPPetugas());
                    try {
                        db.savePetugas(p);
                        petugas.viewAll(db.loadAllPetugas());
                    } catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }//edit petugas
                }else if (src.equals(petugas.getBtnEdit())) {
                    try {
                        Petugas p = db.loadAllPetugas().get(selected);
                        p.setNama(petugas.getTxtNmPetugas().getText());
                        p.setAlamat(petugas.getAlamatPetugas());
                        p.setNoHP(petugas.getNoHPPetugas());
                        db.updatePetugas(p);
                        petugas.reset();
                        petugas.viewAll(db.loadAllPetugas());
                    }catch (SQLException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else if(src.equals(main.getBtnPelanggan())){
                Pelanggan p = new Pelanggan(pelanggan.getTfIdPelanggan().getText(), pelanggan.getTfNamaPelanggan().getText(), pelanggan.getTfNoHpPelanggan().getText());
                try {
                    db.savePelanggan(p);
                    pelanggan.viewAll(db.loadAllPelanggan());
                } catch (SQLException ex) {
                }
            }
        //add Petugas
            
            }
        //save
        
        //Index
        /*if (src.equals(index.getjButtonSignUp())) {
            index.setVisible(false);
            signUp.setVisible(true);
        }
        if (src.equals(index.getjButtonLogin())) {
            index.setVisible(false);
            login.setVisible(true);
        }*/
/*
        //SignUp
        if (src.equals(signUp.getjButtonSignUp())) {
            try {
                Pelanggan p = new Pelanggan(signUp.getTxtNama().getText(),
                        signUp.getTxtJenkel().getText(),
                        signUp.getTxtNotelp().getText());
                if (app.insertPelanggan(p)) {
                    signUp.showMessage("Insert Berhasil !!");
                } else {
                    signUp.showMessage("Insert gagal coy !!!", "ERROR INSERT",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                System.out.println("Insert Error");
            }
        }
*/
        //Login
/*        if (src.equals(login.getjButtonLogin())) {
            try {
                String nama = login.getTxtNama().getText();
                String notelp = login.getTxtNotelp().getText();
                Pelanggan p = new Pelanggan(nama, notelp);
                if (app.cekLoginPelanggan(p)) {
                    login.setVisible(false);
                    menupel.setVisible(true);
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
*/
/*        //Menu Pelanggan
        if (src.equals(menupel.getjButtonTransportasi())) {
            try {
                pesan.setVisible(true);
                menupel.setVisible(false);
            } catch (Exception ae) {
                pesan.showMessage("Gagal");
                ae.printStackTrace();
            }
        }

        //PesanTransport
        if (src.equals(pesan.getjButtonPesan())) {
            try {
                Pelanggan p = new Pelanggan(UserSession.getId_ss(),
                        UserSession.getNama_ss(),
                        UserSession.getJenkel_ss(),
                        UserSession.getNotelp_ss());
                Pesanan ps = p.createPesanan("Transport", pesan.getjTextFieldLokasi().getText(),
                        pesan.getjTextFieldTujuan().getText(),
                        Integer.parseInt(pesan.getjTextFieldJarak().getText()),
                        Integer.parseInt(pesan.getjTextFieldTarif().getText()));
                if (app.insertPesanan(ps, p.getIdPelanggan())) {
                    pesan.showMessage("Pesanan Sukses");
                    menupel.setVisible(true);
                    pesan.setVisible(false);
                } else {
                    pesan.showMessage("Input Gagal");
                    menupel.setVisible(true);
                    pesan.setVisible(false);
                }
            } catch (Exception ea) {
                ea.printStackTrace();
                menupel.setVisible(true);
                pesan.setVisible(false);
            }
        }
*/
    }