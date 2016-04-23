/*
 * Class OpenPlainText 
 * Version:
 * -1.0 (20-04-2012) develop class OpenPlainText
 *
 * Copyright 2010 Omar Abdillah, Prahesa Kusuma Setia, Yahya Muhammad
 */
package tugas1prog_CIS2016;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

final class OpenFile {

    private JFileChooser fileChooser;
    private File file;
    public String src;

    public OpenFile() {
        fileChooser =  new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if( result == JFileChooser.APPROVE_OPTION) {
        	file = fileChooser.getSelectedFile();
            src = file.getPath();
        } else if ( result ==  JFileChooser.CANCEL_OPTION) {
            return;
        }
    }
}