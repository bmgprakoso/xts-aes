package tugas1prog_CIS2016;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

class Panel extends JPanel implements ActionListener  {
    private JLabel title, plaintext, key, ciphertext;
    private JTextField source, keyField, target;
    private JButton encrypt, decrypt, openKey, openFile, saveFile;
    String sourceName, keyName, targetName;
    
    public Panel () {
        setLayout(null);
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        initComponents();
        setSize(800,600);
        addComponents();      
    }

    private void addComponents() {
        add(title);
        add(plaintext);
        add(key);
        add(ciphertext);
        add(source);
        add(keyField);
        add(target);
        add(decrypt);
        add(encrypt);
        add(openKey);
        add(openFile);
        add(saveFile);
    }
    
    private void initComponents() {
        title = new JLabel("XTS-AES Encryption/Decryption Implementation");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setSize(680,40);
        title.setFont(new Font("Roboto",0,25));
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setVerticalTextPosition(SwingConstants.CENTER);
        
        plaintext = new JLabel("Source");
        plaintext.setHorizontalAlignment(SwingConstants.LEFT);
        plaintext.setSize(220,25);
        plaintext.setFont(new Font("Roboto",0,20));
        plaintext.setHorizontalTextPosition(SwingConstants.CENTER);
        plaintext.setVerticalTextPosition(SwingConstants.CENTER);
        plaintext.setLocation(10,70);
        
        key = new JLabel("Key");
        key.setHorizontalAlignment(SwingConstants.LEFT);
        key.setSize(220,25);
        key.setFont(new Font("Roboto",0,20));
        key.setHorizontalTextPosition(SwingConstants.CENTER);
        key.setVerticalTextPosition(SwingConstants.CENTER);
        key.setLocation(10,120);
        
        ciphertext = new JLabel("Target");
        ciphertext.setHorizontalAlignment(SwingConstants.LEFT);
        ciphertext.setSize(220,25);
        ciphertext.setFont(new Font("Roboto",0,20));
        ciphertext.setHorizontalTextPosition(SwingConstants.CENTER);
        ciphertext.setVerticalTextPosition(SwingConstants.CENTER);
        ciphertext.setLocation(10,170);

        source = new JTextField(20);
        source.setSize(source.getPreferredSize());
        source.setLocation(130,70);
        source.setSize(220,20);
        
        keyField =new JTextField(20);
        keyField.setSize(keyField.getPreferredSize());
        keyField.setLocation(130,120);
        keyField.setSize(220,20);
        
        target =new JTextField(20);
        target.setSize(target.getPreferredSize());
        target.setLocation(130,170);
        target.setSize(220,20);
        
        encrypt = new JButton("Encrypt");
        encrypt.setSize(100,20);
        encrypt.setLocation(350,230);
        encrypt.addActionListener(this);

        decrypt = new JButton("Decrypt");
        decrypt.setSize(100,20);
        decrypt.setLocation(190,230);
        decrypt.addActionListener(this);
        
        openFile = new JButton("Source");
        openFile.setSize(150,20);
        openFile.setLocation(400,70);
        openFile.addActionListener(this);
        
        openKey = new JButton("Key");
        openKey.setSize(150,20);
        openKey.setLocation(400,120);
        openKey.addActionListener(this);
        
        saveFile = new JButton("Target");
        saveFile.setSize(150,20);
        saveFile.setLocation(400,170);
        saveFile.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( ae.getSource() == openFile) {
            OpenFile openFile = new OpenFile();
            sourceName = openFile.src;
            source.setText(sourceName);
        } else if (ae.getSource() == openKey) {
            OpenKey openKeytext = new OpenKey();
            keyName = openKeytext.key;
            keyField.setText(keyName);
        } else if(ae.getSource() == saveFile) {
            SaveFile save = new SaveFile();
            targetName = save.target;
            target.setText(targetName);
        } else if (ae.getSource() == encrypt) {
            XTSAES aes = new XTSAES(sourceName, keyName, targetName);
            try {
                aes.eksekusiEnkripsi(keyName, sourceName, targetName);
            } catch (Exception ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == decrypt) {
            XTSAES aes = new XTSAES(sourceName, keyName, targetName);
            try {
                aes.eksekusiDekripsi(keyName, sourceName, targetName);
            } catch (Exception ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   


}
