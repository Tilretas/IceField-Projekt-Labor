package graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Piece Label-eket t�rol, amik 1-1 b�but jelen�tenek meg
 * 
 *
 */
public class PiecePanel extends JPanel
{
	private ArrayList<PieceLabel> pieces = new ArrayList<PieceLabel>();
	
	public void Draw(ArrayList<game.Piece> p) {
		
		pieces.clear();
		for (game.Piece piece : p) {
			PieceLabel temp = new PieceLabel(piece);
			pieces.add(temp);
			add(temp);
			temp.Draw();
		}
	}
}
