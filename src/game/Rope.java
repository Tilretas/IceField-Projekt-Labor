package game;

import java.util.Scanner;

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
		System.out.println("Where is the piece you want to save? (Tile index 0-24):");
		int location = scr.nextInt();
		System.out.println("Which piece do you want to save?");
		int piece = scr.nextInt();
		
		return Game.getInstance().getBoard().getTiles().get(location).getPieces().get(piece);
	}
	
	public char getName() 
	{
		return 'R';
	}
}
