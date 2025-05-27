package hust.soict.ict.aims.screen.customer.controller;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.exception.PlayerException;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import hust.soict.ict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Store store;
    private Cart cart;

    public ItemController(Store store) {
        this.store = store;
        this.cart = new Cart(); // Default cart if none provided
    }

    public ItemController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        lb1Title.setText(media.getTitle());
        lb1Cost.setText(media.getCost() + "$");
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    private Label lb1Cost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lb1Title;

    @FXML
    public void btnAddToCartClicked(ActionEvent event) {
        // Add media to cart
        if(cart.getItemsOrdered().size() < Cart.MAX_NUMBERS_ORDERED){
            cart.addMedia(media);
            //System.out.println("Added to cart: " + media.getTitle());
        } else {
            //System.out.println("The cart is full. Cannot add more items.");
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if(media instanceof Playable){
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("This media cannot be played.");
        }
    }
}



