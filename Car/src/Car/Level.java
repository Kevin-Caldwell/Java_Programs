package Car;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

public class Level {

	public int level;
	public Color color;
	public ArrayList<Shape> obstacles;

	public Rectangle startPosition;
	public Rectangle endPosition;

	public Level() {
		obstacles = new ArrayList<Shape>();
	}

	public Shape getObstacle(int index) {
		Shape obstacle = null;
		try {
			obstacle = obstacles.get(index);
		} catch (Exception e) {

		}

		return obstacle;
	}

	protected void addObstacle(Shape obstacle) {
		obstacles.add(obstacle);
	}

	protected void removeObstacle(int index) {
		obstacles.remove(index);
	}

}
