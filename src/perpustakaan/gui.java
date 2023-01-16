
package perpustakaan;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Component;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;


public class gui extends JFrame {
    
    JLabel perpusLabel, logLabel, passLabel, userLabel;
    JTextField userField;
    JPasswordField passField;

    JButton btn;
    Buku buku = new Buku();

    public gui(int width, int height) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(width, height);
        setLayout(null);
        setLocation(500, 250);
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
        perpusLabel = new JLabel("Perpustakaan");
        setFontSize(perpusLabel,20);
        setFontStyle(perpusLabel, Font.BOLD);
        boundedAdd(perpusLabel,14,29,142,28);

        logLabel = new JLabel("LOGIN");
        setFontSize(logLabel,20);
        setFontStyle(logLabel, Font.BOLD);
        boundedAdd(logLabel,224,86,67,27);

        userLabel = new JLabel("user");
        setFontSize(userLabel,14);
        setFontStyle(userLabel, Font.BOLD);
        boundedAdd(userLabel,93,156,65,17);

        userField = new JTextField();
        userField.setBounds(177,128, 180, 22);
        add(userField);

        passLabel = new JLabel("password");
        setFontSize(passLabel,14);
        setFontStyle(passLabel, Font.BOLD);
        boundedAdd(passLabel,93,194,65,17);

        passField = new JPasswordField();
        passField.setBounds(177,167, 180, 22);
        add(passField);

        btn = new JButton("ENTER");
        setFontSize(btn,7);
        setFontStyle(btn, Font.BOLD);
        boundedAdd(btn,231,234,65,28);
    }

    
    public void event() {
        btn.addActionListener((e) -> {
            Pustakawan p = new Pustakawan();
            String username = String.valueOf(userField.getText());
            String password = String.valueOf(passField.getPassword());

            boolean status = p.loginDB(username, password);
            if (status) {
                new guiMenu(469, 369, buku).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Username atau Password Salah",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}