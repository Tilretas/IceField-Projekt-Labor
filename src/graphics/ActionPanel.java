package graphics;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Game;

/**
 * Az action gombokat tartalmaz� panel (a frame bal oldal�n)
 * Egyszerre csak 1 lehet kiv�lasztva
 *
 */
public class ActionPanel extends JPanel{
	
	/**
	 * Az akci�khoz tartoz� gombokat t�rol� lista
	 */
	private ArrayList<ActionButton> actions = new ArrayList<ActionButton>();
	ButtonGroup group;
	
	/**
	 * JPanel konstruktora segits�g�vel inicializ�ljuk a panelt
	 */
	public ActionPanel() {
		super();
		
	}
	
	/**
	 * 
	 * 
	 * @param view - 
	 */
	public void Draw(JFrame view)
	{
		//padding esetleg?
		setBorder(new EmptyBorder(new Insets(220, 30, 100, 30)));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		actions.add(new ActionButton("Move"));
		actions.add(new ActionButton("Dig"));
		actions.add(new ActionButton("Ability"));
		actions.add(new ActionButton("UseItem"));
		actions.add(new ActionButton("PickUpItem"));
		group = new ButtonGroup();
		for (ActionButton actionButton : actions) {
			group.add(actionButton);
			add(actionButton);
		}
		
	}
	
}
