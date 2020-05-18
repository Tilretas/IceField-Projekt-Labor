package game;
import java.io.IOException;

import graphics.*;

public class Main {
	public static void main(String[] args) {
		
		/*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NetBeansCopy().setVisible(true);
            }
        });   */     
		
		Game game = Game.getInstance(); 
		game.initGame(4);

		new View();
		
		
		/*
		game.startGame(4);
		game.play();*/
		
	}
}
