package game;

public class Shovel implements Item
{
	/**
	 * Az �s� hasznlat�t megval�s�t� f�ggv�ny
	 * 
	 * @param p Az �s�t haszn�l� piece
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
	
	//getter - setterek ---------v�ge------------
}
