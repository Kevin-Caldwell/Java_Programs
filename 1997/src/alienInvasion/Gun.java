package alienInvasion;

public class Gun {
	
	int currentHeight;
	
	public Gun(int startHeight) {
		this.currentHeight = startHeight;
	}
	
	boolean shoot(int enemyHeight) {
		
		if(enemyHeight < currentHeight) {
			currentHeight = enemyHeight;
			return true;
		} else {
			return false;
		}
	}

}
