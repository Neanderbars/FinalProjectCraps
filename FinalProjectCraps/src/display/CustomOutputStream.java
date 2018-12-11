package display;

import java.io.IOException;
import java.io.OutputStream;
 
import javax.swing.JTextArea;
 
/**
 *  Author: Kory Krattiger
 *  This class sets up a custom output stream so that the game is
 *  displayed to the JFrame textbox, and not the eclipse output stream.
 */
public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;
     
    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    // Changes the output stream to another stream of choice
    @Override
    public void write(int i) throws IOException {
        // Data is redirected to the text area
        textArea.append(String.valueOf((char)i));
        // The text is scrolled down to where it ends
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
