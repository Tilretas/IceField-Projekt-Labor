package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game
{
	private static final Game instance = new Game();
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private int nOfPlayers;
	private Board board;
	public boolean stop;
	public boolean testStart;
	private Test test;

    public static Game getInstance() 
    { 
        return instance; 
    } 
    
	public void startGame(int n)
	{
		nOfPlayers = n;
		for (int i = 0; i < n; i++) {
			players.add(new Player(Colour.values()[i]));
		}
		
		board = new Board();
		try {
			board.initBoard("testmap");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void play()
	{
		stop = false;
		int p = 0;
		while(!stop) 
		{
			players.get(p).playerInput();
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
	
	public void testMode()
	{
		test = new Test();
		test.run();
	}
	
	public void endRound()
	{
		Random r = new Random();
		int x = r.nextInt(10);
		if(x == 0)
			snowStorm();
		moveBear();
		for (Tent t : board.getTents()) 
			t.destroy();
		board.getTents().clear();
	}
	
	public void endGame(boolean win)
	{
		stop = true;
		testStart = false;
		
		if(win)
			System.out.println("\nYou survived. WoW!");
		else
			System.out.println("\nSomeone died :( \nThe Coffin Niggas are on their way...");
	}
	
	public void notifyPlayerDied(Piece p)
	{
		endGame(false);
	}
	
	public void notifyWin()
	{
		endGame(true);
	}
	
	public void moveBear()
	{
		Random r = new Random();
		int x;
		Bear b = board.getBear();
		while (b.getTile().getNeighbor(Direction.values()[x = r.nextInt(4)]) == null);
		b.moved(b.getTile().getNeighbor(Direction.values()[x]));
	}
	
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

	public int getnOfPlayers() { return nOfPlayers; }
	
	public ArrayList<Player> getPlayers() {	return players;	}
	
	public Board getBoard() { return board; }
}

