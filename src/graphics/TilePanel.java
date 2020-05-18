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
		addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                Game.getInstance().TilePressed(tile);
            }
        });
	}
	
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
		pieceP.Draw(tile.getPieces(), tile.getSnow());
	}
	
	public void Refresh() {
		labelT.Refresh();
		pieceP.Draw(tile.getPieces(), tile.getSnow());
	}
}
