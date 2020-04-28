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

	/*
     *  Placing an eskimo/explorer with unique colour id on a given tile
     */
    private void TestAddPiece(List<String> input) {
    	try {
    		if(input.size() != 3) {							//3 paramétert adunk át, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));			//Az elsõ a tile
    		String type = input.get(2);						//A második a típusa (explorer/eskimo)
    		Colour id = Colour.valueOf(input.get(3));		//Harmadik az id-je ami szín
    		
            if (s > 24 || s < 0) {							//Ha nem a pálya része a megadott mezõ, error
                throw new Exception();
            }
            
            if(type == "Eskimo") {							
            	Eskimo eskimo = new Eskimo();				//Eskimo létrehozása
            	eskimo.setActionPoints(5);					//Akciópontjainak beállítása
            	eskimo.setColour(id);						//Beállítjuk az azonosítóját, ami a színe
            	eskimo.moved(board.getTiles().get(s));		//Odamozgatjuk lényegében a moved-al a megadott mezõre
            	board.getPieces().add(eskimo);				//Majd végül a piecek tömbjéhez adása
            }
            else if(type == "Explorer") {
            	Explorer explorer = new Explorer();			//Explorer létrehozása
            	explorer.setActionPoints(5);				//Akciópontjainak beállítása
            	explorer.setColour(id);						//Beállítjuk az azonosítóját, ami a színe
            	explorer.moved(board.getTiles().get(s));	//Odamozgatjuk lényegében a moved-al a megadott mezõre
            	board.getPieces().add(explorer);			//Majd végül a piecek tömbjéhez adása
            }
            else {
            	throw new IOException();					//Ha nem Eskimot vagy Explorert adtunk meg, error
            }
    	} catch (NumberFormatException e) {
    		System.out.println("Invalid paramters");
    	} catch (IOException e) {
    		System.out.println("Given piece type does not exist");
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Placing the bear on a given tile
     */
    private void TestAddBear(int s) {
    	try {
            if (s > 24 || s < 0) {							//Ha nem a pálya része a megadott mezõ, error
                throw new Exception();
            }
            Bear bear = new Bear();
            bear.moved(board.getTiles().get(s));			//Odamozgatjuk lényegében a moved-al a megadott mezõre
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Adding specific item to a given tile
     */
    private void TestAddItem(List<String> input) {
    	try {
    		if(input.size() != 2) {							//2 paramétert adunk át, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));			//Az elsõ a tile
    		String type = input.get(2);						//A második a lehelyezni kívánt item típusa
    		
    		if (s > 24 || s < 0) {							//Ha nem a pálya része a megadott mezõ, error
                throw new Exception();
            }
    		
    		switch(type) {									//Hozzáadjuk a megadott mezõhöz a megadott típusú itemet
	    		case "Part":
	    			board.getTiles().get(s).setItem(new Part());
	    			break;
	    		case "Food":
	    			board.getTiles().get(s).setItem(new Food());
	    			break;
	    		case "Suit":
	    			board.getTiles().get(s).setItem(new Suit());
	    			break;
	    		case "Rope":
	    			board.getTiles().get(s).setItem(new Rope());
	    			break;
	    		case "Tent":
	    			board.getTiles().get(s).setItem(new Tent());
	    			break;
	    		case "Shovel":
	    			board.getTiles().get(s).setItem(new Shovel());
	    			break;
	    		case "Wooden":
	    			board.getTiles().get(s).setItem(new Wooden());
	    			break;
	    		default:
	    			throw new IOException();
    		}
    	} catch (NumberFormatException e) {
    		System.out.println("Invalid paramters");
    	} catch (IOException e) {
    		System.out.println("Given item type does not exist");
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	} 
    }
    
    /*
     *  Adding specific item to given piece (distinction by colour)
     */
    private void TestGiveItem(List<String> input) {
    	try {
    		if(input.size() != 2) {							//2 paramétert adunk át, ha nem, error
    			throw new NumberFormatException();
    		}
    		Colour id = Colour.valueOf(input.get(3));		//Elsõ az id-je ami szín
    		String type = input.get(2);						//Második az odaadni kívánt item típusa
    		
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
       	} catch (NumberFormatException e) {
    		System.out.println("Invalid paramters");
    	} catch (IOException e) {
    		System.out.println("Given item type does not exist");
    	} catch (Exception e) {
    		System.out.println("Given piece does not exist");
    	} 
    }
    
    /*
     *  Creating an ice by replacing the old tile
     */
    private void TestCreateIce(List<String> input) {
    	try {
    		if(input.size() != 3) {								//3 paramétert adunk át, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));				//Az elsõ a tile
    		int cap = Integer.parseInt(input.get(2));			//A második a capacity
    		int snw = Integer.parseInt(input.get(3));			//A harmadik a snow
	    	if (s > 24 || s < 0) {								//Ha nem a pálya része a megadott mezõ, error
	            throw new Exception();
	        }
	    	board.getTiles().set(s, new Ice(cap, snw));			//Beállítjuk a megadott mezõt ice-ra									Ice-nál capacity???
    	} catch (Exception e) {
    		System.out.println("Given piece does not exist");
    	}
    }
    
    /*
     *  Creating an unstable ice by replacing the old tile
     */
    private void TestCreateUnstalbe(List<String> input) {
    	try {
    		if(input.size() != 3) {								//3 paramétert adunk át, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));				//Az elsõ a tile
    		int cap = Integer.parseInt(input.get(2));			//A második a capacity
    		int snw = Integer.parseInt(input.get(3));			//A harmadik a snow
	    	if (s > 24 || s < 0) {								//Ha nem a pálya része a megadott mezõ, error
	            throw new Exception();
	        }
	    	board.getTiles().set(s, new Unstable(cap, snw));	//Beállítjuk a megadott mezõt unstable-re
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Creating a hole by replacing the old tile
     */
    private void TestCreateHole(List<String> input) {
    	try {
    		if(input.size() != 3) {								//3 paramétert adunk át, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));				//Az elsõ a tile
    		int cap = Integer.parseInt(input.get(2));			//A második a capacity
    		int snw = Integer.parseInt(input.get(3));			//A harmadik a snow
	    	if (s > 24 || s < 0) {								//Ha nem a pálya része a megadott mezõ, error
	            throw new Exception();
	        }
	    	board.getTiles().set(s, new Unstable(cap, snw));	//Beállítjuk a megadott mezõt hole-ra										HOLE-nál capacity???
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
}
