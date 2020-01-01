package Car;

public class Main {

	static DisplayGame game;
	
	static RunGraphics graphics;

	public static void main(String[] args) {

		game = new DisplayGame();
		graphics = new RunGraphics();
		graphics.start();
	}
}
