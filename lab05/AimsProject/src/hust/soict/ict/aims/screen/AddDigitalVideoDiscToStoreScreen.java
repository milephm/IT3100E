package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
    private JTextField titleInput, categoryInput, costInput, directorInput, lengthInput;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
    }

    @Override
    protected void buildForm() {
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        titleInput = new JTextField();
        categoryInput = new JTextField();
        costInput = new JTextField();
        directorInput = new JTextField();
        lengthInput = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleInput);

        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryInput);

        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costInput);

        inputPanel.add(new JLabel("Director:"));
        inputPanel.add(directorInput);

        inputPanel.add(new JLabel("Length:"));
        inputPanel.add(lengthInput);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> addItem());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void addItem() {
        String title = titleInput.getText();
        String category = categoryInput.getText();
        float cost = Float.parseFloat(costInput.getText());
        String director = directorInput.getText();
        int length = Integer.parseInt(lengthInput.getText());

        DigitalVideoDisc cd = new DigitalVideoDisc(title, category, cost, length, director);

        store.addMedia(cd);
        JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this, "DVD added successfully!");
    }
}
