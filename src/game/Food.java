package game;

/**
 * Élelemért felelõs osztály, amivel növelhetõ 1 bábu testhõje
 */
public class Food implements Item
{
	/**
	 * A piece elfogyaszt egy élelmet, ami növeli a testhõjét.
	 * 
	 * @param p A piece, aki használja az itemet 
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
	
	//getter - setterek ---------vége------------
}
