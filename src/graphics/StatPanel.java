package graphics;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import game.Game;
import game.Piece;

/**
 * A karakter statisztikáit kiíró panel
 * TextFieldekben és Labelekben jeleníti meg ezeket
 */
public class StatPanel extends JPanel{
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();
	private JTextField tf3 = new JTextField();
	private JLabel lb1 = new JLabel();
	private JLabel lb2 = new JLabel();
	private JLabel lb3 = new JLabel();
	private JTextArea tarea = new JTextArea();
	Piece currentPiece;
	
	/**
	 * Konstruktor amely meghívja az õsosztály konstruktorát
	 */
	public StatPanel() 
	{
		super();
	}
	
	/**
	 * A statisztikák képernyõre kirajzolása
	 */
	public void Draw() 
	{
		
		currentPiece = Game.getInstance().getActivePlayer().getPiece();
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tarea.setEditable(false);
		
		lb1.setText("Colour:");
		lb2.setText("Body Temp:");
		lb3.setText("Actionpoints:");
		
		add(lb1);
		add(tf1);
		add(lb2);
		add(tf2);
		add(lb3);
		add(tf3);
		add(tarea);
		
		
		
		tf1.setText(currentPiece.getColour().toString());
		tf2.setText(Integer.toString(currentPiece.getBodyTemp()));
		tf3.setText(Integer.toString(currentPiece.getActionPoints()));
	}
	
	public void Refresh() 
	{
		currentPiece = Game.getInstance().getActivePlayer().getPiece();
		tf1.setText(currentPiece.getColour().toString());
		tf2.setText(Integer.toString(currentPiece.getBodyTemp()));
		tf3.setText(Integer.toString(currentPiece.getActionPoints()));
	}
	
}
