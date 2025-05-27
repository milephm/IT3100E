package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleInput, categoryInput, costInput, authorInput;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
    }

    @Override
    protected void buildForm() {
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        titleInput = new JTextField();
        categoryInput = new JTextField();
        costInput = new JTextField();
        authorInput = new JTextField();

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleInput);

        inputPanel.add(new JLabel("Category:"));
        inputPanel.add(categoryInput);

        inputPanel.add(new JLabel("Cost:"));
        inputPanel.add(costInput);

        inputPanel.add(new JLabel("Authors (comma separated):"));
        inputPanel.add(authorInput);

        JButton addButton = new JButton("Add Book");
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
        List<String> author = new ArrayList<>(Arrays.asList(authorInput.getText().split(",")));

        Book book = new Book(title, category, cost, author);
        store.addMedia(book);
        JOptionPane.showMessageDialog(AddBookToStoreScreen.this, "Book added successfully!");
    }
}
