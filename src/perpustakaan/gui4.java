package perpustakaan;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Component;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;


public class gui4 extends JFrame {
    JLabel Label1, Label2, Label3, Label4;
    JButton btn1;
    Buku buku;
    
    public gui4(int width, int height, Buku buku) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(width, height);
        setLayout(null);
        setLocation(552, 303);
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
        //int size = buku.all().size();
        
        Label1 = new JLabel(buku.tampilDataBuku());
        
        
        setFontSize(Label1,12);
        setFontStyle(Label1, Font.BOLD);
        boundedAdd(Label1,41,21,200,100);
        
        btn1 = new JButton("BACK");
        setFontSize(btn1,12);
        setFontStyle(btn1, Font.BOLD);
        boundedAdd(btn1,400,88,92,31);
    }

    
    public void event() {
        btn1.addActionListener((e) -> {
            new guiMenu(469, 369, buku).setVisible(true);
            dispose();
        });
    }
    
}
