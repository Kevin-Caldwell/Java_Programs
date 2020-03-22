package vector;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4996754426731220368L;

	public static void main(String[] args) {

		new Test();
	}

	public Test() {

		JPanel mainPanel = new JPanel();
//		JPanel controls = new JPanel();
//		JPanel magnitudePanel = new JPanel();
//		JPanel anglePanel = new JPanel();
//		JPanel xComponentPanel = new JPanel();
//		JPanel yComponentPanel = new JPanel();
//
//		JTextArea magnitudeTextArea = new JTextArea("");
//		JTextArea angleTextArea = new JTextArea("");
//		JTextArea xComponentTextArea = new JTextArea("");
//		JTextArea yComponentTextArea = new JTextArea("");
//
//		magnitudePanel.setLayout(new GridLayout(1, 2));
//		magnitudePanel.add(new JLabel("Magnitude: "));
//		magnitudePanel.add(magnitudeTextArea);
//
//		anglePanel.setLayout(new GridLayout(1, 2));
//		anglePanel.add(new JLabel("Angle: "));
//		anglePanel.add(angleTextArea);
//
//		xComponentPanel.setLayout(new GridLayout(1, 2));
//		xComponentPanel.add(new JLabel("X Component: "));
//		xComponentPanel.add(xComponentTextArea);
//
//		yComponentPanel.setLayout(new GridLayout(1, 2));
//		yComponentPanel.add(new JLabel("Y Component: "));
//		yComponentPanel.add(yComponentTextArea);

//		JButton submit = new JButton("Submit");

		DrawCanvas canvas = new DrawCanvas();
		
//		Car car = new Car(100, 100, 5);


//		controls.setLayout(new GridLayout(6, 1));
//		controls.add(new JLabel("A Vector Simulation!"));
//		controls.add(magnitudePanel);
//		controls.add(anglePanel);
//		controls.add(xComponentPanel);
//		controls.add(yComponentPanel);
//		controls.add(submit);

		mainPanel.setLayout(new GridLayout(1, 2));
//		mainPanel.add(controls);
		mainPanel.add(canvas);

//		System.out.println(canvasBounds.x + " " + canvasBounds.y + " " + canvasBounds.width + " " + canvasBounds.height);

		add(mainPanel);

		setTitle("Vectors");
		setVisible(true);
		setSize(new Dimension(1000, 500));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

	}
}
