package game;

/**
 * �lelem�rt felel�s oszt�ly, amivel n�velhet� 1 b�bu testh�je
 */
public class Food implements Item
{
	/**
	 * A piece elfogyaszt egy �lelmet, ami n�veli a testh�j�t.
	 * 
	 * @param p A piece, aki haszn�lja az itemet 
	 */
	public void used(Piece p, Tile t)
	{
		if(p.getTile().equals(t)) {
			p.incBodyTemp();
			p.removeItem(this);
			p.setActionPoints(p.getActionPoints() - 1);
		}
	}
	
	//getter - setterek -------------------------
	
	public String getName() { return "Food";	}
	
	//getter - setterek ---------v�ge------------
}
