package game;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Game game = Game.getInstance();
		game.startGame(4);
		Board board = game.getBoard();
		ArrayList<Tile> tiles = board.getTiles();
		board.drawBoard();
		
		tiles.get(8).setBear(true);
		tiles.get(3).setChecked(true);
		tiles.get(5).setItem(new Rope());
		Eskimo e = new Eskimo();
		tiles.get(21).movedOn(e);
		System.out.println("\n");
		board.drawBoard();
		System.out.print("\n" + e.getInWater());
		
		
		Suit s = new Suit();
		//e.setOnTile(tiles.get(21));
		e.setActionPoints(5);
		e.addItem(s);
		board.getPieces().get(0).addItem(new Rope());
		board.getPieces().get(0).addItem(new Suit());
		board.getPieces().get(0).addItem(new Wooden());
		board.getPieces().get(0).addItem(new Tent());
		board.getPieces().get(0).addItem(new Part());
		//e.useItem(s);
		board.drawBoard();
		System.out.println("\n");

		game.play();
		
	}
}
