package game;

public interface Item
{
	/**
	 * Using the item
	 * @param p The piece
	 */
	public void used(Piece p, Tile t);
	
	//getter - setterek -------------------------
	
	public String getName();

	//getter - setterek ---------vége------------
}
