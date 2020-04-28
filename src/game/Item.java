package game;

public interface Item
{
	/**
	 * Using the item
	 * @param p The piece
	 */
	public void used(Piece p);
	public char getName();
}
