package game;

public class Hole extends Tile
{
	private boolean covered = true;
  
	public Hole(int c, int s) 
	{
		super(c,s);
	}
	
	public boolean isCovered() {
		return covered;
	}

	public void setCovered(boolean covered) {
		this.covered = covered;
	}

	public void movedOn(Piece p)
	{
		pieces.add(p);
		p.setOnTile(this);
		p.setInWater(true);
	}
}
