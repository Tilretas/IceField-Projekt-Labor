package game;

import java.util.ArrayList;

public abstract class Piece
{
	/**
	 * A piece inventory-a
	 */
	private ArrayList<Item> inventory = new ArrayList();
	
	/**
	 * A piece testh�je
	 */
	private int bodyTemp;
	
	/**
	 * A piece akci�pontjai
	 */
	private int actionPoints;
	
	/**
	 * V�zben van-e a piece
	 */
	private boolean inWater;
	
	/**
	 * Fulladozik-e a piece 
	 */
	private boolean suffocate;
	
	/**
	 * A mez�, amelyiken a piece van
	 */
	private Tile onTile = null;
	
	/**
	 * A piece sz�ne
	 */
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
	public void useItem(Item i, Tile t)
	{
		
		if(actionPoints == 0)
		{
			System.out.println("No more action points!");
			return;
		}
		int itemIdx = -1;
		boolean hasItem = false;
		try 
		{
			for(int j = 0; j < inventory.size(); j++) 
			{
				if(inventory.get(j).getClass().equals(i.getClass()))
				{
					hasItem = true;
					itemIdx = j;
					break;
				}
			}
			
			if(!hasItem) 
			{
				throw new Exception("You don't have this item in your inventory!");
			}
			else
				inventory.get(itemIdx).used(this, t);
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
	
	/**
	 * A t�rgyfelv�telt megval�s�t� f�ggv�ny
	 */
	public void pickUp()
	{
		inventory.add(onTile.getItem());
		onTile.setItem(null);
		actionPoints--;
	}
	
	/**
	 * Absztrakt f�ggv�ny a k�pess�g haszn�lat�ra.
	 * Fel�ldefini�lja mind a kutat�, mind az eszkim�
	 */
	public abstract void ability(Tile t);
	
	/**
	 * Hozz�adja a param�terk�nt kapott t�rgyat a piece inventory-hoz
	 * 
	 * @param i Az a t�rgy, amit hozz�adunk az inventory-hoz
	 */
	public void addItem(Item i) { inventory.add(i); }
	
	/**
	 * Kiveszi a param�terk�nt kapott t�rgyat a piece inventory-b�l
	 * 
	 * @param i Az a t�rgy, amit kivesz�nk az inventory-b�l
	 */
	public void removeItem(Item i) { inventory.remove(i); }
	
	/**
	 * Eggyel n�veli a piece testh�j�t
	 */
	public void incBodyTemp() { bodyTemp++; }
	
	/**
	 * Eggyel cs�kkenti a piece testh�j�t
	 */
	public void decBodyTemp() { bodyTemp--; }
	
	/**
	 * �rtes�ti a j�t�kot, hogy az egyik j�t�kos meghalt
	 */
	public void die() { Game.getInstance().notifyPlayerDied(this); }
	
	//getter - setterek -------------------------
	
	public ArrayList<Item> getInventory() { return inventory; }
	
	public int getBodyTemp() { return bodyTemp; }
	
	public void setBodyTemp(int b) { bodyTemp = b; }
	
	public int getActionPoints() { return actionPoints; }
	
	public void setActionPoints(int a) { actionPoints = a; }
	
	public void setTile(Tile t) { onTile = t; }
	
	public Colour getColour() { return colour; }
	
	public void setColour(Colour c) { colour = c; }
	
	public boolean getInWater() { return inWater; }	
	
	public void setInWater(boolean value) { inWater = value; }

	public boolean getSuffocate() { return suffocate; }
	
	public void setSuffocate(boolean s) { suffocate = s; }
	
	public Tile getTile() { return onTile; }
	
	public String getType() { return ""; }
	
	//getter - setterek ---------v�ge------------

}

