package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

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
	
	private JPanel panel;
	
	public View()
	{
		super("szeretem kapit <3");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		actionPanel = new ActionPanel();
		boardPanel = new BoardPanel();
		itemPanel = new ItemPanel();
		
		panel.add(actionPanel, BorderLayout.WEST);
		panel.add(boardPanel, BorderLayout.CENTER);
		panel.add(itemPanel, BorderLayout.EAST);
		panel.add(new JButton("Move"), BorderLayout.SOUTH);
		
		
		Draw();
		/*boardPanel.setMinimumSize(new java.awt.Dimension(500, 500));
		boardPanel.setBorder(BorderFactory.createEtchedBorder());
		boardPanel.setPreferredSize(new java.awt.Dimension(10, 10));
		boardPanel.setLayout(new java.awt.BorderLayout());
		boardPanel.add(new JButton(), BorderLayout.CENTER);*/
		/*actionPanel.setMinimumSize(new Dimension(50, 50));
		boardPanel.setMinimumSize(new Dimension(50, 50));
		itemPanel.setMinimumSize(new Dimension(50, 50));
		actionPanel.setPreferredSize(new Dimension(50, 50));
		boardPanel.setPreferredSize(new Dimension(50, 50));
		itemPanel.setPreferredSize(new Dimension(50, 50));*/
		
		add(panel);
		setLocation(750, 315);
        setMinimumSize(new Dimension(350, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
	}
	
	public void init()
	{
		//setLayout(new BorderLayout());
		

	}
	
	public void Draw() 
	{
		actionPanel.Draw(this);
		//boardPanel.Draw(this, game.Game.getInstance().getBoard().getTiles());
		//itemPanel.Draw(this, activePlayer.getPiece().getInventory());
		
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
