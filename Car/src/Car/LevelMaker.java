package Car;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LevelMaker extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1298996321987829569L;

	ArrayList<Obstacle> obstacles;
	
	Rectangle startZone;
	Rectangle endZone;
	
	public Level newLevel;

	public LevelMaker() {
		
		newLevel = new Level();
		
		addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		        
		    }
		});
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(layout);
		
		LevelCustomizer canvasPanel = new LevelCustomizer();
		canvasPanel.setSize(400, 400);
		JPanel controlPanel = new JPanel();
		controlPanel.setSize(200, 400);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = Main.game.DEFAULT_WINDOW_WIDTH;
		gbc.ipady = Main.game.DEFAULT_WINDOW_HEIGHT;
		gbc.gridwidth = 400;
		gbc.gridheight = 400;
		add(canvasPanel, gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 200;
		gbc.ipady = Main.game.DEFAULT_WINDOW_HEIGHT ;
		gbc.gridwidth = 200;
		gbc.gridheight = 400;
		add(controlPanel, gbc);
		
		JButton customizeCar = new JButton("Customize Car");
		controlPanel.add(customizeCar);
		
		JTextField widthField = new JTextField("Width");
		controlPanel.add(widthField);
		
		widthField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
				widthField.setText("");
			}
		});
		
		JTextField heightField = new JTextField("Height");
		controlPanel.add(heightField);
		
		heightField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				heightField.setText("");
				
			}
		});
		
		JButton addNewObstacle = new JButton("Add Wall");
		controlPanel.add(addNewObstacle);
		
		addNewObstacle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!widthField.getText().equals("") && !heightField.getText().equals("")) {
					try{
						
						System.out.println(Integer.parseInt(widthField.getText()));
						System.out.println(Integer.parseInt(heightField.getText()));
						canvasPanel.addMouseListener(new MouseListener() {
							
							@Override
							public void mouseReleased(MouseEvent e) {
								
							}
							
							@Override
							public void mousePressed(MouseEvent e) {

							}
							
							@Override
							public void mouseExited(MouseEvent e) {
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								
							}
							
							@Override
							public void mouseClicked(MouseEvent e) {
								
								newLevel.addObstacle(new Rectangle(e.getX(), e.getY(), Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText())));
								System.out.println("Wall Added!");
							}
						});
						
					} catch (NumberFormatException e1) {
						
						e1.printStackTrace();
						
						
					} 
				}
			}
		});
		
				
		setSize(Main.game.DEFAULT_WINDOW_WIDTH + 200, Main.game.DEFAULT_WINDOW_HEIGHT);
		setTitle("Car Level Maker");
		setVisible(true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
	}

}
