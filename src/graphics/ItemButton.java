package graphics;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Egy eszk�zh�z tartoz� gomb
 */
public class ItemButton extends JRadioButton
{
	game.Item item;
	
	public ItemButton(game.Item i) {
		item = i;
	}
	
	public void Draw(JPanel ip) 
	{
		
	}
}
