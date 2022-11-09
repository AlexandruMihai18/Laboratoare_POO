package lab5.task4;

public class DangerousAlbum extends Album{
    private boolean isPrime(int number) {
        if (number == 0 || number == 1)
            return false;

        int d = 2;
        while (d * d <= number) {
            if (number % d == 0)
                return false;
            d++;
        }

        return true;
    }
    public void addSong(Song song) {
        if (isPrime(song.getId())) {
            songs.add(song);
        }
    }
}
