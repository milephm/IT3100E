import javax.swing.JOptionPane;

public class demo {
    //Giai pt bac nhat
    public static void FirstDegreeEquation() {
        String str1, str2;
        double a=1, b, result;
        
        //check a
        do {
            if( a==0 ) {
                JOptionPane.showMessageDialog(null, "Invalid because a is can not equal 0"
                            + "Please try again");
            }

            str1 = JOptionPane.showInputDialog(null,
                    "Please input a: ","Input equation ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
            a = Double.parseDouble(str1);
        } while ( a==0 );

        //check b
        str2 = JOptionPane.showInputDialog(null,
                "Please input b: ","Input euqation ax + b = 0", JOptionPane.INFORMATION_MESSAGE);   
        b = Double.parseDouble(str2);

        //solve
        result = -b / a;
        JOptionPane.showMessageDialog(null, "Solution of problem: x = " + result,
                    "Solve quation ax + b = 0", JOptionPane.INFORMATION_MESSAGE);
    }

    //Giai he phuong trinh bac nhat
    public static void SystemFirstDegreeEquation() {
        String str1, str2, str3;
        double[] a = new double[2];
        double[] b = new double[2];
        double[] c = new double[2];
        double D, Dx, Dy, x, y;

        //input a1, b1, c1
        str1 = JOptionPane.showInputDialog(null,
                "Please input a: ","Input the first degree quation ax + by = c", JOptionPane.INFORMATION_MESSAGE);
        a[0] = Double.parseDouble(str1);
        str2 = JOptionPane.showInputDialog(null,
                "Please input b: ","Input the first degree quation ax + by = c", JOptionPane.INFORMATION_MESSAGE);
        b[0] = Double.parseDouble(str2);
        str3 = JOptionPane.showInputDialog(null,
                "Please input c: ","Input the first degree quation ax + by = c", JOptionPane.INFORMATION_MESSAGE);
        c[0] = Double.parseDouble(str3);       

        //input a2, b2, c2
        str1 = JOptionPane.showInputDialog(null,
                "Please input a: ","Input the first degree quation ax + by = c", JOptionPane.INFORMATION_MESSAGE);
        a[1] = Double.parseDouble(str1);
        str2 = JOptionPane.showInputDialog(null,
                "Please input b: ","Input the first degree quation ax + by = c", JOptionPane.INFORMATION_MESSAGE);
        b[1] = Double.parseDouble(str2);
        str3 = JOptionPane.showInputDialog(null,
                "Please input c: ","Input the first degree quation ax + by = c", JOptionPane.INFORMATION_MESSAGE);
        c[1] = Double.parseDouble(str3); 

        D = a[0]*b[1] - a[1]*b[0];
        Dx = c[0]*b[1] - c[1]*b[0];
        Dy = a[0]*c[1] - a[1]*c[0];

        if( D !=0 ) {
            x = Dx / D;
            y = Dy / D;
            JOptionPane.showMessageDialog(null, "Solution of problem : (" + x + "," + y + ").",
                        "Solve system of first-degree quation", JOptionPane.INFORMATION_MESSAGE);
        } else if ( D == Dx && Dx == Dy && Dy == 0) {
            JOptionPane.showMessageDialog(null,
            "This system of equation has infinitely solutions",
            "Solve system of first-degree quation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
            "This system of euqation has no solution",
            "Solve system of first-degree quation", JOptionPane.INFORMATION_MESSAGE);
        }
    } 

    //Giai phuong trinh bac hai
    public static void SecondDegreeEquation() {
        String str1, str2, str3;
        double a=1, b, c;
        double delta, x1, x2;

        do {
            if (a == 0 ) {
                JOptionPane.showMessageDialog(null, "Invalid because a can not equal 0"
                            + "Please try again");
            }
            str1 = JOptionPane.showInputDialog(null,
            "Please input a: ","Input euqation ax^2 + bx +c = 0", JOptionPane.INFORMATION_MESSAGE);
            a = Double.parseDouble(str1);
        } while ( a==0 );

        //input b, c
        str2 = JOptionPane.showInputDialog(null,
            "Please input b: ","Input euqation ax^2 + bx +c = 0", JOptionPane.INFORMATION_MESSAGE);
        b = Double.parseDouble(str2);
        str3 = JOptionPane.showInputDialog(null,
            "Please input c: ","Input euqation ax^2 + bx +c = 0", JOptionPane.INFORMATION_MESSAGE);
        c = Double.parseDouble(str3);

        //solve
        delta = b * b - 4 * a * c;
        if( delta > 0 ) {
            x1 = (-b + Math.sqrt(delta)) / 2*a;
            x2 = (-b - Math.sqrt(delta)) / 2*a;
            JOptionPane.showMessageDialog(null, "Solution of this problem: x1 = " + x1 + " and x2 = " + x2,
            "Solve equation of ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        } else if ( delta == 0 ) {
            x1 = -b / 2*a;
            x2 = x1;
            JOptionPane.showMessageDialog(null, "Solution of this problen: x1 = x2 = " + x1,
            "Solve equation of ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "This system of euqation has no solution",
            "Solve equation of ax^2 + bx + c = 0", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        String option;

        option = JOptionPane.showInputDialog(null,
        "Please select programs: \n"
        + "1. Solve the first-degree euqation (linear euqation) with one varible \n"
        + "2. Solve the system of firsr-degree equations (linear system) with two varibles \n"
        + "3. Solve the second-degree quation with one varible \n"
        + "4. Exit \n", 
        "NMTung's programs", JOptionPane.INFORMATION_MESSAGE 
        );

        switch (option) {
            case "1":
                FirstDegreeEquation();
                main(null);
                break;
            case "2":
                SystemFirstDegreeEquation();
                main(null);
                break;
            case "3":
                SecondDegreeEquation();
                main(null);
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Program is stopped");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Invalid option! Please try again");
                main(null);
        }
    }
}