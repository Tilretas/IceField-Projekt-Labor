package game;

public class Unstable extends Ice
{
	public Unstable(int c, int s) {
		super(c,s);
	}
	/**
	 * Moving to the tile
	 * @param p The piece who moved to the tile
	 */
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
	
	/**
	 * Unstable flipping over and pieces fall into the water
	 */
	public void flip()
	{
		for(int i = 0; i < getCapacity(); i++)
			pieces.get(i).setInWater(true);
	}
}
