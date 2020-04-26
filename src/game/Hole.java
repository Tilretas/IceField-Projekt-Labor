package game;

public class Hole extends Tile
{
	private boolean covered;
	public void movedOn(Piece p)
	{
		playersOnTile.add(p);
		p.setInWater(true);
	}
}
