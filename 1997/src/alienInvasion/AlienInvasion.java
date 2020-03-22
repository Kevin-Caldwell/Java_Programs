package alienInvasion;

import java.util.ArrayList;

public class AlienInvasion {
	
	public static ArrayList<Gun> gunList = new ArrayList<Gun>();
	
	public int getNumberOfGuns(int[] heights) {
		
//		gunList.add(new Gun(heights[0]));
		
		for (int height : heights) {
			if(newGunRequired(height)) {
				gunList.add(new Gun(height));
				System.out.println(height + " , " + "new gun added");
			}
		}
		
		return gunList.size();
	}
	
	public boolean newGunRequired(int height) {
		boolean newGun = false;
		for (Gun gun : gunList) {
			System.out.println(gunList.indexOf(gun) + ", " + gun.currentHeight);
			newGun = !gun.shoot(height) && !newGun;
		}
		
		

		System.out.println(newGun);
		
		return !newGun;
	}

}
