package game;

/**
 * Az iglu�rt (mint mened�k�rt) felel�s oszt�ly
 * Implement�lja a Shelter interf�szt
 */
public class Igloo implements Shelter
{
	/**
	 * Visszadja, hogy megv�d-e a medve t�mad�st�l
	 * 
	 * @return mindig true, mivel az iglu megv�d a medv�t�l
	 */
	public boolean defend() {
		return true;
	}
}
