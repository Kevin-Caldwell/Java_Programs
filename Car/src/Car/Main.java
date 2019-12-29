package Car;

public class Main {

	static DisplayGame game;
	static boolean runGame = true;
	public static void main(String[] args) {
		
		game = new DisplayGame();
		new RunGraphics().start();
	}
}
