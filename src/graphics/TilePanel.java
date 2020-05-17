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
	private TileLabel label;
	private PiecePanel pieceP;
	
	public void Draw() {
		pieceP.Draw(tile.getPieces());
	}
}
