package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame {
    public HomePage() {
        setTitle("Menu Utama");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Tengah layar

        // Font dan Warna
        Font font = new Font("Segoe UI", Font.BOLD, 16);
        Color backgroundColor = new Color(52, 152, 219); // Biru muda
        Color hoverColor = new Color(41, 128, 185); // Biru tua
        Color textColor = Color.WHITE;

        // Tombol Mahasiswa
        JButton btnMahasiswa = createStyledButton("Mahasiswa", font, backgroundColor, hoverColor, textColor);
        btnMahasiswa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Mahasiswa.ViewData().setVisible(true);
            }
        });

        // Tombol Dosen
        JButton btnDosen = createStyledButton("Dosen", font, backgroundColor, hoverColor, textColor);
        btnDosen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new View.Dosen.ViewData().setVisible(true);
            }
        });

        // Panel Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        panel.add(btnMahasiswa);
        panel.add(btnDosen);

        add(panel);
    }

    // Metode pembuat tombol bergaya
    private JButton createStyledButton(String text, Font font, Color bgColor, Color hoverColor, Color textColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hover efek
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }
}
