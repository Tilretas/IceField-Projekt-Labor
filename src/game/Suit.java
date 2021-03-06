package game;

import java.util.Scanner;


/**
 * A b?v?rruh??rt, mint eszk?z?rt felel?s oszt?ly.
 * Implement?lja az Item interf?szt
 */
public class Suit implements Item
{
	/**
	 * A b?v?rruha used f?ggv?nye, a param?terk?nt kapott piece-t ki l?pteti a v?zb?l
	 * 
	 * @param p A b?v?rruh?t haszn?l? piece
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
	 * Megk?rdezi a felhaszn?l?t?l, hogy melyik mez?re akar kimenni a v?zb?l
	 * 
	 * @return A mez?, ahova l?pni fog
	 */
	public Tile getDirection(Tile t)
	{
		Scanner scr = new Scanner(System.in);
		Game.getInstance().getView().getStatPanel().settext_area("On which tile do you want to move?");
		int idx = scr.nextInt();
		
		if(idx < 1 || idx > 4) 
		{
			Game.getInstance().getView().getStatPanel().settext_area("There are only four options...");
			scr.close();
			return null;
		}
		
		while(t.getNeighbor(Direction.values()[idx-1]) == null) 
		{
			Game.getInstance().getView().getStatPanel().settext_area("There is no tile in that direction!");
			idx = scr.nextInt();			
		}
		
		scr.close();
		return t.getNeighbor(Direction.values()[idx-1]);
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Suit"; //diving suit (?tk?z?tt a shovellel)
	}
	
	//getter - setterek ---------v?ge------------
}
