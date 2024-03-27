
/*
 * Charlie Burrow
 * 531 008 931
 * charlie@tamu.edu
 * 
 * Created 5 March 2024
 */

import java.util.Scanner;

public class Player {

    // parameters
    private String name;
    private Card[] clock = new Card[12];
    private Card[] queue = new Card[12];

    // constructors
    Player() {
        // players are given a pseudorandom number as a name if none is provided
        name = Integer.toString((int) System.currentTimeMillis() % 1000);
    }

    Player(String setName) {
        name = setName;
    }

    // methods
    // accessors
    String getName() {
        return name;
    }

    Card[] getQueue() {
        return queue;
    }

    Card[] getClock() {
        return clock;
    }

    // mutators

    public void resetQueue() {
        queue = new Card[12];
    }

    /*
     * checks if there is an open spot in the queue for the card,
     * if so, fills the spot and returns true
     * if not, returns false
     */
    @SuppressWarnings("resource")
    boolean drawCard(Card drawnCard) {
        Scanner userIn = new Scanner(System.in);

        // tell the player what they drew
        System.out.printf("You drew %s\n", drawnCard.getCardString());

        // check for kings
        if (drawnCard.getValue() == 13) {

            // ask the player where they wish to put the king
            System.out.print("Where would you like to place your King?\nOpen Slot(s): ");
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] == null)
                    System.out.print(i + 1 + " ");
            }
            System.out.println();

            // verify that the users selection is open
            int userSelection;
            do {
                System.out.print(">>> ");
                userSelection = userIn.nextInt();
            } while (userSelection <= 0 || userSelection >= 13 || queue[userSelection - 1] != null);

            System.out.println();

            // add the king to the queue
            queue[userSelection - 1] = drawnCard;
            return true;

        } else if (queue[drawnCard.getValue() - 1] != null) {

            System.out.println("There is no Room in the Queue");
            return false;
        } else {
            queue[drawnCard.getValue() - 1] = drawnCard;
            return true;
        }
    }

    public void endTurn() {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null && clock[i] == null) {
                clock[i]  = new Card(queue[i]);
                queue[i] = null;
            }
        }
    }
}
