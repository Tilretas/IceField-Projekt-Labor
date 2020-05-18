package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import game.Game;

/**
 * Egy eszközhöz tartozó gomb
 */
public class ItemButton extends JRadioButton
{
	game.Item item;
	
	public ItemButton(game.Item i) {
		item = i;
		setBackground(new Color(91, 92, 110));
		setForeground(new Color(214, 225, 150));
		addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
				Game.getInstance().setActiveItem(Inventory.valueOf(getText()));
				//System.out.println(getText());
            }
        });
	}
	
}
