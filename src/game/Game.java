package game;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import graphics.Action;
import graphics.View;

public class Game
{
	private static final Game instance = new Game();
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private int nOfPlayers;
	private Board board;
	public boolean gameEnd;
	public boolean testStart;
	
	private View view;
	private Player activePlayer;
	private int playerIdx;
	private Action activeAction = null;
	private Item activeItem;

	/**
	 * Visszaadja a játék instance-ét
	 * 
	 * @return A játék példánya
	 */
    public static Game getInstance() { return instance; } 
    
	public void initGame(int n)
	{
		nOfPlayers = n;
		for (int i = 0; i < n; i++) {
			players.add(new Player(Colour.values()[i]));
		}
		playerIdx = 0;
		activePlayer = players.get(playerIdx);
		
		board = new Board();
		try {
			board.initBoard("testmap.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * A tesztmód elindításáért felelõs függvény.
	 */
	/*public void testMode()
	{
		test = new Test();
		if(test.run())
			//play();
	}*/
	
	/**
	 * Minden kör végén meghívódik (amikor minden játékos elhasználta az akciópontjait).
	 * 25% eséllyel lesz hóvihar.
	 * A medve egy szomszédos mezõre lép.
	 */
	public void endRound()
	{
		Random r = new Random();
		int x = r.nextInt(4);
		if(x == 0)
			snowStorm();
		moveBear();
		for (Tent t : board.getTents()) 
			t.destroy();
		board.getTents().clear();
	}
	
	/**
	 * A játék végéért felelõs függvény.
	 * Közli a játékosokkal a játék kimenetelét.
	 * 
	 * @param win Átadja, hogy nyertek-e a játékosok.
	 */
	public void endGame(boolean win)
	{
		gameEnd = true;
		if(win)
		{
			instance.setText("\nYou survived. WoW!");
			instance.getView().getStatPanel().setBackground(Color.GREEN);
		}
		else
		{
			instance.setText("Someone died :( \nThe Coffin Dancers are on their way...");
			instance.getView().getStatPanel().setBackground(Color.RED);
		}
	}
	
	/**
	 * Ezen a függvényen keresztül értesül a játék egy bábu haláláról.
	 * @param p A meghalt bábu.
	 */
	public void notifyPlayerDied(Piece p)
	{
		endGame(false);
	}
	
	/**
	 * Ezen a függvényen keresztül értesül a játék a játékosok gyõzelmérõl.
	 */
	public void notifyWin()
	{
		endGame(true);
	}
	
	/**
	 * A medve mozgatásáért felelõs.
	 * Egy random kiválasztott szomszédos mezõre lép.
	 */
	public void moveBear()
	{
		Random r = new Random();
		int x;
		Bear b = board.getBear();
		while (b.getTile().getNeighbor(Direction.values()[x = r.nextInt(4)]) == null);
		b.moved(b.getTile().getNeighbor(Direction.values()[x]));
	}
	
	/**
	 * Hóviharért felelõs.
	 * Minden mezõre kerül egy réteg hó.
	 * A nem fedett játékosok veszítenek egy testhõt.
	 */
	public void snowStorm()
	{
		for(Tile t : board.getTiles())
    	{
    		t.addSnow();
    	}
    	for(Piece p : board.getPieces())
    	{
    		if(p.getTile().getShelter() == null)
    		{
    			p.decBodyTemp();
    			if(p.getBodyTemp() <= 0)
    				p.die();
    		}
    	}  
	}
	
	public void TilePressed(Tile t) 
	{
		if(gameEnd) {
			view.setVisible(false);
			view.dispose();
		}
		if(activeAction != null)
			activePlayer.playerInput(t, activeAction);
	}
	
	public void PiecePressed(Piece p)
	{
		if(activeItem.getClass().equals(new Rope().getClass()) && activeAction == Action.UseItem)
			new Rope().savePiece(activePlayer.getPiece(), p);
		view.Refresh();
	}
	
	public void NextPlayer() {
		playerIdx++;
		if(playerIdx >= nOfPlayers) {
			playerIdx = 0;
			endRound();
		}
		activeItem = null;
		activePlayer = players.get(playerIdx);
		activePlayer.YourTurn();
		view.Refresh();
	}
	
	public void setText(String s)
	{
		getView().getStatPanel().settext_area(s);
	}

	//getter - setterek -------------------------

	public int getnOfPlayers() { return nOfPlayers; }
	
	public ArrayList<Player> getPlayers() {	return players;	}
	
	public Board getBoard() { return board; }
	
	public boolean getTestStart() { return testStart; }
	
	public View getView() { return view; }
	
	public void setView(View v) { view = v; }
	
	public void setActiveAction(Action ac) { activeAction = ac;}
	
	public void setActiveItem(Item ai) { activeItem = ai;}
	
	public void setActivePlayer(Player p) { activePlayer = p; }
	
	public Player getActivePlayer() { return activePlayer; }
	
	public Item getActiveItem() { return activeItem; }

	//getter - setterek ---------vége------------
}

