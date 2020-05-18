package graphics;

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

		addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
				Game.getInstance().getView().setActiveAction(Action.valueOf(getText()));
				//System.out.println(getText());
            }
        });
	}
	
}
