package it.altaformazione;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Movimenti<Operazione> movimenti = new MovimentiImpl<>();
        Conto<Operazione> conto = new Conto<>("AAAAXXXX1919", movimenti);

        movimenti.add(new Entrata(109.1, new Date()));
        movimenti.add(new Entrata(230, new Date()));
        movimenti.add(new Entrata(1000.90, new Date()));
        movimenti.add(new Entrata(200, new Date()));

        System.out.println("------------------------");

        System.out.println("CC : " + conto.getCc());

        System.out.println("------------------------");

        /////////////////////////////// FUNCTIONAL JAVA
        /////////////////////////////// ///////////////////////////////////

        // Group by
        // Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
        // .collect(groupingBy(BlogPost::getType));

        // Function<String, Optional<Movimenti<Operazione>>> trovaOperazione =
        Map<String, List<Operazione>> mappa = movimenti.getLista().stream()
                .collect(Collectors.groupingBy(Operazione::getType));

        // Collection sort
        Collections.sort(movimenti.getLista(), (m1, m2) -> m1.getDate().compareTo(m2.getDate()));

        // Optional<String> optionalIsbn = books.entrySet().stream()
        // .filter(e -> "Effective Java".equals(e.getValue()))
        // .map(Map.Entry::getKey)
        // .findFirst();

        // Stream Foreach
        movimenti.getLista().stream().forEach(m -> {
            System.out.println(((Operazione) m).getType());
            System.out.println(((Operazione) m).getDate());
            System.out.println(((Operazione) m).getValue() + "€");
            System.out.println("------------------------");
        });

        System.out.println("TOTALE MOVIMENTI : " + movimenti.getLista().size());
        System.out.println("SALDO CONTO : " + movimenti.getSaldo());

        // Optional
        Optional<Integer> opt = Optional.of(1);
        int val = opt.isPresent() ? opt.get() : null;
        opt.ifPresent(m -> System.out.println(m)); // F(X) -> Y

        int v2 = opt.orElseGet(() -> 0);

    }
}
