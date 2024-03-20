import java.util.ArrayList;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Midnight
 */
class Midnight {

    // variables
    final private String TITLE = "Midnight";
    private byte playerCount, botCount;
    private Player[] players;
    private ArrayList<Card> deck;
    private JFrame frame = new JFrame();

    // start screen
    public void startScreen() {
        Object[] options = { "1", "2" };
        JOptionPane.showOptionDialog(frame, "Test", TITLE, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
}
