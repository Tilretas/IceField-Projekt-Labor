package game;

public class Ice extends Tile
{
	/**
	 * A j�gben l�v� t�rgy
	 */
	private Item item;
	
	/**
	 * Az Ice konstruktora, megh�vja a Tile konstruktor�t
	 * 
	 * @param c Erre fogjuk be�ll�tani a mez� kapacit�s�t
	 * @param s Erre fogjuk be�llitani a mez� h�mennyis�g�t
	 */
	public Ice(int c, int s) 
	{
		super(c, s);
	}
	
	

	/**
	 * Hozz�adja a mez�n l�v� piece-ek k�z� a param�terk�nt kapott piece-t
	 * 
	 * @param p A piece, aki a mez�re l�pett
	 */
	public void movedOn(Piece p)
	{
		pieces.add(p);
		p.setTile(this);
	}
	
	//getter - setterek -------------------------
	
	public Item getItem()
	{
		return item;
	}
	
	public void setItem(Item i) {
		item = i;
	}
	
	public int getType() { 
		if(item == null)
			return 1; 
		return 2;
	}

	
	//getter - setterek ---------v�ge------------
}
