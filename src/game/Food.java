package game;

public class Food implements Item
{
	/**
	 * A piece elfogyaszt egy élelmet, ami növeli a testhõjét.
	 * 
	 * @param p A piece, aki használja az itemet 
	 */
	public void used(Piece p)
	{
		p.incBodyTemp();
		p.removeItem(this);
		p.setActionPoints(p.getActionPoints() - 1);
	}
	
	//getter - setterek -------------------------
	
	public char getName() { return 'F';	}
	
	//getter - setterek ---------vége------------
}
