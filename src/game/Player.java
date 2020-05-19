package game;

import graphics.Action;

/**
 * A j�t�kost reprezent�l� oszt�ly.
 * Itt tal�lhat�ak meg a j�t�kos lehet�s�gei
 */
public class Player

{
	/**
	 * A j�t�koshoz tartoz� piece
	 */
	private Piece piece;
	
	/**
	 * A j�t�koshoz tartoz� sz�n
	 */
	private Colour colour;

	/**
	 * A Player oszt�ly konstruktora, inicializ�lja a colour attrib�tumot
	 * 
	 * @param c A Player sz�ne
	 */
	public Player(Colour c) { colour = c; }
	
	public void YourTurn()
	{
		piece.setActionPoints(4);
		if (piece.getInWater()) 
		{
			if (piece.getSuffocate())
				piece.die();
			else piece.setSuffocate(true);
		}
	}
	
	/**
	 * A felhaszn�l�i input bek�r�s��rt �s v�grehajt�s��rt felel.
	 * 6 akci� k�z�l tud v�lasztani a felhaszn�l� (+1 rejtett, a '-1' inputtal a teszt m�dba ker�l
	 */
	public void playerInput(Tile t, Action activeAction) 
	{
		switch (activeAction) {
		case Move:
			Move(t);
			break;

		case Dig:
			Dig(t);
			break;
		
		case UseAbility:
			UseAbility(t);
			break;
		
		case UseItem:
			if(Game.getInstance().getActiveItem() != null)
			{
				useItem(t, Game.getInstance().getActiveItem());
				Game.getInstance().setText("Iteming " + Game.getInstance().getActiveItem().getName());
			}
			break;
			
		case PickUpItem:
			PickUpItem(t);
			break;
			
		default:
			break;
			
		}
		if(piece.getActionPoints() <= 0)
			Game.getInstance().NextPlayer();
		Game.getInstance().getView().Refresh();		
	}
	
	/**
	 * A felhaszn�l� �ltal megadott mez�re l�pteti a piece-t, ha az szomsz�dos a jelenlegi mez�j�vel
	 */
	public void Move(Tile t) 
	{
		if(getPiece().getInWater() == true)
		{
			System.out.println("You need to use a diving suit to get out of water!");
			return;
		}

		if(piece.getTile().isNeighbor(t))
		{
			piece.moved(t);
			Game.getInstance().setText("Moving");
		}
	}
	
	/**
	 * 1 h�mennyis�get �s a piece jelenlegi mez�j�n
	 */
	public void Dig(Tile t) { 
		if(piece.getTile().equals(t))
			piece.dig(); 
	}
	
	/**
	 * A piece haszn�lja a k�pess�g�t
	 */
	public void UseAbility(Tile t) {
		Game.getInstance().setText("Abiliting");
		piece.ability(t); 
	}
	
	/**
	 * Mekk�rd�zi a felhaszn�l�t�l, hogy melyik t�rgyat akarja haszn�lni, majd haszn�lja
	 */
	public void useItem(Tile t, Item i)
	{
		piece.useItem(i, t);
	}
	
	/**
	 * Felvesz egy t�rgyat
	 */
	public void PickUpItem(Tile t)
	{
		if(piece.getTile().equals(t)) {
			if (piece.getTile().getItem() == null)
				Game.getInstance().setText("There is no item to pick up!");
			else if(t.getSnow() != 0)
				Game.getInstance().setText("You need to remove the snow first!");
			else
				piece.pickUp();
		}
	}
	
	
	public Colour getColour() { return colour; }
	
	public void setPiece(Piece p) { piece = p; }
	
	public Piece getPiece() { return piece; }
}

