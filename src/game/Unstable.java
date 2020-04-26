package game;

public class Unstable extends Ice
{
	public void movedOn(Piece p)
	{
		playersOnTile.add(p);
		if(playersOnTile.size() > getCapacity())
			flip();
	}
	
	public void flip()
	{
		for(int i = 0; i < getCapacity(); i++)
			playersOnTile.get(i).setInWater(true);
	}
}
