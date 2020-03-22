package ccc_2004;

import java.util.Scanner;

public class Squares {

	public Squares() {
	}
	
	public static int getLargestSquareSide(int tiles) {
		int side = 1;
		int remainder = 1;
		
		while (remainder != tiles) {
			side++;
			remainder = tiles % (side * side);
			
		}
		
		return side-1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of Tiles?");
		System.out.println("The largest square has side length " + getLargestSquareSide(scanner.nextInt()));
		scanner.close();
	}

}
