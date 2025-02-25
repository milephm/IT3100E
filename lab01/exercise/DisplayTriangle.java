// 250225 - Lab 01
// Exercise 6.3

import javax.swing.JOptionPane;
public class DisplayTriangle{
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog(null, "Enter a number: ");
        int n = Integer.parseInt(input);
        for(int i = 1, k = 0; i <= n; ++i, k = 0){
            for(int space = 1; space <= n - i; ++space){
                System.out.print(" ");
            }
            while(k != 2*i-1){
                System.out.print("*");
                ++k;
            }
            System.out.println();
        }
    }
}
