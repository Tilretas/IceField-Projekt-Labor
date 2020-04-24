package game;

import java.util.ArrayList;

public abstract class Piece
{
	private ArrayList<Item> inventory;
	private int bodyTemp;
	private int actionPoints;
	private boolean inWater;
	private Tile onTile;
	private Colour colour;
	
	public void moved(Tile t)
	{
	}
	
	public abstract void ability(Tile t);
	
	public void addItem(Item i)
	{
	}
	
	public void removeItem(Item i)
	{
	}
	
	public void useItem(Item i)
	{
	}
	
	public void incBodyTemp()
	{
	}
	
	public void decBodyTemp()
	{
	}
	
	public void setInWater(boolean value)
	{
	}
	
	public void die()
	{	
	}
	
	public Tile getTile()
	{
		return onTile;
	}
}
