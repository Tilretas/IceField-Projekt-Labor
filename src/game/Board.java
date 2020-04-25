package game;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class Board
{
	private ArrayList<Piece> pieces;
	private ArrayList<Tile> tiles;
	private ArrayList<Item> items;
	private Bear bear;
	
	public void initBoard(File setup)
	{
		String confTiles[];
		String [] confItems;
		String [] confPieces;


	}
	
	public void drawBoard() // ! medvét még nem rajzolja, mindig mutatja a teherbírást !
	{	
		for (int y = 0; y < 5; y++) {
			System.out.println();
			for (int x = 0; x < 5; x++) {
				int s = tiles.get(y*5 + x).getSnow();
				int p = tiles.get(y*5 + x).getPlayers().size();
				System.out.print(s + p + "  ");
			}
			
			System.out.println();
			for (int x = 0; x < 5; x++) {
				char i = 'X';
				if (tiles.get(y*5 + x).getItem() != null)
					i = tiles.get(y*5 + x).getItem().getName();
				
				int c = tiles.get(y*5 + x).getCapacity();
				System.out.print(i + c + "  ");
			}
		}
	}
	
	public void createTiles(String[] confTiles)
	{
	}
	
	public void generateItems(String[] confItems)
	{
	}
	
	public void spawnPieces(String[] confPieces)
	{
	}
}
