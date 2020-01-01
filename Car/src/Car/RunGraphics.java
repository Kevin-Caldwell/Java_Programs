package Car;

public class RunGraphics extends Thread {

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
				Main.game.car.moveCar(4);
			}
			
			if(Main.game.downPressed) {
				Main.game.car.acceleration = -0.5 * Main.game.car.MAX_ACCELERATION;
				Main.game.car.moveCar(4);
			}
			
			if(Main.game.leftPressed) {
				Main.game.car.angle -= Math.toRadians(2);
				Main.game.car.acceleration = Main.game.car.MAX_ACCELERATION;
				Main.game.car.moveCar(4);
			}
			
			if(Main.game.rightPressed) {
				Main.game.car.angle += Math.toRadians(1);
				Main.game.car.acceleration = Main.game.car.MAX_ACCELERATION;
				Main.game.car.moveCar(4);
			}
			
			if(!Main.game.upPressed && !Main.game.downPressed && !Main.game.leftPressed && !Main.game.rightPressed) {
				Main.game.car.slowToStop(4);
				System.out.println("slowed");
			}

			Main.game.repaint();
			
		}

	}

}
