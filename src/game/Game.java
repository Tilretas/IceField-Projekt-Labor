package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import graphics.Action;
import graphics.Inventory;
import graphics.View;

public class Game
{
	private static final Game instance = new Game();
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private int nOfPlayers;
	private Board board;
	public boolean stop;
	public boolean testStart;
	private Test test;
	
	private View view;
	private Player activePlayer;
	private int playerIdx;
	private Action activeAction = null;
	private Inventory activeItem;

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
	 * A k�r�k�rt felel�s f�ggv�ny.
	 * Addig megy, am�g nem nyernek vagy vesz�tenek a j�t�kosok, vagy a 0 paranccsal nem l�pnek ki. 
	 */
	public void play()
	{
		stop = false;
		int p = 0;
		while(!stop) 
		{
			//players.get(p).playerInput();
			p++;
			if(p >= nOfPlayers)
			{
				endRound();
				p = 0;
			}
		}
		if(testStart)
		{
			testMode();
		}
	}
	
	/**
	 * A tesztm�d elind�t�s��rt felel�s f�ggv�ny.
	 */
	public void testMode()
	{
		test = new Test();
		if(test.run())
			play();
	}
	
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
		stop = true;
		testStart = false;
		
		if(win)
			System.out.println("\nYou survived. WoW!");
		else
			System.out.println("\nSomeone died :( \nThe Coffin Dancers are on their way...");
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
		if(activeAction != null)
			activePlayer.playerInput(t, activeAction);
	}
	
	public void NextPlayer() {
		playerIdx++;
		if(playerIdx >= nOfPlayers)
			playerIdx = 0;
		activePlayer = players.get(playerIdx);
		activePlayer.YourTurn();
		view.Refresh();
	}

	//getter - setterek -------------------------

	public int getnOfPlayers() { return nOfPlayers; }
	
	public ArrayList<Player> getPlayers() {	return players;	}
	
	public Board getBoard() { return board; }
	
	public boolean getTestStart() { return testStart; }
	
	public View getView() { return view; }
	
	public void setView(View v) { view = v; }
	
	public void setActiveAction(Action ac) { activeAction = ac;}
	
	public void setActiveItem(Inventory ai) { activeItem = ai;}
	
	public void setActivePlayer(Player p) { activePlayer = p; }
	
	public Player getActivePlayer() { return activePlayer; }

	//getter - setterek ---------v�ge------------
}

