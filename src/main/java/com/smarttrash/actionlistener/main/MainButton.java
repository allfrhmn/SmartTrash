/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.actionlistener.main;

/**
 *
 * @author allfiandi
 */
// import library yang dibutuhkan untuk membuat button
import java.awt.event.*;
import com.smarttrash.main.MainFrame;

public class MainButton implements ActionListener {
    // deklarasi variabel yang dibutuhkan untuk membuat button
    private MainFrame mainFrame;

    // constructor MainButtonActionListener untuk membuat button
    public MainButton(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    // method actionPerformed untuk mengatur button yang ada semua frame
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainFrame.getButtonMasyarakat()) {
            mainFrame.showMasyarakatFrame();
        } 
        if(e.getSource() == mainFrame.getButtonPetugas()) {
            mainFrame.showPetugasFrame();
        }
        if(e.getSource() == mainFrame.getButtonKategori()) {
            mainFrame.showKategoriFrame();
        }
        if(e.getSource() == mainFrame.getButtonJenis()) {
            mainFrame.showJenisFrame();
        }
        if(e.getSource() == mainFrame.getButtonPenjemputan()) {
            mainFrame.showPenjemputanFrame();
        }
        if(e.getSource() == mainFrame.getButtonPoin()) {
            mainFrame.showPoinFrame();
        }
    }    
}