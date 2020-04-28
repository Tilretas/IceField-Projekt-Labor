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
			p.moved(getDirection());              
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
		return 'D'; //diving suit (�tk�z�tt a shovellel)
	}
}
