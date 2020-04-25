package game;

public class Unstable extends Ice
{
	public void movedOn(Player p)
	{
		playersOnTile.add(p.getPiece());
		if(playersOnTile.size() > getCapacity())
			flip();
	}
	
	public void flip()
	{
		for(int i = 0; i < getCapacity(); i++)
			playersOnTile.get(i).setInWater(true);
	}
}
