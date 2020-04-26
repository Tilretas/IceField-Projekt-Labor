package game;

public class Player
{
	private Piece piece;
	private Colour colour;
	
	public Piece getPiece() 
	{
		return piece;
	}
	
	public void move(Tile t)
	{
		getPiece().moved(t);
	}
	
	public void useItem(Item i)
	{
	}
	
	public void useAbility(Tile t)
	{
	}
	
	public void pickUpItem(Tile t)
	{
	}
}
