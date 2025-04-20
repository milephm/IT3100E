package hust.soict.ict.test.cart;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.CompactDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(2, "The Lion King", "Animation", 19.95f, "Roger Allers");
        cart.addMedia(dvd1);

        CompactDisc dvd2 =  new CompactDisc(1, "Wicked", "Musical", 24.95f, "Jon M Chu");
        cart.addMedia(dvd2);

        cart.print();
        // TO-DO: Test search methods here
        cart.searchID(1);
        cart.searchTitle("Aladdin");
    }
}
