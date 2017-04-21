

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
 * The GridPoint class defines the attributes of one cell on the
 * Battleship Grid
 * It's Co-ordinate (column,row), It's contents (part of ship or empty),
 * It's status (untouched [0], miss [1], hit [2])
 * @author kruge
 */


public class GridPoint {
    // Int gridPointCounter;
    private int[] gridPointRef = new int[2];  //col,row reference of gridPoint
    private String gridPointName;
    private String gridPointContains;
    private int gridPointStatus;

    /**
     * @return the gridPointRef
     */
    public int[] getGridPointRef() {
        return gridPointRef;
    }

    /**
     * @param col the column of the gridPoint
     * @param row the row of the gridPoint
     */
    public void setGridPointRef(int col, int row) {
        char firstCol = 'A';
        int asciiFirstCol = firstCol;
                
        this.gridPointRef[0] = col;
        this.gridPointRef[1] = row;
        this.gridPointName = String.valueOf(Character.toChars(asciiFirstCol + col -1)) + row;  //Assign column alphabet letter and number eg A1 or B3
        
    }

    /**
     * @return the gridPointName
     */
    public String getGridPointName() {
        return gridPointName;
    }

    /**
     * @param gridPointName the gridPointName to set
     */
    public void setGridPointName(String gridPointName) {
        this.gridPointName = gridPointName;
    }

    /**
     * @return the gridPointContains
     */
    public String getGridPointContains() {
        return gridPointContains;
    }

    /**
     * @param gridPointContains the gridPointContains to set
     */
    public void setGridPointContains(String gridPointContains) {
        this.gridPointContains = gridPointContains;
    }

    /**
     * @return the gridPointStatus
     */
    public int getGridPointStatus() {
        return gridPointStatus;
    }

    /**
     * @param gridPointStatus the gridPointStatus to set
     */
    public void setGridPointStatus(int gridPointStatus) {
        this.gridPointStatus = gridPointStatus;
    }
}
