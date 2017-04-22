/*
 * Copyright (C) 2017 kruge
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package battleship;

/**
 * a Class holding the attributes of ships used in the Battleship board game.
 * @author PappaG
 */
public class Ship {
    // class variables
    private static int activeShips; // total count of ships on the board and not sunk
    
    // instance variables
    private int shipID;     // starts with 1, allocated in order of placement
    private int shipSize;   //         ,        ,    2    ,      3  ,  3   ,         5 
    private int shipType;  // frigate , corvette, destroyer, cruiser, sub, aircraft carrier
    private String shipName;  // a historic ship of this type
    private int shipLives; // remaining lives - starts equal to sipSize

    /**
     * @return the activeShips
     */
    public static int getActiveShips() {
        return activeShips;
    }

    /**
     * @param aActiveShips the activeShips to set
     */
    public static void setActiveShips(int aActiveShips) {
        activeShips = aActiveShips;
    }

    /**
     * @return the shipID
     */
    public int getShipID() {
        return shipID;
    }

    /**
     * @param shipID the shipID to set
     */
    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    /**
     * @return the shipSize
     */
    public int getShipSize() {
        return shipSize;
    }

    /**
     * @param shipSize the shipSize to set
     */
    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    /**
     * @return the shipType
     */
    public int getShipType() {
        return shipType;
    }

    /**
     * @param shipType the shipType to set
     */
    public void setShipType(int shipType) {
        this.shipType = shipType;
    }

    /**
     * @return the shipName
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * @param shipName the shipName to set
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    /**
     * @return the shipLives
     */
    public int getShipLives() {
        return shipLives;
    }

    /**
     * @param shipLives the shipLives to set
     */
    public void setShipLives(int shipLives) {
        this.shipLives = shipLives;
    }

    
}
