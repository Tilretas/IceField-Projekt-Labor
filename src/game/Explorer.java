package game;

/**
 * Az egyik játszható karaktert (sarkkutatót) reprezentáló osztály
 */
public class Explorer extends Piece
{
	public Explorer() {
		setBodyTemp(4);
	}
	
	/**
	 * A sarkkutató képességét megvalósító függvény.
	 * Megkérdezi a felhasználótól, hogy melyik mezõ kapacitását szeretné megnézni
	 */
	public void ability(Tile t)
	{
		if(getTile().isNeighbor(t) || getTile().equals(t))
		{
			t.setChecked(true);
			setActionPoints(getActionPoints() - 1);
			return;
		}
	}
	
	public String getType() { return "Exp"; }

}
