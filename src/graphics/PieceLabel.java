package graphics;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import game.Colour;
import game.Game;
import game.Piece;

/**
 * Egy b�bu k�p�t megjelen�t� Label
 */
public class PieceLabel extends JLabel{
	/**
	 * A b�bu melynek a k�p�t megjelen�tj�k
	 */
	private Piece piece;
	/**
	 * A b�bu sz�ne, mivel a megfelel� sz�n� b�but kell megjelen�teni
	 */
	private Colour colour;
	/**
	 * A megjelen�tett k�p ikonk�nt
	 */
	private ImageIcon icon;
	
	
	/**
	 * Konstruktor, mely egy b�but kap �s be�ll�tja annak adatait
	 * @param p A b�bu melyhez l�trehozzuk a labelt
	 */
	public PieceLabel(game.Piece p) 
	{
		piece = p;
		colour = p.getColour();
		
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent evt) {
				Game.getInstance().PiecePressed(piece);
			}
		});
	}
	
	/**
	 * Kirajzolja a b�bu t�pus�hoz megfelel� k�pet
	 */
	public void Draw() 
	{
		setIcon(new ImageIcon(new ImageIcon("Images/" + piece.getType() + colour + ".png").getImage().getScaledInstance(15, 30, Image.SCALE_SMOOTH)));
	}
}
