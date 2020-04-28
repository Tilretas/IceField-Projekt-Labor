package game;

public class Tent implements Item, Shelter
{
	/**
	 * A mezõ, amelyiken a sátor van
	 */
	private Tile onTile;

	/**
	 * Lehelyezi a sátrat a paraméterként kapott piece mezõjére
	 * 
	 * @param p A piece, aki lerakja a sátrat
	 */
	public void used(Piece p)
	{
		onTile = p.getTile();
		p.getInventory().remove(this);
		p.getTile().setShelter(this);
		p.setActionPoints(p.getActionPoints() - 1);
		Game.getInstance().getBoard().getTents().add(this);
	}
	
	/**
	 * Lebontja a sátrat
	 */
	public void destroy() { onTile.setShelter(null); }
	
	public char getName() 
	{
		return 'T';
	}
	
	public boolean defend()
	{
		if(onTile != null)
			destroy();
		return false;
	}
}
