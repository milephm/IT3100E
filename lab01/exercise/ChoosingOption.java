// 250225 - Lab 01
// Exercise 6.1

import javax.swing.JOptionPane;
public class ChoosingOption{
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");

        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}

// If users choose "Cancel" => Option chosen = "No"
// To customize the options use ShowOptionDialog(null, "Do you want to change to the first class ticket?", 
// "Choose", 0, 0, null, options, options[0]) with options[] = "I do", "I don't",...