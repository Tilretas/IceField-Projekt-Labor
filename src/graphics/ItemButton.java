package graphics;

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
		
		addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
				Game.getInstance().getView().setActiveItem(Inventory.valueOf(getText()));
				//System.out.println(getText());
            }
        });
	}
	
}
