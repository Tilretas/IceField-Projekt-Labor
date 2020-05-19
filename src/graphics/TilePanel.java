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
 * Egy mez�t t�rol� panel
 * TileLabel ben jelenik meg a mez� iconja
 * PiecePanelben vannak a b�buk
 */
public class TilePanel extends JPanel
{	
	/**
	 * A mez� amihez a Panel tartozik
	 */
	private Tile tile;
	/*
	 * A Label, amiben megjelen�tj�k a mez� ikonj�t
	 */
	private TileLabel labelT;
	/**
	 * A mez�h�z tartoz� Panel, amelyen a b�bukat jelen�tj�k meg
	 */
	private PiecePanel pieceP;
	
	/**
	 * Konstruktor, amely be�ll�tja a mez�t
	 * @param t A mez� amihez a Panel tartozik
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
	 * A Panelt kirajzol� f�ggv�ny
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
	 * Friss�t� f�ggv�ny, a megv�ltozott �llapotra v�ltoztatja a Label k�p�t
	 */
	public void Refresh() {
		labelT.Refresh();
		int c = -1;
		if(tile.getChecked())
			c = tile.getCapacity();
		pieceP.Draw(tile.getPieces(), tile.getSnow(), c);
	}

}
