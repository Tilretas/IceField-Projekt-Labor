package game;

/**
 * A fa�s��rt, mint eszk�z�rt felel�s oszt�ly.
 * Implement�lja az Item interf�szt
 */
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
