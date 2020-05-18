package graphics;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Az action gombokat tartalmazó panel (a frame bal oldalán)
 * Egyszerre csak 1 lehet kiválasztva
 *
 */
public class ActionPanel extends JPanel{
	
	private ArrayList<ActionButton> actions = new ArrayList<ActionButton>();
	ButtonGroup group;
	
	public ActionPanel() {
		super();
	}
	
	public void Draw(JFrame view)
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		actions.add(new ActionButton("Move"));
		actions.add(new ActionButton("Dig"));
		actions.add(new ActionButton("Ability"));
		actions.add(new ActionButton("Use Item"));
		actions.add(new ActionButton("Pick Up Item"));
		group = new ButtonGroup();
		for (ActionButton actionButton : actions) {
			group.add(actionButton);
			add(actionButton);
		}
		
	}
	
}
