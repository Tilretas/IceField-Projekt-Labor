package game;

/**
 * Az alkatrészekért felelõs osztály,
 * melyekkel meg lehet nyerni a játékot
 */
public class Part implements Item
{
	/**
	 * Megnézi, hogy megvan-e az összes alkatrész, és értesíti a játékot arról, hogy ezzel a játékosok nyertek
	 * 
	 * @param p A piece, aki az összeszerelést kezdeményezi
	 */
	public void used(Piece p)
	{
		int counter = 0;
		for (Piece b : p.getTile().getPieces()) 
			for (Item i : b.getInventory()) 
				if (this.getClass() == i.getClass())
					counter++;
		
		if(counter >= 3) 
		{
			for(Piece b : p.getTile().getPieces())
				b.setActionPoints(b.getActionPoints() - 1);
			Game.getInstance().notifyWin();
		}
			
			
		
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Part";
	}
	
	//getter - setterek ---------vége------------
}
