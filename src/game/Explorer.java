package game;

import java.util.Scanner;

/**
 * Az egyik j�tszhat� karaktert (sarkkutat�t) reprezent�l� oszt�ly
 */
public class Explorer extends Piece
{
	public Explorer() {
		setBodyTemp(4);
	}
	
	/**
	 * A sarkkutat� k�pess�g�t megval�s�t� f�ggv�ny.
	 * Megk�rdezi a felhaszn�l�t�l, hogy melyik mez� kapacit�s�t szeretn� megn�zni
	 */
	public void ability(Tile t)
	{
		//System.out.println("\nWhich neighboring tile do you want to check?(0: under you | 1: up | 2: right | 3: down | 4: left)");
		/*Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt();
		
		if(idx < 0 || idx > 4) 
		{
			System.out.println("There are only five options...");
			return;
		}
		*/
		if(getTile().isNeighbor(t) || getTile().equals(t))
		{
			t.setChecked(true);
			setActionPoints(getActionPoints() - 1);
			return;
		}
		/*while(getTile().getNeighbor(Direction.values()[idx-1]) == null) 
		{
			System.out.println("There is no tile in that direction!");
			idx = sc.nextInt();			
		}
		getTile().getNeighbor(Direction.values()[idx-1]).setChecked(true);
		setActionPoints(getActionPoints()-1);	*/			
	}
	
	public String getType() { return "Exp"; }

}
