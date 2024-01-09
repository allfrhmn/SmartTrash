/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smarttrash.main;

/**
 *
 * @author allfiandi
 */

import java.awt.FlowLayout;
import com.smarttrash.frame.*;
import com.smarttrash.actionlistener.main.MainButton;
import com.smarttrash.dao.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

// class MainFrame untuk membuat semua frame
public class MainFrame extends JFrame {
// deklarasi variabel yang dibutuhkan untuk membuat semua frame
    private MasyarakatFrame masyarakatFrame;
    private PetugasFrame petugasFrame;
    private KategoriFrame kategoriFrame;
    private JenisFrame jenisFrame;
    private PenjemputanFrame penjemputanFrame;
    private PoinFrame poinFrame;
    private MasyarakatReportFrame masyarakatReportFrame;
    private PetugasReportFrame petugasReportFrame;
    
    private MasyarakatDao masyarakatDao;
    private PetugasDao petugasDao;
    private KategoriDao kategoriDao;
    private JenisDao jenisDao;
    private PenjemputanDao penjemputanDao;
    private PoinDao poinDao;

    private JLabel titleLabel;
    private JLabel subTitleLabel;
    private JButton buttonMasyarakat;
    private JButton buttonPetugas;
    private JButton buttonJenis;
    private JButton buttonKategori;
    private JButton buttonPenjemputan;
    private JButton buttonPoin;
    private JButton buttonMasyarakatReport;
    private JButton buttonPetugasReport;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);

        this.titleLabel = new JLabel("Smart Trash Apps");
        titleLabel.setBounds(50, 10, 300, 20);
        titleLabel.setFont(new java.awt.Font("Arial", 1, 24));
        this.add(titleLabel);

        this.subTitleLabel = new JLabel("by. Kelompok 5 kelas B Matakuliah PP2");
        subTitleLabel.setBounds(50, 40, 300, 20);
        subTitleLabel.setFont(new java.awt.Font("Arial", 1, 12));
        this.add(subTitleLabel);
        
        this.masyarakatDao = new MasyarakatDao();        
        this.petugasDao = new PetugasDao();
        this.kategoriDao = new KategoriDao();
        this.jenisDao = new JenisDao();
        this.penjemputanDao = new PenjemputanDao();
        this.poinDao = new PoinDao();

        this.masyarakatFrame = new MasyarakatFrame(masyarakatDao);
        this.petugasFrame = new PetugasFrame(petugasDao);
        this.kategoriFrame = new KategoriFrame(kategoriDao);
        this.jenisFrame = new JenisFrame(jenisDao, kategoriDao);
        this.penjemputanFrame = new PenjemputanFrame(penjemputanDao, masyarakatDao, petugasDao);
        this.poinFrame = new PoinFrame(poinDao, kategoriDao);    
        
        MainButton actionListener = new MainButton(this);
        this.setLayout(new FlowLayout());

        this.buttonMasyarakat = new JButton("Masyarakat");
        this.buttonMasyarakat.addActionListener(actionListener);
        this.add(buttonMasyarakat);

        this.buttonPetugas = new JButton("Petugas");
        this.buttonPetugas.addActionListener(actionListener);
        this.add(buttonPetugas);

        this.buttonKategori = new JButton("Kategori");
        this.buttonKategori.addActionListener(actionListener);
        this.add(buttonKategori);

        this.buttonJenis = new JButton("Jenis");
        this.buttonJenis.addActionListener(actionListener);
        this.add(buttonJenis);

        this.buttonPenjemputan = new JButton("Penjemputan");
        this.buttonPenjemputan.addActionListener(actionListener);
        this.add(buttonPenjemputan);

        this.buttonPoin = new JButton("Poin");
        this.buttonPoin.addActionListener(actionListener);
        this.add(buttonPoin);
        
        this.buttonMasyarakatReport = new JButton("Masyarakat Report");
        this.buttonMasyarakatReport.addActionListener(actionListener);
        this.add(buttonMasyarakatReport);
        
        this.buttonPetugasReport = new JButton("Petugas Report");
        this.buttonPetugasReport.addActionListener(actionListener);
        this.add(buttonPetugasReport);
        
    }
    
    public JButton getButtonMasyarakat() {
        return buttonMasyarakat;
    }

    public JButton getButtonPetugas() {
        return buttonPetugas;
    }

    public JButton getButtonKategori() {
        return buttonKategori;
    }

    public JButton getButtonJenis() {
        return buttonJenis;
    }

    public JButton getButtonPenjemputan() {
        return buttonPenjemputan;
    }

    public JButton getButtonPoin() {
        return buttonPoin;
    }
    
    public JButton getButtonMasyarakatReport() {
        return buttonMasyarakatReport;
    }
    
    public JButton getButtonPetugasReport() {
        return buttonPetugasReport;
    }
    
    public void showMasyarakatFrame() {
        if(masyarakatFrame == null) {
            masyarakatFrame = new MasyarakatFrame(masyarakatDao);
        }
        masyarakatFrame.setVisible(true);
    }
    
    public void showPetugasFrame() {
        if(petugasFrame == null) {
            petugasFrame = new PetugasFrame(petugasDao);
        }
        petugasFrame.setVisible(true);
    }
    
    public void showKategoriFrame() {
        if(kategoriFrame == null) {
            kategoriFrame = new KategoriFrame(kategoriDao);
        }
        kategoriFrame.setVisible(true);
    }

    public void showJenisFrame() {
        if(jenisFrame == null) {
            jenisFrame = new JenisFrame(jenisDao, kategoriDao);
        }
        jenisFrame.setVisible(true);
    }

    public void showPenjemputanFrame() {
        if(penjemputanFrame == null) {
            penjemputanFrame = new PenjemputanFrame(penjemputanDao, masyarakatDao, petugasDao);
        }
        penjemputanFrame.setVisible(true);
    }

    public void showPoinFrame() {
        if(poinFrame == null) {
            poinFrame = new PoinFrame(poinDao, kategoriDao);
        }
        poinFrame.setVisible(true);
    }
    
    public void showMasyarakatReportFrame() {
        if(masyarakatReportFrame == null) masyarakatReportFrame = new MasyarakatReportFrame();
        masyarakatReportFrame.setVisible(true);
    }
    
    public void showPetugasReportFrame() {
        if(petugasReportFrame == null) petugasReportFrame = new PetugasReportFrame();
        petugasReportFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
}