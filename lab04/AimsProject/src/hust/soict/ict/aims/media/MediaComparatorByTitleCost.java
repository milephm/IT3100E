package hust.soict.ict.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleCompare = m1.getTitle().compareTo(m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Float.compare(m2.getCost(), m1.getCost());
    }
}