package Car;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7328956229243818502L;

	public final int DEFAULT_WINDOW_WIDTH = 600;
	public final int DEFAULT_WINDOW_HEIGHT = 600;

	Car car;

	JButton pickColor;
	DrawCanvas canvas;

	boolean upPressed;
	boolean downPressed;
	boolean leftPressed;
	boolean rightPressed;

	public DisplayGame() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(layout);

		car = new Car();

		canvas = new DrawCanvas();
		canvas.setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);

		System.out.println(canvas.getHeight());

		JPanel optionsPanel = new JPanel();
		optionsPanel.setSize(new Dimension(600, 100));

		pickColor = new JButton("Pick Color");
		pickColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Color initialcolor = car.color;
				Color chosen = JColorChooser.showDialog(new JFrame("Pick Color"), "Select a color", initialcolor);
				car.color = chosen;

				repaint();

			}
		});
		optionsPanel.add(pickColor);
		pickColor.addKeyListener(new GameControls());

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = DEFAULT_WINDOW_WIDTH;
		add(optionsPanel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 2.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = DEFAULT_WINDOW_WIDTH;
		gbc.ipady = DEFAULT_WINDOW_HEIGHT - 100;
		gbc.gridwidth = 4;
		gbc.gridheight = 5;
		add(canvas, gbc);

		setSize(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
		setTitle("Cars");
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

	}

	class GameControls implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode();
			switch (keyCode) {

			case KeyEvent.VK_UP:

				System.out.println("UP pressed");
//				car.acceleration = car.MAX_ACCELERATION;
//				car.moveCarForward(MAX_ACCELERATION, 4);
				upPressed = true;

				break;

			case KeyEvent.VK_DOWN:
				System.out.println("DOWN pressed");
//				car.acceleration = -1 * car.MAX_ACCELERATION;
				downPressed = true;
				break;

			case KeyEvent.VK_LEFT:
				System.out.println("LEFT pressed");
//				car.angle -= Math.toRadians(5);
//				car.acceleration = car.MAX_ACCELERATION;
				leftPressed = true;
				break;

			case KeyEvent.VK_RIGHT:
				System.out.println("RIGHT pressed");
//				car.angle += Math.toRadians(5);
//				car.acceleration = car.MAX_ACCELERATION;
				rightPressed = true;
				break;
			case KeyEvent.VK_W:
				System.out.println("UP pressed");
//				car.acceleration = car.MAX_ACCELERATION;
				upPressed = true;
				break;

			case KeyEvent.VK_S:
				System.out.println("DOWN pressed");
//				car.acceleration = -1 * car.MAX_ACCELERATION;
				downPressed = true;
				break;

			case KeyEvent.VK_A:
				System.out.println("LEFT pressed");
//				car.angle -= Math.toRadians(5);
//				car.acceleration = car.MAX_ACCELERATION;
				leftPressed = true;
				break;

			case KeyEvent.VK_D:
				System.out.println("RIGHT pressed");
//				car.angle += Math.toRadians(5);
//				car.acceleration = car.MAX_ACCELERATION;
				rightPressed = true;
				break;
			}

			repaint();

		}

		@Override
		public void keyReleased(KeyEvent e) {

			int keyCode = e.getKeyCode();
			switch (keyCode) {

			case KeyEvent.VK_UP:
				System.out.println("UP released");
				upPressed = false;
				break;

			case KeyEvent.VK_DOWN:
				System.out.println("DOWN released");
				downPressed = false;
				break;

			case KeyEvent.VK_LEFT:
				System.out.println("LEFT released");
				leftPressed = false;
				break;

			case KeyEvent.VK_RIGHT:
				System.out.println("RIGHT released");
				rightPressed = false;
				break;
			case KeyEvent.VK_W:
				System.out.println("UP released");
				upPressed = false;
				break;

			case KeyEvent.VK_S:
				System.out.println("DOWN released");
				downPressed = false;
				break;

			case KeyEvent.VK_A:
				System.out.println("LEFT released");
				leftPressed = false;
				break;

			case KeyEvent.VK_D:
				System.out.println("RIGHT released");
				rightPressed = false;
				break;
			}
			repaint();
		}

	}

}
