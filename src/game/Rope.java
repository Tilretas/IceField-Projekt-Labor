package game;

public class Rope implements Item
{
	public void used(Piece p)
	{
		savePiece(getPiece());
	}
	
	public Piece getPiece()
	{
		return new Eskimo(); //ideiglenes
	}
	
	private void savePiece(Piece p)
	{
		
	}
	
	public char getName() 
	{
		return 'R';
	}
}
