package graphics;


/**
 * Enumeráció, mely tárol minden lehetséges mezõ kombinációt
 * A mezõk ezen típusok szerint rajzolódnak ki a képernyõre
 */
public enum TileGraphics {
	/**
	 * Egyszerû jégmezõ bármi nélkül
	 */
	Ice, 
	/**
	 * Olyan jégmezõ amelyen van iglu
	 */
	IceIgloo, 
	/**
	 * Olyan jégmezõ, amelyen van sátor
	 */
	IceTent, 
	/**
	 * Az a jégmezõ amelyen aktuálisan a medve tartózkodik
	 */
	IceBear, 
	/**
	 * Az a jégmezõ amelyen aktuálisan a medve tartózkodik, továbbá van rajt egy iglu is
	 */
	IceBearIgloo, 
	/**
	 * Az a jégmezõ amelyen aktuálisan a medve tartózkodik, továbbá van rajt egy sátor is
	 */
	IceBearTent, 
	/**
	 * Olyan jégmezõ, amiben található item
	 */
	Item, 
	/**
	 * Olyan jégmezõ, amiben található item, és van rajt iglu
	 */
	ItemIgloo, 
	/**
	 * Olyan jégmezõ, amiben található item, és van rajt sátor
	 */
	ItemTent, 
	/**
	 * Olyan jégmezõ, amiben található item, és rajta tartózkodik a medve
	 */
	ItemBear, 
	/**
	 * Olyan jégmezõ, amiben található item, rajta tartózkodik a medve, és van rajt iglu
	 */
	ItemBearIgloo, 
	/**
	 * Olyan jégmezõ, amiben található item, rajta tartózkodik a medve, és van rajt sátor
	 */
	ItemBearTent,
	/**
	 * Lyuk
	 */
	Hole, 
	/**
	 * Lyuk, amelyen épp a medve úszkál
	 */
	HoleBear
}
