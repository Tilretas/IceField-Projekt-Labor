package game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A t�bl�t kezel� oszt�ly
 */
public class Board
{
	/**
	 * B�bukat tartalmaz� lista
	 */
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	/**
	 * A mez�ket tartalmaz� lista
	 */
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	/**
	 * Eszk�z�ket tartalmaz� lista
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * S�trakat tartalmaz� lista
	 */
	private ArrayList<Tent> tents = new ArrayList<Tent>();
	/**
	 * V�ltoz� a medv�re
	 */
	private Bear bear;

	/**
	 * A t�bla el�k�sz�t�s��rt, �s a rajta l�v� elemek beolvas�s��rt felel�s.
	 * Stringekbe t�rolja a beolvasott inform�c�t
	 * 
	 * @param setupFile A txt c�me, ahonnan beolvassa a p�lya fel�p�t�s�t
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
	 * A t�bla konzolra val� ki�r�s��rt felel�s f�ggv�ny.
	 * 5x5 mez� van, minden mez� 2x2 karakternek felel meg.
	 * Bal fels� �rt�k: a mez�n l�v� j�t�kosok sz�m�t jelzi (ha medve van a mez�n, akkor 'B', ha iglu 'I', ha s�tor akkor 'T').
	 * Jobb fels�: A mez�n l�v� t�rgy kezd�bet�je.
	 * Bal als�: A mez�n l�v� h�r�tegek sz�ma.
	 * Jobb als�: A mez� kapacit�sa ('X' ha ismeretlen, 'S' ha stabil, '0' ha lyuk).
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
	 * A mez�k(Tile) l�trehoz�s��rt felel�s f�ggv�ny.
	 * 5x5 Tile-t hoz l�tre a konfigur�ci�nak megfelel�en, ahol minden Tile egy 3 sz�mjegy� sz�m.
	 * Sz�zas helyi�rt�k: Mez� t�pusa (0: j�g | 1: instabil j�g | 2: lyuk).
	 * Tizes: Mez� teherb�r�sa (ha j�g, akkor 9, ha lyuk akkor 0).
	 * Egyes: Mez�n l�v� h�r�tegek sz�ma.
	 * 
	 * @param confTiles Mez�k konfigur�ci�s stringje.
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
	 * A t�rgyak gener�l�s��rt felel�s.
	 * A kapott stringben 3 sz�mjegy� sz�mok vannak, ahol a sz�zas hely�rt�k a t�rgy fajt�ja, a tizes-egyes a mez� indexe ahova a t�rgy kar�l.
	 * 
	 * @param confItems A t�rgyak konfigur�ci�s stringje.
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
	 * A b�buk l�trehoz�s��rt felel�s.
	 * A stringben l�v� sz�m meghat�rozza, hogy melyik mez�re ker�ljenek a b�buk.
	 * Minden j�t�kos 1 b�but kap.
	 * 
	 * @param confPieces A kezd� mez�t tartalmaz� string.
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
	
	//getter - setterek ---------v�ge------------

}
