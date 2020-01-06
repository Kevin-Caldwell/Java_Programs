package Car;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowCarProperties extends JFrame {
	
	JLabel speed;
	JLabel acceleration;
	JLabel angle;
	
	public ShowCarProperties() {
		setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3));
		
		panel.add(new JLabel("Speed: "));
		speed = new JLabel("");
		panel.add(speed);
		
		panel.add(new JLabel("Acceleration: "));
		acceleration = new JLabel("");
		panel.add(acceleration);
		
		panel.add(new JLabel("Angle: "));
		angle = new JLabel("");
		panel.add(angle);
		setBounds(new Rectangle(800, 0, 100, 100));
		setVisible(true);
		
	}
	
	
	public void updateVals() {
		speed.setText(Main.game.car.speed + "");
		acceleration.setText(Main.game.car.acceleration + "");
		angle.setText(Main.game.car.angle + "");
	}

}
