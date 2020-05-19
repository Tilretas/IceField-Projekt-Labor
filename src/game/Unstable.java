package game;

/**
 * Az instabil jégmezõért felelõs osztály
 */
public class Unstable extends Ice
{
	
	private boolean flipped = false;
	
	public Unstable(int c, int s) {
		super(c,s);
	}
	
	/**
	 * Az instabil jégtáblára léptetõ függvény
	 * @param p A bábu ami odalép
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
	 *  Az instabil jégtábla átfordul, ha túl sokan vannak rajta,
	 *  Ezáltal a rajta tartózkodók vízbe esnek
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
