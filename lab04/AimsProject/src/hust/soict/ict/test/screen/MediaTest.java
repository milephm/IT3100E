package hust.soict.ict.test.screen;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();

        // dvd
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", 24.99f, 90, "Ron Clements");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Toy Story", "Animation", 18.99f, 81, "John Lasseter");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Finding Nemo", "Animation", 22.50f,100, "Andrew Stanton");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Cars", "Animation", 21.00f, 117, "John Lasseter");

        mediaList.add(dvd);
        mediaList.add(dvd2);
        mediaList.add(dvd3);
        mediaList.add(dvd4);
        mediaList.add(dvd5);

        // cd
        CompactDisc cd = new CompactDisc("Thriller", "Music", 74.3f);
        CompactDisc cd2 = new CompactDisc("Bad", "Music", 60.5f);
        CompactDisc cd3 = new CompactDisc("Thriller 25", "Music", 75.0f);
        CompactDisc cd4 = new CompactDisc("Dangerous", "Music", 77.0f);
        CompactDisc cd5 = new CompactDisc("HIStory", "Music", 76.0f);

        mediaList.add(cd);
        mediaList.add(cd2);
        mediaList.add(cd3);
        mediaList.add(cd4);
        mediaList.add(cd5);

        // book
        Book book = new Book("The Lord of the Rings", "Fantasy", 50.0f, new ArrayList<>());
        Book book2 = new Book("The Hobbit", "Fantasy", 30.0f, new ArrayList<>());
        Book book3 = new Book("The Two Towers", "Fantasy", 40.0f, new ArrayList<>());
        Book book4 = new Book("The Return of the King", "Fantasy", 45.0f, new ArrayList<>());
        Book book5 = new Book("The Silmarillion", "Fantasy", 55.0f, new ArrayList<>());
        Book book6 = new Book("Unfinished Tales", "Fantasy", 35.0f, new ArrayList<>());

        mediaList.add(book);
        mediaList.add(book2);
        mediaList.add(book3);
        mediaList.add(book4);
        mediaList.add(book5);
        mediaList.add(book6);

        // Print out each item in the mediaList
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
