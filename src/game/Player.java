package game;

public class Player
{
	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

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
