package game;

public class Food implements Item
{
	public void used(Piece p)
	{
		p.incBodyTemp();
		p.removeItem(this);
		p.setActionPoints(p.getActionPoints() - 1);
	}
	public char getName() 
	{
		return 'F';
	}
}
