package game;

public class Tent implements Item, Shelter
{
	private Tile onTile;

	public void used(Piece p)
	{
		onTile = p.getTile();
		p.getInventory().remove(this);
		p.getTile().setShelter(this);
		p.setActionPoints(p.getActionPoints() - 1);
		Game.getInstance().getBoard().getTents().add(this);
	}
	
	public void destroy() { onTile.setShelter(null); }
	
	public char getName() 
	{
		return 'T';
	}
	
	public boolean defend()
	{
		if(onTile != null)
			destroy();
		return false;
	}
}
