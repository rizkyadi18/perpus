package perpustakaan;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Component;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class gui2 extends JFrame {
    JLabel Label1, Label2;
    JTextField userField1, userField2;
    JButton btn1, btn2;
    Buku buku;
    
    public gui2(int width, int height, Buku buku) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(width, height);
        setLayout(null);
        setLocation(500, 500);
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
        Label1 = new JLabel(buku.tampilDataBuku());
        setFontSize(Label1,12);
        setFontStyle(Label1, Font.BOLD);
        boundedAdd(Label1,34,27,224,82);
        
        userField1 = new JTextField();
        userField1.setBounds(93,154, 224, 32);
        add(userField1);
        
        Label2 = new JLabel("Edit Buku Menjadi");
        setFontSize(Label2,12);
        setFontStyle(Label2, Font.BOLD);
        boundedAdd(Label2,96,226,224,32);
        
        userField2 = new JTextField();
        userField2.setBounds(96,282, 224, 32);
        add(userField2);

        btn1 = new JButton("OK");
        setFontSize(btn1,12);
        setFontStyle(btn1, Font.BOLD);
        boundedAdd(btn1,361,408,78,31);
        
        btn2 = new JButton("BACK");
        setFontSize(btn2,12);
        setFontStyle(btn2, Font.BOLD);
        boundedAdd(btn2,238,408,78,31);
    }

    
    public void event() {
        btn1.addActionListener((e) -> {
        String respon = buku.editBuku(userField1.getText(),userField2.getText());
        Label1.setText(buku.tampilDataBuku());

        });
        
        btn2.addActionListener((e) -> {
        new guiMenu(469, 369, buku).setVisible(true);
        dispose();
        });
    }
}