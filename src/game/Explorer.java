package game;

import java.util.Scanner;

public class Explorer extends Piece
{
	/**
	 * A sarkkutató képességét megvalósító függvény.
	 * Megkérdezi a felhasználótól, hogy melyik mező kapacitását szeretné megnézni
	 */
	public void ability()
	{
		System.out.println("\nWhich neighboring tile do you want to check?(0: under you | 1: up | 2: right | 3: down | 4: left)");
		Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt();
		
		if(idx < 0 || idx > 4) 
		{
			System.out.println("There are only five options...");
			return;
		}
		
		if(idx == 0)
		{
			getTile().setChecked(true);
			setActionPoints(getActionPoints() - 1);
			return;
		}
		while(getTile().getNeighbor(Direction.values()[idx-1]) == null) 
		{
			System.out.println("There is no tile in that direction!");
			idx = sc.nextInt();			
		}
		getTile().getNeighbor(Direction.values()[idx-1]).setChecked(true);
		setActionPoints(getActionPoints()-1);				
	}
	
	public String getType() { return "Exp"; }

}
