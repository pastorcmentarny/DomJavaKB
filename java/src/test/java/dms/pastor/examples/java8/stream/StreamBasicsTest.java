package dms.pastor.examples.java8.stream;

import dms.pastor.ExampleRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class StreamBasicsTest implements ExampleRunner {

    @Test
    public void getRandomNumbersAcceptanceTest() {
        // when
        final int[] randomNumbers = StreamBasics.getRandomNumbersUsingIntStream();

        // debug
        System.out.println(Arrays.toString(randomNumbers));

        // then
        assertThat(randomNumbers.length).isLessThanOrEqualTo(10);
        assertThat(randomNumbers.length).isGreaterThan(5);
    }


    @Test
    public void streamFilterMapSortedExampleAcceptanceTest() {
        // when
        final var result = StreamBasics.streamFilterMapSortedExample();

        // then
        assertThat(result).isEqualTo(Arrays.asList("AA", "AB", "AC", "AD", "AE", "AF"));
    }

    @Test
    public  void printIfFindFirstIfPresentAcceptanceTest(){
        // when
        StreamBasics.printIfFindFirstIfPresent();

        // check output as i am too lazy to catch print for this
    }
}