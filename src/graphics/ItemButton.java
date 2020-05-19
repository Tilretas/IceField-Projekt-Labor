package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import game.Game;

/**
 * Egy eszk�zh�z tartoz� gomb
 */
public class ItemButton extends JRadioButton
{
	/**
	 * Eszk�z v�ltoz�. Itt t�roljuk, hogy milyen eszk�zh�z fog
	 * tartozni a gombunk
	 */
	game.Item item;
	
	/**
	 * Ezzel a f�ggv�nnyel hozunk l�tre egy gombot egy adott
	 * eszk�zh�z
	 * 
	 * @param i - Az eszk�z, melyhez a l�trehozzuk a gombot
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
