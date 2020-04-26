package game;

import java.util.ArrayList;

public class Tile
{
	protected ArrayList<Piece> playersOnTile;
	private ArrayList<Tile> neighbors; //valahogy össze kéne kötni a directionnal -> map?
	private int snow;
	private boolean igloo, bear;
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
