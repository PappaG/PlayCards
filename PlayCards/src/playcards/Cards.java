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
    public ArrayList<String> deck = new ArrayList<>();  //Cards will be stored as a string in format <value><suit> eg "2D", "QH" 
    
    // make a new, unshuffled deck
public void newDeck() {
    
    for(String suit: cardSuit) {
        for(String value: cardValue) {
            deck.add( value.concat(suit) );
        }
    }
    }

    // shuffle deck of cards passed as @param and return
public void shuffleDeck() {
    // implementation of perfectly randomised shuffle
    // as per Persi Diaconis (Stanford University) on card shuffling [ https://youtu.be/AxJubaijQbI]
    // Summary of method: [Note bottom card. Take top card and place randomly in deck. 
    // Repreat until original bottom card is now on top. Shuffle this card in randomly and end]
    int deckSize = deck.size();
    String lastCard =  deck.get( deckSize - 1); // must remember last card for shuffle completion
    String currentCard;  //card being shuffled
    boolean lastOnTop = false;
    boolean finalPass = false;
    ArrayList<String> shuffledDeck = (ArrayList<String>) deck.clone();
    Random rand = new Random();
    int placePosition;  //position to insert currentCard
    int shufflesCount = 0;  
    
    while (!finalPass) {
        // draw top card
        currentCard = shuffledDeck.get(0);
        shuffledDeck.remove(0);
        
        if(lastOnTop) { finalPass = true; }
        // shuffle card in to deck
        placePosition = rand.nextInt(deckSize - 1) + 1;
        if (placePosition < deckSize - 1) {
            shuffledDeck.add(placePosition, currentCard);
        } else { shuffledDeck.add(currentCard); }
        
        // check for last card on top
        if( shuffledDeck.indexOf(lastCard) == 0) { lastOnTop = true; }
        shufflesCount ++;    
    }
    
    deck = (ArrayList<String>) shuffledDeck.clone();
    System.out.println("Shuffles to randomise the deck : " + shufflesCount );
}

    // draw a card from top of deck and remove card from deck
public String drawTopCard() {
    String drawnCard = deck.get(0);
    deck.remove(0);
    
    return(drawnCard);
}

// draw a random card from within the deck
public String drawRandomCard() {
    Random rand = new Random(); 
    int drawPosition = rand.nextInt(deck.size() - 1);

    String drawnCard = deck.get(drawPosition);
    deck.remove(drawPosition);
    
    return(drawnCard);          
            }


// add card to deck
public void addCardToDeck( String card) {
    deck.add(card);
}

// transfer n cards from source to target
public void transferCardsTo(Cards target, int n ) {
    
    for(int i=1; i <= n; i++ ) {
        target.deck.add( this.deck.get(0) );
        this.deck.remove(0);
    }
}

// transfer specific cards from source to target based on position
public void transferThisCardTo(Cards target, int cardPos ) {
        if ( deck.size() > cardPos ) {
        target.deck.add( this.deck.get(cardPos) );
        this.deck.remove(cardPos);
        } else { System.out.println("The requested card is out of range of this deck :" + cardPos); }

}

// transfer specific cards from source to target based on value
public void transferThisCardTo(Cards target, String cardVal ) {
        if( deck.contains(cardVal) ) {
        target.deck.add( cardVal );
        this.deck.remove(cardVal);
        } else { System.out.println("This deck does not contain card :" + cardVal); }
}

    // print the card in deck to console in 
public void printDeck() {
        int cols = 10;
        int colWidth = 5;
        String sPad = new String(new char[colWidth]).replace("\0", " ");         
        //repeated = new String(new char[n]).replace("\0", s);
        int i = 0;
        
        for( String card: deck) {
            i++;
            System.out.print( (card + sPad).substring(0, colWidth));
            if( i == cols ) { System.out.println(""); i = 0; }
        }
        System.out.println("");
}    



}
