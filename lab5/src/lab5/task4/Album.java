package lab5.task4;

import java.util.ArrayList;

abstract class Album {
    public ArrayList<Song> songs = new ArrayList<>();

    abstract void addSong(Song song);

    void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        return "Album{" +
                "songs=" + songs +
                '}';
    }
}
