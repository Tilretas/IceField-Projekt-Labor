package game;

public class Ice extends Tile
{
	private Item item;
	
	public Ice(int c, int s) 
	{
		super(c, s);
	}
	
	public void setItem(Item i) {
		item = i;
	}


	public void movedOn(Piece p)
	{
		pieces.add(p);
		p.setTile(this);
	}
	
	public Item getItem()
	{
		return item;
	}
}
