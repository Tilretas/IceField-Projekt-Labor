package game;

public class Shovel implements Item
{
	/**
	 * Az ásó hasznlatát megvalósító függvény
	 * 
	 * @param p Az ásót használó piece
	 */
	public void used(Piece p)
	{
		p.getTile().removeSnow();
		p.getTile().removeSnow();
		p.setActionPoints(p.getActionPoints() - 1);
	}
	
	public char getName() 
	{
		return 'S';
	}
}
