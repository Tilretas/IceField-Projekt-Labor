package graphics;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Az action gombokat tartalmazó panel (a frame bal oldalán)
 * Egyszerre csak 1 lehet kiválasztva
 *
 */
public class ActionPanel extends JPanel{
	private ArrayList<ActionButton> actions; //lehet nem kell action but, elég a sima radio
	
	public void Draw(JFrame view)
	{
		ArrayList<JPanel> sokPanelGrunak = new ArrayList<JPanel>();
		for (int i = 0; i < 174; i++)
			sokPanelGrunak.add(new JPanel());
	}
	
}
