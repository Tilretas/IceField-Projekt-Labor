package game;

import java.io.*;
import java.util.*;

public class Test
{
	private boolean exit;
    private boolean running;
    private boolean save = false;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private Test()
    {
    	exit = false;
    	running = false;
    	//...
    }
    
    private void run()
    {
    	while(!exit)
    	{
    		
    	}
    }
    
    private List<String> ReadLine()
    {
        String line;
        List<String> input;
        try
        {
            line = br.readLine();
            if (line != null)
            {
                input = Arrays.asList(line.split(" "));
                return input;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
