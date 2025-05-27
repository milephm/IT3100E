package hust.soict.ict.aims.exception;

import javax.swing.*;

public class PlayerException extends Exception {
    public PlayerException(String msg) {
        super(msg);
        UIManager.put("OptionPane.okButtonText", "OK");
        JOptionPane.showMessageDialog(null, "Error" + msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
