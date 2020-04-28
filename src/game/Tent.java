package game;

public class Tent implements Item, Shelter
{
	private Tile onTile;

	public void used(Piece p)
	{
		onTile = p.getTile();
		p.getInventory().remove(this);
		p.getTile().setShelter(this);
	}
	
	public void destroy()
	{
		
	}
	
	public char getName() 
	{
		return 'T';
	}
	
	public boolean defend()
	{
		onTile.setShelter(null);
		return false;
	}
}
