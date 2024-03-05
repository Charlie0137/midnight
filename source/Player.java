/*
 * Charlie Burrow
 * 531 008 931
 * charlie@tamu.edu
 * 
 * Created 5 March 2024
 */

import java.util.ArrayList;

public class Player {
    // parameters
    private String name;
    private ArrayList<Card> hand;

    // constructors
    Player() {
        // players are given a pseudorandom number as a name if none is provided
        name = Integer.toString((int) System.currentTimeMillis() % 1000);
    }

    Player(String setName) {
        name = setName;
        hand = new ArrayList<Card>();
    }

    // methods
    // accessors
    String getName() {
        return name;
    }

    ArrayList<Card> getHand() {
        return hand;
    }

    // mutators
    void addCard(Card drawnCard) {
        hand.add(drawnCard);
    }
}
