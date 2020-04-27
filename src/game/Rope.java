package game;

import java.util.Scanner;

public class Rope implements Item
{
	public void used(Piece p)
	{
		savePiece(getPiece());
	}
	
	public Piece getPiece()
	{
		Scanner scr = new Scanner(System.in);
		System.out.println("Where is the piece you want to save? (Tile index 0-24):");
		int location = scr.nextInt();
		System.out.println("Which piece do you want to save?");
		int piece = scr.nextInt();
		
		return Game.getInstance().getBoard().getTiles().get(location).getPieces().get(piece);
	}
	
	private void savePiece(Piece p)
	{
		
	}
	
	public char getName() 
	{
		return 'R';
	}
}
