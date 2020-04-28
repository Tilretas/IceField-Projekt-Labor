package game;

import java.util.Scanner;

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
