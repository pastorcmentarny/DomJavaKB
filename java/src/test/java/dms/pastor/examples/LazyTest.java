package dms.pastor.examples;

import org.junit.jupiter.api.Test;

public class LazyTest {

    @Test
    public void lazyExampleAcceptanceTest() {
        Lazy<String> lazyToString = new Lazy<String>();
        String x = "LOL";
        String y = "WOW";

        final var start = System.nanoTime();
        System.out.println(lazyToString.getOrCompute(() -> "(" + x + ", " + y + ")"));
        final var coldLap = System.nanoTime();
        System.out.println(lazyToString.getOrCompute(() -> "(" + x + ", " + y + ")"));
        final var stop = System.nanoTime();

        System.out.println("Cold execution: " + (coldLap - start) + "ns. Warm execution: " + (stop - coldLap) + "ns.");
    }
}