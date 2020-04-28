package game;

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
	public void used(Piece p)
	{
		onTile = p.getTile();
		p.getInventory().remove(this);
		p.getTile().setShelter(this);
		p.setActionPoints(p.getActionPoints() - 1);
		Game.getInstance().getBoard().getTents().add(this);
	}
	
	/**
	 * Lebontja a s�trat
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
