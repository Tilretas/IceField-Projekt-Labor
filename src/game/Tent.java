package game;

/**
 * A s�tor�rt, mint eszk�z�rt �s mened�k�rt felel�s oszt�ly.
 * Implement�lja az Item �s Shelter interf�szt
 */
public class Tent implements Item, Shelter
{
	/**
	 * A mez�, amelyiken a s�tor van
	 */
	private Tile onTile;

	/**
	 * Lehelyezi a s�trat a param�terk�nt kapott piece mez�j�re
	 * 
	 * @param p A piece, aki lerakja a s�trat
	 */
	public void used(Piece p, Tile t)
	{
		if(p.getTile().equals(t))
		{
			onTile = p.getTile();
			p.getInventory().remove(this);
			p.getTile().setShelter(this);
			p.setActionPoints(p.getActionPoints() - 1);
			Game.getInstance().getBoard().getTents().add(this);
		}
	}
	
	/**
	 * Lebontja a s�trat
	 */
	public void destroy() { onTile.setShelter(null); }
	
	
	/**
	 * Visszadja, hogy megv�d-e a medve t�mad�st�l
	 * Lebontja a s�trat medve t�mad�s eset�n
	 * 
	 * @return mindig false, mert a s�tor nem v�d a medv�t�l
	 */
	public boolean defend()
	{
		if(onTile != null)
			destroy();
		return false;
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Tent";
	}
	
	//getter - setterek ---------v�ge------------
}
