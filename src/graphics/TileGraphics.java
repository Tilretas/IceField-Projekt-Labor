package graphics;


/**
 * Enumer�ci�, mely t�rol minden lehets�ges mez� kombin�ci�t
 * A mez�k ezen t�pusok szerint rajzol�dnak ki a k�perny�re
 */
public enum TileGraphics {
	/**
	 * Egyszer� j�gmez� b�rmi n�lk�l
	 */
	Ice, 
	/**
	 * Olyan j�gmez� amelyen van iglu
	 */
	IceIgloo, 
	/**
	 * Olyan j�gmez�, amelyen van s�tor
	 */
	IceTent, 
	/**
	 * Az a j�gmez� amelyen aktu�lisan a medve tart�zkodik
	 */
	IceBear, 
	/**
	 * Az a j�gmez� amelyen aktu�lisan a medve tart�zkodik, tov�bb� van rajt egy iglu is
	 */
	IceBearIgloo, 
	/**
	 * Az a j�gmez� amelyen aktu�lisan a medve tart�zkodik, tov�bb� van rajt egy s�tor is
	 */
	IceBearTent, 
	/**
	 * Olyan j�gmez�, amiben tal�lhat� item
	 */
	Item, 
	/**
	 * Olyan j�gmez�, amiben tal�lhat� item, �s van rajt iglu
	 */
	ItemIgloo, 
	/**
	 * Olyan j�gmez�, amiben tal�lhat� item, �s van rajt s�tor
	 */
	ItemTent, 
	/**
	 * Olyan j�gmez�, amiben tal�lhat� item, �s rajta tart�zkodik a medve
	 */
	ItemBear, 
	/**
	 * Olyan j�gmez�, amiben tal�lhat� item, rajta tart�zkodik a medve, �s van rajt iglu
	 */
	ItemBearIgloo, 
	/**
	 * Olyan j�gmez�, amiben tal�lhat� item, rajta tart�zkodik a medve, �s van rajt s�tor
	 */
	ItemBearTent,
	/**
	 * Lyuk
	 */
	Hole, 
	/**
	 * Lyuk, amelyen �pp a medve �szk�l
	 */
	HoleBear
}
