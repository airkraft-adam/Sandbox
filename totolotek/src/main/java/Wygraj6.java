import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Wygraj6 {

    private int licznik;
    private int piatka;
    private int czworka;
    private int trojka;


    public void losowanie(Set<Integer> wybraneLiczby) {
        Set<Integer> wylosowane = new HashSet<>();
        Set<Integer> robocze = new HashSet<>();
        Random wypadlaLiczba = new Random();
        boolean czyJest6 ;
        do {
            while (wylosowane.size() < 6) {
                wylosowane.add(wypadlaLiczba.nextInt(48 + 1));
            }

            robocze.addAll(wybraneLiczby);
            robocze.retainAll(wylosowane);
            czyJest6 = wybraneLiczby.containsAll(wylosowane);
            licznik++;
            if (robocze.size() == 5) {
                piatka++;
            }
            if (robocze.size() == 4) {
                czworka++;
            }
            if (robocze.size() == 3) {
                trojka++;
            }
            wylosowane.clear();
            robocze.clear();
        }
        while (!czyJest6);
    }

    public int getLicznik() {
        return licznik;
    }

    public int getPiatka() {
        return piatka;
    }

    public int getCzworka() {
        return czworka;
    }

    public int getTrojka() {
        return trojka;
    }
}