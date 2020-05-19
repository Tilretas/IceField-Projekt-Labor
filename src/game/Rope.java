package game;

/**
 * A kötélért, mint eszközért felelõs osztály.
 * Implementálja az Item interfészt
 */
public class Rope implements Item
{
	/**
	 * A kötél used függvénye, a paraméterként kapott piece mezõjére mozgatja a vízben lévõ piecet.
	 * 
	 *  @param p A piece aki használja a kötelet
	 */
	public void used(Piece p, Tile t)
	{
		Game.getInstance().getView().getStatPanel().settext_area("Select a piece to save!");
	}
	
	/**
	 * Megkérdezi a felhasználótól, hogy hol van a kimentedõ piece és, hogy melyik az
	 * 
	 * @return A kimentedõ piece
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
	
	//getter - setterek ---------vége------------
}
