package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import game.Game;



/**
 * Maga az ablak(frame), bal oldal�n az action gombok, k�z�pen a mez�k, jobb oldalon a t�rgyak
 * Tov�bb� tartozik hozz� egy statisztik�kat ki�r� panel
 */
public class View extends JFrame
{
	/**
	 * Az ablak bal oldal�n tal�lhat� panel, ami az akci�khoz tartozik
	 */
	private ActionPanel actionPanel;
	/**
	 * A f� panel, a mez�k megjelen�t�s��rt felel�s
	 */
	private BoardPanel boardPanel;
	/**
	 * Az adott b�bun�l tal�lhat� itemeket megjelen�t� panel
	 */
	private ItemPanel itemPanel;
	/**
	 * Az adott b�bu statisztik�it megjelen�t� panel
	 */
	private StatPanel statPanel;
	/**
	 * Panel, amit �j panelek l�trehoz�s�ra haszn�lunk
	 */
	private JPanel panel;

	/**
	 * Konstruktor, amely be�ll�tja a j�t�kot �s megjelen�ti grafikusan azt
	 */
	public View()
	{
		super("Council of the Dark Eskimoes");
		Game.getInstance().setView(this);
		init();
	}
	
	/**
	 * Inicializ�l� f�ggv�ny
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
	 * Kirajzol� f�ggv�ny, amely megh�vja az alpanelek kirajzol� f�ggv�nyeit
	 */
	public void Draw() 
	{
		actionPanel.Draw(this);
		boardPanel.Draw(this, Game.getInstance().getBoard().getTiles());
		itemPanel.Draw(this, Game.getInstance().getActivePlayer().getPiece().getInventory());
		statPanel.Draw();
	}
	
	/**
	 * A grafikus fel�let megjelen�t�s�t friss�t� fel�let
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
