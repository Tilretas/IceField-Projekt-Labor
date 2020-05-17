package graphics;

import javax.swing.JRadioButton;

public class ItemButton extends JRadioButton
{
	game.Item item;
	
	public ItemButton(game.Item i) {
		item = i;
	}
}
