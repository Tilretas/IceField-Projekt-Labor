package game;

import java.util.ArrayList;

public class Tile
{
	protected ArrayList<Piece> playersOnTile;
	private ArrayList<Tile> neighbors; //valahogy �ssze k�ne k�tni a directionnal -> map?
	private int snow;
	private boolean igloo;
	private int capactiy;
	
	public void addSnow()
	{
		snow++;
	}
	
	public void removeSnow()
	{
		snow--;
	}
	
	public void movedOn(Player p)
	{
		playersOnTile.add(p.getPiece());
	}
	
	public void buildIgloo()
	{
		igloo = true;
	}
	
	public int getSnow()
	{
		return snow;
	}
	
	public int getCapacity()
	{
		return capactiy;
	}
	
}
