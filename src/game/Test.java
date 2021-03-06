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
    
    /**
     *  Ez a függvény kommunikál a felhasználóval,
     *  Itt lehet kiválasztani melyik tesztesetet szeretnénk futtatni.
     */
    public boolean run()
    {
    	while(!exit)
    	{
    		Scanner sc = new Scanner(System.in);
    		int cmd;
    		boolean wrong = true;
    		
    		while(wrong) {
    			wrong = false;
    			System.out.println("Test mode: ON");
    			System.out.println("What do you want to do?\n 1: AddPiece | 2: AddBear | 3: AddItem | 4: GiveItem | 5: CreateTile | 6: SnowStorm | 0: Test OFF\n");
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
    				return true;
    				
    			case -1:
    				exit = true;
    				break;
    				
    			default:
    				wrong = true;
    				System.out.println("Incorrect input!");
    				break;
    			}
    			if (!Game.getInstance().getTestStart())
    	    		exit = true;
    		}
    	}
    	return false;
    }

	/**
	 *  Teszteset
     *  Egy megadott egyedi színű és típusú (eszkimó/sarkkutató) bábut helyez a játéktáblára.
     *  @param tile A mező ahova helyezni szeretnénk
     *  @param type Típusa, ami lehet eszkimó vagy sarkkutató
     *  @param id A bábu színe
     */
    private void TestAddPiece(int tile, int type, Colour id) {
    	try {   		
            if (tile > 24 || tile < 0) {					//Ha nem a pálya része a megadott mező, error
                throw new Exception();
            }
            
            if(type == 1) {							
            	Eskimo eskimo = new Eskimo();				//Eskimo létrehozása
            	eskimo.setActionPoints(5);					//Akciópontjainak beállítása
            	eskimo.setColour(id);						//Beállítjuk az azonosítóját, ami a színe
            	eskimo.moved(board.getTiles().get(tile));	//Odamozgatjuk lényegében a moved-al a megadott mezőre
            	board.getPieces().add(eskimo);				//Majd végül a piecek tömbjéhez adása
            }
            else if(type == 2) {
            	Explorer explorer = new Explorer();			//Explorer létrehozása
            	explorer.setActionPoints(5);				//Akciópontjainak beállítása
            	explorer.setColour(id);						//Beállítjuk az azonosítóját, ami a színe
            	explorer.moved(board.getTiles().get(tile));	//Odamozgatjuk lényegében a moved-al a megadott mezőre
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
    
    /**
	 *  Teszteset
     *  Lehelyezzük a medvét a megadott mezőre
     *  @param tile A mező ahova helyezni szeretnénk
     */
    private void TestAddBear(int tile) {
    	try {
            if (tile > 24 || tile < 0) {							//Ha nem a pálya része a megadott mező, error
                throw new Exception();
            }
            Bear bear = new Bear();
            bear.moved(board.getTiles().get(tile));					//Odamozgatjuk lényegében a moved-al a megadott mezőre
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /**
	 *  Teszteset
     *  Egy választható fajtájú tárgyat helyez a megadott mezőbe.
     *  @param tile A mező amibe helyezni szeretnénk
     *  @param type A tárgy típusa
     */
    private void TestAddItem(int tile, String type) {
    	try {    		
    		if (tile > 24 || tile < 0) {							//Ha nem a pálya része a megadott mező, error
                throw new Exception();
            }
    		
    		switch(type) {											//Hozzáadjuk a megadott mezőhöz a megadott típusú itemet
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
    
    /**
	 *  Teszteset
     *  Egy választható fajtájú tárgyat ad a szín szerint választott bábunak
     *  @param id A bábu színe aminek adni szeretnénk
     *  @param type A tárgy típusa
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
    		
    		boolean found = false;									//temp változó annak ellenőrzésére, hogy létezik-e az adott színű piece
    		for(int i = 0; i < board.getPieces().size(); i++) {		//Keressük a megadott színű piecet
    			if(board.getPieces().get(i).getColour() == id) {
    				board.getPieces().get(i).addItem(item);			//Ha megtaláltuk nekiadjuk az itemet
    				found = true;									//És beállítjuk, hogy megtaláltuk						
    			}
    		}
    		if(!found)												//Ha nincs olyan színű bábu, exception3
    			throw new Exception();
    	} catch (IOException e) {
    		System.out.println("Given item type does not exist");
    	} catch (Exception e) {
    		System.out.println("Given piece does not exist");
    	} 
    }
    
    /**
	 *  Teszteset
     *  Létrehoz egy jégtáblát a megadott mező helyén
     *  @param tile A mező aminek fajtáját ki szeretnénk cserélni
     */
    private void TestCreateIce(int tile) {
    	try {
	    	if (tile > 24 || tile < 0) {							//Ha nem a pálya része a megadott mező, error
	            throw new Exception();
	        }
	    	board.getTiles().set(tile, new Ice(9, 0));			//Beállítjuk a megadott mezőt ice-ra									Ice-nál capacity???
    	} catch (Exception e) {
    		System.out.println("Given piece does not exist");
    	}
    }
    
    /**
	 *  Teszteset
     *  Létrehoz egy instabil jégtáblát a megadott mező helyén
     *  @param tile A mező aminek fajtáját ki szeretnénk cserélni
     */
    private void TestCreateUnstable(int tile, int cap) {
    	try {
	    	if (tile > 24 || tile < 0) {								//Ha nem a pálya része a megadott mező, error
	            throw new Exception();
	        }
	    	board.getTiles().set(tile, new Unstable(cap, 0));			//Beállítjuk a megadott mezőt unstable-re
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /**
	 *  Teszteset
     *  Létrehoz egy lyukat a megadott mező helyén
     *  @param tile A mező aminek fajtáját ki szeretnénk cserélni
     */
    private void TestCreateHole(int tile) {
    	try {
	    	if (tile > 24 || tile < 0) {								//Ha nem a pálya része a megadott mező, error
	            throw new Exception();
	        }
	    	board.getTiles().set(tile, new Unstable(0, 0));				//Beállítjuk a megadott mezőt hole-ra
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /**
	 *  Teszteset
     *  Hóvihar
     */
    private void TestSnowStorm()
    {
    	Game.getInstance().snowStorm();
    }
    
}
