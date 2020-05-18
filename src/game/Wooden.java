package game;

/**
 * A faásóért, mint eszközért felelõs osztály.
 * Implementálja az Item interfészt
 */
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
				Game.getInstance().getView().getStatPanel().settext_area("The shovel broke!");
		}
		
	}
	
	public String getName() 
	{
		return "Wooden";
	}
}
