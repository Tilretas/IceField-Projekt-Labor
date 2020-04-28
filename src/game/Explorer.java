package game;

import java.util.Scanner;

public class Explorer extends Piece
{
	public void ability()
	{
		System.out.println("\nWhich neighboring tile do you want to check?(1: up | 2: right | 3: down | 4: left");
		Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt()-1;
		
		if(idx < 1 || idx > 4)
			System.out.println("There is only four directions...");
		if(getTile().getNeighbor(Direction.values()[idx]) == null)
			System.out.println("There is no tile in that direction!");
		else 
		{
			getTile().getNeighbor(Direction.values()[idx]).setChecked(true);
			this.setActionPoints(getActionPoints()-1);				
		}
	}
	
}
