package game;

import java.io.IOException;
import java.util.ArrayList;

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
    
	public void setnOfPlayers(int n) {
		nOfPlayers = n;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getnOfPlayers() {
		return nOfPlayers;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Board getBoard() {
		return board;
	}
	
	public void startGame(int n)
	{
		nOfPlayers = n;
		for (int i = 0; i < n; i++) {
			players.add(new Player());
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
			board.drawBoard();
			players.get(p).playerInput();
			p++;
			if(p >= nOfPlayers)
				p = 0;
		}
		if(testStart)
		{
			test = new Test();
			test.run();
		}
	}
	
	public void endGame(boolean win)
	{
	}
	
	public void notifyPlayerDied(Piece p)
	{
	}
	
	public void notifyWin()
	{
		System.out.println("VICTORY");
	}
	
	public void moveBear()
	{		
	}
	
	public void readFile(String s)
	{
	}
	
	public void snowStorm()
	{
		for(Tile t : board.getTiles())
    	{
    		t.addSnow();
    	}
    	for(Piece p : board.getPieces())
    	{
    		p.decBodyTemp();
    	}  
	}
}
