package game;

public class Tent implements Item
{
	private Tile onTile;
	public Tile getOnTile() {
		return onTile;
	}

	public void setOnTile(Tile onTile) {
		this.onTile = onTile;
	}

	public void used(Piece p)
	{
	}
	
	public void destroy()
	{
	}
	
	public char getName() 
	{
		return 'T';
	}
}
