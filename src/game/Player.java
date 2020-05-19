package game;

import graphics.Action;

/**
 * A játékost reprezentáló osztály.
 * Itt találhatóak meg a játékos lehetõségei
 */
public class Player

{
	/**
	 * A játékoshoz tartozó piece
	 */
	private Piece piece;
	
	/**
	 * A játékoshoz tartozó szín
	 */
	private Colour colour;

	/**
	 * A Player osztály konstruktora, inicializálja a colour attribútumot
	 * 
	 * @param c A Player színe
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
	 * A felhasználói input bekéréséért és végrehajtásáért felel.
	 * 6 akció közül tud választani a felhasználó (+1 rejtett, a '-1' inputtal a teszt módba kerül
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
	 * A felhasználó által megadott mezõre lépteti a piece-t, ha az szomszédos a jelenlegi mezõjével
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
	 * 1 hómennyiséget ás a piece jelenlegi mezõjén
	 */
	public void Dig(Tile t) { 
		if(piece.getTile().equals(t))
			piece.dig(); 
	}
	
	/**
	 * A piece használja a képességét
	 */
	public void UseAbility(Tile t) {
		Game.getInstance().setText("Abiliting");
		piece.ability(t); 
	}
	
	/**
	 * Mekkérdézi a felhasználótól, hogy melyik tárgyat akarja használni, majd használja
	 */
	public void useItem(Tile t, Item i)
	{
		piece.useItem(i, t);
	}
	
	/**
	 * Felvesz egy tárgyat
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

