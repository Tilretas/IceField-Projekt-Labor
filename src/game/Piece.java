package game;

import java.util.ArrayList;

public abstract class Piece
{
	private ArrayList<Item> inventory = new ArrayList();
	private int bodyTemp;
	private int actionPoints;
	private boolean inWater;
	private Tile onTile;
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

	public Tile getOnTile() {
		return onTile;
	}

	public void setOnTile(Tile onTile) {
		this.onTile = onTile;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public boolean isInWater() {
		return inWater;
	}

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
