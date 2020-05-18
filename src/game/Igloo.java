package game;

/**
 * Az igluért (mint menedékért) felelõs osztály
 * Implementálja a Shelter interfészt
 */
public class Igloo implements Shelter
{
	/**
	 * Visszadja, hogy megvéd-e a medve támadástól
	 * 
	 * @return mindig true, mivel az iglu megvéd a medvétõl
	 */
	public boolean defend() {
		return true;
	}
}
