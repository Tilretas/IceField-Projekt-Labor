package game;

import java.util.ArrayList;

public class Tile
{
	protected ArrayList<Piece> playersOnTile;
	private ArrayList<Tile> neighbors; //valahogy össze kéne kötni a directionnal -> map?
	private int snow;
  
	private boolean igloo;
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

	public int getCapactiy() {
		return capactiy;
	}

	public void setCapactiy(int capactiy) {
		this.capactiy = capactiy;
	}

	public void setSnow(int snow) {
		this.snow = snow;
	}

	private boolean bear;
  
	private int capactiy;
	
	public void addSnow()
	{
		snow++;
	}
	
	public void removeSnow()
	{
		snow--;
	}
	
	public void movedOn(Piece p)
	{
		playersOnTile.add(p);
	}
	
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
	
	public ArrayList<Piece> getPlayers(){
		return playersOnTile;
	}
	
	public int getCapacity()
	{
		return capactiy;
	}
	
	public boolean getBear()
	{
		return bear;
	}
	
}
