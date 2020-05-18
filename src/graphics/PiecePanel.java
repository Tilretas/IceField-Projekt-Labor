package graphics;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Piece Label-eket t�rol, amik 1-1 b�but jelen�tenek meg
 * 
 *
 */
public class PiecePanel extends JPanel
{
	private ArrayList<PieceLabel> pieces = new ArrayList<PieceLabel>();
	
	public void Draw(ArrayList<game.Piece> p, int s) {
		removeAll();
		pieces.clear();
		setBackground(new Color(231, 249, 251));
		add(new JLabel(Integer.toString(s)));
		for (game.Piece piece : p) {
			PieceLabel temp = new PieceLabel(piece);
			pieces.add(temp);
			add(temp);
			temp.Draw();
		}
	}
}
