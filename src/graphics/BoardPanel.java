package graphics;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A mezõket tároló panel
 * 25 db panelként tárolja õket
 *
 */
public class BoardPanel extends JPanel{
	/**
	 * A mezõk paneljeit (25db-ot) tartalmazó lista
	 */
	private ArrayList<TilePanel> tilePanels = new ArrayList<TilePanel>();
	
	/**
	 * Draw segítségével rajzoljuk ki a mezõket
	 * 
	 * @param view - Keret (JFrame) az elrendezéshez
	 * @param tiles - A játékban található mezõk listája
	 */
	public void Draw(JFrame view, ArrayList<game.Tile> tiles) {
		
		setBackground(new Color(231, 249, 251));
        tilePanels.clear();
		setLayout(new GridBagLayout());
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.fill = GridBagConstraints.BOTH;
        gbs.ipadx = 0;
        gbs.ipady = 0;
        gbs.weightx = 1.0;
        gbs.weighty = 1.0;
        gbs.insets = new java.awt.Insets(0, 0, 1, 1);
        
        
        for(int x = 0; x < 5; x++) {
        	gbs.gridy = x;
        	for(int y = 0; y < 5; y++) {
        		TilePanel temp = new TilePanel(tiles.get(x * 5 + y));
        		tilePanels.add(temp);
        		add(temp, gbs);
        		temp.Draw(this);
        	}
        }
		
	}
	
	/**
	 * Minden egyes mezõn végigmegy, és frissíti õket.
	 */
	public void Refresh()

	{
		for (TilePanel tilePanel : tilePanels) {
			tilePanel.Refresh();
		}
	}

}
