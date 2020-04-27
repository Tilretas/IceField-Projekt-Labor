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
		int [][] confTiles = new int[5][5];
		String confPieces;
		String confItems;

		FileInputStream fstream = new FileInputStream("testmap.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String line;
		
		for (int y = 0; y < 5; y++) 
		{
			line = br.readLine();
			Scanner sc = new Scanner(line);
			for (int x = 0; x < 5; x++) 
			{
				confTiles[y][x] = sc.nextInt();
			}
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
				int s = tiles.get(y*5 + x).getSnow();
				char p = (char) (tiles.get(y*5 + x).getPlayers().size() + '0');
				if (p == '0')
					p = 'X';
				if (tiles.get(y*5 + x).getBear())
					p = 'B';
				System.out.print(s + " " + p + " | ");
			}
			
			System.out.println("");
			for (int x = 0; x < 5; x++) {
				char i = 'X';
				char c = 'X';
				if (tiles.get(y*5 + x).getItem() != null)
					i = tiles.get(y*5 + x).getItem().getName();
				if(tiles.get(y*5 + x).getChecked())
					c = (char) (tiles.get(y*5 + x).getCapacity() + '0');
				System.out.print(i + " " + c + " | ");
			}
			System.out.println();
		}
		for (int i = 0; i < 29; i++)
			System.out.print("-");
	}
	
	public void createTiles(int[][] confTiles)
	{
		for (int y = 0; y < 5; y++) 
		{
			for (int x = 0; x < 5; x++) 
			{
				switch (confTiles[y][x] / 100) {
				case 0:
					tiles.add(new Ice(9, confTiles[y][x] % 10));
					break;
					
				case 1:
					tiles.add(new Unstable(confTiles[y][x] / 10 % 10, confTiles[y][x] % 10));
					break;
					
				case 2:
					tiles.add(new Hole(0, confTiles[y][x] % 10));
					break;

				default:
					break;
				}
			}
		}
	}
	
	public void generateItems(String confItems)
	{
	}
	
	public void spawnPieces(String confPieces)
	{
	}
}
