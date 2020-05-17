package graphics;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A mezõket tároló panel
 * 25 db panelként tárolja õket
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
