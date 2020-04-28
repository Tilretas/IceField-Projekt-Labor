package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile
{
	protected ArrayList<Piece> pieces;
	protected HashMap<Direction, Tile> neighbors;
	private Bear bear = null; //nem így kéne
	private boolean checked = false;
	private Shelter shelter = null;
	private int snow;
	private int capacity;
	
	public Tile(int c, int s) 
	{
		capacity = c;
		snow = s;
		pieces = new ArrayList<Piece>();
		neighbors = new HashMap<>();
	}
  
	public ArrayList<Piece> getPieces() { return pieces; }

	public void setPieces(ArrayList<Piece> p) { pieces = p; }

	public Tile getNeighbor(Direction d) { return neighbors.get(d);	}

	public void setNeighbor(Direction d, Tile t) { neighbors.put(d, t);	}
	
	public boolean isNeighbor(Tile t) 
	{
		boolean isneighbor = false;
		
		if(neighbors.get(Direction.UP).equals(t) || neighbors.get(Direction.RIGHT).equals(t) || neighbors.get(Direction.LEFT).equals(t) || neighbors.get(Direction.DOWN).equals(t)) 
		{
			isneighbor = true;
		}
		
		return isneighbor;
	}
	public Shelter getShelter() { return shelter; }

	public void setShelter(Shelter s) { shelter = s; }

	public int getCapacity() 
	{ 
		checked = true;
		return capacity;
	}

	public void setCapacity(int c) { capacity = c; }

	public void setSnow(int s) { snow = s; }
	
	public void addSnow() { snow++; }
	
	public void removeSnow() { snow--; }
	
	public void removePiece(Piece p) { pieces.remove(p); }
	
	public void movedOn(Piece p) {}
		
	public int getSnow() { return snow; }
	
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
	
}
