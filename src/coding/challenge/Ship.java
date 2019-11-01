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
    String[] directions = {"N", "E", "S", "W"};
    
    public Ship(String[] coordinates, String direction)
    {
        xcoordinate = Integer.parseInt(coordinates[0]);
        ycoordinate = Integer.parseInt(coordinates[1]);
        this.direction = direction;
    }
    
    public void updateDirection(String instruction)
    {
        for (int i = 0; i < 4; i++) {
            if(directions[i]==direction)
            {
                if(instruction == "L")
                {
                    if(i==0)
                    {
                        direction = directions[3];
                    }
                    else
                    {
                        direction = directions[i-1];
                    }
                }
                else
                {
                    if(i==3)
                    {
                        direction = directions[0];
                    }
                    else
                    {
                        direction = directions[i+1];
                    }
                }
            }
        }
        
    }
    
}
