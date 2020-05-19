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
	 * Visszaadja a j�t�k instance-�t
	 * 
	 * @return A j�t�k p�ld�nya
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
	 * A tesztm�d elind�t�s��rt felel�s f�ggv�ny.
	 */
	/*public void testMode()
	{
		test = new Test();
		if(test.run())
			//play();
	}*/
	
	/**
	 * Minden k�r v�g�n megh�v�dik (amikor minden j�t�kos elhaszn�lta az akci�pontjait).
	 * 25% es�llyel lesz h�vihar.
	 * A medve egy szomsz�dos mez�re l�p.
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
	 * A j�t�k v�g��rt felel�s f�ggv�ny.
	 * K�zli a j�t�kosokkal a j�t�k kimenetel�t.
	 * 
	 * @param win �tadja, hogy nyertek-e a j�t�kosok.
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
	 * Ezen a f�ggv�nyen kereszt�l �rtes�l a j�t�k egy b�bu hal�l�r�l.
	 * @param p A meghalt b�bu.
	 */
	public void notifyPlayerDied(Piece p)
	{
		endGame(false);
	}
	
	/**
	 * Ezen a f�ggv�nyen kereszt�l �rtes�l a j�t�k a j�t�kosok gy�zelm�r�l.
	 */
	public void notifyWin()
	{
		endGame(true);
	}
	
	/**
	 * A medve mozgat�s��rt felel�s.
	 * Egy random kiv�lasztott szomsz�dos mez�re l�p.
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
	 * H�vihar�rt felel�s.
	 * Minden mez�re ker�l egy r�teg h�.
	 * A nem fedett j�t�kosok vesz�tenek egy testh�t.
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

	//getter - setterek ---------v�ge------------
}

