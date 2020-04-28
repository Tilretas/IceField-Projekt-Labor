package game;

public class Bear
{
	private Tile onTile = null;
		
	/**
	 * A sarkkutat� k�pess�g�t megval�s�t� f�ggv�ny.
	 * Megk�rdezi a felhaszn�l�t�l, hogy melyik mez� kapacit�s�t szeretn� megn�zni
	 * 
	 * @param t - A Tile ahova a medve mozog
	 */
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
