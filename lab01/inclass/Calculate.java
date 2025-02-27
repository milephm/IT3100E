// 250225 - Lab 01
// Assignemnt 2.2.5
import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null,
        		"Please input the first number: ");
        double num1 = Double.parseDouble(strNum1);
        System.out.println("First number: " + num1);
        
        strNum2 = JOptionPane.showInputDialog(null,
        		"Please input the second number: ");
        double num2 = Double.parseDouble(strNum2);
        System.out.println("Second number: " + num2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1*num2;
        double quotient = num1/num2;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        if(num2 == 0){
            System.out.println("Error. Devisor must be different than 0");
        }
        else System.out.println("Quotient: " + quotient);
        System.exit(0);
    }
}