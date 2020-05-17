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
	private TileLabel labelT;
	private PiecePanel pieceP;
	
	public TilePanel(Tile t) {
		tile = t;
	}
	
	public void Draw(JPanel ip) {
		labelT.Draw(this, tile);
		pieceP.Draw(this, tile.getPieces());
	}
}
