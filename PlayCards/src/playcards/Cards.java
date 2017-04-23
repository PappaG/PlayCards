/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playcards;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kruge
 */
public class Cards {
    public final String[] cardSuit = {"H", "S", "D", "C"};  //Hearts, Spades, Diamonds, Clubs
    public final String[] cardValue = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    ArrayList<String> deck = new ArrayList<>();  //Cards will be stored as a string in format <value><suit> eg "2D", "QH" 

    // return a new, unshuffled deck
public ArrayList<String> newDeck() {
    ArrayList<String> printDeck = new ArrayList<>(); 
    
    for(String suit: cardSuit) {
        for(String value: cardValue) {
            printDeck.add( value.concat(suit) );
        }
    }
        return printDeck;
    }

    // shuffle deck of cards passed as @param and return
public ArrayList<String> shuffleDeck(ArrayList<String> originalDeck) {
    // implementation of perfectly randomised shuffle
    // as per Persi Diaconis (Stanford University) on card shuffling [ https://youtu.be/AxJubaijQbI]
    // Summary of method: [Note bottom card. Take top card and place randomly in deck. 
    // Repreat until original bottom card is now on top. Shuffle this card in randomly and end]
    int deckSize = originalDeck.size();
    String lastCard =  originalDeck.get( deckSize ); // must remember last card for shuffle completion
    ArrayList<String> shuffledDeck = (ArrayList<String>) originalDeck.clone();
    Random rand = new Random();
    
    
    
    
    
}







}
