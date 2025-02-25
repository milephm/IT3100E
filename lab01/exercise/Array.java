// 250225 - Lab 01
// Exercise 6.5

import java.util.Arrays;
import java.util.Scanner;
public class Array {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
        System.out.println("Enter size of the array: ");
		int num = keyboard.nextInt();
		int[] array = new int[num];
		
        System.out.println("Enter element of the array: ");
		for(int i = 0; i < num; i++) {
			array[i] = keyboard.nextInt();
		}		
		
		Arrays.sort(array);
		double sum = 0;
		for(int i = 0; i < num; i++) {
			sum += array[i];
		}
		double avg = sum/num;
		
        System.out.println("The sorted array is: " + Arrays.toString(array));
        System.out.println("The sum is: " + sum);
        System.out.println("The average is: " + avg);
        
        keyboard.close();
	}
}
