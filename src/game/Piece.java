package game;

import java.util.ArrayList;

public abstract class Piece
{
	private ArrayList<Item> inventory = new ArrayList();
	private int bodyTemp;
	private int actionPoints;
	private boolean inWater;
	private Tile onTile = null;
	private Colour colour;
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public int getBodyTemp() {
		return bodyTemp;
	}

	public void setBodyTemp(int bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	public int getActionPoints() {
		return actionPoints;
	}

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	public void setTile(Tile t) { onTile = t; }

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public boolean getInWater() {
		return inWater;
	}	
	
	public void moved(Tile t)
	{
		//TODO
		if(actionPoints == 0)
		{
			System.out.println("No more action points!");
		}
		else
		{
			if(t.getBear() == true)	
			{
				this.die();
				//game over, de annak az implementációja nem itt van I guess
			}
			if(onTile != null)
				onTile.removePiece(this);
			t.movedOn(this);			
		}
	}
	
	public abstract void ability();
	
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
		
		if(actionPoints == 0)
		{
			System.out.println("No more action points!");
			return;
		}
		
		boolean hasItem = false;
		try 
		{
			for(int j = 0; j < inventory.size(); j++) 
			{
				if(inventory.get(j).getClass().equals(i.getClass()))		//Megnéztem, mûködik a feltétel
				{
					hasItem = true;
					i.used(this);
					break;
				}
			}
			
			if(!hasItem) 
			{
				throw new Exception("Nincs ilyen tárgyad!");
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public void dig() 
	{
		if(actionPoints == 0)
		{
			System.out.println("No more action points!");
			return;
		}
		
		this.getTile().removeSnow();		
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
