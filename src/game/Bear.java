package game;

//import javax.swing.ImageIcon;

public class Bear
{
	//public static ImageIcon pic = new GraphicsBear();
	
	/**
	 * A mezõ, amelyiken a medve megtalálható
	 */
	private Tile onTile = null;
		
	/**
	 * A medve mozgását megvalósító függvény.
	 * A megadott mezõre mozdgatja a medvét, ahol vannak fedetlen bábuk, megtámadja azokat.
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

	//getter - setterek ---------vége------------
	
}
