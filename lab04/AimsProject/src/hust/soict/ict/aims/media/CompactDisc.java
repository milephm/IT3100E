package hust.soict.ict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, float cost) {
        super(title, cost);
    }

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost, director);
    }

    public String getArtist() {
        return artist;
    }


    public void addTrack(Track track) {
        if(this.tracks.contains(track)) {
            System.out.println("Track already exists in this Compact Disc");
        }
        else {
            this.tracks.add(track);
            System.out.println("Track added to this Compact Disc");
        }
    }

    public void removeTrack(Track track) {
        if(!this.tracks.contains(track)) {
            System.out.println("Track does not exist in this Compact Disc");
        }
        else {
            this.tracks.remove(track);
            System.out.println("Track removed from this Compact Disc");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for(Track e: this.tracks) {
            totalLength += e.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return String.format("%d. CompactDisc - [%s] - [%s] - [%s] - [%s] - [%d]: [%f] $", this.getId(), this.getTitle(),
                this.getCategory(), this.getDirector(), this.getArtist(), this.getLength(), this.getCost());
    }

    public void play() {
        for(Track track : tracks) {
            System.out.println("Playing Track: " + track.getTitle());
            track.play();
        }
    }
}
