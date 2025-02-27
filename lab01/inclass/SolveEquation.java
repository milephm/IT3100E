// 250225 - Lab 01
// Assignemnt 2.2.6
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.lang.Math; 

public class SolveEquation {
	public static Scanner keyboard = new Scanner(System.in);
    // first degree equation
    public static void FirstDegreeEquation(){
    	double a, b;
        while(true){
            System.out.println("Input a: ");
            a = keyboard.nextDouble();
        if(a == 0){
            System.out.println("Invalid! Please try again.");
        } else break;
        }

        System.out.println("Input b: ");
        b = keyboard.nextDouble();

        // solve
        double res = -b/a;
        System.out.println("Solution: " + res);
    }

    // system of first degree equation (linear system)
    public static void SystemFirstDegreeEquation(){
        double a1, b1, c1;
        double a2, b2, c2;
        double D, Dx, Dy;
        double x, y;

        // first equation
        System.out.println("Input a1: ");
        a1 = keyboard.nextDouble();

        System.out.println("Input b1: ");
        b1 = keyboard.nextDouble();

        System.out.println("Input c1: ");
        c1 = keyboard.nextDouble();

        // second equation
        System.out.println("Input a2: ");
        a2 = keyboard.nextDouble();

        System.out.println("Input b2: ");
        b2 = keyboard.nextDouble();

        System.out.println("Input c2: ");
        c2 = keyboard.nextDouble();

        // calculate determinants
        D = a1*b2 - a2*b1;
        Dx = c1*b2 - c2*b1;
        Dy = a1*c2 - a2*c1;

        if( D !=0 ) {
            x = Dx / D;
            y = Dy / D;
            System.out.println("Solution: " + x + " and " + y + "");
        } else if ( D == Dx && Dx == Dy && Dy == 0) {
        	System.out.println(
            "The system of equation has infinitely solutions");
        } else {
        	System.out.println(
            "The system of euqation has no solution");
        }
    }

    // second-degree equation
    public static void SecondDegreeEquation() {
        double a, b, c;
        double x1, x2;

        // check a and input 
        while(true){
            System.out.println("Input a: ");
            a = keyboard.nextDouble();
        if(a == 0){
            System.out.println("Invalid! Please try again.");
        } else break;
        }

        System.out.println("Input b: ");
        b = keyboard.nextDouble();

        System.out.println("Input c: ");
        c = keyboard.nextDouble();

        // solve
        double delta = b*b - 4*a*c;
        if(delta > 0) {
            x1 = (-b + Math.sqrt(delta))/2*a;
            x2 = (-b - Math.sqrt(delta))/2*a;
            System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        } else if(delta == 0) {
            x1 = -b / 2*a;
            x2 = x1;
            System.out.println("Solution: x1 = x2 = " + x1);
        } else {
        	System.out.println("This system of euqation has no solution");
        }
        
    }

    // main programm
    public static void main(String[] args) {
        String option;

        option = JOptionPane.showInputDialog(null,
            "1 = First-degree equation (linear equation)\n"
            + "2 = System of first-degree equations (linear system)\n"
            + "3 = Second-degree equation]\n"
            + "4 = Exit");

        switch (option) {
            case "1":
                FirstDegreeEquation();
                break;
            case "2":
                SystemFirstDegreeEquation();
                break;
            case "3":
                SecondDegreeEquation();
                break;
            case "4":
                System.out.println("Exit program");
                System.exit(0);
            default:
            	System.out.println("Invalid! Please try again");
                main(null);
        }
    }
}