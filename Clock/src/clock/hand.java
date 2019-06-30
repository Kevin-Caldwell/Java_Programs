package clock;

public class hand{
	
	public int length = 20;
	
	public int EndX = 200;
	public int EndY = 200;
	
	public final int CentreX = 200;
	public final int CentreY = 200;
	
	public double angle = 90;
	public double slope = 0;
	
	public int handType;
	
	public MyTime currentTime;
	
		
	/**
	 * @param length
	 * @param angle
	 */
	public hand(int length, int angle, int handType) {
		this.length = length;
		this.angle = angle;
		this.handType = handType;
		
		currentTime = new MyTime();
		currentTime.getCurrentTime();
	}
	
	/**
	 * Finds new coordinates
	 */
	public void findNewCoordinates() {

		if(handType == 0) {
			angle = currentTime.seconds + 90;
		} else if(handType == 1) {
			angle = currentTime.minutes + 90;
		} else if(handType == 2) {
			angle = currentTime.hours + 90;
		} else {
			angle = 23;
		}
		
		
		System.out.println(angle);
		
		EndX = (int)(200 - length * Math.cos(Math.toRadians(angle)));
		EndY = (int)(200 - length * Math.sin(Math.toRadians(angle)));
		
		currentTime.addOneSecond();
	}
}
