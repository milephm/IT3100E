package hust.soict.ict.test.store;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Anination", 18.99f);
        store.addMedia(dvd3);

        DigitalVideoDisc tmp = new DigitalVideoDisc(4, "Wicked", "Musical", 100.01f);
        store.removeMedia(tmp);

        store.removeMedia(dvd2);
    }
}
