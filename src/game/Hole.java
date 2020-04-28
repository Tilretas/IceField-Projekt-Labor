package game;

public class Hole extends Tile
{
	
	public Hole(int c, int s) 
	{
		super(c,s);
	}

	public void movedOn(Piece p)
	{
		pieces.add(p);
		p.setTile(this);
		p.setInWater(true);
		p.setSuffocate(true);
		this.setChecked(true);
	}
}
