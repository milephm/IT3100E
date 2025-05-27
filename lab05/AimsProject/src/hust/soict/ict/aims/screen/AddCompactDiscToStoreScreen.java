package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen{
    private JTextField titleInput, categoryInput, costInput, artistInput;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
    }

    @Override
    protected void buildForm() {
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        titleInput = new JTextField();
        categoryInput = new JTextField();
        costInput = new JTextField();
        artistInput = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleInput);

        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryInput);

        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costInput);

        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(artistInput);

        JButton addButton = new JButton("Add CD");
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
        String artist = artistInput.getText();

        CompactDisc cd = new CompactDisc(title, category, cost, artist);

        store.addMedia(cd);
        JOptionPane.showMessageDialog(AddCompactDiscToStoreScreen.this, "CD added successfully!");
    }
}
