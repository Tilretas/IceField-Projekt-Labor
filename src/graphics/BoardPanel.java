package graphics;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A mez�ket t�rol� panel
 * 25 db panelk�nt t�rolja �ket
 *
 */
public class BoardPanel extends JPanel{
	private ArrayList<TilePanel> tilePanels = new ArrayList<TilePanel>(); //25 db
	
	public void Draw(JFrame view, ArrayList<game.Tile> tiles) {
		for (game.Tile tile : tiles) {
			TilePanel temp = new TilePanel(tile);
			tilePanels.add(temp);
			temp.Draw(this);
		}
	}

}
