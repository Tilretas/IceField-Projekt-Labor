package game;

import java.util.Scanner;

public class Suit implements Item
{
	/**
	 * A búvárruha used függvénye, a paraméterként kapott piece-t ki lépteti a vízbõl
	 * 
	 * @param p A búvárruhát használó piece
	 */
	public void used(Piece p)
	{
		if(p.getInWater()) 
		{
			p.moved(getDirection());              
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
	public Tile getDirection()
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("On which tile do you want ot move? (Tile index 0-24):");
		int tile_num = scr.nextInt();
		scr.close();
		
		return Game.getInstance().getBoard().getTiles().get(tile_num);
	}
	
	public char getName() 
	{
		return 'D'; //diving suit (ütközött a shovellel)
	}
}
