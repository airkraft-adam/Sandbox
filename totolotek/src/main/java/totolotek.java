

import java.util.*;

public class totolotek {
    public static void main(String[] args) {

        Wygraj6 wygraj6 = new Wygraj6();
        Set<Integer> wybrane6liczb = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        wygraj6.losowanie(wybrane6liczb);

        System.out.println("Twoje liczby"+wybrane6liczb);
        System.out.printf("wypadly po %,d losowaniach%n", wygraj6.getLicznik());
        System.out.println("w tym czasie wypadlo piátek: " + wygraj6.getPiatka());
        System.out.println("w tym czasie wypodlo czórek: " + wygraj6.getCzworka());
        System.out.println("w tym czasie wypodlo trójek: " + wygraj6.getTrojka());

    }
}