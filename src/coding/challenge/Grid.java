/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coding.challenge;

import java.util.List;

/**
 *
 * @author kitty
 */
public class Grid {
    
    int xaxis;
    int yaxis;
    
    public Grid(String[] size)
    {
        xaxis = Integer.parseInt(size[0]);
        yaxis = Integer.parseInt(size[1]);
    }
    public String calculatePosition(String[] coordinates, String[] instructions)
    {
        String[] firstCoordinates = {coordinates[0], coordinates[1]};
        Ship ship = new Ship(firstCoordinates, coordinates[2]);
        String output = "";
        return output;
    }
}
