package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private final Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    public JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);
        viewStoreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
            }
        });

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem smAddBook = new JMenuItem("Add Book");
        smAddBook.addActionListener(new btnMenuListener());
        smUpdateStore.add(smAddBook);

        JMenuItem smAddCD = new JMenuItem("Add CD");
        smAddCD.addActionListener(new btnMenuListener());
        smUpdateStore.add(smAddCD);

        JMenuItem smAddDVD = new JMenuItem("Add DVD");
        smAddDVD.addActionListener(new btnMenuListener());
        smUpdateStore.add(smAddDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 50));
        title.setForeground(Color.RED);

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));

        return header;
    }

    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Add Book" -> {
                    AddBookToStoreScreen addBookPanel = new AddBookToStoreScreen(store);
                    setContentPane(addBookPanel);
                }
                case "Add CD" -> {
                    AddCompactDiscToStoreScreen addCDPanel = new AddCompactDiscToStoreScreen(store);
                    setContentPane(addCDPanel);
                }
                case "Add DVD" -> {
                    AddDigitalVideoDiscToStoreScreen addDVDPanel = new AddDigitalVideoDiscToStoreScreen(store);
                    setContentPane(addDVDPanel);
                }
            }
            revalidate();
            repaint();
        }
    }
}
