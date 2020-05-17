package game;

public class Ice extends Tile
{
	/**
	 * A jégben lévõ tárgy
	 */
	private Item item;
	
	/**
	 * Az Ice konstruktora, meghívja a Tile konstruktorát
	 * 
	 * @param c Erre fogjuk beállítani a mezõ kapacitását
	 * @param s Erre fogjuk beállitani a mezõ hómennyiségét
	 */
	public Ice(int c, int s) 
	{
		super(c, s);
	}
	
	

	/**
	 * Hozzáadja a mezõn lévõ piece-ek közé a paraméterként kapott piece-t
	 * 
	 * @param p A piece, aki a mezõre lépett
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

	
	//getter - setterek ---------vége------------
}
