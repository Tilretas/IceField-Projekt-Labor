package game;

public class Wooden extends Shovel
{
	private int durability;

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public void used(Piece p)
	{
		try 
		{
			if(durability > 0) 
			{
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
			System.out.println(e.toString()); //ez minek?
		}
		
	}
	
	public char getName() 
	{
		return 'W';
	}
}
