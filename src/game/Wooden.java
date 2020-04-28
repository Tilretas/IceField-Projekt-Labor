package game;

public class Wooden extends Shovel
{
	/**
	 * A faásó tartóssága(ahányszor használni lehet)
	 */
	private int durability;

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	/**
	 * A faásó használatát megvalósító függvény
	 * 
	 * @param p Az ásót használó piece
	 */
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
