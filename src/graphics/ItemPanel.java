package graphics;

import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Az eszk�z�ket tartalmaz� panel. Ide irjuk ki
 * a haszn�lhat� eszk�z�ket
 */
public class ItemPanel extends JPanel
{
	/**
	 * Az eszk�z�ket reprezent�l� gombok list�ja
	 */
	private ArrayList<ItemButton> items = new ArrayList<ItemButton>();
	
	/**
	 * Kiirjuk az �ppen haszn�lhat� eszk�z�ket
	 * 
	 * @param view - Keret (JFrame) az elrendez�shez
	 * @param itemlist - Eszk�zlista, amely megadja, hogy az adott 
	 * j�t�kosn�l �ppen milyen eszk�z�k vannak
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
