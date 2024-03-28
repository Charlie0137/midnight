import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.event.*;

/**
 * Midnight
 */
public class Midnight extends JFrame {
    // properties
    final Color BACKGROUND = new Color(53, 101, 77);

    class MenuButton extends JButton {
        public MenuButton(String text) {
            setText(text);
            setBackground(new Color(255, 255, 255));
            setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            // setMargin(new Insets(0, 4, 0, 40));
        }
    }

    /*
     * handles logic for a players turn
     */
    class PlayerArea extends JPanel {
        // properties
        JPanel queuePanel = new JPanel();
        JPanel clockPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        MenuButton draw = new MenuButton("Draw");
        MenuButton stay = new MenuButton("Stay");
        Player player;

        public PlayerArea(Player playerIn) {
            setLayout(new GridLayout(1, 3, 2, 500));

            player = playerIn;

            setBackground(BACKGROUND);

            queuePanel.setLayout(new GridLayout(4, 3, 4, 4));
            queuePanel.setBackground(BACKGROUND);
            clockPanel.setBackground(BACKGROUND);
            clockPanel.setLayout(new GridLayout(4, 3, 4, 4));

            buttonPanel.setBackground(BACKGROUND);
            buttonPanel.setLayout(new GridLayout(2, 1, 50, 50));
            buttonPanel.add(draw);
            buttonPanel.add(stay);

            draw.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player.drawCard(new Card());
                    updateClock();
                    updateQueue();
                    updateUI();
                }
            });

            stay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // player.endTurn();
                    updateClock();
                    updateQueue();
                    updateUI();
                }
            });

            updateClock();
            updateQueue();

            add(queuePanel);
            add(buttonPanel);
            add(clockPanel);
        }

        void updateClock() {
            Card[] clock = player.getClock();
            for (int i = 0; i < clock.length; i++) {

                if (clock[i] != null) {
                    add(new CardGraphic(clock[i]));
                }
            }
        }

        void updateQueue() {
            Card[] queue = player.getQueue();
            for (int i = 0; i < queue.length; i++) {

                if (queue[i] != null) {
                    add(new CardGraphic(queue[i]));
                }
            }
        }

    }

    class CardGraphic extends JLabel {
        public CardGraphic(Card card) {
            // JLabel label = new JLabel();
            String imageDir = String.format("midnight/assets/%s%s.png", card.getValue(), card.getCharSuit());
            // System.out.println(imageDir);
            ImageIcon icon = new ImageIcon(imageDir);

            setIcon(icon);
            // add(label);
            // setBackground(BACKGROUND);
        }
    }

    public Midnight() {
        // default settings for the game area
        setTitle("Midnight");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        // setSize(400, 400);
        setMinimumSize(new Dimension(400, 400));
        getContentPane().setBackground(BACKGROUND);
        // getContentPane().setLayout(new GridBagLayout());
        // GridBagConstraints c = new GridBagConstraints();
        // c.fill = GridBagConstraints.BOTH;
        // c.weighty = 1;
        // c.weightx = 1;

        // components to add
        JMenuBar menu = new JMenuBar();

        MenuButton aboutButton = new MenuButton("About");
        MenuButton rulesButton = new MenuButton("Rules");
        JMenu newGame = new JMenu("New Game");
        MenuButton exitButton = new MenuButton("Exit");

        JMenuItem solo = new JMenuItem("Solo");
        JMenuItem duo = new JMenuItem("Duo");

        // component functionality

        // newGameButton
        // option for 1 or 2 players

        // dispose of frame on press
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // about popup
        // upon clicking, opens a new JFrame that displays information about the game
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame about = new JFrame();
                JTextArea info = new JTextArea();
                info.setText("Midnight\nCreated by Charlie Burrow\nMarch 2024");
                info.setEditable(false);
                about.add(info);
                about.setSize(300, 100);
                about.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                about.setVisible(true);
            }
        });

        // add components
        newGame.add(solo);
        newGame.add(duo);

        menu.add(aboutButton);
        menu.add(rulesButton);
        menu.add(newGame);
        menu.add(exitButton);
        setJMenuBar(menu);

        // add(new CardGraphic(new Card()));
        add(new PlayerArea(new Player()));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Midnight();
    }
}
