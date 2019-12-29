package Car;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawCanvas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3333394521253800578L;
	Level currLevel;
	boolean crashed = false;
	Rectangle rect = null;

	public DrawCanvas() {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		currLevel = new Level_One();

		g.setColor(Color.BLUE);
		drawCar(g);
//		System.out.println(Main.game.car.getX() + ", " + Main.game.car.getY() + ", " + Main.game.car.width + ", "
//				+ Main.game.car.length + " , " + Main.game.car.speed + " , " + Main.game.car.acceleration);

	}

	public void drawCar(Graphics g) {
		
		drawBackground(1, g);
		drawStartAndFinish(1, g); 

		Graphics2D g2d = (Graphics2D) g;
		
		
		if (Main.game.car != null) {
			rect = new Rectangle(Main.game.car.getX(), Main.game.car.getY(), Main.game.car.width, Main.game.car.length);
		}

		Rectangle windShield = new Rectangle(Main.game.car.getX() + 5, Main.game.car.getY() + 10, 30, 10);

		Shape polygon = AffineTransform.getRotateInstance(Main.game.car.angle, Main.game.car.getX() + Main.game.car.width / 2, Main.game.car.getY() + Main.game.car.length / 2).createTransformedShape(rect);
		Shape windshield = AffineTransform.getRotateInstance(Main.game.car.angle,Main.game.car.getX() + Main.game.car.width / 2, Main.game.car.getY() + Main.game.car.length / 2).createTransformedShape(windShield);
		
		g2d.setColor(Main.game.car.color);
		g2d.draw(polygon);
		g2d.fill(polygon);
		
		g2d.setColor(Color.BLACK);
		g2d.draw(windshield);
		g2d.fill(windshield);
		
		crashed = false;
		for(int i = 0; i < currLevel.obstacles.size(); i++) {
			
			if(polygon.intersects((Rectangle)currLevel.obstacles.get(i))) {
				crashed = true;
			}
		}
		if(rect.equals(currLevel.startPosition)) {
			System.out.println("Park car in yellow zone");
		}
		
		if(crashed) {
			Main.game.car.speed*=-1;
			System.out.println("You have crashed!");
		}
		if(rect.equals(currLevel.endPosition)) {
			System.out.println("Level completed!");
		}
		
		checkGameStatus();
		

	}
	
	public void drawStartAndFinish(int level, Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(currLevel.startPosition.x, currLevel.startPosition.y, currLevel.startPosition.width, currLevel.startPosition.height);
		g.setColor(Color.YELLOW);
		g.fillRect(currLevel.endPosition.x, currLevel.endPosition.y, currLevel.endPosition.width, currLevel.endPosition.height);
	}
	
	public void drawBackground(int level, Graphics g) {
		
		
		g.setColor(currLevel.color);
		
		for (Shape obstacle : currLevel.obstacles) {
			
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
	
	public void checkGameStatus() {
		if(currLevel.endPosition.contains(rect)) {
			System.out.println("You won!");
			JFrame endGame = new JFrame("Congratulations!");
			endGame.add(new JButton("You won"));
			endGame.setVisible(true);
			endGame.setSize(50, 50);
			
		}
	}

}
