
package coding.challenge;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    
    int xaxis;
    int yaxis;
    List<String[]> lostPositions = new ArrayList<>();
    
    public Grid(String[] size)
    {
        xaxis = Integer.parseInt(size[0]);
        yaxis = Integer.parseInt(size[1]);
    }
    public String calculatePosition(String[] coordinates, String[] instructions)
    {
        String[] firstCoordinates = {coordinates[0], coordinates[1]};
        Ship ship = new Ship(firstCoordinates, coordinates[2]);
        boolean stopped = false;
        boolean lost = false;
        int count = 0;
        while(!lost && !stopped && count < instructions[0].length()){
            switch(String.valueOf(instructions[0].charAt(count)))
            {
                case "R":
                    ship.updateDirection("R");
                    break;
                case "L":
                    ship.updateDirection("L");
                    break;
                case "F":
                    String status = ship.moveForward(xaxis, yaxis, lostPositions);
                    if(status == "Lost")
                    {
                        lost = true;
                    }
                    else if (status == "Stopped")
                    {
                        stopped = true;
                    }
                    break;
            }
            count++;
        }
        if(lost)
        {
            String [] position = {ship.getDirection(), 
                String.valueOf(ship.getXCoordinate()), 
                String.valueOf(ship.getYCoordinate())};
            lostPositions.add(position);
        }
        return ship.getFinalPosition();
    }
}
