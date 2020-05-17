package graphics;

import javax.swing.JPanel;

import game.Tile;

/**
 * 1 mezõnek megfelelõ panel
 * TileLabel ben jelenik meg a mezõ iconja
 * PiecePanelben vannak a bábuk
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
