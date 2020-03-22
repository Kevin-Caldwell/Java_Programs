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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawCanvas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3333394521253800578L;
	
	boolean crashed = false;
	Rectangle rect = null;

	public DrawCanvas() {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		g.setColor(Color.BLUE);
		drawCar(g);
//		System.out.println(Main.game.car.getX() + ", " + Main.game.car.getY() + ", " + Main.game.car.width + ", "
//				+ Main.game.car.length + " , " + Main.game.car.speed + " , " + Main.game.car.acceleration);

	}

	public void drawCar(Graphics g) {
		
		drawBackground(1, g);
		drawStartAndFinish(1, g);
		drawCarStatus(g);


		Graphics2D g2d = (Graphics2D) g;
		
		
		if (Main.game.car != null) {
			rect = new Rectangle((int)Main.game.car.topLeft_X, (int)Main.game.car.topLeft_Y, Car.width, Car.length);
		}

		Rectangle windShield = new Rectangle((int)Main.game.car.topLeft_X + 5, (int)Main.game.car.topLeft_Y + 10, 30, 10);

		Shape polygon = AffineTransform.getRotateInstance(Main.game.car.angle, Main.game.car.topLeft_X + Car.width / 2, Main.game.car.topLeft_Y + Car.length / 2).createTransformedShape(rect);
		Shape windshield = AffineTransform.getRotateInstance(Main.game.car.angle,Main.game.car.topLeft_X + Car.width / 2, Main.game.car.topLeft_Y + Car.length / 2).createTransformedShape(windShield);
		
		g2d.setColor(Main.game.car.color);
		g2d.draw(polygon);
		g2d.fill(polygon);
		
		g2d.setColor(Color.BLACK);
		g2d.draw(windshield);
		g2d.fill(windshield);
		
		
		crashed = false;
		for(int i = 0; i < Main.currLevel.obstacles.size(); i++) {
			
			if(polygon.intersects((Rectangle)Main.currLevel.obstacles.get(i))) {
				crashed = true;
			}
		}
		if(!polygon.intersects(0, 0, 800, 800)) {
			crashed = true;
		}
				
		if(crashed) {
			System.out.println("You have crashed!");
			Main.game.car.topLeft_X = Main.currLevel.startPosition.x;
			Main.game.car.topLeft_Y = Main.currLevel.startPosition.y;
			Main.game.car.angle = 0;
			Main.game.car.acceleration = 0;
			Main.game.car.speed = 0;
		}
		if(rect.equals(Main.currLevel.endPosition)) {
			System.out.println("Level completed!");
		}
		
		checkGameStatus();
		

	}
	
	public void drawCarStatus(Graphics g) {
		g.setColor(Color.WHITE);
		
		g.drawString(Main.game.car.speed + "", 400, 20);
		g.drawString(Main.game.car.acceleration + "", 400, 40);
		g.drawString(Main.game.car.angle + "", 400, 60);
		g.drawString(Main.game.upPressed + "", 400, 80);
		g.drawString(Main.game.downPressed + "", 400, 100);
		g.drawString(Main.game.leftPressed + "", 400, 120);
		g.drawString(Main.game.rightPressed + "", 400, 140);
		g.drawString(Math.toRadians(RunGraphics.angleIncrement * RunGraphics.getAbs(Main.game.car.speed)) + "", 400, 160);

	}
	
	public void drawStartAndFinish(int level, Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillRect(Main.currLevel.startPosition.x, Main.currLevel.startPosition.y, Main.currLevel.startPosition.width, Main.currLevel.startPosition.height);
		
		g.setColor(Color.YELLOW);
		g.fillRect(Main.currLevel.endPosition.x, Main.currLevel.endPosition.y, Main.currLevel.endPosition.width, Main.currLevel.endPosition.height);
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
	
	public void checkGameStatus() {
		if(Main.currLevel.endPosition.contains(rect) && !Main.levelFinished) {
			Main.levelFinished = true;
			System.out.println("You won!");
			
			JFrame endGame = new JFrame("Congratulations!");
			endGame.add(new JLabel(new ImageIcon("Win.png")));
			endGame.setVisible(true);
			endGame.setSize(380, 131);
			Main.graphics.interrupt();
			
		} 
	}

}
