package Car;

public class RunGraphics extends Thread {
	
	public static final double angleIncrement = 1/60;

	public RunGraphics() {
	}

	@Override
	public void run() {

		while (!isInterrupted()) {

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(Main.game.upPressed) {
				Main.game.car.acceleration = Main.game.car.MAX_ACCELERATION;
				Main.game.car.moveCar(0.01);
			}
			
			if(Main.game.downPressed) {
				Main.game.car.acceleration = -2 * Main.game.car.MAX_ACCELERATION;
				Main.game.car.moveCar(0.01);
			}
			
			if(Main.game.leftPressed) {
				Main.game.car.angle -= Math.toRadians(angleIncrement * getAbs(Main.game.car.speed));
				System.out.println(Main.game.car.angle);
			}
			
			if(Main.game.rightPressed) {
				Main.game.car.angle += Math.toRadians(angleIncrement * getAbs(Main.game.car.speed));
			}
			
			if(!Main.game.upPressed && !Main.game.downPressed) {
				Main.game.car.slowToStop(0.01);
			}

			Main.game.repaint();
			
		}

	}
	
	public static double getAbs(double a) {
		if(a < 0) {
			return a *= -1;
		} else {
			return a;
		}
	}

}
