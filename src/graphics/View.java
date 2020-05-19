package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import game.Game;



/**
 * Maga az ablak(frame), bal oldalán az action gombok, középen a mezõk, jobb oldalon a tárgyak
 * Továbbá tartozik hozzá egy statisztikákat kiíró panel
 */
public class View extends JFrame
{
	/**
	 * Az ablak bal oldalán található panel, ami az akciókhoz tartozik
	 */
	private ActionPanel actionPanel;
	/**
	 * A fõ panel, a mezõk megjelenítéséért felelõs
	 */
	private BoardPanel boardPanel;
	/**
	 * Az adott bábunál található itemeket megjelenítõ panel
	 */
	private ItemPanel itemPanel;
	/**
	 * Az adott bábu statisztikáit megjelenítõ panel
	 */
	private StatPanel statPanel;
	/**
	 * Panel, amit új panelek létrehozására használunk
	 */
	private JPanel panel;

	/**
	 * Konstruktor, amely beállítja a játékot és megjeleníti grafikusan azt
	 */
	public View()
	{
		super("Council of the Dark Eskimoes");
		Game.getInstance().setView(this);
		init();
	}
	
	/**
	 * Inicializáló függvény
	 */
	public void init()
	{
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		actionPanel = new ActionPanel();
		boardPanel = new BoardPanel();
		itemPanel = new ItemPanel();
		statPanel = new StatPanel();
		
		actionPanel.setBackground(new Color(91, 92, 110));
		itemPanel.setBackground(new Color(91, 92, 110));

		
		panel.add(actionPanel, BorderLayout.WEST);
		panel.add(boardPanel, BorderLayout.CENTER);
		panel.add(itemPanel, BorderLayout.EAST);
		panel.add(statPanel, BorderLayout.SOUTH); 
		
		actionPanel.setMinimumSize(new Dimension(100, 700));
		itemPanel.setMinimumSize(new Dimension(100, 700));

		Draw();
		add(panel);
		setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

	}
	
	/**
	 * Kirajzoló függvény, amely meghívja az alpanelek kirajzoló függvényeit
	 */
	public void Draw() 
	{
		actionPanel.Draw(this);
		boardPanel.Draw(this, Game.getInstance().getBoard().getTiles());
		itemPanel.Draw(this, Game.getInstance().getActivePlayer().getPiece().getInventory());
		statPanel.Draw();
	}
	
	/**
	 * A grafikus felület megjelenítését frissítõ felület
	 */
	public void Refresh() 
	{
		boardPanel.Refresh();
		itemPanel.Draw(this, Game.getInstance().getActivePlayer().getPiece().getInventory());
		statPanel.Refresh();
	}

	public StatPanel getStatPanel() 
	{
		return statPanel;
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
