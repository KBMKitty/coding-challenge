
package coding.challenge;

import java.io.IOException;
import java.util.List;

public class CodingChallenge {

    public static void main(String[] args) throws IOException {
        ReadFile file = new ReadFile();
        //System.out.println(file.outputFile());
        List<String[]> input = file.outputFile();
        Grid grid = new Grid(input.get(0));
        
        int count = 1;
        while (count<input.size()-1){
            if(input.get(count)[0].isEmpty())
            {
                count++;
            }
            else
            {
                String status = grid.calculatePosition(input.get(count), 
                        input.get(count+1));
                count=count+2;
            }
            
        }
        
    }
    
}
