package clock;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Test extends JFrame implements Runnable {

	JPanel drawPanel;
	Canvas canvas;
	hand secondsHand;
	hand minutesHand;
	hand hoursHand;

	public static void main(String args[]) {

		Test test = new Test();
		test.run();
	}

	public Test() {

		drawPanel = new JPanel(new FlowLayout());

		canvas = new Canvas();
		drawPanel.add(canvas);

		secondsHand = new hand(100, 90, 0);
		minutesHand = new hand(75, 90, 1);
		hoursHand = new hand(50, 90, 2);

		setTitle("Clock");
		setLayout(new FlowLayout());
		add(drawPanel);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	// @Override
	public void paint(Graphics g) {

		g.clearRect(0, 0, 400, 400);
		
		((Graphics2D) g).setStroke(new BasicStroke(6F));
		
		g.setColor(Color.BLUE);
		g.drawLine(secondsHand.CentreX, secondsHand.CentreY, secondsHand.EndX, secondsHand.EndY);
		
		((Graphics2D) g).setStroke(new BasicStroke(10F));
		
		g.setColor(Color.RED);
		g.drawLine(minutesHand.CentreX, minutesHand.CentreY, minutesHand.EndX, minutesHand.EndY);
		
		g.setColor(Color.RED);
		g.drawLine(hoursHand.CentreX, hoursHand.CentreY, hoursHand.EndX, hoursHand.EndY);
		
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 200, 200);
		
		minutesHand.findNewCoordinates();
		secondsHand.findNewCoordinates();
		hoursHand.findNewCoordinates();
	}

	public void update() {
		repaint();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			update();
		}
	}
}
