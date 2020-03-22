package Car;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class LevelCustomizer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3182938646251294748L;

	public LevelCustomizer() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, getWidth(), getHeight());
		g.drawLine(0, 0, 100, 100);
		
	}
	
public void drawBackground(int level, Graphics g) {
		
		
		g.setColor(Main.currLevel.color);
		
		for (Shape obstacle : Main.currLevel.obstacles) {
			
			if(obstacle instanceof Point) {
				
				g.fillOval(((Point) obstacle).x, ((Point) obstacle).y, 10, 10);
				
			} else if (obstacle instanceof Line2D) {
				
				g.drawLine((int)((Line2D) obstacle).getX1(), (int)((Line2D) obstacle).getY1(), (int)((Line2D) obstacle).getX2(), (int)((Line2D) obstacle).getY2());
				
			} else if (obstacle instanceof Rectangle) {
				
				g.fillRect(((Rectangle) obstacle).x, ((Rectangle) obstacle).y, ((Rectangle) obstacle).width, ((Rectangle) obstacle).height);
				
			} else if (obstacle instanceof Ellipse2D) {
				
				g.fillOval((int)((Ellipse2D) obstacle).getX(), (int)((Ellipse2D) obstacle).getY(), (int)((Ellipse2D) obstacle).getWidth(), (int)(((Ellipse2D) obstacle).getHeight()));
				
			} else if (obstacle instanceof Polygon) {
				
				g.fillPolygon((Polygon)obstacle);
				
			}
		}
	}
	
	


}
