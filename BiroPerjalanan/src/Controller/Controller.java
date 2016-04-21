/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Config.Database;
import Models.AplikasiKonsol;
import Models.Petugas;
import View.InputPelanggan;
import View.InputPetugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter implements ActionListener {

    public AplikasiKonsol app;
    public Database db;
    public InputPetugas petugas;
    public InputPelanggan pelanggan;
    public Petugas pet;

    public Controller() {
        this.app = app;
        this.db = db;
        this.petugas = petugas;
        db.connect();
    }
    /**
     *
     * @param app
     * @param e
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        //add Petugas
            if (src.equals(petugas.getBtnAdd())){
                db.connect();
                db.savePetugas(pet);
                petugas.getBtnAdd();
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


    
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
    }

}