package graphics;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Az action gombokat tartalmaz� panel (a frame bal oldal�n)
 * Egyszerre csak 1 lehet kiv�lasztva
 *
 */
public class ActionPanel extends JPanel{
	private ArrayList<ActionButton> actions; //lehet nem kell action but, el�g a sima radio
	
	public void Draw(JFrame view)
	{
		ArrayList<JPanel> sokPanelGrunak = new ArrayList<JPanel>();
		for (int i = 0; i < 174; i++)
			sokPanelGrunak.add(new JPanel());
	}
	
}
