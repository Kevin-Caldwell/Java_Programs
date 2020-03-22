package ccc_2004;

import java.util.Scanner;

public class Terms_Of_Office {

	public Terms_Of_Office() {
	}
	
	public static int getNextYear(int x, int y) {
		if((y - x) >= 60) {
			return x + 60;	
		} else {
			return -1;
		} 
		
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the current year:");
		int x = scanner.nextInt();
		System.out.println("Enter a future year:");
		int y = scanner.nextInt();
		
		System.out.println("All positions change in year " + x);
		while(getNextYear(x, y) != -1) {
			System.out.println("All positions change in year " + getNextYear(x, y));
			x += 60;
		}
		
		scanner.close();

	}

}
