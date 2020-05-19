package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import game.Game;

/**
 * 1 akci�nak megfelel� gomb
 * 
 *
 */
public class ActionButton extends JRadioButton
{
	/**
	 * Ebben a konstruktorban fogjuk egyes�vel kiirni az akci�kat bal oldalon.
	 * Ezt hivjuk meg minden akci�hoz az ActionPanel Draw f�ggv�ny�b�l
	 * 
	 * @param name - A kiirand� akci� neve
	 */
	public ActionButton(String name)
	{
		super(name);
		setBackground(new Color(91, 92, 110));
		setForeground(new Color(214, 225, 150));
		addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Action temp = Action.valueOf(getText());
				Game.getInstance().setActiveAction(temp);
            }
        });
	}
	
}
