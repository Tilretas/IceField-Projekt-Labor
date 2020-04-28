package game;

public class Tent implements Item
{
	private Tile onTile;
	public Tile getTile() {
		return onTile;
	}

	public void setOnTile(Tile t) {
		onTile = t;
	}

	public void used(Piece p)
	{
		setOnTile(p.getTile());
	}
	
	public void destroy()
	{
	}
	
	public char getName() 
	{
		return 'T';
	}
}
