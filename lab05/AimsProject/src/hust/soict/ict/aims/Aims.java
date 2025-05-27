package hust.soict.ict.aims;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.exception.PlayerException;
import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import hust.soict.ict.aims.screen.StoreManagerScreen;
import hust.soict.ict.aims.store.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aims {
    public static Scanner scanner = new Scanner(System.in);
    public static Store store = new Store();
    public static Cart cart = new Cart();

    public static void main(String[] args) {
        init();
        StoreManagerScreen screen = new StoreManagerScreen(store);
        System.out.println(screen);
    }

    public static void init() {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", 24.99f, 90, "Ron Clements");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Toy Story", "Animation", 18.99f, 81, "John Lasseter");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Finding Nemo", "Animation", 22.50f,100, "Andrew Stanton");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Cars", "Animation", 21.00f, 117, "John Lasseter");

        store.addMedia(dvd);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);

        // cd
        CompactDisc cd = new CompactDisc("Thriller", "Music", 74.3f);
        CompactDisc cd2 = new CompactDisc("Bad", "Music", 60.5f);
        CompactDisc cd3 = new CompactDisc("Thriller 25", "Music", 75.0f);
        CompactDisc cd4 = new CompactDisc("Dangerous", "Music", 77.0f);
        CompactDisc cd5 = new CompactDisc("HIStory", "Music", 76.0f);

        store.addMedia(cd);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);
        store.addMedia(cd5);

        // book
        Book book = new Book("The Lord of the Rings", "Fantasy", 50.0f, new ArrayList<>());
        Book book2 = new Book("The Hobbit", "Fantasy", 30.0f, new ArrayList<>());
        Book book3 = new Book("The Two Towers", "Fantasy", 40.0f, new ArrayList<>());
        Book book4 = new Book("The Return of the King", "Fantasy", 45.0f, new ArrayList<>());
        Book book5 = new Book("The Silmarillion", "Fantasy", 55.0f, new ArrayList<>());
        Book book6 = new Book("Unfinished Tales", "Fantasy", 35.0f, new ArrayList<>());

        store.addMedia(book);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(book5);
        store.addMedia(book6);
    }

    public static void showMenu() throws PlayerException {
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("------------------------------------------------------");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    storeMenu();
                    continue;
                case 2:
                    updateStoreMenu();
                    continue;
                case 3:
                    cartMenu();
                    continue;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }

    public static void updateStoreMenu() {
        while (true) {
            System.out.println("Options:");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("------------------------------------------------------");
            System.out.println("---> ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    Media newItem = createNewMedia();
                    store.addMedia(newItem);
                    continue;
                case 2:
                    System.out.println("Enter the media title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    Media foundMedia = store.searchByTitle(title);
                    store.removeMedia(foundMedia);
                    continue;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }

    public static Media createNewMedia() {
        Media item = null;
        System.out.println("Enter the Media info");
        System.out.println("Title: ");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Cost: ");
        float price = scanner.nextFloat();

        while (true) {
            System.out.println("Chosse a media type: ");
            System.out.println("1. Book");
            System.out.println("2. DigitalVideoDisc");
            System.out.println("3. CD");
            System.out.println("0. Back");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    item = new Book(title, price);
                    break;
                case 2:
                    item = new DigitalVideoDisc(title, price);
                    break;
                case 3:
                    item = new CompactDisc(title, price);
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
        return item;
    }

    public static void storeMenu() throws PlayerException {
        while (true) {
            store.print();
            System.out.println("Options: ");
            System.out.println("------------------------------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play media");
            System.out.println("4. See current cart");
            System.out.println("0. Exit");
            System.out.println("------------------------------------------------------");
            System.out.println("Please choose a number: 0, 1, 2, 3, 4");
            System.out.println("--->");

            String title;
            Media item;
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("Enter the media title: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    item = store.searchByTitle(title);
                    if(item != null) {
                        mediaDetailMenu(item);
                    }
                    continue;
                case 2:
                    System.out.println("Enter the media title: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    item = store.searchByTitle(title);
                    if(item != null) {
                        cart.addMedia(item);
                    }
                    continue;
                case 3:
                    System.out.println("Enter the media title: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    item = store.searchByTitle(title);
                    if(item instanceof Playable) {
                        ((Playable) item).play();
                    } else if (item != null) {
                        System.out.println("This item is not playable");
                    }
                    continue;
                case 4:
                    cart.print();
                    continue;
                default:
                    System.out.println("Invalid choise, please try again");
                    continue;
            }
            break;
        }
    }


    public static void mediaDetailMenu(Media item) throws PlayerException {
        while (true) {
            System.out.println(item.toString());
            System.out.println("Options: ");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("------------------------------------------------------");
            System.out.println("Please chosse a number: 0, 1, 2");
            System.out.println("--->");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    cart.addMedia(item);
                    continue;
                case 2:
                    if(item instanceof Book) {
                        System.out.println("Books are not playable");
                    } else if (item instanceof Playable) {
                        ((Playable) item).play();
                    }
                    continue;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }

    public static void cartMenu() throws PlayerException {
        cart.print();
        while (true) {
            System.out.println("Options: ");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("Please choose a number: 0, 1, 2, 3, 4, 5");
            System.out.println("--->");

            int choice = scanner.nextInt();
            scanner.nextLine();
            String title = null;
            int id;
            Media item = null;
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("1. Filter by ID");
                    System.out.println("2. Filter by title");
                    System.out.print("Choose an option: ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine(); // Xử lý ký tự xuống dòng
                    switch (filterChoice) {
                        case 1:
                            System.out.print("Enter the ID: ");
                            id = scanner.nextInt();
                            scanner.nextLine(); // Xử lý ký tự xuống dòng
                            System.out.println(cart.searchID(id));
                            break;
                        case 2:
                            System.out.print("Enter the title: ");
                            title = scanner.nextLine();
                            System.out.println(cart.searchTitle(title));
                            break;
                        default:
                            System.out.println("Invalid filter option");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Sort by cost");
                    System.out.println("2. Sourt by title");
                    System.out.println("Choose an option: ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (sortChoice) {
                        case 1:
                            cart.sortByCost();
                            cart.print();
                            break;
                        case 2:
                            cart.sortByTitle();
                            cart.print();
                            break;
                        default:
                            System.out.println("Invalid sort option");
                            break;
                    }
                case 3:
                    System.out.println("Enter the title: ");
                    title = scanner.nextLine();
                    item  = cart.searchTitle(title);
                    if(item != null) {
                        cart.removeMedia(item);
                    }
                    cart.print();
                    continue;
                case 4:
                    System.out.print("Enter a title: ");
                    title = scanner.nextLine();
                    item = cart.searchTitle(title);

                    if (item == null) {
                        System.out.println("Item not found.");
                        continue;
                    }

                    if (item instanceof Playable) {
                        ((Playable) item).play();
                    } else {
                        System.out.println("Item not playable.");
                    }
                    continue;
                case 5:
                    System.out.println("Order info:");
                    System.out.println("Total cost: " + cart.totalCost());
                    System.out.println("1. Continue\t2. Back");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            cart.clear();;
                            System.out.println("Order placed successfully");
                            break;
                        case 2:
                            break;
                    }
                    continue;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
            break;
        }
    }
}