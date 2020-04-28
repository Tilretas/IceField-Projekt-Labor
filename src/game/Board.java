package game;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Board
{
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private Bear bear;
	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Bear getBear() {
		return bear;
	}

	public void setBear(Bear bear) {
		this.bear = bear;
	}

	public void initBoard(String setupFile) throws IOException
	{
		String [] confTiles = new String[5];
		String confPieces;
		String confItems;

		FileInputStream fstream = new FileInputStream("testmap.txt");
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
	
	public void drawBoard()
	{	
		for (int y = 0; y < 5; y++) {
			
			for (int i = 0; i < 29; i++)
				System.out.print("-");
			System.out.println();
			
			for (int x = 0; x < 5; x++) {
				
				char i = 'X';
				if (tiles.get(y*5 + x).getItem() != null)
					i = tiles.get(y*5 + x).getItem().getName();
				char p = (char) (tiles.get(y*5 + x).getPieces().size() + '0');
				if (p == '0')
					p = 'X';
				if (tiles.get(y*5 + x).getBear())
					p = 'B';
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
	
	public void generateItems(String confItems)
	{
		Scanner sc = new Scanner(confItems);
		int i;
		while (sc.hasNext()) //nem szép emgoldás, de csak így tudtam
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
	
	public void spawnPieces(String confPieces)
	{
		int s = Integer.parseInt(confPieces);
		if (s < 0 || s > 24)
			s = 13;
		for (int i = 0; i < Game.getInstance().getnOfPlayers(); i++) {
			if (i % 2 == 0)
				pieces.add(new Eskimo());
			else
				pieces.add(new Explorer());
			pieces.get(i).setActionPoints(5);
			pieces.get(i).moved(tiles.get(s));
			Game.getInstance().getPlayers().get(i).setPiece(pieces.get(i));
		}
	}
}
