package vector;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		JPanel controls = new JPanel();
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

				if (!magnitudeTextArea.getText().isEmpty() && !angleTextArea.getText().isEmpty()
						&& xComponentTextArea.getText().equals("") && yComponentTextArea.getText().equals("")) {
					try {

						magnitude = Double.parseDouble(magnitudeTextArea.getText());
						angle = Math.toRadians(Double.parseDouble(angleTextArea.getText()));

						vector = Vector.createVectorPolarForm(magnitude, angle);

						xComponentTextArea.setText(Double.toString(vector.getxComponent()));
						yComponentTextArea.setText(Double.toString(vector.getyComponent()));

					} catch (NumberFormatException e1) {

					}
				}

				if (!xComponentTextArea.getText().equals("") && !yComponentTextArea.getText().equals("")
						&& magnitudeTextArea.getText().isEmpty() && angleTextArea.getText().isEmpty()) {
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

		DrawCanvas canvas = new DrawCanvas();

		canvas.addMouseListener(new MouseListener() {

			int x1 = 0;
			int y1 = 0;
			int x2 = 0;
			int y2 = 0;

			@Override
			public void mouseReleased(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {

					if (x1 != 0 && y1 != 0 && x2 == 0 && y2 == 0) {
						x2 = e.getX();
						y2 = e.getY();

						System.out.println("Mouse Released twice : " + e.getPoint());
						System.out.println("Mouse Clicked twice : " + x2 + " , " + y2);

						canvas.addVector(Vector.createVectorWithComponents(x1, y1, x2 - x1, y2 - y1));

						canvas.repaint();
						
//											
//						magnitudeTextArea.setText(Double.toString(resultant.getMagnitude()));
//						angleTextArea.setText(Double.toString(resultant.getAngle()));
//						xComponentTextArea.setText(Double.toString(resultant.getxComponent()));
//						yComponentTextArea.setText(Double.toString(resultant.getyComponent()));

						x1 = x2;
						x2 = 0;
						y1 = y2;
						y2 = 0;
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {

					if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
						x1 = e.getX();
						y1 = e.getY();
						System.out.println("Mouse Pressed once : " + e.getPoint());
						System.out.println("Mouse Clicked once : " + x1 + " , " + y1);

					}
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == MouseEvent.BUTTON1) {

					if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0) {
						x1 = e.getX();
						y1 = e.getY();
						System.out.println("Mouse Clicked once : " + e.getPoint());
						System.out.println("Mouse Clicked once : " + x1 + " , " + y1);

					} else if (x1 != 0 && y1 != 0 && x2 == 0 && y2 == 0) {
						x2 = e.getX();
						y2 = e.getY();

						System.out.println("Mouse Clicked twice : " + e.getPoint());
						System.out.println("Mouse Clicked twice : " + x2 + " , " + y2);

						canvas.addVector(Vector.createVectorWithComponents(x1, y1, x2 - x1, y2 - y1));

						canvas.repaint();

						x1 = x2;
						x2 = 0;
						y1 = y2;
						y2 = 0;
					}
				}

			}
		});


		controls.setLayout(new GridLayout(6, 1));
		controls.add(new JLabel("A Vector Simulation!"));
		controls.add(magnitudePanel);
		controls.add(anglePanel);
		controls.add(xComponentPanel);
		controls.add(yComponentPanel);
		controls.add(submit);

		mainPanel.setLayout(new GridLayout(1, 2));
		mainPanel.add(controls);
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
