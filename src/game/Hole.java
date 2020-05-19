package game;

/**
 * A lyuk mez��rt felel�s oszt�ly
 */
public class Hole extends Tile
{
	/**
	 * A Hole konstruktora, megh�vja a Tile konstruktor�t
	 * 
	 * @param c Erre fogjuk be�ll�tani a mez� kapacit�s�t
	 * @param s Erre fogjuk be�llitani a mez� h�mennyis�g�t
	 */
	public Hole(int c, int s) 
	{
		super(c,s);
	}

	/**
	 * Hozz�adja a lyukban l�v� piecek-hez a param�terk�nt kapott piece-t, �s be�ll�tja a megfelel� tulajdons�gait
	 * 
	 * @param p A lyukra l�p� piece
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
