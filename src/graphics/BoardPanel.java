package graphics;

import java.util.ArrayList;

/**
 * A mez�ket t�rol� panel
 * 25 db panelk�nt t�rolja �ket
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
