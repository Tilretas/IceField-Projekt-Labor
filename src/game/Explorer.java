package game;

/**
 * Az egyik j�tszhat� karaktert (sarkkutat�t) reprezent�l� oszt�ly
 */
public class Explorer extends Piece
{
	public Explorer() {
		setBodyTemp(4);
	}
	
	/**
	 * A sarkkutat� k�pess�g�t megval�s�t� f�ggv�ny.
	 * Megk�rdezi a felhaszn�l�t�l, hogy melyik mez� kapacit�s�t szeretn� megn�zni
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
