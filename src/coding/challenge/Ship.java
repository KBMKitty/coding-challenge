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
    boolean lost;
    
    public Ship(String[] coordinates, String direction)
    {
        xcoordinate = Integer.parseInt(coordinates[0]);
        ycoordinate = Integer.parseInt(coordinates[1]);
        this.direction = direction;
        lost = false;
    }
    
    public int getXCoordinate()
    {
        return xcoordinate;
    }
    
    public int getYCoordinate()
    {
        return ycoordinate;
    }
    
    public String getDirection()
    {
        return direction;
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
    
    public String moveForward(int gridXAxis, int gridYAxis, List<String[]> lostPositions)
    {
        int originalXCoordinate = xcoordinate;
        int originalYCoordinate = ycoordinate;
        boolean stopped = false;
        String returnValue = "";
        String [] position = {direction, String.valueOf(ycoordinate), 
                String.valueOf(xcoordinate)};
        //check if going off board
        for (int i = 0; i < lostPositions.size(); i++) {
            if(lostPositions.get(i)[0].equals(position[0]) &&
                    lostPositions.get(i)[1].equals(position[1]) &&
                    lostPositions.get(i)[2].equals(position[2]))
            {
                returnValue = "Safe";
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
                lost = true;
                xcoordinate = originalXCoordinate;
                ycoordinate = originalYCoordinate;
            }
            else
            {
                returnValue = "Safe";
            }
        }
        return returnValue;   
    }
    
    public String getFinalPosition()
    {
        if(lost)
        {
            return (Integer.toString(xcoordinate) + " " + Integer.toString(ycoordinate) + " " + direction+ " LOST");
        }
        else
        {
            return (Integer.toString(xcoordinate) + " " + Integer.toString(ycoordinate) + " " + direction);
        }
    }
    
    
}
