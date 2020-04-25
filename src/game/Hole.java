package game;

public class Hole extends Tile
{
	private boolean covered;
	public void movedOn(Player p)
	{
		playersOnTile.add(p.getPiece());
		p.getPiece().setInWater(true);
	}
}
