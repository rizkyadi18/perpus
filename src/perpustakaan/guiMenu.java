/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Component;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class guiMenu extends JFrame {
    JLabel menuLabel;
    JTextField userField;
    JButton btn1, btn2, btn3, btn4, btn5;
    Buku buku;
    
    public guiMenu(int width, int height, Buku buku) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(width, height);
        setLayout(null);
        setLocation(469, 369);
        this.buku = buku;
    }
    
        @Override
    public void setVisible(boolean b) {
        if (b == true) {
            component();
            event();
        }
        super.setVisible(b);
    }


    protected void boundedAdd(Component comp, int x, int y, int width, int height) {
        int constX = 15, constY = 55;
        x = x - (constX / 2);
        y = y - (constY / 2);
        width = width + (constX / 2);
        comp.setBounds(x, y, width, height);
        add(comp);
    }


    protected void setFontStyle(Component comp, int style) {
        Font fontLama = comp.getFont();
        Font fontBaru = new Font(fontLama.getFontName(), style, fontLama.getSize());
        comp.setFont(fontBaru);
    }

    protected void setFontSize(Component comp, int size) {
        Font fontLama = comp.getFont();
        Font fontBaru = new Font(fontLama.getFontName(), fontLama.getStyle(), size);
        comp.setFont(fontBaru);
    }


    public void component() {
        menuLabel = new JLabel("MENU");
        setFontSize(menuLabel,24);
        setFontStyle(menuLabel, Font.BOLD);
        boundedAdd(menuLabel,174,25,82,30);

        btn1 = new JButton("Tambah Buku");
        setFontSize(btn1,12);
        setFontStyle(btn1, Font.BOLD);
        boundedAdd(btn1,88,55,228,34);
        
        btn2 = new JButton("Edit Buku");
        setFontSize(btn2,12);
        setFontStyle(btn2, Font.BOLD);
        boundedAdd(btn2,88,105,228,34);
        
        btn3 = new JButton("Hapus Buku");
        setFontSize(btn3,12);
        setFontStyle(btn3, Font.BOLD);
        boundedAdd(btn3,88,155,228,34);
        
        btn4 = new JButton("Tampilkan Buku");
        setFontSize(btn4,12);
        setFontStyle(btn4, Font.BOLD);
        boundedAdd(btn4,88,205,228,34);
        
        btn5 = new JButton("EXIT");
        setFontSize(btn5,12);
        setFontStyle(btn5, Font.BOLD);
        boundedAdd(btn5,88,305,228,34);
    }

    
    public void event() {
        btn5.addActionListener((e) -> {
            new gui(500, 300).setVisible(true);
            dispose();
        });
        
        btn1.addActionListener((e) -> {
            new gui1(431, 294, buku).setVisible(true);
            dispose();
        });
        
        btn2.addActionListener((e) -> {
            new gui2(500, 500, buku).setVisible(true);
            dispose();
        });
        
        btn3.addActionListener((e) -> {
            new gui3(431, 294, buku).setVisible(true);
            dispose();
        });
        
        btn4.addActionListener((e) -> {
            new gui4(552, 303, buku).setVisible(true);
            dispose();
        });
    }
}
