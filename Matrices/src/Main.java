/**
 * @author Kevin Caldwell
 * Date: 25 November 2018
 * Designed to add, subtract and multiply Matrices
 */

public class Main {
	public static void main(String[] args) {		
		MatrixOperations myMatrix = new MatrixOperations();
		
		myMatrix.getFirstMatrix();		
		myMatrix.getSecondMatrix();		
		
		int[][] Product = myMatrix.multiplyMatrices();
		
		myMatrix.printMatrix(Product);
	}
}
