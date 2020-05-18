package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import game.Game;
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
		init();
	}
	
	public void init()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		activePlayer = Game.getInstance().getPlayers().get(0);
		
		actionPanel = new ActionPanel();
		boardPanel = new BoardPanel();
		itemPanel = new ItemPanel();
		
		panel.add(actionPanel, BorderLayout.WEST);
		panel.add(boardPanel, BorderLayout.CENTER);
		panel.add(itemPanel, BorderLayout.EAST);
		
		actionPanel.setMinimumSize(new Dimension(100, 700));
		itemPanel.setMinimumSize(new Dimension(100, 700));

		Draw();
		add(panel);
		setLocation(500, 200);
        //setMinimumSize(new Dimension(700, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

	}
	
	public void Draw() 
	{
		actionPanel.Draw(this);
		boardPanel.Draw(this, game.Game.getInstance().getBoard().getTiles());
		itemPanel.Draw(this, activePlayer.getPiece().getInventory());
		
	}
	/*
	public void paintComponent(Graphics g)
	{
		
	}
	
	public void clear()
	{
		
	}
	
	public void validate()
	{
		
	}*/

}
