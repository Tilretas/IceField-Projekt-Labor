package game;

import java.util.Scanner;

/**
 * A k�t�l�rt, mint eszk�z�rt felel�s oszt�ly.
 * Implement�lja az Item interf�szt
 */
public class Rope implements Item
{
	/**
	 * A k�t�l used f�ggv�nye, a param�terk�nt kapott piece mez�j�re mozgatja a v�zben l�v� piecet.
	 * 
	 *  @param p A piece aki haszn�lja a k�telet
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
	 * Megk�rdezi a felhaszn�l�t�l, hogy hol van a kimented� piece �s, hogy melyik az
	 * 
	 * @return A kimented� piece
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
	
	//getter - setterek ---------v�ge------------
}
