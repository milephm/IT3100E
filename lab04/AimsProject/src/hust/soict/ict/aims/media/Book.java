package hust.soict.ict.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> author = new ArrayList<String>();

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public Book(int id, String title, String category, float cost, List<String> author) {
        super(id, title, category, cost);
        this.author = author;
    }

    public Book(String title, String category, float cost, List<String> author) {
        super(title, category, cost);
        this.author = author;
    }

    public Book(String title, float cost) {
        super(title, cost);
    }

    public void addAuthor(String author) {
        if(this.author.contains(author)) {
            System.out.println("Author already exists as author of the book");
        }
        else {
            this.author.add(author);
            System.out.println("Author added to the author list of the book");
        }
    }

    public void removeAuthor(String author) {
        if(!this.author.contains(author)) {
            System.out.println("Author does not exist as author of the book");
        }
        else {
            this.author.remove(author);
            System.out.println("Author removed from the author list of the book");
        }
    }

    @Override
    public String toString() {
        return String.format("%d. Book - [%s] - [%s] - [%s]: [%f] $", this.getId(), this.getTitle(), this.getCategory(),
                String.join(", ", this.getAuthor()), this.getCost());
    }
}
