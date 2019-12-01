import java.util.*;

public class MatrixOperations {
	// Defining variables
	public int first_col;
	public int first_row;
	public int second_col;
	public int second_row;

	public int[][] firstMatrix;
	public int[][] secondMatrix;
	private int[][] matrixSum;
	private int[][] matrixDifference;
	private int[][] matrixProduct;

	private boolean canBeAdded = false;
	private boolean canBeMultiplied = false;

	// Store the first Matrix
	void getFirstMatrix() {
		Scanner Input = new Scanner(System.in);

		System.out.println("Enter number of rows in first Matrix: ");
		first_row = Input.nextInt();

		System.out.println();

		System.out.println("Enter number of columns in second Matrix: ");
		first_col = Input.nextInt();

		firstMatrix = new int[first_row][first_col];
		System.out.println("Enter Array: ");

		for (int i = 0; i < firstMatrix.length; i++) {
			for (int j = 0; j < firstMatrix[i].length; j++) {
				firstMatrix[i][j] = Input.nextInt();
			}
		}
	}

	// Store the second Matrix
	void getSecondMatrix() {
		Scanner Input = new Scanner(System.in);

		System.out.println("Enter number of rows in second Matrix: ");
		second_row = Input.nextInt();

		System.out.println();

		System.out.println("Enter number of columns in second Matrix: ");
		second_col = Input.nextInt();

		secondMatrix = new int[second_row][second_col];
		System.out.println("Enter Array: ");

		for (int i = 0; i < secondMatrix.length; i++) {
			for (int j = 0; j < secondMatrix[i].length; j++) {
				secondMatrix[i][j] = Input.nextInt();
			}
		}
	}

	// Print out a given Matrix
	void printMatrix(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;

		System.out.println("The Matrix being shown currently has " + row + " rows and " + col + " columns.");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// Adding Matrices
	int[][] addMatrices() {

		matrixSum = new int[first_row][first_col];

		// Decides whether or not the given Matrices can be added
		if (first_col == second_col & first_row == second_row) {
			canBeAdded = true;
		}

		if (canBeAdded) {
			for (int i = 0; i < first_row; i++) {
				for (int j = 0; j < first_col; j++) {
					matrixSum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
				}
			}
		} else
			matrixSum = null;
		return matrixSum;
	}

	// Subtract Matrices
	int[][] subtractMatrices() {

		matrixDifference = new int[first_row][first_col];

		// Decides whether or not the given Matrices can be added
		if (first_col == second_col & first_row == second_row) {
			canBeAdded = true;
		}

		if (canBeAdded) {
			for (int i = 0; i < first_row; i++) {
				for (int j = 0; j < first_col; j++) {
					matrixDifference[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
				}
			}
		} else
			matrixDifference = null;
		return matrixDifference;
	}

	//only works for square matrices so far
	int[][] multiplyMatrices() {
		
		matrixProduct = new int[first_row][second_col];

		// Decides whether or not the given Matrices can be multiplied
		if (first_col == second_row) canBeMultiplied = true;

		if (canBeMultiplied) {
			for (int i = 0; i < first_row; i++) {
				for (int j = 0; j < second_col; j++) {
					for (int k = 0; k < first_col; k++) {
						matrixProduct[i][j]+= firstMatrix[i][k]*secondMatrix[k][j];
					}
				}
			}
		}else {
			System.out.println("Cannot be multiplied.");
			matrixProduct = null;
		}
		
		return matrixProduct;
	}
	
	private int findDeterminant(int[][] arr) {
		if(arr.length==2) {
			return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
		}
		else {
			int determinant = 0;
			
			for (int i = 0; i < arr[0].length; i++) {
				determinant += Math.pow(-1, i) * arr[0][i] * findDeterminant(findCofactor(arr, i));
//				System.out.println(determinant + " : " + Math.pow(-1, i));
			}
			
			return determinant;
		}
	}
	
	private int[][] findCofactor(int[][] arr, int n){
//		System.out.println("cofactor for " + n);
		
		int length = arr.length - 1;
		int[][] cofactor = new int[length][length];
		
		for(int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				
				if(j >= n) {
					cofactor[i][j] = arr[i+1][j+1];
				} else {
					cofactor[i][j] = arr[i+1][j];
				}
				
//				System.out.println("Cofactor element: " + i + " : " + j + " -> " + cofactor[i][j]);
			}
		}
		
		return cofactor;
	}
}