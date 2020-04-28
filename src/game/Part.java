package game;

public class Part implements Item
{
	public void used(Piece p)
	{
		int counter = 0;
		for (Piece b : p.getTile().getPieces()) 
			for (Item i : b.getInventory()) 
				if (this.getClass() == i.getClass())
					counter++;
		
		if(counter >= 3)
			Game.getInstance().notifyWin();
		
	}
	
	public char getName() 
	{
		return 'P';
	}
}
