// 250225 - Lab 01
// Assignemnt 2.2.6
import javax.swing.JOptionPane;
import java.lang.Math; 

public class SolveEquation {
    // first degree equation
    public static void FirstDegreeEquation(){
        String str1, str2;
        double a, b, res;

        while(true){
            str1 = JOptionPane.showInputDialog(null,
                    "Input a: ");
            a = Double.parseDouble(str1);
        if(a == 0){
            JOptionPane.showMessageDialog(null, "Invalid! Please try again.");
        } else break;
        }

        str2 = JOptionPane.showInputDialog(null,
        		"Input b: ");
        b = Double.parseDouble(str2);

        // solve
        res = -b/a;
        JOptionPane.showMessageDialog(null, "Solution: " + res);
    }

    // system of first degree equation (linear system)
    public static void SystemFirstDegreeEquation(){
        String str1, str2, str3;
        double a1, b1, c1;
        double a2, b2, c2;
        double D, Dx, Dy;
        double x, y;

        // first equation
        str1 = JOptionPane.showInputDialog(null,
        "Input a1: ");
        a1 = Double.parseDouble(str1);

        str2 = JOptionPane.showInputDialog(null,
        "Input b1: ");
        b1 = Double.parseDouble(str2);

        str3 = JOptionPane.showInputDialog(null,
        "Input c1: ");
        c1 = Double.parseDouble(str3);

        // second equation
        str1 = JOptionPane.showInputDialog(null,
        "Input a2: ");
        a2 = Double.parseDouble(str1);

        str2 = JOptionPane.showInputDialog(null,
        "Input b2: ");
        b2 = Double.parseDouble(str2);

        str3 = JOptionPane.showInputDialog(null,
        "Input c2: ");
        c2 = Double.parseDouble(str3);

        // calculate determinants
        D = a1*b2 - a2*b1;
        Dx = c1*b2 - c2*b1;
        Dy = a1*c2 - a2*c1;

        if( D !=0 ) {
            x = Dx / D;
            y = Dy / D;
            JOptionPane.showMessageDialog(null, "Solution: (" + x + "," + y + ").");
        } else if ( D == Dx && Dx == Dy && Dy == 0) {
            JOptionPane.showMessageDialog(null,
            "The system of equation has infinitely solutions");
        } else {
            JOptionPane.showMessageDialog(null,
            "The system of euqation has no solution");
        }
    }

    // second-degree equation
    public static void SecondDegreeEquation() {
        String str1, str2, str3;
        double a, b, c;
        double x1, x2;

        // check a and input 
        while(true){
            str1 = JOptionPane.showInputDialog(null,
                    "Input a: ");
            a = Double.parseDouble(str1);
        if(a == 0){
            JOptionPane.showMessageDialog(null, "Invalid! Please try again.");
        } else break;
        }

        str2 = JOptionPane.showInputDialog(null,
        "Input b: ");
        b = Double.parseDouble(str2);

        str3 = JOptionPane.showInputDialog(null,
        "Input c: ");
        c = Double.parseDouble(str3);

        // solve
        double delta = b*b - 4*a*c;
        if(delta > 0) {
            x1 = (-b + Math.sqrt(delta))/2*a;
            x2 = (-b - Math.sqrt(delta))/2*a;
            JOptionPane.showMessageDialog(null, "Solution: x1 = " + x1 + " and x2 = " + x2);
        } else if(delta == 0) {
            x1 = -b / 2*a;
            x2 = x1;
            JOptionPane.showMessageDialog(null, "Solution: x1 = x2 = " + x1);
        } else {
            JOptionPane.showMessageDialog(null, "This system of euqation has no solution");
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
                JOptionPane.showMessageDialog(null, "Exit program");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Invalid! Please try again");
                main(null);
        }
    }
}