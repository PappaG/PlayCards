/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


/**
 *
 * @author kruge
 */
public class BattleShip {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
         int gridCols = 5;
         int gridRows = 5;
         GridPoint[][] shipGrid = new GridPoint[gridCols + 1][gridRows +1]; // column and row 0 are reserved for metedata so we add one extra row and column to house the actual data
         
         createGrid(shipGrid);
         placeShips(shipGrid, 2);
         displayShips(shipGrid, 1);
         
         fireShot(shipGrid);
        // displayGrid(shipGrid, 0);
    }
    
    // create a square array of GridPoint objects and populate default values
    static void createGrid(GridPoint[][] shipGrid) {
         int rows = shipGrid.length; 
         int cols = rows;
                
        // Instantiate every shipGrid GridPoint with its _Ref and _Name, and set
        // defaults to _Contains and _Status
        for(int x=0; x < cols; x++) {
            for(int y=0; y < rows; y++) {
               shipGrid[x][y] = new GridPoint(); 
               shipGrid[x][y].setGridPointRef(x, y);
               shipGrid[x][y].setGridPointContains("~");
               shipGrid[x][y].setGridPointStatus(0);                
            }
        }
      
    }
    
    // display contents of shipGrid, starting with [start] as top left reference - 0 will display all
    static void displayGrid(GridPoint[][] shipGrid, int start ) {
         int rows = shipGrid.length;
         int cols = rows;
                
        // Display contents of every GridPoint
        for(int y= start; y < rows; y++) {
            System.out.print(y + "-");
            for(int x= start; x < cols; x++) {
               System.out.print( "["+ Arrays.toString(shipGrid[x][y].getGridPointRef()) +" ,"); //GridPointRef is a [2] array - so need to use toString to display 
               System.out.print( shipGrid[x][y].getGridPointName() +" ,");
               System.out.print( shipGrid[x][y].getGridPointContains() +" ,");
               System.out.print( shipGrid[x][y].getGridPointStatus() + "]");                
            }
            System.out.println("");
        }
    }

    // display ship locations on shipGrid, starting with [start] as top left reference - 0 will display all
    static void displayShips(GridPoint[][] shipGrid, int start ) {
         int rows = shipGrid.length;
         int cols = rows;
                
        // Display contents of every GridPoint
        for(int y= start; y < rows; y++) {
            System.out.print(y + "-");
            for(int x= start; x < cols; x++) {
               System.out.print( shipGrid[x][y].getGridPointContains() +" ,");            
            }
            System.out.println("");
        }
    }    
    
    // place n = [nrOfShips ships of length [shipLen] on random locations within boundaries of the shipGrid 
    static void placeShips(GridPoint[][] shipGrid, int nrOfShips ) {
        int maxRows = shipGrid.length -1;
        int maxCols = maxRows;
        int shipsPlaced = 0;
        int shipLen = 2;
        int shipOrientation; // 0 = horisontal, 1 = vertical
        int pinX, pinY; // starting position of ship to be placed
        Random rand = new Random();
        boolean noClash = false;
        int tries = 0; // number of attempts to place ships
     
        // ToDo: need to test for FIT - does it fit on the board without going over the edge
        //       need to test for CLASH - does it overlap another ship
       while (shipsPlaced <= nrOfShips) {
            //spawn random start and orientation
            pinX = rand.nextInt(maxRows) + 1;
            pinY = rand.nextInt(maxCols) +1;
            shipOrientation = rand.nextInt(2);
            tries ++;
            // test FIT
            if(shipOrientation == 0) {  // orientation is horisontal
               for (int i = 0; i <= shipLen - 1; i++) {
                   if (pinX + i > maxCols) { 
                       noClash = false;
                       break; } else { noClash = true; } // test FIT
                   if ( noClash && 
                           shipGrid[pinX + i][pinY].getGridPointContains().matches("~") ) {  // test CLASH
                       noClash = true; }
                   else { 
                       noClash = false;
                       break;}         
               }
               if (noClash) {
                        for (int i = 0; i <= shipLen - 1; i++) {
                        shipGrid[pinX + i][pinY].setGridPointContains(String.valueOf(shipsPlaced));
                        shipGrid[pinX + i][0].setGridPointStatus( shipGrid[pinX + i][0].getGridPointStatus() + 1); // increment column counter
                        shipGrid[0][pinY].setGridPointStatus( shipGrid[0][pinY].getGridPointStatus() + 1); // increment row counter
                        }
                        shipsPlaced ++;
                        System.out.println("Placed ship #: " + shipsPlaced + " with orientation: " + shipOrientation);
                        }
                        
            } else {  // orientation is vertical
                        for (int i = 0; i <= shipLen - 1; i++) {
                   if (pinY + i > maxRows) { 
                       noClash = false;
                       break; } else { noClash = true; } // test FIT
                   if ( noClash && shipGrid[pinX][pinY + i].getGridPointContains().matches("~") ) {  // test CLASH
                       noClash = true; }
                   else { 
                       noClash = false;
                       break;}
               }
               if (noClash) {
                        for (int i = 0; i <= shipLen - 1; i++) {
                        shipGrid[pinX][pinY + i].setGridPointContains(String.valueOf(shipsPlaced));
                        shipGrid[pinX][0].setGridPointStatus( shipGrid[pinX][0].getGridPointStatus() + 1); // increment column counter
                        shipGrid[0][pinY + i].setGridPointStatus( shipGrid[0][pinY + i].getGridPointStatus() + 1); // increment row counter
                        }
                        shipsPlaced ++;
                        System.out.println("Placed ship #: " + shipsPlaced + " with orientation: " + shipOrientation);
                }    
            }           
        }               
      
    System.out.println("Attempts made to place all ships -total: " + tries);
    System.out.println("Ships placed: " + shipsPlaced);     
}

    // get user input (x,y co-ords) and evaluate if shot hits. If not give a hint
    static void fireShot(GridPoint[][] shipGrid) {
        boolean hitScored = false;
                
        while ( !hitScored) {
            String userInput = getUserInput(5);
            System.out.println("Validated user input is :" + userInput);
            hitScored = checkHit(shipGrid, userInput);
            displayShips(shipGrid, 1);
        }
       
    }
    
    
    static String getUserInput(int gridSize) {   
        
        // set max and min for columns (single char starting with 'A') 
        // and rows (int starting with 1) 
        char minCol = 'A';
        int asciiMinCol = minCol;  
        int asciiMaxCol = minCol + gridSize -1;
        char maxCol = (char)asciiMaxCol;
        int minRow = 1;
        int maxRow = gridSize;
        
        String userInput; //raw user input
        String validatedInput; //validated and formatted input
        char xInput = 'z'; // user's x co-ord guess
        int yInput = 0; // user's y co-ord guess
        Scanner reader = new Scanner(System.in);
        boolean validXinput = false;
        boolean validYinput = false;
        
        System.out.println("Please enter target co-ordinates e.g. B2 and press enter :");
        
        while ( !validXinput || !validYinput ) {
           userInput = reader.nextLine();
           userInput = userInput.toUpperCase();
            System.out.println("You requested co-ordinates : " + userInput);
            xInput = Character.toUpperCase( userInput.charAt(0) );
            if (xInput >= minCol && xInput <= maxCol) { validXinput = true; }
              else { 
                System.out.println("Please enter character " + minCol + " - " + maxCol + " for column. You typed :" + xInput);
                validXinput = false;
                            } 
            // System.out.println("Row selected was : " + userInput.substring(1,2) );
            yInput = Integer.valueOf( userInput.substring(1,2) );
            // System.out.println("Row selected was reworked to : " + yInput );
            if (yInput >= 1 && yInput <= 5) { validYinput = true; }
              else { 
                System.out.println("Please enter number from " + minRow + " - " + maxRow + " for row. You typed :" + yInput);
                validYinput = false;      
            } 
            System.out.println("Let's try again.");
        }
        validatedInput = xInput + String.valueOf(yInput);
        //System.out.println("Co-ordinate entered was good: " + validatedInput);
             
        return( validatedInput );
    }

    
    static boolean checkHit(GridPoint[][] shipGrid, String userInput) {
        boolean hitScored;
        // parsa A1 userInput in to int column and row reference
        char minCol = 'A';
        int asciiMinCol = minCol;  
        int colRef = userInput.charAt(0) - asciiMinCol + 1;
        int rowRef = Integer.valueOf(userInput.substring(userInput.length() -1));
        String missID = "~";
        String targetContents = shipGrid[colRef][rowRef].getGridPointContains();
        
        if ( targetContents.equals(missID) ) {
            hitScored = false;
            shipGrid[colRef][rowRef].setGridPointStatus(1); // set target status to miss
            shipGrid[colRef][rowRef].setGridPointContains("*"); // set target status to mi
            System.out.println("You missed ...");
            } else {
            hitScored = true;
            shipGrid[colRef][rowRef].setGridPointStatus(2); // set target status to hit
             shipGrid[colRef][rowRef].setGridPointContains("X"); // set target status to hit           
            System.out.println("A hit! Ship number :" + targetContents);
        }
        
        
        
        return(hitScored);
    }
}

