package vector;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Test {

	public static void main(String[] args) {

		setUpGUI();
	}

	public static void setUpGUI() {
		JFrame frame = new JFrame();

		JPanel mainPanel = new JPanel();
		JPanel magnitudePanel = new JPanel();
		JPanel anglePanel = new JPanel();
		JPanel xComponentPanel = new JPanel();
		JPanel yComponentPanel = new JPanel();

		JTextArea magnitudeTextArea = new JTextArea("");
		JTextArea angleTextArea = new JTextArea("");
		JTextArea xComponentTextArea = new JTextArea("");
		JTextArea yComponentTextArea = new JTextArea("");

		magnitudePanel.setLayout(new GridLayout(1, 2));
		magnitudePanel.add(new JLabel("Magnitude: "));
		magnitudePanel.add(magnitudeTextArea);

		anglePanel.setLayout(new GridLayout(1, 2));
		anglePanel.add(new JLabel("Angle: "));
		anglePanel.add(angleTextArea);

		xComponentPanel.setLayout(new GridLayout(1, 2));
		xComponentPanel.add(new JLabel("X Component: "));
		xComponentPanel.add(xComponentTextArea);

		yComponentPanel.setLayout(new GridLayout(1, 2));
		yComponentPanel.add(new JLabel("Y Component: "));
		yComponentPanel.add(yComponentTextArea);

		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double magnitude = 0;
				double angle = 0;
				double xComponent = 0;
				double yComponent = 0;
				
				Vector vector;

				if (!magnitudeTextArea.getText().isEmpty() && !angleTextArea.getText().isEmpty() && xComponentTextArea.getText().equals("") && yComponentTextArea.getText().equals("")){
					try {
						
						magnitude = Double.parseDouble(magnitudeTextArea.getText());
						angle = Math.toRadians(Double.parseDouble(angleTextArea.getText()));
						
						vector = Vector.createVectorPolarForm(magnitude, angle);
						
						xComponentTextArea.setText(Double.toString(vector.getxComponent()));
						yComponentTextArea.setText(Double.toString(vector.getyComponent()));
						
					} catch (NumberFormatException e1) {
						
					}
				}
				
				if (!xComponentTextArea.getText().equals("") && !yComponentTextArea.getText().equals("") && magnitudeTextArea.getText().isEmpty() && angleTextArea.getText().isEmpty()) {
					try {
						System.out.println(xComponentTextArea.getText());
						
						xComponent = Double.parseDouble(xComponentTextArea.getText());
						yComponent = Double.parseDouble(yComponentTextArea.getText());
						
						vector = Vector.createVectorWithComponents(xComponent, yComponent);
						
						magnitudeTextArea.setText(Double.toString(vector.getMagnitude()));
						angleTextArea.setText(Double.toString(Math.toDegrees(vector.getAngle())));
						
					} catch (NumberFormatException e1) {
						
					}
				}
			}
		});

		mainPanel.setLayout(new GridLayout(8, 1));
		mainPanel.add(new JLabel("A Vector Simulation!"));
		mainPanel.add(magnitudePanel);
		mainPanel.add(anglePanel);
		mainPanel.add(xComponentPanel);
		mainPanel.add(yComponentPanel);
		mainPanel.add(submit);

		frame.add(mainPanel);

		frame.setTitle("Vectors");
		frame.setVisible(true);
		frame.setSize(new Dimension(500, 500));

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

	}

}
