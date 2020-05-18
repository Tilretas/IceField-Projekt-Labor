package game;

/**
 * A sátorért, mint eszközért és menedékért felelõs osztály.
 * Implementálja az Item és Shelter interfészt
 */
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
	 * Lebontja a sátrat
	 */
	public void destroy() { onTile.setShelter(null); }
	
	
	/**
	 * Visszadja, hogy megvéd-e a medve támadástól
	 * Lebontja a sátrat medve támadás esetén
	 * 
	 * @return mindig false, mert a sátor nem véd a medvétõl
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
	
	//getter - setterek ---------vége------------
}
