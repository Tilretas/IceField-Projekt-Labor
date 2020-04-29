package game;

public class Food implements Item
{
	/**
	 * A piece elfogyaszt egy �lelmet, ami n�veli a testh�j�t.
	 * 
	 * @param p A piece, aki haszn�lja az itemet 
	 */
	public void used(Piece p)
	{
		p.incBodyTemp();
		p.removeItem(this);
		p.setActionPoints(p.getActionPoints() - 1);
	}
	
	//getter - setterek -------------------------
	
	public char getName() { return 'F';	}
	
	//getter - setterek ---------v�ge------------
}
