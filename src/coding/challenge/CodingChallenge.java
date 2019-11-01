
package coding.challenge;

import java.io.IOException;
import java.util.List;

public class CodingChallenge {

    public static void main(String[] args) throws IOException {
        ReadFile file = new ReadFile();
        System.out.println(file.outputFile());
        List<String[]> input = file.outputFile();
        Grid grid = new Grid(input.get(0));
        for (int i = 1; i < input.size(); i=i+2) {
            String newPosition = grid.calculatePosition(input.get(i), input.get(i+1));
        }
        
    }
    
}
