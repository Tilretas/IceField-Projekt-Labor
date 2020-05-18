package game;

import java.util.ArrayList;

public abstract class Piece
{
	/**
	 * A piece inventory-a
	 */
	private ArrayList<Item> inventory = new ArrayList();
	
	/**
	 * A piece testhõje
	 */
	private int bodyTemp;
	
	/**
	 * A piece akciópontjai
	 */
	private int actionPoints;
	
	/**
	 * Vízben van-e a piece
	 */
	private boolean inWater;
	
	/**
	 * Fulladozik-e a piece 
	 */
	private boolean suffocate;
	
	/**
	 * A mezõ, amelyiken a piece van
	 */
	private Tile onTile = null;
	
	/**
	 * A piece színe
	 */
	private Colour colour;
	
	/**
	 * A bábut mozgató függvényünk, mely le is ellenõrzi, 
	 * hogy van-e medve a kiválasztott mezõn
	 * 
	 * @param t a mezõ, melyre a bábut mozgatni akarjuk
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
	 * Függvény, mely az eszközök használatáért felelõs.
	 * 
	 * @param i Az eszköz, amit használni akarunk 
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
	 * Az ásásért felelõs függvény
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
	 * A tárgyfelvételt megvalósító függvény
	 */
	public void pickUp()
	{
		inventory.add(onTile.getItem());
		onTile.setItem(null);
		actionPoints--;
	}
	
	/**
	 * Absztrakt függvény a képesség használatára.
	 * Felüldefiniálja mind a kutató, mind az eszkimó
	 */
	public abstract void ability(Tile t);
	
	/**
	 * Hozzáadja a paraméterként kapott tárgyat a piece inventory-hoz
	 * 
	 * @param i Az a tárgy, amit hozzáadunk az inventory-hoz
	 */
	public void addItem(Item i) { inventory.add(i); }
	
	/**
	 * Kiveszi a paraméterként kapott tárgyat a piece inventory-ból
	 * 
	 * @param i Az a tárgy, amit kiveszünk az inventory-ból
	 */
	public void removeItem(Item i) { inventory.remove(i); }
	
	/**
	 * Eggyel növeli a piece testhõjét
	 */
	public void incBodyTemp() { bodyTemp++; }
	
	/**
	 * Eggyel csökkenti a piece testhõjét
	 */
	public void decBodyTemp() { bodyTemp--; }
	
	/**
	 * Értesíti a játékot, hogy az egyik játékos meghalt
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
	
	//getter - setterek ---------vége------------

}

