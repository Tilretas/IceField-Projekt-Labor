package game;

import java.util.ArrayList;

public abstract class Piece
{
	private ArrayList<Item> inventory = new ArrayList();
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
		inventory.add(i);
	}
	
	public void removeItem(Item i)
	{
		inventory.remove(i);
	}
	
	public void useItem(Item i)
	{
		i.used(this);
	}
	
	public void incBodyTemp()
	{
		bodyTemp++;
	}
	
	public void decBodyTemp()
	{
		bodyTemp--;
	}
	
	public void setInWater(boolean value)
	{
		inWater = value;
	}
	
	public void die()
	{	
	}
	
	public Tile getTile()
	{
		return onTile;
	}
}
