package hust.soict.ict.aims.media;

import hust.soict.ict.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    
    @Override
    public String toString() {
        return String.format("Track - [%s] - [%d]", this.getTitle(), this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // the same reference
        if (obj == null || getClass() != obj.getClass()) return false; // null or different class
        Track othertrack = (Track) obj; //
        return this.getTitle().equals(othertrack.getTitle()) && this.getLength() == othertrack.getLength();
    }
    
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD " + this.getTitle());
            System.out.println("DVD Length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }
}
