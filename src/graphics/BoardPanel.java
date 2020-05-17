package graphics;

import java.util.ArrayList;

/**
 * A mezõket tároló panel
 * 25 db panelként tárolja õket
 *
 */
public class BoardPanel {
	private ArrayList<TilePanel> tilePanels = new ArrayList<TilePanel>(); //25 db
	
	public void Draw(ArrayList<game.Tile> tiles) {
		for (game.Tile tile : tiles) {
			TilePanel temp = new TilePanel(tile);
			tilePanels.add(temp);
			temp.Draw();
		}
	}

}
