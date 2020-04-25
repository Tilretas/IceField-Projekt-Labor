package game;

public class Ice extends Tile
{
	private Item item;
	
	public void movedOn(Player p)
	{
		playersOnTile.add(p.getPiece());
	}
	
	public Item getItem()
	{
		return item;
	}
}
