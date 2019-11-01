/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coding.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kitty
 */
public class Ship {
    int xcoordinate;
    int ycoordinate;
    String direction;
    String[] directions = {"N", "E", "S", "W"};
    List<String[]> lostPositions = new ArrayList<>();
    String[] originalCoordinates;
    String originalDirection;
    boolean lost;
    
    public Ship(String[] coordinates, String direction)
    {
        xcoordinate = Integer.parseInt(coordinates[0]);
        ycoordinate = Integer.parseInt(coordinates[1]);
        this.direction = direction;
        originalCoordinates = coordinates;
        originalDirection = direction;
        lost = false;
    }
    
    public void updateDirection(String instruction)
    {
        
        int count = 0;
        boolean found = false;
        while(count<4 && found != true)
        {
            if(directions[count].equals(direction))
            {
                found = true;
                if(instruction == "L")
                {
                    if(count==0)
                    {
                        direction = directions[3];
                    }
                    else
                    {
                        direction = directions[count-1];
                    }
                }
                else
                {
                    if(count==3)
                    {
                        direction = directions[0];
                    }
                    else
                    {
                        direction = directions[count+1];
                    }
                }
            }
            count++;
        }
        
    }
    
    public String moveForward(int gridXAxis, int gridYAxis)
    {
        boolean stopped = false;
        String returnValue = "";
        //check if going off board
        for (int i = 0; i < lostPositions.size(); i++) {
            String [] position = {direction, String.valueOf(ycoordinate), 
                String.valueOf(xcoordinate)};
            if(lostPositions.get(i) == position) 
            {
                returnValue = "Stopped";
                stopped = true;
            }
        }
        if(!stopped)
        {
            switch(direction){      
                case "N":
                    ycoordinate++;
                    break;
                case "E":
                    xcoordinate++;
                    break;
                case "S":
                    ycoordinate--;
                    break;
                case "W":
                    xcoordinate--;
                    break;
            }
            if(xcoordinate < 0 || xcoordinate > gridXAxis || 
                    ycoordinate < 0 || ycoordinate > gridYAxis)
            {
                returnValue = "Lost";
            }
            else
            {
                returnValue = "Safe";
            }
            
        }
        
        return returnValue;   
    }
    
    
}
