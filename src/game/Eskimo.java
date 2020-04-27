package game;

public class Eskimo extends Piece
{
	public void ability()
	{
		this.getTile().buildIgloo();
	}
}
