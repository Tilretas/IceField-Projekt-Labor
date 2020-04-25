package game;

public class Wooden extends Shovel
{
	private int durability;

	public void used(Piece p)
	{
		try 
		{
			if(durability > 0) 
			{
				p.getTile().removeSnow();
				p.getTile().removeSnow();
				durability--;				
			}
			else 
			{
				p.removeItem(this);
				throw new Exception("Elt�rt az �s�!");
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.toString()); //ez minek? ; Gondoltam valahogy jelezni k�ne, ha elt�rik az �s� nem?
		}
		
	}
	
	public char getName() 
	{
		return 'W';
	}
}
