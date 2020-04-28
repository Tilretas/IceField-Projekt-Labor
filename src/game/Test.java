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
    				//move();	//nem a case ben val�s�tom meg a tov�bbi dolgokat, hanem k�l�n f�ggv�nyekben		
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
    		if(input.size() != 3) {							//3 param�tert adunk �t, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));			//Az els� a tile
    		String type = input.get(2);						//A m�sodik a t�pusa (explorer/eskimo)
    		Colour id = Colour.valueOf(input.get(3));		//Harmadik az id-je ami sz�n
    		
            if (s > 24 || s < 0) {							//Ha nem a p�lya r�sze a megadott mez�, error
                throw new Exception();
            }
            
            if(type == "Eskimo") {							
            	Eskimo eskimo = new Eskimo();				//Eskimo l�trehoz�sa
            	eskimo.setActionPoints(5);					//Akci�pontjainak be�ll�t�sa
            	eskimo.setColour(id);						//Be�ll�tjuk az azonos�t�j�t, ami a sz�ne
            	eskimo.moved(board.getTiles().get(s));		//Odamozgatjuk l�nyeg�ben a moved-al a megadott mez�re
            	board.getPieces().add(eskimo);				//Majd v�g�l a piecek t�mbj�hez ad�sa
            }
            else if(type == "Explorer") {
            	Explorer explorer = new Explorer();			//Explorer l�trehoz�sa
            	explorer.setActionPoints(5);				//Akci�pontjainak be�ll�t�sa
            	explorer.setColour(id);						//Be�ll�tjuk az azonos�t�j�t, ami a sz�ne
            	explorer.moved(board.getTiles().get(s));	//Odamozgatjuk l�nyeg�ben a moved-al a megadott mez�re
            	board.getPieces().add(explorer);			//Majd v�g�l a piecek t�mbj�hez ad�sa
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
            if (s > 24 || s < 0) {							//Ha nem a p�lya r�sze a megadott mez�, error
                throw new Exception();
            }
            Bear bear = new Bear();
            bear.moved(board.getTiles().get(s));			//Odamozgatjuk l�nyeg�ben a moved-al a megadott mez�re
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Adding specific item to a given tile
     */
    private void TestAddItem(List<String> input) {
    	try {
    		if(input.size() != 2) {							//2 param�tert adunk �t, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));			//Az els� a tile
    		String type = input.get(2);						//A m�sodik a lehelyezni k�v�nt item t�pusa
    		
    		if (s > 24 || s < 0) {							//Ha nem a p�lya r�sze a megadott mez�, error
                throw new Exception();
            }
    		
    		switch(type) {									//Hozz�adjuk a megadott mez�h�z a megadott t�pus� itemet
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
    		if(input.size() != 2) {							//2 param�tert adunk �t, ha nem, error
    			throw new NumberFormatException();
    		}
    		Colour id = Colour.valueOf(input.get(3));		//Els� az id-je ami sz�n
    		String type = input.get(2);						//M�sodik az odaadni k�v�nt item t�pusa
    		
    		Item item;
    		
    		switch(type) {									//L�trehozzuk a megadott t�pus� itemet
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
    		
    		boolean found = false;									//temp v�ltoz� annak ellen�rz�s�re, hogy l�tezik-e az adott sz�n� piece
    		for(int i = 0; i < board.getPieces().size(); i++) {		//Keress�k a megadott sz�n� piecet
    			if(board.getPieces().get(i).getColour() == id) {
    				board.getPieces().get(i).addItem(item);			//Ha megtal�ltuk nekiadjuk az itemet
    				found = true;									//�s be�ll�tjuk, hogy megtal�ltuk						
    			}
    		}
    		if(!found)												//Ha nincs olyan sz�n� b�bu, exception3
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
    		if(input.size() != 3) {								//3 param�tert adunk �t, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));				//Az els� a tile
    		int cap = Integer.parseInt(input.get(2));			//A m�sodik a capacity
    		int snw = Integer.parseInt(input.get(3));			//A harmadik a snow
	    	if (s > 24 || s < 0) {								//Ha nem a p�lya r�sze a megadott mez�, error
	            throw new Exception();
	        }
	    	board.getTiles().set(s, new Ice(cap, snw));			//Be�ll�tjuk a megadott mez�t ice-ra									Ice-n�l capacity???
    	} catch (Exception e) {
    		System.out.println("Given piece does not exist");
    	}
    }
    
    /*
     *  Creating an unstable ice by replacing the old tile
     */
    private void TestCreateUnstalbe(List<String> input) {
    	try {
    		if(input.size() != 3) {								//3 param�tert adunk �t, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));				//Az els� a tile
    		int cap = Integer.parseInt(input.get(2));			//A m�sodik a capacity
    		int snw = Integer.parseInt(input.get(3));			//A harmadik a snow
	    	if (s > 24 || s < 0) {								//Ha nem a p�lya r�sze a megadott mez�, error
	            throw new Exception();
	        }
	    	board.getTiles().set(s, new Unstable(cap, snw));	//Be�ll�tjuk a megadott mez�t unstable-re
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
    
    /*
     *  Creating a hole by replacing the old tile
     */
    private void TestCreateHole(List<String> input) {
    	try {
    		if(input.size() != 3) {								//3 param�tert adunk �t, ha nem, error
    			throw new NumberFormatException();
    		}
    		int s = Integer.parseInt(input.get(1));				//Az els� a tile
    		int cap = Integer.parseInt(input.get(2));			//A m�sodik a capacity
    		int snw = Integer.parseInt(input.get(3));			//A harmadik a snow
	    	if (s > 24 || s < 0) {								//Ha nem a p�lya r�sze a megadott mez�, error
	            throw new Exception();
	        }
	    	board.getTiles().set(s, new Unstable(cap, snw));	//Be�ll�tjuk a megadott mez�t hole-ra										HOLE-n�l capacity???
    	} catch (Exception e) {
    		System.out.println("Given tile is not part of the board");
    	}
    }
}
