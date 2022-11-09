package lab5.task4;

public class BadAlbum extends Album{
    private boolean isPalindrom(int number) {
        int copy = number;
        int palindrom = 0;

        while (copy > 0) {
            palindrom = palindrom * 10 + copy % 10;
            copy /= 10;
        }

        if (number == palindrom)
            return true;

        return false;
    }
    public void addSong(Song song) {
        if (song.getName().length() == 3 && isPalindrom(song.getId()))
            songs.add(song);
    }
}
