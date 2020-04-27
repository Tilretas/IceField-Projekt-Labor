package game;

import java.util.ArrayList;

public class Tile
{
	protected ArrayList<Piece> pieces;
	protected ArrayList<Tile> neighbors; //valahogy Ã¶ssze kÃ©ne kÃ¶tni a directionnal -> map?
	private boolean igloo = false;
	private boolean bear = false; //nem így kéne
	private boolean checked = false;
	private int snow;
	private int capacity;
	
	public Tile(int c, int s) 
	{
		capacity = c;
		snow = s;
		pieces = new ArrayList<Piece>();
		neighbors = new ArrayList<Tile>();
	}
  
	public ArrayList<Piece> getPieces() { return pieces; }

	public void setPieces(ArrayList<Piece> p) { pieces = p; }

	public ArrayList<Tile> getNeighbors() { return neighbors; }

	public void setNeighbors(ArrayList<Tile> n) { neighbors = n; }

	public boolean getIgloo() { return igloo; }

	public void setIgloo(boolean i) { igloo = i; }

	public int getCapacity() { return capacity; }

	public void setCapacity(int c) { capacity = c; }

	public void setSnow(int s) { snow = s; }
	
	public void addSnow() { snow++; }
	
	public void removeSnow() { snow--; }
	
	public void removePiece(Piece p) { pieces.remove(p); }
	
	public void movedOn(Piece p) {}
	
	public void buildIgloo() { igloo = true; }
	
	public int getSnow() { return snow; }
	
	public Item getItem() { return null; }
	
	public void setItem(Item i) {}
	
	public boolean getBear() { return bear; }
	
	public void setBear(boolean b) { bear = b; }
	
	public boolean getChecked() { return checked; }
	
	public void setChecked(boolean c) { checked = c; }
	
}
