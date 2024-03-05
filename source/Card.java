/*
 * Charlie Burrow
 * 531 008 931
 * charlie@tamu.edu
 * 
 * Created 5 March 2024
 */

import javax.swing.JOptionPane;
import java.awt.*;

/**
 * card
 */
public class Card {
    // parameters
    private enum Suits {
        Hearts,
        Diamonds,
        Spades,
        Clubs
    }

    private byte value;
    private Suits suit;

    // constructor
    Card() {
        value = 1;
        suit = Suits.Hearts;
    }

    Card(byte valueIn, Suits suitIn) {
        value = (valueIn <= 13 && valueIn > 0) ? valueIn : 1; // ensures value is between 1 and 13 (inclusive)
        suit = suitIn;
    }

    Card(byte valueIn, char suitIn) {
        value = (valueIn <= 13 && valueIn > 0) ? valueIn : 1; // ensures value is between 1 and 13 (inclusive)
        switch (Character.toLowerCase(suitIn)) {
            case 'd':
                suit = Suits.Diamonds;
                break;

            case 's':
                suit = Suits.Spades;
                break;

            case 'c':
                suit = Suits.Clubs;
                break;

            default:
                suit = Suits.Hearts;
                break;
        }
    }

    Card(byte valueIn, byte suitIn) {
        value = (valueIn <= 13 && valueIn > 0) ? valueIn : 1; // ensures value is between 1 and 13 (inclusive)
        suit = Suits.values()[(suitIn < 4 && suitIn >= 0) ? suitIn : 0];
    }

    // methods
    // getters
    byte getValue() {
        return value;
    }

    String getValueString() {
        switch (value) {
            case 1: return "an Ace";
            case 8: return "an 8";
            case 11: return "a Jack";
            case 12: return "a Queen";
            case 13: return "a King";
            default: return "a " + value;
        }
    }

    byte getByteSuit() {
        return (byte) suit.ordinal();
    }

    char getCharSuit() {
        return suit.name().charAt(0);
    }

    String getSuit() {
        return suit.name();
    }

    String getCardString() {
        return String.format("%s of %s", getValueString(), suit.name());
    }
}