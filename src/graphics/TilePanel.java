package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import game.Game;
import game.Tile;

/**
 * Egy mezõt tároló panel
 * TileLabel ben jelenik meg a mezõ iconja
 * PiecePanelben vannak a bábuk
 */
public class TilePanel extends JPanel
{	
	/**
	 * A mezõ amihez a Panel tartozik
	 */
	private Tile tile;
	/*
	 * A Label, amiben megjelenítjük a mezõ ikonját
	 */
	private TileLabel labelT;
	/**
	 * A mezõhöz tartozó Panel, amelyen a bábukat jelenítjük meg
	 */
	private PiecePanel pieceP;
	
	/**
	 * Konstruktor, amely beállítja a mezõt
	 * @param t A mezõ amihez a Panel tartozik
	 */
	public TilePanel(Tile t) {
		tile = t;
		addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                Game.getInstance().TilePressed(tile);
            }
        });
	}
	
	/**
	 * A Panelt kirajzoló függvény
	 */
	public void Draw(JPanel ip) {
		setLayout(new BorderLayout());
		setBackground(new Color(231, 249, 251));
		setBorder(javax.swing.BorderFactory.createEtchedBorder());
		labelT = new TileLabel();
		labelT.setMinimumSize(new Dimension(50, 50));
		add(labelT, BorderLayout.CENTER);
		pieceP = new PiecePanel();
		add(pieceP, BorderLayout.SOUTH);
		
		labelT.Draw(tile);
		int c = -1;
		if(tile.getChecked())
			c = tile.getCapacity();
		pieceP.Draw(tile.getPieces(), tile.getSnow(), c);
	}
	
	/**
	 * Frissítõ függvény, a megváltozott állapotra változtatja a Label képét
	 */
	public void Refresh() {
		labelT.Refresh();
		int c = -1;
		if(tile.getChecked())
			c = tile.getCapacity();
		pieceP.Draw(tile.getPieces(), tile.getSnow(), c);
	}

}
