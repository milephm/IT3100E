package hust.soict.ict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;


    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(int id, String title) {
        super(id, title);
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Disc(String title, float cost) {
        super(title, cost);
    }

    public Disc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost);
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    @Override
    public String toString() {
        return String.format("%d. Disc - [%s] - [%s] - [%s] - [%d]: [%f] $", this.getId(), this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
    }
}
