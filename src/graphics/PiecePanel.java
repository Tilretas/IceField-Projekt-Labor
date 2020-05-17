package graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Piece Label-eket tárol, amik 1-1 bábut jelenítenek meg
 * 
 *
 */
public class PiecePanel extends JPanel
{
	private ArrayList<PieceLabel> pieces;
	
	public void Draw(JPanel tp, ArrayList<game.Piece> p) {
		pieces.clear();
		for (game.Piece piece : p) {
			PieceLabel temp = new PieceLabel(piece);
			pieces.add(temp);
			temp.Draw(this);
		}
	}
}
