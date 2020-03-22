package Car;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Obstacle {
	
	public static ArrayList<Obstacle> obstacle_Choices;
	
	ImageIcon obstacle;
	String type;
	
	private Obstacle(ImageIcon obstacle, String type) {
		this.obstacle = obstacle;
		this.type = type;
	}
	
	public static void addObstacle(ImageIcon obstacle, String type) {
		obstacle_Choices.add(new Obstacle(obstacle, type));
	}

}
