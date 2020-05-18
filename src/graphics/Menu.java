package graphics;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import game.Game;

@SuppressWarnings("serial")
public class Menu extends JFrame{
    
    private JPanel panel;
    private BoxLayout layout;
    private JButton bGame;
    private JButton bPlayers;
    private JButton bExit;
    private menuClick al;
    private JTextField tf;
    
    public Menu(){
        
        super("Snowstorm Menu");
        panel = new JPanel();
        layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
        al = new menuClick();
        bGame = new JButton("New Game");
        bGame.addActionListener(al);
        bGame.setMaximumSize(new Dimension(130, 30));
        tf = new JTextField("3");
        tf.setMaximumSize(new Dimension(260, 30));
        bPlayers = new JButton("Players");
        bPlayers.addActionListener(al);
        bPlayers.setMaximumSize(new Dimension(130, 30));
        bExit = new JButton("Exit");
        bExit.addActionListener(al);
        bExit.setMaximumSize(new Dimension(130, 30));
        panel.add(bGame);
        panel.add(bPlayers);
        panel.add(tf);
        panel.add(bExit);
        add(panel);
        setLocation(750, 315);
        setMinimumSize(new Dimension(350, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    private class menuClick implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == bGame)
            {
        		int temp = Integer.parseInt(tf.getText());              		
            	Game game = Game.getInstance();
        		game.initGame(temp);
        		new View();
            }
            
            
            if (e.getSource() == bExit)
            {
            	setVisible(false);
                dispose();
            }
            	
        }
        
    }
    
	public void Run()
	{
		
	}
}
