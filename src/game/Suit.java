package game;

import java.util.Scanner;

public class Suit implements Item
{
	public void used(Piece p)
	{
		if(p.getInWater()) 
		{
			p.moved(getDirection());              //Szomsz�doss�g ellen�rz�se m�g hi�nyzik
		}
	}
	
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
