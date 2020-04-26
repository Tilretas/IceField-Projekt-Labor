package game;

public class Eskimo extends Piece
{
	public void ability(Tile t)
	{
		this.getTile().buildIgloo();
	}
}
