// 250225 - Lab 01
// Exercise 6.6

import java.util.Scanner;
public class MatrixAdd {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
        System.out.println("Enter the size of the matrix");
        System.out.println("Row: ");
        int rows = keyboard.nextInt();
        System.out.println("Column: ");
        int columns = keyboard.nextInt();

        double[][] matrixA = new double[rows][columns];
        double[][] matrixB = new double[rows][columns];
        
        // matrixA
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < columns; j++) {
                System.out.println("Enter element [" + (i) + "][" + (j) + "] of the first matrix: ");
        		matrixA[i][j] = keyboard.nextDouble();
        	}
        }
        
        // matrixB
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < columns; j++) {
                System.out.println("Enter element [" + (i) + "][" + (j) + "] of the first matrix: ");
        		matrixB[i][j] = keyboard.nextDouble();
        	}
        }        
        // sum of 2 matrices
		double[][] sum = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sum[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
		
		// print result
        System.out.println("Sum of the two matrices is: ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(sum[i][j] + "\t");
			}
			System.out.println();
		}
		keyboard.close();
	}
}
