package game;

public class Ice extends Tile
{
	private Item item;
	
	public void setItem(Item item) {
		this.item = item;
	}


	public void movedOn(Piece p)
	{
		playersOnTile.add(p);
	}
	
	public Item getItem()
	{
		return item;
	}
}
