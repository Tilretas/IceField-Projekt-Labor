package game;

public class Eskimo extends Piece
{
	/**
	 * Az eszkim� k�pess�g�t megval�s�t� f�ggv�ny.
	 * Egy iglut �p�t az eszkim� mez�j�n
	 */
	public void ability()
	{
		this.getTile().setShelter(new Igloo());
		setActionPoints(getActionPoints()-1);
	}
}
