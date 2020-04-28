package game;

public class Unstable extends Ice
{
	public Unstable(int c, int s) {
		super(c,s);
	}
	
	public void movedOn(Piece p)
	{
		pieces.add(p);
		p.setTile(this);
		if(pieces.size() > getCapacity())
		{
			flip();
			p.setSuffocate(true);
		}
	}
	
	public void flip()
	{
		for(int i = 0; i < getCapacity(); i++)
			pieces.get(i).setInWater(true);
	}
}
