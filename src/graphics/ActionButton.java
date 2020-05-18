package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import game.Game;

/**
 * 1 akciónak megfelelõ gomb
 * 
 *
 */
public class ActionButton extends JRadioButton
{
	
	public ActionButton(String name)
	{
		super(name);
		setBackground(new Color(91, 92, 110));
		setForeground(new Color(214, 225, 150));
		addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Action temp = Action.valueOf(getText());
				Game.getInstance().getView().setActiveAction(temp);
				System.out.println(getText());
            }
        });
	}
	
}
