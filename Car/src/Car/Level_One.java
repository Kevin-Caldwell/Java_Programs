package Car;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

public class Level_One extends Level {

	public Level_One() {
		super();
		super.level = 1;
		super.color = Color.BLACK;
		super.addObstacle(new Rectangle(0, 0, 200, 200));
		super.addObstacle(new Rectangle(0, 400, 200, 300));
		super.addObstacle(new Rectangle(400, 0, 200, 600));
		super.startPosition = new Rectangle(320, 320, Main.game.car.width + 10, Main.game.car.length + 10);
		super.endPosition = new Rectangle(220, 20, Main.game.car.width + 10, Main.game.car.length + 10);
	}

	@Override
	public Shape getObstacle(int index) {
		return super.getObstacle(index);
	}
}
