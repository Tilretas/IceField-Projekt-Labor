package game;

import java.io.*;
import java.util.*;

public class Test
{
	private boolean exit;
    private boolean running;
    private boolean save = false;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public Test()
    {
    	exit = false;
    	running = false;
    	//...
    }
    
    public void run()
    {
    	while(!exit)
    	{
    		Scanner sc = new Scanner(System.in);
    		int cmd;
    		boolean wrong = true;
    		
    		while(wrong) {
    			wrong = false;
    			System.out.println("What do you want to do?\n 1: Move | 2: Dig | 3: Ability | 4: Use Item | 5: Pick up Item\n");
    			cmd = sc.nextInt();
    			
    			switch (cmd) {
    			case 1:
    				System.out.println("Moving...");
    				//move();	//nem a case ben valósítom meg a további dolgokat, hanem külön függvényekben		
    				break;

    			case 2:
    				System.out.println("Digging...");
    				//dig();				
    				break;
    				
    			case 3:
    				System.out.println("Abiliting...");
    				//useAbility();				
    				break;
    				
    			case 4:
    				System.out.println("Iteming...");
    				//useItem();				
    				break;
    				
    			case 5:
    				System.out.println("Pick upping...");
    				//pickUpItem();				
    				break;
    				
    			case 0:
    				exit = true;
    				break;
    				
    			default:
    				wrong = true;
    				System.out.println("Incorrect input!");
    				break;
    			}
    		}
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
