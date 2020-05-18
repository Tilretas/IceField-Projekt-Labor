package game;

/**
 * Az egyik játszható karaktert (eszkimót) reprezentáló osztály
 */
public class Eskimo extends Piece
{
	public Eskimo() {
		setBodyTemp(5);
	}
	
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
