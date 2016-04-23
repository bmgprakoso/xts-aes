package tugas1prog_CIS2016;

import java.awt.Color;
import javax.swing.JFrame;

public class Frame extends JFrame {
    private Panel mainPanel = new Panel();

    public Frame() {
        super( "XTS AES" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLayout(null);
        setSize(800, 600);
        setVisible( true );
        setBounds(0,0,720,450);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().add(mainPanel);
        setVisible(true);
    }
}
