package game;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Tile.java
//  @ Date : 2020. 04. 22.
//  @ Author : 
//
//

import java.util.ArrayList;

public class Tile
{
	private ArrayList<Piece> playersOnTile;
	private ArrayList<Tile> neighbors; //valahogy �ssze k�ne k�tni a directionnal -> map?
	private int snow;
	private boolean igloo;
	private int capactiy;
	
	public void addSnow()
	{
	}
	
	public void removeSnow()
	{
	}
	
	public void movedOn(Player p)
	{
	}
	
	public void buildIgloo()
	{
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
