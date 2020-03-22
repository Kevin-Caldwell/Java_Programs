package alienInvasion;

import java.io.BufferedReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
		
		int numberOfAliens = 0;
		
		try {
			numberOfAliens = Integer.valueOf(reader.readLine());
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int[] AlienHeights = new int[numberOfAliens];
		
		for(int i = 0; i < numberOfAliens; i++) {
			try {
				AlienHeights[i] = Integer.valueOf(reader.readLine());
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		int numberOfGuns = (new AlienInvasion()).getNumberOfGuns(AlienHeights);
		System.out.println(numberOfGuns);
	}
}
