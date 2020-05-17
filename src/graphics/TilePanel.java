package graphics;

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
	
	public void Draw() {
		labelT.Draw(tile);
		pieceP.Draw(tile.getPieces());
	}
}
