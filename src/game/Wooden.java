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
				throw new Exception("Eltört az ásó!");
			}
		}
		catch(Exception e) 
		{
			System.out.println(e.toString()); //ez minek? ; Gondoltam valahogy jelezni kéne, ha eltörik az ásó nem?
		}
		
	}
	
	public char getName() 
	{
		return 'W';
	}
}
