package game;

public class Bear
{
	private Tile onTile = null;
		
	public void moved(Tile t)
	{
		if(onTile != null)
			onTile.setBear(null);
		onTile = t;	
		t.setBear(this);
		if(t.getShelter() != null)
		{
			if(!t.getShelter().defend()) 
				for (Piece p : t.getPieces()) 
					p.die();		
		}
		else 
			for (Piece p : t.getPieces()) 
				p.die();
			
	}
	
	public Tile getTile() { return onTile; }
}
