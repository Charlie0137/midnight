
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
    private Card[] clock, queue = new Card[12];

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

    /*
     * checks if there is an open spot in the queue for the card,
     * if so, fills the spot and returns true
     * if not, returns false
     */
    boolean drawCard(Card drawnCard) {

        // tell the player what they drew
        System.out.printf("You drew %s\n", drawnCard.getCardString());

        // check for kings
        if (drawnCard.getValue() == 13) {
            Scanner userIn = new Scanner(System.in);

            // ask the player where they wish to put the king
            System.out.print("Where would you like to place your King?\nOpen Slot(s): ");
            for (int i = 0; i < queue.length; i++) {
                if (queue[i] != null)
                    System.out.print(i + " ");
            }
            System.out.println(">>>");

            // verify that the users selection is open
            int userSelection;
            do {
                userSelection = userIn.nextInt();
                System.out.println();
            } while (userSelection <= 13 && queue[userSelection] == null);
            userIn.close();

            // add the king to the queue
            queue[userSelection] = drawnCard;
            return true;

        } else if (queue[drawnCard.getValue()] != null) {

            System.out.println("There is no Room in the Queue");
            return false;
        } else {
            queue[drawnCard.getValue()] = drawnCard;
            return true;
        }
    }
}
