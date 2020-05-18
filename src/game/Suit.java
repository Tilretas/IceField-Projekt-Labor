package game;

import java.util.Scanner;

public class Suit implements Item
{
	/**
	 * A búvárruha used függvénye, a paraméterként kapott piece-t ki lépteti a vízbõl
	 * 
	 * @param p A búvárruhát használó piece
	 */
	public void used(Piece p, Tile t)
	{
		if(p.getInWater() && p.getTile().isNeighbor(t)) 
		{
			Tile tasd = getDirection(p.getTile());
			if(t== null)
				return;
			p.moved(t);              
			p.setInWater(false);
			p.setSuffocate(false);
			p.setActionPoints(p.getActionPoints() - 1);
		}
	}
	
	/**
	 * Megkérdezi a felhasználótól, hogy melyik mezõre akar kimenni a vízbõl
	 * 
	 * @return A mezõ, ahova lépni fog
	 */
	public Tile getDirection(Tile t)
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("On which tile do you want to move? (1: up | 2: right | 3: down | 4: left):");
		int idx = scr.nextInt();
		
		if(idx < 1 || idx > 4) 
		{
			System.out.println("There are only four options...");
			scr.close();
			return null;
		}
		
		while(t.getNeighbor(Direction.values()[idx-1]) == null) 
		{
			System.out.println("There is no tile in that direction!");
			idx = scr.nextInt();			
		}
		
		scr.close();
		return t.getNeighbor(Direction.values()[idx-1]);
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Suit"; //diving suit (ütközött a shovellel)
	}
	
	//getter - setterek ---------vége------------
}
