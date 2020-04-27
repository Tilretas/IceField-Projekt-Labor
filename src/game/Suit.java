package game;

public class Suit implements Item
{
	public void used(Piece p)
	{
		if(p.getInWater()) 
		{
			p.moved(getDirection());
		}
	}
	
	public Tile getDirection()
	{
		return new Tile(0,0); //ideiglenes  TODO
	}
	
	public char getName() 
	{
		return 'D'; //diving suit (ütközött a shovellel)
	}
}
