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
 * Egy bábu képét megjelenítõ Label
 */
public class PieceLabel extends JLabel{
	/**
	 * A bábu melynek a képét megjelenítjük
	 */
	private Piece piece;
	/**
	 * A bábu színe, mivel a megfelelõ színû bábut kell megjeleníteni
	 */
	private Colour colour;
	/**
	 * A megjelenített kép ikonként
	 */
	private ImageIcon icon;
	
	
	/**
	 * Konstruktor, mely egy bábut kap és beállítja annak adatait
	 * @param p A bábu melyhez létrehozzuk a labelt
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
	 * Kirajzolja a bábu típusához megfelelõ képet
	 */
	public void Draw() 
	{
		setIcon(new ImageIcon(new ImageIcon("Images/" + piece.getType() + colour + ".png").getImage().getScaledInstance(15, 30, Image.SCALE_SMOOTH)));
	}
}
