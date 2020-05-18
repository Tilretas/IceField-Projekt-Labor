package game;

/**
 * Eszk�z interface - ebb�l sz�rmazik le
 * az �sszes eszk�z
 */
public interface Item
{
	/**
	 * Using the item
	 * @param p The piece
	 */
	public void used(Piece p, Tile t);
	
	//getter - setterek -------------------------
	
	public String getName();

	//getter - setterek ---------v�ge------------
}
