package hust.soict.ict.aims.store;
import hust.soict.ict.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return this.itemsInStore;
    }
    public void addMedia(Media m) {
        if(this.itemsInStore.contains(m))
        {
            System.out.println(m.getTitle() + " has already been in this Store!");
        }
        else
        {
            this.itemsInStore.add(m);
            System.out.println(m.getTitle() + " has been added into the Store!");
        }
    }

    public void removeMedia(Media m) {
        if(!this.itemsInStore.contains(m))
        {
            System.out.println(m.getTitle() + " hasn't been in this Store!");
        }
        else
        {
            this.itemsInStore.remove(m);
            System.out.println(m.getTitle() + " has been removed from the Store!");
        }
    }

    public void print() {
        System.out.println("*********************** STORE ***********************");
        for (Media media : this.itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("******************************************************");
    }

    public Media searchByID(int id) {
        for (Media media : this.itemsInStore) {
            if(media.isMatch(id))
            {
                return media;
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : this.itemsInStore) {
            if(media.isMatch(title))
            {
                return media;
            }
        }
        return null;
    }
}
