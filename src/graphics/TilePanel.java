package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import game.Tile;

/**
 * 1 mez�nek megfelel� panel
 * TileLabel ben jelenik meg a mez� iconja
 * PiecePanelben vannak a b�buk
 */
public class TilePanel extends JPanel
{	
	private Tile tile;
	private TileLabel labelT;
	private PiecePanel pieceP;
	
	public TilePanel(Tile t) {
		tile = t;
	}
	
	public void Draw(JPanel ip) {
		setLayout(new BorderLayout());
		
		labelT = new TileLabel();
		labelT.setMinimumSize(new Dimension(50, 50));
		add(labelT, BorderLayout.CENTER);
		pieceP = new PiecePanel();
		add(pieceP, BorderLayout.SOUTH);
		
		labelT.Draw(tile);
		pieceP.Draw(tile.getPieces());
	}
	
	public void Refresh() { labelT.Refresh(); }
}
