package game;

public class Hole extends Tile
{
	private boolean covered;
  
	public boolean isCovered() {
		return covered;
	}

	public void setCovered(boolean covered) {
		this.covered = covered;
	}

	public void movedOn(Piece p)
	{
		playersOnTile.add(p);
		p.setInWater(true);
	}
}
