package game;

public class Wooden extends Shovel
{
	/**
	 * A fa�s� tart�ss�ga(ah�nyszor haszn�lni lehet)
	 */
	private int durability;

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	/**
	 * A fa�s� haszn�lat�t megval�s�t� f�ggv�ny
	 * 
	 * @param p Az �s�t haszn�l� piece
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
			System.out.println(e.toString()); //ez minek? ; Gondoltam valahogy jelezni k�ne, ha elt�rik az �s� nem?
		}
		
	}
	
	public char getName() 
	{
		return 'W';
	}
}
