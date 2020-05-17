package graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ItemPanel extends JPanel
{
	private ArrayList<ItemButton> items = new ArrayList<ItemButton>();
	
	public void Draw(ArrayList<game.Item> itemlist) 
	{
		for (game.Item item : itemlist) {
			ItemButton temp = new ItemButton(item);
			items.add(temp);
		}
	}
}