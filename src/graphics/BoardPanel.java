package graphics;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A mez�ket t�rol� panel
 * 25 db panelk�nt t�rolja �ket
 *
 */
public class BoardPanel extends JPanel{
	/**
	 * A mez�k paneljeit (25db-ot) tartalmaz� lista
	 */
	private ArrayList<TilePanel> tilePanels = new ArrayList<TilePanel>();
	
	/**
	 * Draw seg�ts�g�vel rajzoljuk ki a mez�ket
	 * 
	 * @param view - Keret (JFrame) az elrendez�shez
	 * @param tiles - A j�t�kban tal�lhat� mez�k list�ja
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
	 * Minden egyes mez�n v�gigmegy, �s friss�ti �ket.
	 */
	public void Refresh()

	{
		for (TilePanel tilePanel : tilePanels) {
			tilePanel.Refresh();
		}
	}

}
