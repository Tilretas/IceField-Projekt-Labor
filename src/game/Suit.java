package game;

public class Suit implements Item
{
	public void used(Piece p)
	{
		if(p.isInWater()) 
		{
			p.moved(getDirection());
		}
	}
	
	public Tile getDirection()
	{
		return new Tile(); //ideiglenes  TODO
	}
	
	public char getName() 
	{
		return 'D'; //diving suit (ütközött a shovellel)
	}
}
