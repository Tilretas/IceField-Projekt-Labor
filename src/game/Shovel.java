package game;

public class Shovel implements Item
{
	/**
	 * Az ásó hasznlatát megvalósító függvény
	 * 
	 * @param p Az ásót használó piece
	 */
	public void used(Piece p, Tile t)
	{
		if(p.getTile().equals(t))
		{
			p.getTile().removeSnow();
			p.getTile().removeSnow();
			p.setActionPoints(p.getActionPoints() - 1);
		}
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Shovel";
	}
	
	//getter - setterek ---------vége------------
}
