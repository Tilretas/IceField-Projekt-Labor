package graphics;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ItemPanel extends JPanel
{
	private ArrayList<ItemButton> items = new ArrayList<ItemButton>();
	
	public void Draw(JFrame view, ArrayList<game.Item> itemlist) 
	{
		if(itemlist.size() == 0)
			setBorder(new EmptyBorder(new Insets(220, 80, 100, 80)));
		else
			setBorder(new EmptyBorder(new Insets(220, 30, 100, 30)));
		
		for (game.Item item : itemlist) {
			ItemButton temp = new ItemButton(item);
			items.add(temp);
			add(temp);
			temp.Draw(this);
		}
	}
}
