package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import game.Player;


/**
 * Maga az ablak(frame), bal oldal�n az action gombok, k�z�pen a mez�k, jobb oldalon a t�rgyak
 * 
 *
 */
public class View extends JFrame
{
	private boolean valid;	
	private Player activePlayer;
	private ActionPanel actionPanel;
	private BoardPanel boardPanel;
	private ItemPanel itemPanel;
	
	public void Draw() 
	{
		actionPanel.Draw(this);
		boardPanel.Draw(this, game.Game.getInstance().getBoard().getTiles());
		itemPanel.Draw(this, activePlayer.getPiece().getInventory());
		
	}
	
	public void paintComponent(Graphics g)
	{
		
	}
	
	public void clear()
	{
		
	}
	
	public void validate()
	{
		
	}
}
