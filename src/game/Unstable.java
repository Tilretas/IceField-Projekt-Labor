package game;

/**
 * Az instabil j?gmez??rt felel?s oszt?ly
 */
public class Unstable extends Ice
{
	
	private boolean flipped = false;
	
	public Unstable(int c, int s) {
		super(c,s);
	}
	
	/**
	 * Az instabil j?gt?bl?ra l?ptet? f?ggv?ny
	 * @param p A b?bu ami odal?p
	 */
	public void movedOn(Piece p)
	{
		pieces.add(p);
		p.setTile(this);
		if(pieces.size() > getCapacity())
		{
			flip();
			p.setSuffocate(true);
		}
	}
	
	/**
	 *  Az instabil j?gt?bla ?tfordul, ha t?l sokan vannak rajta,
	 *  Ez?ltal a rajta tart?zkod?k v?zbe esnek
	 */
	public void flip()
	{
		for(Piece p : getPieces())
			p.setInWater(true);
		flipped = true;
		Game.getInstance().setText("The tile has flipped!");
	}
	
	@Override
	public int getType() 
	{
		if(flipped)
		{
			flipped = false;
			return 3;
		}
		if(getItem() == null)
			return 1; 
		return 2;
	}
}
