package hust.soict.ict.aims.media;
import java.util.Comparator;

public class MediaComparatorByTypeTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int typeCompare = m1.getClass().getName().compareTo(m2.getClass().getName());
        if (typeCompare != 0) {
            return typeCompare;
        }
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
