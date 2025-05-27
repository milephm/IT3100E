package hust.soict.ict.aims.screen.customer.controller;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {
    private Store store;
    private Cart cart;
    private Stage stage;

    public ViewStoreController(Store store) {
        this.store = store;
        this.cart = new Cart(); // Initialize cart
    }

    public ViewStoreController(Store store, Cart cart, Stage stage) {
        this.store = store;
        this.cart = cart;
        this.stage = stage;
    }

    @FXML
    private GridPane gridPane;

//    @FXML
//    void 004cff(ActionEvent event) {
//
//    }

    @FXML
    public void btnViewCartPressed(ActionEvent event) {
        final String CART_FXML_FILE_PATH = "/hust/soict/ict/aims/screen/customer/view/Cart.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            CartController cartController = new CartController(cart, store, stage);
            fxmlLoader.setController(cartController);

            Parent cartRoot = fxmlLoader.load();
            stage.setTitle("Cart");
            stage.setScene(new Scene(cartRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/ict/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;
        for(int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));

                ItemController itemController = new ItemController(store, cart);
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i), cart);

                if(column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
