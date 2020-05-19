package game;

/**
 * A k�t�l�rt, mint eszk�z�rt felel�s oszt�ly.
 * Implement�lja az Item interf�szt
 */
public class Rope implements Item
{
	/**
	 * A k�t�l used f�ggv�nye, a param�terk�nt kapott piece mez�j�re mozgatja a v�zben l�v� piecet.
	 * 
	 *  @param p A piece aki haszn�lja a k�telet
	 */
	public void used(Piece p, Tile t)
	{
		Game.getInstance().getView().getStatPanel().settext_area("Select a piece to save!");
	}
	
	/**
	 * Megk�rdezi a felhaszn�l�t�l, hogy hol van a kimented� piece �s, hogy melyik az
	 * 
	 * @return A kimented� piece
	 */
	public void savePiece(Piece user, Piece saved)
	{
		if(user.getTile().isNeighbor(saved.getTile()) && saved.getInWater())
		{
			saved.moved(user.getTile());
			saved.setInWater(false);
			saved.setSuffocate(false);
			user.setActionPoints(user.getActionPoints() - 1);
		}
	}
	
	//getter - setterek -------------------------
	
	public String getName() 
	{
		return "Rope";
	}
	
	//getter - setterek ---------v�ge------------
}
