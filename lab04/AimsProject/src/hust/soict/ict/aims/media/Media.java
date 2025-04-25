package hust.soict.ict.aims.media;
import java.util.Comparator;
import java.util.List;

public class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TYPE_TITLE = new MediaComparatorByTypeTitle();

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%d. Media - [%s] - [%s]: [%f] $", this.getId(), this.getTitle(), this.getCategory(), this.getCost());
    }
    public boolean isMatch(String title) {
        return (this.getTitle()).equals(title);
    }

    public boolean isMatch(int id) {
        return (this.getId()) == id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // the same reference
        if (obj == null || getClass() != obj.getClass()) return false; // null or different class
        Media othermedia = (Media) obj; //
        return this.getTitle().equals(othermedia.getTitle());
    }
}
