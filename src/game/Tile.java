package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile
{
	/**
	 * A mezőn lévő játékosokat tárolja
	 */
	protected ArrayList<Piece> pieces;	
	/**
	 * A mezővel szomszédos mezők
	 */
	protected HashMap<Direction, Tile> neighbors;
	/**
	 * Medve a mezőn
	 */
	private Bear bear = null;
	/**
	 * Volt-e már ellenőrizve a mező kapacitása
	 */
	private boolean checked = false;
	/**
	 * Menedék a mezőn
	 */
	private Shelter shelter = null;
	/**
	 * Hómennyiség a mezőn
	 */
	private int snow;
	/**
	 * A mező kapacitása
	 */
	private int capacity;
	
	/**
	 * A Tile konstruktora. Beállitja a mezõ kapacitását valamint
	 * a rajta található hómennyiséget, és inicializálja a bábukat
	 * található listát, valamint a szomszédokat tartalmazó HashMap-ot
	 * 	 
	 * @param c	Erre fogjuk beállitani a mezõ kapacitását
	 * @param s	Erre fogjuk beállitani a mezõ hómennyiségét
	 */
	public Tile(int c, int s) 
	{
		capacity = c;
		snow = s;
		pieces = new ArrayList<Piece>();
		neighbors = new HashMap<>();
	}
	
	/**
	 * Eggyel növeli a hó mennyiségét 
	 */
	public void addSnow() { snow++; }
	
	/**
	 * Eggyel csökkenti a hó mennyiségét
	 */
	public void removeSnow() { snow--; }
  
	
	
	
	/**
	 * Ellenõrzi, hogy a paraméternek kapott mezõ ennek
	 * a mezõnek a szomszédja-e (felette, alatta, jobbra
	 * vagy balra található tõle)
	 * 
	 * @param t A mezõ, melyrõl meg akarjuk határozni, hogy szomszédos-e
	 * @return 	Boolean-t ad vissza (true ha szomszédos, false ha nem)
	 */
	public boolean isNeighbor(Tile t) 
	{
		boolean isneighbor = false;
		
		for(int i = 0; i < 4; i++)
			if(neighbors.get(Direction.values()[i]) != null)
				if(neighbors.get(Direction.values()[i]).equals(t))
					isneighbor = true;

		return isneighbor;
	}
	
	/**
	 * A paraméterként kapott piece-t eltávolítja a mezőn lévő piece-ek közül
	 * 
	 * @param p Az eltávolítandó piece
	 */
	public void removePiece(Piece p) { pieces.remove(p); }
	
	/**
	 * Felüldefiniálandó függvény, mely akkor 
	 * hivódik meg, ha rálépnek a mezőre
	 * 
	 * @param p A mezőre lépő bábu
	 */
	public void movedOn(Piece p) {}
		
	//getter - setterek -------------------------
	
	public Shelter getShelter() { return shelter; }

	public void setShelter(Shelter s) { shelter = s; }

	public int getCapacity() { return capacity;	}

	public void setCapacity(int c) { capacity = c; }
	
	public int getSnow() { return snow; }
	
	public void setSnow(int s) { snow = s; }
	
	public Item getItem() { return null; }
	
	public void setItem(Item i) {}
	
	public boolean getBear()
	{
		if(bear == null)
			return false;
		else return true;
	}
	
	public void setBear(Bear b) { bear = b; }
	
	public boolean getChecked() { return checked; }
	
	public void setChecked(boolean c) { checked = c; }
	
	public ArrayList<Piece> getPieces() { return pieces; }

	public void setPieces(ArrayList<Piece> p) { pieces = p; }

	public Tile getNeighbor(Direction d) { return neighbors.get(d);	}

	public void setNeighbor(Direction d, Tile t) { neighbors.put(d, t);	}
	
	public int getType() { return 0; }
	
	//getter - setterek ---------vége------------
}
