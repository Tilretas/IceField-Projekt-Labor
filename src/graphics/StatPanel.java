package graphics;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Game;
import game.Piece;

public class StatPanel extends JPanel{
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();
	private JTextField tf3 = new JTextField();
	private JLabel lb1 = new JLabel();
	private JLabel lb2 = new JLabel();
	private JLabel lb3 = new JLabel();
	
	public StatPanel() 
	{
		super();
	}
	
	public void Draw() 
	{
		Piece currentPiece;
		currentPiece = Game.getInstance().getActivePlayer().getPiece();
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		
		lb1.setText("Colour:");
		lb2.setText("Body Temp:");
		lb3.setText("Actionpoints:");
		
		add(lb1);
		add(tf1);
		add(lb2);
		add(tf2);
		add(lb3);
		add(tf3);
		
		tf1.setText(currentPiece.getColour().toString());
		tf2.setText(Integer.toString(currentPiece.getBodyTemp()));
		tf3.setText(Integer.toString(currentPiece.getActionPoints()));
	}
}
