package hust.soict.ict.aims.media;
import java.util.Comparator;
import java.util.List;

public class Media implements Comparable<Media> {
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
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;
        Media other = (Media) obj;

        // handle possible null titles
        if (this.getTitle() == null || other.getTitle() == null) return false;

        return this.getTitle().equals(other.getTitle()) && Float.compare(this.getCost(), other.getCost()) == 0;
    }

    @Override
    public int compareTo(Media o) {
        if (o == null) throw new NullPointerException("Cannot compare to null");

        // title comparison
        int titleCompare = (this.getTitle() == null ?
                (o.getTitle() == null ? 0 : -1) :
                (o.getTitle() == null ? 1 : this.getTitle().compareTo(o.getTitle()))
        );

        if (titleCompare == 0) {
            return Float.compare(this.getCost(), o.getCost());
        }
        return titleCompare;
    }
}
