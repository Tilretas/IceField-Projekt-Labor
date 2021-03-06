package game;

/**
 * Az alkatr?szek?rt felel?s oszt?ly,
 * melyekkel meg lehet nyerni a j?t?kot
 */
public class Part implements Item
{
	/**
	 * Megn?zi, hogy megvan-e az ?sszes alkatr?sz, ?s ?rtes?ti a j?t?kot arr?l, hogy ezzel a j?t?kosok nyertek
	 * 
	 * @param p A piece, aki az ?sszeszerel?st kezdem?nyezi
	 */
	public void used(Piece p, Tile t)
	{
		if(p.getTile().equals(t))
		{
			int counter = 0;
			boolean sameTile = true;
			for (Piece b : Game.getInstance().getBoard().getPieces())
				if(!p.getTile().equals(b.getTile()))
					sameTile = false;
			for (Piece b : p.getTile().getPieces()) {
				for (Item i : b.getInventory()) 
					if (this.getClass() == i.getClass())
						counter++;
			}
			if(counter >= 3 && sameTile) 
			{
				for(Piece b : p.getTile().getPieces())
					b.setActionPoints(b.getActionPoints() - 1);
				Game.getInstance().notifyWin();
			}
		}
			
			
		
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Part";
	}
	
	//getter - setterek ---------v?ge------------
}
