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
	/**
	 * Eszköz változó. Itt tároljuk, hogy milyen eszközhöz fog
	 * tartozni a gombunk
	 */
	game.Item item;
	
	/**
	 * Ezzel a függvénnyel hozunk létre egy gombot egy adott
	 * eszközhöz
	 * 
	 * @param i - Az eszköz, melyhez a létrehozzuk a gombot
	 */
	public ItemButton(game.Item i) {
		item = i;
		setBackground(new Color(91, 92, 110));
		setForeground(new Color(214, 225, 150));
		setText(item.getName());
		addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
				Game.getInstance().setActiveItem(item);
            }
        });
	}
	
}
