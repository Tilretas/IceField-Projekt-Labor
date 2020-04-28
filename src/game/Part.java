package game;

public class Part implements Item
{
	/**
	 * Megn�zi, hogy megvan-e az �sszes alkatr�sz, �s �rtes�ti a j�t�kot arr�l, hogy ezzel a j�t�kosok nyertek
	 * 
	 * @param p A piece, aki az �sszeszerel�st kezdem�nyezi
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
	
	public char getName() 
	{
		return 'P';
	}
}
