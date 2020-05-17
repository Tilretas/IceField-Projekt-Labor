package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import game.Player;


/**
 * Maga az ablak(frame), bal oldalán az action gombok, középen a mezõk, jobb oldalon a tárgyak
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
