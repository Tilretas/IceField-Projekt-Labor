package game;

//import javax.swing.ImageIcon;

public class Bear
{
	//public static ImageIcon pic = new GraphicsBear();
	
	/**
	 * A mez�, amelyiken a medve megtal�lhat�
	 */
	private Tile onTile = null;
		
	/**
	 * A medve mozg�s�t megval�s�t� f�ggv�ny.
	 * A megadott mez�re mozdgatja a medv�t, ahol vannak fedetlen b�buk, megt�madja azokat.
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
	//getter - setterek -------------------------
	
	public Tile getTile() { return onTile; }

	//getter - setterek ---------v�ge------------
	
}
