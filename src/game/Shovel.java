package game;

public class Shovel implements Item
{
	public void used(Piece p)
	{
		p.getTile().removeSnow();
		p.getTile().removeSnow();
	}
	
	public char getName() 
	{
		return 'S';
	}
}
