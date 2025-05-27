package hust.soict.ict.aims.screen.customer.controller;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.exception.PlayerException;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import hust.soict.ict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;
    private Stage stage;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    public CartController(Cart cart, Store store, Stage stage) {
        this.cart = cart;
        this.store = store;
        this.stage = stage;
    }

    @FXML
    private TableColumn<Media, Integer> colMediaID;
    @FXML
    private Label costLabel;
    @FXML
    private Label costLabel1;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private TextField tfFilter;

    @FXML
    public void initialize() {
        colMediaID.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));

        if(cart.getItemsOrdered() != null)
            tblMedia.setItems(cart.getItemsOrdered());

        costLabel1.setText(cart.totalCost() + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(
                new ChangeListener<String>() {

                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        showFilteredMedia(newValue);
                    }

                    private void showFilteredMedia(String keyword) {
                        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

                        if (!keyword.isEmpty() && radioBtnFilterId.isSelected()) {
                            filteredList.setPredicate(media -> {
                                String idString = String.valueOf(media.getId());
                                return idString.equals(keyword);
                            });
                        } else if (!keyword.isEmpty() &&  radioBtnFilterTitle.isSelected()) {
                            filteredList.setPredicate(media -> {
                                String title = media.getTitle().toLowerCase();
                                return title.contains(keyword.toLowerCase());
                            });
                        } else {
                            filteredList.setPredicate(null);
                        }
                        tblMedia.setItems(filteredList);
                    }
                });
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Book) {
                btnPlay.setVisible(false);
            } else {
                btnPlay.setVisible(true);
            }
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Book) {
            System.out.println("This media cannot be played.");
        } else {
            ((Playable) media).play();
        }
    }

    @FXML
    public void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel1.setText(cart.totalCost() + " $");
    }

    @FXML
    public void btnViewStorePressed(ActionEvent event) {
        final String STORE_FXML_FILE_PATH = "/hust/soict/ict/aims/screen/customer/view/Store.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            ViewStoreController viewStoreController = new ViewStoreController(store, cart, primaryStage);
            fxmlLoader.setController(viewStoreController);

            Parent root = fxmlLoader.load();
            primaryStage.setTitle("Store");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void orderPlaced(ActionEvent event) {
        cart.print();
    }
}

