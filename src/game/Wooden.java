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
				p.getTile().removeSnow();
				p.setActionPoints(p.getActionPoints() - 1);
				durability--;				
			}
			else 
			{
				p.removeItem(this);
				throw new Exception("The shovel broke!");
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
