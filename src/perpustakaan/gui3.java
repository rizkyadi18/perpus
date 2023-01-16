package perpustakaan;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Component;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class gui3 extends JFrame {
     JLabel tambahLabel;
    JTextField userField;
    JButton btn1, btn2;
    Buku buku;
    
    public gui3(int width, int height, Buku buku) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(width, height);
        setLayout(null);
        setLocation(431, 294);
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
        tambahLabel = new JLabel("Hapus Buku");
        setFontSize(tambahLabel,15);
        setFontStyle(tambahLabel, Font.BOLD);
        boundedAdd(tambahLabel,25,26,200,100);
        
        userField = new JTextField();
        userField.setBounds(145,114, 239, 33);
        add(userField);

        btn1 = new JButton("OK");
        setFontSize(btn1,12);
        setFontStyle(btn1, Font.BOLD);
        boundedAdd(btn1,301,188,83,27);
        
        btn2 = new JButton("BACK");
        setFontSize(btn2,12);
        setFontStyle(btn2, Font.BOLD);
        boundedAdd(btn2,148,192,83,27);
    }

    
    public void event() {
        btn1.addActionListener((e) -> {
            String respon = buku.hapusBuku(userField.getText());
            tambahLabel.setText(buku.tampilDataBuku());
        });
        btn2.addActionListener((e) -> {
            new guiMenu(469, 369, buku).setVisible(true);
            dispose();
        });
    }
}