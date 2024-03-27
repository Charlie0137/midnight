/*
 * Charlie Burrow
 * 531 008 931
 * 20 March 2024
 * 
 * Program to showcase players ability to draw a card and place it into their clock
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Checkpoint {
    static ArrayList<Card> deck = new ArrayList<Card>();

    public static void main(String[] args) {

        Player player1 = new Player("Example Player");
        Player player2 = new Player("Example Player 2");

        // populate the deck
        for (Card.Suits i : Card.Suits.values()) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(j, i));
                System.out.println("Added " + deck.get(deck.size() - 1).getCardString());
            }
            System.out.println();
        }

        playerTurn(player1);
        System.out.println("\nPlayer 2's Turn");
        playerTurn(player2);

    }

    private static Card drawCard() {
        if (deck.size() == 0) {
            System.out.println("Error Deck is Empty");
            System.exit(-1);
        }
        int drawNum = (int) (Math.random() * deck.size());
        Card card = deck.get(drawNum);
        deck.remove(card);
        return card;
    }

    private static void playerTurn(Player player) {
        Scanner userTurnScanner = new Scanner(System.in);
        String userDirection;
        Card drawnCard;

        while (true) {
            System.out.print("Draw a Card or Stay?\n>>> ");
            userDirection = userTurnScanner.next();
            if (userDirection.equalsIgnoreCase("draw") || userDirection.equalsIgnoreCase("d")) {

                drawnCard = drawCard();
                if (!player.drawCard(drawnCard)) {
                    for (Card c : player.getQueue()) {
                        if (c == null)
                            continue;
                        deck.add(c);
                    }
                    deck.add(drawnCard);
                    break;
                }

            } else if (userDirection.equalsIgnoreCase("stay") || userDirection.equalsIgnoreCase("s"))
                break;
            else
                continue;
            System.out.println();
        }
    }
}
