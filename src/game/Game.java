package game;

import java.util.ArrayList;

//singletonná kell tenni, idk how
public class Game
{
	private static final Game instance = new Game();
	
	private int nOfPlayers;
	private ArrayList<Player> players;
	private Board board;

    public static Game getInstance() 
    { 
        return instance; 
    } 
    
	public void setnOfPlayers(int nOfPlayers) {
		this.nOfPlayers = nOfPlayers;
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
	
	public void startGame()
	{
	}
	
	public void endGame(boolean win)
	{
	}
	
	public void notifyPlayerDied(Piece p)
	{
	}
	
	public void notifyWin()
	{
	}
	
	public void moveBear()
	{		
	}
	
	public void readFile(String s)
	{
	}
	
	public void snowStorm()
	{
	}
}
