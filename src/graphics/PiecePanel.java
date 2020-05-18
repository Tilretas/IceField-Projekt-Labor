package graphics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;

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
