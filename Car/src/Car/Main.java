package Car;

public class Main {

	static DisplayGame game;
	
	static RunGraphics graphics;
	static Level currLevel;
	static boolean levelFinished = false;

	public static void main(String[] args) {
		currLevel = new Level_One(); 
		game = new DisplayGame();
		graphics = new RunGraphics();
		graphics.start();
//		carProperties = new ShowCarProperties();		
	}
}
