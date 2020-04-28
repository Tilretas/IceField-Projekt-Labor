package game;

import java.util.ArrayList;

public abstract class Piece
{
	private ArrayList<Item> inventory = new ArrayList();
	private int bodyTemp;
	private int actionPoints;
	private boolean inWater;
	private boolean suffocate;
	private Tile onTile = null;
	private Colour colour;
	
	/**
	 * A b�but mozgat� f�ggv�ny�nk, mely le is ellen�rzi, 
	 * hogy van-e medve a kiv�lasztott mez�n
	 * 
	 * @param t a mez�, melyre a b�but mozgatni akarjuk
	 */
	public void moved(Tile t)
	{
		//TODO
		if(actionPoints == 0)
		{
			System.out.println("No more action points!");
		}
		else
		{
			if(onTile != null)
				onTile.removePiece(this);
			t.movedOn(this);			
			if(t.getBear() == true)	
				this.die();
			actionPoints--;
		}
	}
	
	/**
	 * F�ggv�ny, mely az eszk�z�k haszn�lat��rt felel�s.
	 * 
	 * @param i Az eszk�z, amit haszn�lni akarunk 
	 */
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
				if(inventory.get(j).getClass().equals(i.getClass()))		//Megn�ztem, m�k�dik a felt�tel
				{
					hasItem = true;
					i.used(this);
					break;
				}
			}
			
			if(!hasItem) 
			{
				throw new Exception("You don't have this item in your inventory!");
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	/**
	 * Az �s�s�rt felel�s f�ggv�ny
	 */
	public void dig() 
	{
		if(actionPoints == 0)
		{
			System.out.println("No more action points!");
			return;
		}
		if(this.getTile().getSnow() > 0) 
		{
			this.getTile().removeSnow();		
			actionPoints--;
		}
		else 
			System.out.println("\nThere is no more snow to dig!");
	}
	
	public void pickUp()
	{
		inventory.add(onTile.getItem());
		onTile.setItem(null);
		actionPoints--;
	}
	
	
	public ArrayList<Item> getInventory() {
		return inventory;
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
	
	public abstract void ability();
	
	public void addItem(Item i)
	{
		inventory.add(i);
	}
	
	public void removeItem(Item i)
	{
		inventory.remove(i);
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
		Game.getInstance().notifyPlayerDied(this);
	}
	
	public boolean getSuffocate() { return suffocate; }
	
	public void setSuffocate(boolean s) { suffocate = s; }
	
	public Tile getTile()
	{
		return onTile;
	}
}
