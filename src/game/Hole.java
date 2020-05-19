package game;

/**
 * A lyuk mezõért felelõs osztály
 */
public class Hole extends Tile
{
	/**
	 * A Hole konstruktora, meghívja a Tile konstruktorát
	 * 
	 * @param c Erre fogjuk beállítani a mezõ kapacitását
	 * @param s Erre fogjuk beállitani a mezõ hómennyiségét
	 */
	public Hole(int c, int s) 
	{
		super(c,s);
	}

	/**
	 * Hozzáadja a lyukban lévõ piecek-hez a paraméterként kapott piece-t, és beállítja a megfelelõ tulajdonságait
	 * 
	 * @param p A lyukra lépõ piece
	 */
	public void movedOn(Piece p)
	{
		pieces.add(p);
		p.setTile(this);
		p.setInWater(true);
		p.setSuffocate(true);
		this.setChecked(true);
		this.setSnow(0);
	}
	
	public int getType() { 
		if(getChecked() || getSnow() == 0)
			return 3; 
		return 1;
	}

}
