package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel inputPanel;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;
        setTitle(title);
        setSize(1024, 768);
        setLayout(new BorderLayout());

        setJMenuBar(createMenuBar());

        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> addItem());
        btnPanel.add(btnAdd);
        add(btnPanel, BorderLayout.SOUTH);

        buildForm();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        StoreManagerScreen tempScreen = new StoreManagerScreen(store);
        return tempScreen.createMenuBar();
    }

    protected abstract void buildForm();
    protected abstract void addItem();
}
