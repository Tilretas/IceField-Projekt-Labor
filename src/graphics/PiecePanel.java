package graphics;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Piece Label-eket tárol, amik 1-1 bábut jelenítenek meg
 */
public class PiecePanel extends JPanel
{
	/**
	 * A mezõkhöz tartozó piece labelek tárolója
	 */
	private ArrayList<PieceLabel> pieces = new ArrayList<PieceLabel>();
	
	/**
	 * A panelt kirajzoló függvény
	 * @param p A bábukat tároló lista
	 * @param s A hóréteg mérete
	 */
	public void Draw(ArrayList<game.Piece> p, int s, int c) {
		removeAll();
		revalidate();
		repaint();
		pieces.clear();
		setBackground(new Color(231, 249, 251));
		add(new JLabel(Integer.toString(s)));
		if(c != -1) {
			if(c == 9)
				add(new JLabel("| S"));
			else
			add(new JLabel("| " + Integer.toString(c)));
		}
		for (game.Piece piece : p) {
			PieceLabel temp = new PieceLabel(piece);
			pieces.add(temp);
			add(temp);
			temp.Draw();
		}
	}
}
