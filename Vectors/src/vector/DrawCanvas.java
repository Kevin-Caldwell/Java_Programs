package vector;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawCanvas extends JPanel {

	int x = 0;
	int y = 0;
	int w = 0;
	int h = 0;

	ArrayList<Vector> listOfVectors = new ArrayList<Vector>();

	public DrawCanvas() {

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		repaint();
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		repaint();
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
		repaint();
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
		repaint();
	}

	public void addVector(Vector v) {
		listOfVectors.add(v);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);

		for (Vector vector : listOfVectors) {
			drawVector(vector, Color.BLACK, g);
		}
		
		if(!listOfVectors.isEmpty()) {
			
			Vector[] array = listOfVectors.toArray(new Vector[listOfVectors.size()]);
			
			Vector resultant = Vector.addVectors(array);
		
			drawVector(resultant, Color.GREEN, g);
		}
		
	}

	public void drawPlane(int x1, int y1, int w, int h, Graphics g) {

		g.drawLine(0, 50, 300, 50);
	}

	public void drawVector(Vector vector, Color color, Graphics g) {
		g.setColor(color);
		g.drawLine(vector.getStartX(), vector.getStartY(), vector.getStartX() + (int) vector.getxComponent(),
				vector.getStartY() + (int) vector.getyComponent());

		System.out.println(vector.getStartX() + ", " + vector.getStartY() + ", " + (int) vector.getxComponent() + " , "
				+ (int) vector.getyComponent());
	}

}
