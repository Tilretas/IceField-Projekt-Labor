package game;

public class Eskimo extends Piece
{
	/**
	 * Az eszkim� k�pess�g�t megval�s�t� f�ggv�ny.
	 * Egy iglut �p�t az eszkim� mez�j�n
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
