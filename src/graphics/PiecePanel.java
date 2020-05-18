package graphics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;

/**
 * Piece Label-eket t�rol, amik 1-1 b�but jelen�tenek meg
 */
public class PiecePanel extends JPanel
{
	/**
	 * A mez�kh�z tartoz� piece labelek t�rol�ja
	 */
	private ArrayList<PieceLabel> pieces = new ArrayList<PieceLabel>();
	
	/**
	 * A panelt kirajzol� f�ggv�ny
	 * @param p A b�bukat t�rol� lista
	 * @param s A h�r�teg m�rete
	 */
	public void Draw(ArrayList<game.Piece> p, int s) {
		removeAll();
		revalidate();
		repaint();
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
