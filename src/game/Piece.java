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
		try 
		{
			for(int j = 0; j < inventory.size(); j++) 
			{
				if(inventory.get(j).getClass().getClass().equals(i.getClass()))		//Ebben egy�ltal�n nem vagyok biztos hogy ez �gy j�, de nem tudom, hogy instanceof n�lk�l hogy k�ne
				{
					i.used(this);
				}
				else 
				{
					throw new Exception("Nincs ilyen t�rgyad!");
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public void dig() 
	{
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
