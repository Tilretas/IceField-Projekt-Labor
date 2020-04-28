package game;

public class Eskimo extends Piece
{
	public void ability()
	{
		this.getTile().setShelter(new Igloo());
		setActionPoints(getActionPoints()-1);
	}
}
