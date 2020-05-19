package game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A táblát kezelõ osztály
 */
public class Board
{
	/**
	 * Bábukat tartalmazó lista
	 */
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	/**
	 * A mezõket tartalmazó lista
	 */
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	/**
	 * Eszközöket tartalmazó lista
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * Sátrakat tartalmazó lista
	 */
	private ArrayList<Tent> tents = new ArrayList<Tent>();
	/**
	 * Változó a medvére
	 */
	private Bear bear;

	/**
	 * A tábla elõkészítéséért, és a rajta lévõ elemek beolvasásáért felelõs.
	 * Stringekbe tárolja a beolvasott informácót
	 * 
	 * @param setupFile A txt címe, ahonnan beolvassa a pálya felépítését
	 */
	public void initBoard(String setupFile) throws IOException
	{
		String [] confTiles = new String[5];
		String confPieces;
		String confItems;

		FileInputStream fstream = new FileInputStream(setupFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		for (int y = 0; y < 5; y++) 
		{
			confTiles[y] = br.readLine();
		}
		
		confPieces = br.readLine();
		confItems = br.readLine();
		
		createTiles(confTiles);
		spawnPieces(confPieces);
		generateItems(confItems);
	}
	
	/**
	 * A tábla konzolra való kiírásáért felelõs függvény.
	 * 5x5 mezõ van, minden mezõ 2x2 karakternek felel meg.
	 * Bal felsõ érték: a mezõn lévõ játékosok számát jelzi (ha medve van a mezõn, akkor 'B', ha iglu 'I', ha sátor akkor 'T').
	 * Jobb felsõ: A mezõn lévõ tárgy kezdõbetûje.
	 * Bal alsó: A mezõn lévõ hórétegek száma.
	 * Jobb alsó: A mezõ kapacitása ('X' ha ismeretlen, 'S' ha stabil, '0' ha lyuk).
	 */
	public void drawBoard()
	{	
		for (int y = 0; y < 5; y++) {
			
			for (int i = 0; i < 29; i++)
				System.out.print("-");
			System.out.println();
			
			for (int x = 0; x < 5; x++) {
				
				char i = 'X';
				if (tiles.get(y*5 + x).getItem() != null)
					i = 'T';
				char p = (char) (tiles.get(y*5 + x).getPieces().size() + '0');
				if (p == '0')
					p = 'X';
				if (tiles.get(y*5 + x).getBear())
					p = 'B';
				if (tiles.get(y*5 + x).getShelter() != null)
					if (tiles.get(y*5 + x).getShelter().defend())
						p = 'I';
					else
						p = 'T';
				System.out.print(p + " " + i + " | ");
			}
			
			System.out.println();
			for (int x = 0; x < 5; x++) {
				
				int s = tiles.get(y*5 + x).getSnow();
				char c = 'X';
				if(tiles.get(y*5 + x).getChecked())
					c = (char) (tiles.get(y*5 + x).getCapacity() + '0');
				if (c == '9')
					c = 'S';
				System.out.print(s + " " + c + " | ");
			}
			System.out.println();
		}
		for (int i = 0; i < 29; i++)
			System.out.print("-");
	}
	
	/**
	 * A mezõk(Tile) létrehozásáért felelõs függvény.
	 * 5x5 Tile-t hoz létre a konfigurációnak megfelelõen, ahol minden Tile egy 3 számjegyû szám.
	 * Százas helyiérték: Mezõ típusa (0: jég | 1: instabil jég | 2: lyuk).
	 * Tizes: Mezõ teherbírása (ha jég, akkor 9, ha lyuk akkor 0).
	 * Egyes: Mezõn lévõ hórétegek száma.
	 * 
	 * @param confTiles Mezõk konfigurációs stringje.
	 */
	public void createTiles(String[] confTiles)
	{
		int [][] conf = new int[5][5];
		for (int y = 0; y < 5; y++) 
		{
			
			Scanner sc = new Scanner(confTiles[y]);
			for (int x = 0; x < 5; x++) 
			{
				conf[y][x] = sc.nextInt();
			}
		}
		
		for (int y = 0; y < 5; y++) 
		{
			for (int x = 0; x < 5; x++) 
			{
				switch (conf[y][x] / 100) {
				case 0:
					tiles.add(new Ice(9, conf[y][x] % 10));
					break;
					
				case 1:
					tiles.add(new Unstable(conf[y][x] / 10 % 10, conf[y][x] % 10));
					break;
					
				case 2:
					tiles.add(new Hole(0, conf[y][x] % 10));
					break;

				default:
					break;
				}
			}
		}
		
		for (int i = 0; i < 25; i++)
		{
			if(i < 5)
				tiles.get(i).setNeighbor(Direction.UP, null);
			else
				tiles.get(i).setNeighbor(Direction.UP, tiles.get(i-5));
			
			if(i % 5 == 4)
				tiles.get(i).setNeighbor(Direction.RIGHT, null);
			else
				tiles.get(i).setNeighbor(Direction.RIGHT, tiles.get(i+1));
			
			if(i > 19)
				tiles.get(i).setNeighbor(Direction.DOWN, null);
			else
				tiles.get(i).setNeighbor(Direction.DOWN, tiles.get(i+5));
			
			if(i % 5 == 0)
				tiles.get(i).setNeighbor(Direction.LEFT, null);
			else
				tiles.get(i).setNeighbor(Direction.LEFT, tiles.get(i-1));
		}
	}
	
	/**
	 * A tárgyak generálásáért felelõs.
	 * A kapott stringben 3 számjegyû számok vannak, ahol a százas helyérték a tárgy fajtája, a tizes-egyes a mezõ indexe ahova a tárgy karül.
	 * 
	 * @param confItems A tárgyak konfigurációs stringje.
	 */
	public void generateItems(String confItems)
	{
		Scanner sc = new Scanner(confItems);
		int i;
		while (sc.hasNext())
		{
			i = sc.nextInt();
			
			switch (i / 100) {
			case 1:
				tiles.get(i % 100).setItem(new Part());
				break;
				
			case 2:
				tiles.get(i % 100).setItem(new Food());
				break;
				
			case 3:
				tiles.get(i % 100).setItem(new Suit());
				break;
				
			case 4:
				tiles.get(i % 100).setItem(new Rope());
				break;
				
			case 5:
				tiles.get(i % 100).setItem(new Tent());
				break;
				
			case 6:
				tiles.get(i % 100).setItem(new Shovel());
				break;
				
			case 7:
				tiles.get(i % 100).setItem(new Wooden());
				break;
				
			default:
				break;
			}
		}
		
		
	}
	
	/**
	 * A bábuk létrehozásáért felelõs.
	 * A stringben lévõ szám meghatározza, hogy melyik mezõre kerüljenek a bábuk.
	 * Minden játékos 1 bábut kap.
	 * 
	 * @param confPieces A kezdõ mezõt tartalmazó string.
	 */
	public void spawnPieces(String confPieces)
	{
		int s = Integer.parseInt(confPieces);
		if (s < 0 || s > 24)
			s = 13;
		for (int i = 0; i < Game.getInstance().getnOfPlayers(); i++) {
			if (i % 2 == 0)
				pieces.add(new Explorer());
			else
				pieces.add(new Eskimo());
			pieces.get(i).setActionPoints(5);
			pieces.get(i).moved(tiles.get(s));
			Game.getInstance().getPlayers().get(i).setPiece(pieces.get(i));
			pieces.get(i).setColour(Game.getInstance().getPlayers().get(i).getColour());
		}
		bear = new Bear();
		bear.moved(tiles.get(0));
		
	}
	
	//getter - setterek -------------------------
	
	public ArrayList<Piece> getPieces() { return pieces; }
	
	public ArrayList<Tile> getTiles() { return tiles; }
	
	public ArrayList<Item> getItems() { return items; }
	
	public ArrayList<Tent> getTents() { return tents; }
	
	public Bear getBear() { return bear;	}
	
	public void setBear(Bear b) { bear = b; }
	
	//getter - setterek ---------vége------------

}
