package hust.soict.ict.aims.cart;
import hust.soict.ict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media m) {
        if(this.itemsOrdered.contains(m))
        {
            System.out.println(m.getTitle() + " has already been in this Cart!");
        }
        else
        {
            this.itemsOrdered.add(m);
            System.out.println(m.getTitle() + " added to the Cart!");
        }
    }

    public void removeMedia(Media m) {
        if(!this.itemsOrdered.contains(m)){
            System.out.println(m.getTitle() + " is not in this Cart!");
        }
        else {
            this.itemsOrdered.remove(m);
            System.out.println(m.getTitle() + " removed from the Cart!");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for(Media media : this.itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // print list of ordered items of a cart and its infos
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for(Media media : this.itemsOrdered) {
            System.out.println(media.toString());
        }

        float total = totalCost();
        System.out.printf("Total Cost: %.2f$ \n", total);
        System.out.println("***************************************************");
    }

    // search by ID
    public Media searchID(int id) {
        for(Media media : this.itemsOrdered) {
            if(media.isMatch(id)) {
                return media;
            }
        }
        return null;
    }

    // search by title
    public Media searchTitle(String title) {
        for (Media media : this.itemsOrdered) {
            if(media.isMatch(title))
            {
                return media;
            }
        }
        return null;
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByType() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TYPE_TITLE);
    }

    public void clear() {
        this.itemsOrdered.clear();
    }

}