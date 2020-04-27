package game;

import java.util.ArrayList;

public class Tile
{
	protected ArrayList<Piece> playersOnTile;
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
		playersOnTile = new ArrayList<Piece>();
		neighbors = new ArrayList<Tile>();
	}
  
	public ArrayList<Piece> getPlayersOnTile() {
		return playersOnTile;
	}

	public void setPlayersOnTile(ArrayList<Piece> playersOnTile) {
		this.playersOnTile = playersOnTile;
	}

	public ArrayList<Tile> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<Tile> neighbors) {
		this.neighbors = neighbors;
	}

	public boolean isIgloo() {
		return igloo;
	}

	public void setIgloo(boolean igloo) {
		this.igloo = igloo;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int c) {
		capacity = c;
	}

	public void setSnow(int s) {
		snow = s;
	}
	
	public void addSnow()
	{
		snow++;
	}
	
	public void removeSnow()
	{
		snow--;
	}
	
	public void movedOn(Piece p) {}
	
	public void buildIgloo()
	{
		igloo = true;
	}
	
	public int getSnow()
	{
		return snow;
	}
	
	public Item getItem() {
		return null;
	}
	
	public void setItem(Item i) {}
	
	public ArrayList<Piece> getPlayers(){
		return playersOnTile;
	}
	
	public boolean getBear()
	{
		return bear;
	}
	
	public void setBear(boolean b) {
		bear = b;
	}
	
	public boolean getChecked() { return checked; }
	
	public void setChecked(boolean c) { checked = c; }
	
}
