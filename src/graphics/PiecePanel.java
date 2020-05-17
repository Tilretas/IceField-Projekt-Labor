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
	
	public void Draw(ArrayList<game.Piece> p) {
		pieces.clear();
		for (game.Piece piece : p) {
			
			//pieces.add(p);
		}
	}
}
