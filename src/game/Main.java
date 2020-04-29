package game;

public class Main {
	public static void main(String[] args) {
		Game game = Game.getInstance();
		game.startGame(4);
		game.play();
		
	}
}
