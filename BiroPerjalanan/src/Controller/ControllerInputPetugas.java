/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.AplikasiKonsol;
import Models.Petugas;
import View.InputPetugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;

/**
 *
 * @author IPutuAdi
 */
public class ControllerInputPetugas implements ActionListener, FocusListener {

    AplikasiKonsol model;
    InputPetugas view;
    Petugas p;

    public ControllerInputPetugas(AplikasiKonsol model) {
        this.model = model;
        view = new InputPetugas();
        view.setVisible(true);
        view.addListener(this);
        this.p = null;
        
        this.view.getTfNamaPetugas().addFocusListener(this);
        this.view.getTfAlamatPetugas().addFocusListener(this);
    }

    public ControllerInputPetugas(AplikasiKonsol model, Petugas p) {
        this.model = model;
        view = new InputPetugas();
        view.setVisible(true);
        view.addListener(this);
        this.p = p;
        view.setNamaPetugas(p.getNama());
        view.setAlamatPetugas(p.getAlamat());
        view.setIdPetugas(p.getIdPetugas());
        view.setNoHPPetugas(p.getNoHP());
        view.getBtnAdd().setText("Update");
        view.setTitle("Edit Petugas");
    }

   @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source.equals(view.getBtnAdd())) {
            String nama = view.getNamaPetugas();
            String alamat = view.getAlamatPetugas();
            String id = view.getIdPetugas();
            if (p == null) {
                int idPetugas = model.addPetugas();
                view.showMessage(view, "ID Anda = " + idPetugas);
                view.setNamaPetugas("");
                view.setAlamatPetugas("");
            } else{
                p.setNama(nama);
                p.setAlamat(alamat);
                model.updatePelanggan(p);
                JOptionPane.showMessageDialog(view, "ID Pelanggan "+p.getIdPetugas()+" berhasil di update");
                new ControllerViewPetugas(model);
                view.dispose();
            }
        } else if(source.equals(view.getBtnBack())){
            new ControllerViewPelanggan(model);
            view.dispose();
        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if(o.equals(this.view.getTfNamaPetugas())){
            if(this.view.getTfNamaPetugas().getText().equals("")){
                JOptionPane.showMessageDialog(null, "jgn kosong bray");
            }
        }
    }
}