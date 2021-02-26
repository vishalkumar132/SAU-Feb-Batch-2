import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Countofwords {
	
	public void wcmethod() throws IOException {
		try {
			 String line;  
		        int count = 0;  
		        FileReader file = new FileReader("./Book.txt");  
		        BufferedReader br = new BufferedReader(file);  
		        while((line = br.readLine()) != null)
		        {  
		            
		            String words[] = line.split(" ");  
		            
		            count = count + words.length;  
		        }  
		          
		        System.out.println("Total number of words are " + count);  
		        br.close(); 
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		}

}