package Car;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

public class DrawCanvas extends JPanel {

	public DrawCanvas() {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	    g.setColor(Color.BLUE);
		drawCar(g);
		
//		g.drawLine(0, 0, getWidth(), getHeight());
//		g.drawRect(0, 0, getWidth(), getHeight());

		System.out.println(Main.game.car.getX() + ", " + Main.game.car.getY() + ", " + Main.game.car.width + ", " + Main.game.car.length + " , " + Main.game.car.angle);


		
	}

	public void drawCar(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
	    g2d.setColor(Main.game.car.color);
	    Rectangle rect = null;
	    if(Main.game.car != null) {
	    	rect = new Rectangle(Main.game.car.getX(), Main.game.car.getY(), Main.game.car.width, Main.game.car.length);
	    }
	    
	    Rectangle windShield = new Rectangle(Main.game.car.getX() + 5, Main.game.car.getY() + 10, 30, 10);
	    
	    
	    
	    Shape polygon = AffineTransform.getRotateInstance(Main.game.car.angle, Main.game.car.getX() + Main.game.car.width/2, Main.game.car.getY() + Main.game.car.length/2).createTransformedShape(rect);
	    Shape windshield = AffineTransform.getRotateInstance(Main.game.car.angle, Main.game.car.getX() + Main.game.car.width/2, Main.game.car.getY() + Main.game.car.length/2).createTransformedShape(windShield);
	    
	    g2d.draw(polygon);
	    g2d.fill(polygon);
	    g2d.setColor(Color.BLACK);
	    g2d.draw(windshield);
	    g2d.fill(windshield);
		

	}

}
