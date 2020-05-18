package game;

public class Eskimo extends Piece
{
	/**
	 * Az eszkimó képességét megvalósító függvény.
	 * Egy iglut épít az eszkimó mezõjén
	 */
	public void ability(Tile t)
	{
		if(getTile().equals(t)) {
			this.getTile().setShelter(new Igloo());
			setActionPoints(getActionPoints()-1);
		}
	}
	
	public String getType() { return "Esk"; }
}
