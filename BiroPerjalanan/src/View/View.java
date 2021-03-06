/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Dwiki Bayu
 */
public interface View {
    public void addListener(ActionListener al);

    public class backgroundBus extends JPanel{
        private Image gambar;

        public backgroundBus() {
            gambar = new ImageIcon(getClass().getResource("/gambar/bus.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);

            Graphics2D gd = (Graphics2D) grphcs.create();
            gd.drawImage(gambar, 0, 0, getWidth(), getHeight(), null);
            gd.dispose();
        }
    }

    public class backgroundLogin extends JPanel{
        private Image gambar;
        
        public backgroundLogin() {
            gambar = new ImageIcon(getClass().getResource("/gambar/backgroundLogin.jpg")).getImage();
        }
        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);

            Graphics2D gd = (Graphics2D) grphcs.create();
            gd.drawImage(gambar, 0, 0, getWidth(), getHeight(), null);
            gd.dispose();
        }
    }
    
}
