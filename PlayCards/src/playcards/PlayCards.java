/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playcards;


import java.util.ArrayList;

/**
 *
 * @author kruge
 */
public class PlayCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cards testDeck = new Cards();
        Cards testHand1 = new Cards();
        Cards testHand2 = new Cards();
        Cards discardPile = new Cards();
        
        testDeck.newDeck();
        testDeck.shuffleDeck();
        testDeck.printDeck();
        
        testDeck.transferCardsTo(testHand1, 7);
        testDeck.transferCardsTo(testHand2, 7);
        System.out.print("Hand1 :"); testHand1.printDeck();
        System.out.print("Hand2 :"); testHand2.printDeck();
        System.out.println("Remaining deck :");;
        testDeck.printDeck();
        
        testHand1.transferCardsTo(discardPile, 3);
        testDeck.transferCardsTo(testHand1, 3);
        testHand2.transferThisCardTo(discardPile, 1);
        testDeck.transferCardsTo(testHand2, 1);        
        testHand2.transferThisCardTo(discardPile, 3);
        testDeck.transferCardsTo(testHand2, 1);      
        testHand2.transferThisCardTo(discardPile, 5);
        testDeck.transferCardsTo(testHand2, 1);      
                
        System.out.print("Hand1 :"); testHand1.printDeck();
        System.out.print("Hand2 :"); testHand2.printDeck();
        System.out.println("Remaining deck :");;
        testDeck.printDeck();
    }
    
}
