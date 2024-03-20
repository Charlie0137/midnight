/*
 * Charlie Burrow
 * 531 008 931
 * 20 March 2024
 * 
 * Program to showcase players ability to draw a card and place it into their clock
 */

import java.util.ArrayList;

public class Checkpoint {
    static ArrayList<Card> deck = new ArrayList<Card>();
    static Player player = new Player("Example Player");

    public static void main(String[] args) {
        // populate the deck
        for (Card.Suits i : Card.Suits.values()) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(j, i));
                System.out.println("Added " + deck.get(deck.size() - 1).getCardString());
            }
            System.out.println();
        }
        for (int i = 0; i < 52; i++) {
            Card drawnCard = drawCard();
            System.out.printf("%2d: %2d %s\n", i + 1, drawnCard.getValue(), drawnCard.getSuit());
        }
    }

    private static Card drawCard() {
        int drawNum = (int) (Math.random() * deck.size());
        Card card = deck.get(drawNum);
        deck.remove(card);
        return card;
    }
}
