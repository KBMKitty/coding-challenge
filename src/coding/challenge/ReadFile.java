package coding.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public ReadFile() {
    }
    public List<String[]> outputFile () throws FileNotFoundException, IOException
    {
        List<String[]> output = new ArrayList<>();
        URL path = ReadFile.class.getResource("input.txt");
        File f = new File(path.getFile());
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String st; 
        while ((st = reader.readLine()) != null) 
        {
            output.add(st.split(" "));
        }
        return output;
    }
    
}