package game;

public class Food implements Item
{
	public void used(Piece p)
	{
		p.incBodyTemp();
		p.removeItem(this);
	}
}
