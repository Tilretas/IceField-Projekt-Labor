package graphics;

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
	
	private ArrayList<TilePanel> tilePanels = new ArrayList<TilePanel>();
	
	public void Draw(JFrame view, ArrayList<game.Tile> tiles) {
        tilePanels.clear();
		setLayout(new GridBagLayout());
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.fill = GridBagConstraints.BOTH;
        gbs.ipadx = 1;
        gbs.ipady = 1;
        gbs.weightx = 1.0;
        gbs.weighty = 1.0;
        gbs.insets = new java.awt.Insets(0, 0, 1, 1);
        
        
        for(int x = 0; x < 5; x++) {
        	gbs.gridy = x;
        	for(int y = 0; y < 5; y++) {
        		TilePanel temp = new TilePanel(tiles.get(x * 5 + y));
        		tilePanels.add(temp);
        		temp.setBorder(BorderFactory.createEtchedBorder());
        		add(temp, gbs);
        		temp.Draw(this);
        	}
        }
		
	}
	
	public void Resfresh()
	{
		for (TilePanel tilePanel : tilePanels) {
			tilePanel.Refresh();
		}
	}

}
