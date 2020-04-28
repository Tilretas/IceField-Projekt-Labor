package game;

import java.io.*;
import java.util.*;

public class Test
{
	private boolean exit;
    private boolean running;
    private boolean save = false;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Board board = Game.getInstance().getBoard();
    
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
    			System.out.println("What do you want to do?\n 1: AddPiece | 2: AddBear | 3: AddItem | 4: GiveItem | 5: CreateTile | 6: SnowStorm\n");
    			cmd = sc.nextInt();
    			
    			int tile;
    			String type;
    			int id;
    			
    			switch (cmd) {
    			case 1:
    				System.out.println("Onto which tile would you like to add the piece? (0 - 24)");
    				tile = sc.nextInt();
    				System.out.println("Which kind of piece would you like to add? (1: Eskimo | 2: Explorer)");
    				int p = sc.nextInt();
    				System.out.println("What colour do you want your piece to be? (1: RED | 2: YELLOW | 3: PURPLE | 4: GREEN | 5: CYAN | 6: BLUE");
    				id = sc.nextInt();
    				System.out.println("Adding new piece...");
    				TestAddPiece(tile, p, Colour.values()[id - 1]);
    				break;
    			case 2:
    				System.out.println("Onto which tile would you like to add the bear? (0 - 24)");
    				tile = sc.nextInt();
    				System.out.println("Adding bear...");
    				TestAddBear(tile);			
    				break;
    				
    			case 3:
    				System.out.println("Onto which tile would you like to add the item? (0 - 24)");
    				tile = sc.nextInt();
    				System.out.println("Which kind of item would you like to add? (Part | Food | Suit | Rope | Tent | Shovel | Wooden)");
    				type = sc.nextLine();	
    				System.out.println("Adding item...");
    				TestAddItem(tile, type);
    				break;
    				
    			case 4:
    				System.out.println("Which piece would you like to give the item to? (1: RED | 2: YELLOW | 3: PURPLE | 4: GREEN | 5: CYAN | 6: BLUE");
    				id = sc.nextInt();
    				System.out.println("Which kind of item would you like to add? (Part | Food | Suit | Rope | Tent | Shovel | Wooden)");
    				type = sc.nextLine();
    				System.out.println("Giving item...");
    				TestGiveItem(Colour.values()[id - 1], type);
    				break;
    				
    			case 5:
    				System.out.println("Which kind of tile would you like to create? (1: Ice | 2: Unstable | 3: Hole");
    				int t = sc.nextInt();
    				System.out.println("Where do you want to create your tile? (0 - 24)");
    				tile = sc.nextInt();
    				if(t == 1) TestCreateIce(tile);
    				else if(t == 2) {
    					System.out.println("How many would you like your Unstable's capacity to be? (1 - 5)");
        				int cap = sc.nextInt();
    					TestCreateUnstable(tile, cap);
    				}
    				else if(t == 3) TestCreateHole(tile);
    				else System.out.println("Incorrect tile type input");
    				break;
    			
    			case 6:
    				System.out.println("Initiating snowstorm");
    				TestSnowStorm();				
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

	/*
     *  Placing an eskimo/explorer with unique colour id on a given tile
     */
    private void TestAddPiece(int tile, int type, Colour id) {
    	try {   		
            if (tile > 24 || tile < 0) {					//Ha nem a pálya része a megadott mezõ, error
                throw new Exception();
            }
            
            if(type == 1) {							
            	Eskimo eskimo = new Eskimo();				//Eskimo létrehozása
            	eskimo.setActionPoints(5);					//Akciópontjainak beállítása
            	eskimo.setColour(id);						//Beállítjuk az azonosítóját, ami a színe
            	eskimo.moved(board.getTiles().get(tile));	//Odamozgatjuk lényegében a moved-al a megadott mezõre
            	board.getPieces().add(eskimo);				//Majd végül a piecek tömbjéhez adása
            }
            else if(type == 2) {
            	Explorer explorer = new Explorer();			//Explorer létrehozása
            	explorer.setActionPoints(5);				//Akciópontjainak beállítása
            	explorer.setColour(id);						//Beállítjuk az azonosítóját, ami a színe
            	explorer.moved(board.getTiles().get(tile));	//Odamozgatjuk lényegében a moved-al a megadott mezõre
            	board.getPieces().add(explorer);			//Majd végül a piecek tömbjéhez adása
            }
            else {
            	throw new IOException();					//Ha nem Eskimot vagy Explorert adtunk meg, error
            }
    	} catch (IOException e) {
    		System.out.println("Given piece type does not exist");
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Placing the bear on a given tile
     */
    private void TestAddBear(int tile) {
    	try {
            if (tile > 24 || tile < 0) {							//Ha nem a pálya része a megadott mezõ, error
                throw new Exception();
            }
            Bear bear = new Bear();
            bear.moved(board.getTiles().get(tile));					//Odamozgatjuk lényegében a moved-al a megadott mezõre
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Adding specific item to a given tile
     */
    private void TestAddItem(int tile, String type) {
    	try {    		
    		if (tile > 24 || tile < 0) {							//Ha nem a pálya része a megadott mezõ, error
                throw new Exception();
            }
    		
    		switch(type) {											//Hozzáadjuk a megadott mezõhöz a megadott típusú itemet
	    		case "Part":
	    			board.getTiles().get(tile).setItem(new Part());
	    			break;
	    		case "Food":
	    			board.getTiles().get(tile).setItem(new Food());
	    			break;
	    		case "Suit":
	    			board.getTiles().get(tile).setItem(new Suit());
	    			break;
	    		case "Rope":
	    			board.getTiles().get(tile).setItem(new Rope());
	    			break;
	    		case "Tent":
	    			board.getTiles().get(tile).setItem(new Tent());
	    			break;
	    		case "Shovel":
	    			board.getTiles().get(tile).setItem(new Shovel());
	    			break;
	    		case "Wooden":
	    			board.getTiles().get(tile).setItem(new Wooden());
	    			break;
	    		default:
	    			throw new IOException();
    		}
    	} catch (IOException e) {
    		System.out.println("Given item type does not exist");
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	} 
    }
    
    /*
     *  Adding specific item to given piece (distinction by colour)
     */
    private void TestGiveItem(Colour id, String type) {
    	try {
    		Item item;
    		
    		switch(type) {									//Létrehozzuk a megadott típusú itemet
	    		case "Part":
	    			item = new Part();
	    			break;
	    		case "Food":
	    			item = new Food();
	    			break;
	    		case "Suit":
	    			item = new Suit();
	    			break;
	    		case "Rope":
	    			item = new Rope();
	    			break;
	    		case "Tent":
	    			item = new Tent();
	    			break;
	    		case "Shovel":
	    			item = new Shovel();
	    			break;
	    		case "Wooden":
	    			item = new Wooden();
	    			break;
	    		default:
	    			throw new IOException();
    		}
    		
    		boolean found = false;									//temp változó annak ellenõrzésére, hogy létezik-e az adott színû piece
    		for(int i = 0; i < board.getPieces().size(); i++) {		//Keressük a megadott színû piecet
    			if(board.getPieces().get(i).getColour() == id) {
    				board.getPieces().get(i).addItem(item);			//Ha megtaláltuk nekiadjuk az itemet
    				found = true;									//És beállítjuk, hogy megtaláltuk						
    			}
    		}
    		if(!found)												//Ha nincs olyan színû bábu, exception3
    			throw new Exception();
    	} catch (IOException e) {
    		System.out.println("Given item type does not exist");
    	} catch (Exception e) {
    		System.out.println("Given piece does not exist");
    	} 
    }
    
    /*
     *  Creating an ice by replacing the old tile
     */
    private void TestCreateIce(int tile) {
    	try {
	    	if (tile > 24 || tile < 0) {							//Ha nem a pálya része a megadott mezõ, error
	            throw new Exception();
	        }
	    	board.getTiles().set(tile, new Ice(9, 0));			//Beállítjuk a megadott mezõt ice-ra									Ice-nál capacity???
    	} catch (Exception e) {
    		System.out.println("Given piece does not exist");
    	}
    }
    
    /*
     *  Creating an unstable ice by replacing the old tile
     */
    private void TestCreateUnstable(int tile, int cap) {
    	try {
	    	if (tile > 24 || tile < 0) {								//Ha nem a pálya része a megadott mezõ, error
	            throw new Exception();
	        }
	    	board.getTiles().set(tile, new Unstable(cap, 0));			//Beállítjuk a megadott mezõt unstable-re
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Creating a hole by replacing the old tile
     */
    private void TestCreateHole(int tile) {
    	try {
	    	if (tile > 24 || tile < 0) {								//Ha nem a pálya része a megadott mezõ, error
	            throw new Exception();
	        }
	    	board.getTiles().set(tile, new Unstable(0, 0));				//Beállítjuk a megadott mezõt hole-ra
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    private void TestSnowStorm()
    {
    	Game.getInstance().snowStorm();
    }
    
}
