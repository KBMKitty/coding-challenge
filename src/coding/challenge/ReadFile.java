package coding.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadFile {
    public ReadFile() {
    }
    public String outputFile () throws FileNotFoundException, IOException
    {
        String output = "";
        URL path = ReadFile.class.getResource("input.txt");
        File f = new File(path.getFile());
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String st; 
        while ((st = reader.readLine()) != null) 
            output = output+"\\"+st; 
        return output;
    }
    
}