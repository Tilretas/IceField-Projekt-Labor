package game;

import java.util.Scanner;

/**
 * A kötélért, mint eszközért felelõs osztály.
 * Implementálja az Item interfészt
 */
public class Rope implements Item
{
	/**
	 * A kötél used függvénye, a paraméterként kapott piece mezõjére mozgatja a vízben lévõ piecet.
	 * 
	 *  @param p A piece aki használja a kötelet
	 */
	public void used(Piece p)
	{
		Piece saved = getPiece();
		if(saved == null)
			return;
		if(saved == p)
		{
			System.out.println("There's only one thing that you can use a rope on yourself for, and that stuff's waaaay too dark.");
			return;
		}
		if(saved.getInWater())
		{
			saved.moved(p.getTile());
			saved.setInWater(false);
			saved.setSuffocate(false);
			p.setActionPoints(p.getActionPoints() - 1);
		}
	}
	
	/**
	 * Megkérdezi a felhasználótól, hogy hol van a kimentedõ piece és, hogy melyik az
	 * 
	 * @return A kimentedõ piece
	 */
	
	public Piece getPiece()
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("Which piece do you want to save?(0-" + (Game.getInstance().getnOfPlayers()-1) + ")");
		int idx = scr.nextInt();
		if(idx < 0 || idx > Game.getInstance().getnOfPlayers()-1) 
		{
			System.out.println("There isn't a piece with that index!");
			return null;
		}
		while(!Game.getInstance().getBoard().getPieces().get(idx).getInWater())
			System.out.println("That piece isn't in da wa'er!");
		
		return Game.getInstance().getBoard().getPieces().get(idx);
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Rope";
	}
	
	//getter - setterek ---------vége------------
}
