package game;

import java.util.Scanner;

public class Suit implements Item
{
	/**
	 * A b�v�rruha used f�ggv�nye, a param�terk�nt kapott piece-t ki l�pteti a v�zb�l
	 * 
	 * @param p A b�v�rruh�t haszn�l� piece
	 */
	public void used(Piece p)
	{
		if(p.getInWater()) 
		{
			Tile t = getDirection(p.getTile());
			if(t== null)
				return;
			p.moved(t);              
			p.setInWater(false);
			p.setSuffocate(false);
			p.setActionPoints(p.getActionPoints() - 1);
		}
	}
	
	/**
	 * Megk�rdezi a felhaszn�l�t�l, hogy melyik mez�re akar kimenni a v�zb�l
	 * 
	 * @return A mez�, ahova l�pni fog
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
	
	public char getName() 
	{
		return 'D'; //diving suit (�tk�z�tt a shovellel)
	}
}
