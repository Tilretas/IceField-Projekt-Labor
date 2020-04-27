package game;

public class Rope implements Item
{
	public void used(Piece p)
	{
		savePiece(getPiece());
	}
	
	public Piece getPiece()
	{
		//return Game.getInstance().getBoard().getTiles().get().getPlayersOnTile().get();
		return new Eskimo();
	}
	
	private void savePiece(Piece p)
	{
		
	}
	
	public char getName() 
	{
		return 'R';
	}
}
