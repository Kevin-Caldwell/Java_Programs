package CCC_2003;

import java.util.Scanner;

public class Trident {

	public Trident() {
		// TODO Auto-generated constructor stub
	}

	public static void DrawTrident(int t, int s, int h) {
		for (int i = 0; i < t; i++) {
			System.out.print("*");
			for(int k = 0; k < s; k++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for(int k = 0; k < s; k++) {
				System.out.print(" ");
			}			
			System.out.println("*");
			
		}
		
		for(int i = 0; i < s * 2 + 3; i++) {
			System.out.print("*");
		}
	
		for(int i = 0; i < h; i++) {
			System.out.println("");
			for(int k = 0; k < s + 1; k++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DrawTrident(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		
		scanner.close();
	}

}
