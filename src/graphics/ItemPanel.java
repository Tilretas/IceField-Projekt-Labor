package graphics;

import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Az eszközöket tartalmazó panel. Ide irjuk ki
 * a használható eszközöket
 */
public class ItemPanel extends JPanel
{
	/**
	 * Az eszközöket reprezentáló gombok listája
	 */
	private ArrayList<ItemButton> items = new ArrayList<ItemButton>();
	
	/**
	 * Kiirjuk az éppen használható eszközöket
	 * 
	 * @param view - Keret (JFrame) az elrendezéshez
	 * @param itemlist - Eszközlista, amely megadja, hogy az adott 
	 * játékosnál éppen milyen eszközök vannak
	 */
	public void Draw(JFrame view, ArrayList<game.Item> itemlist) 
	{
		removeAll();
		revalidate();
		repaint();
		items.clear();
		if(itemlist.size() == 0)
			setBorder(new EmptyBorder(new Insets(220, 80, 100, 80)));
		else
			setBorder(new EmptyBorder(new Insets(220, 30, 100, 30)));
		
		for (game.Item item : itemlist) {
			ItemButton temp = new ItemButton(item);
			items.add(temp);
			add(temp);
		}
	}
}
