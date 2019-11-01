/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coding.challenge;

/**
 *
 * @author kitty
 */
public class Ship {
    int xcoordinate;
    int ycoordinate;
    String direction;
    
    public Ship(String[] coordinates, String direction)
    {
        xcoordinate = Integer.parseInt(coordinates[0]);
        ycoordinate = Integer.parseInt(coordinates[1]);
        this.direction = direction;
    }
    
}
