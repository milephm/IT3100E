package hust.soict.ict.test.screen.customer.store;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.ict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/ict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ITEM_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart, primaryStage);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        /*
         * Add some item to store here
         */
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, -1, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Aladdin", "Animation", 24.99f, 90, "Ron Clements");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Toy Story", "Animation", 18.99f, 81, "John Lasseter");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Finding Nemo", "Animation", 22.50f,100, "Andrew Stanton");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "Cars", "Animation", 21.00f, 117, "John Lasseter");

        store.addMedia(dvd);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);

        CompactDisc cd =  new CompactDisc(6, "Wicked", "Musical", 24.95f, "Jon M Chu");
        CompactDisc cd2 =  new CompactDisc(7, "Bottoms", "Comedy", 20.35f, "Emma Seligman");
        CompactDisc cd3 = new CompactDisc(8, "Les Misérables", "Musical", 19.99f, "Tom Hooper");
        CompactDisc cd4 = new CompactDisc(9, "La La Land", "Musical", 22.50f, "Damien Chazelle");

        store.addMedia(cd);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);

        launch(args);
    }
}
