package dms.pastor.tasks.exercises.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/04/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FirstPrimeFinderTest {


    private final FirstPrimeFinder firstPrimeFinder = new FirstPrimeFinder();

    @Test
    public void findShouldReturnPrimeNumberIfInputWithPrimeNumberAcceptanceCriteria() {

        // given
        final int primeNumber = 7;
        final int expectedResult = 7;
        // when
        final int result = firstPrimeFinder.find(primeNumber);

        // then
        assertThat(expectedResult).isEqualTo(result);
    }

    @Test
    public void findShouldReturn0IfInputWithNonPrimeNumberAcceptanceCriteria() {

        // given
        final int primeNumber = 4;
        // when
        final int result = firstPrimeFinder.find(primeNumber);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void findShouldReturn7IfInputWith7AcceptanceCriteria() {

        // given
        final int primeNumber = 7;
        final int expectedLine = 7;
        // when
        final int result = firstPrimeFinder.find(primeNumber);

        // then
        assertThat(expectedLine).isEqualTo(result);
    }

    @Test
    public void findShouldReturn79ForInputThanSumWillHavePrimeNumberAcceptanceCriteria() {

        // given
        final int[] primeNumbers = new int[]{4, 5, 17, 2, 51, 17, 32, 54, 2, 4, 6, 108};
        final int expectedLine = 79;
        // when
        final int result = firstPrimeFinder.find(primeNumbers);

        // then
        assertThat(expectedLine).isEqualTo(result);
    }

    @Test
    public void findShouldReturn0ForInputThanSumWillNotHavePrimeNumberAcceptanceCriteria() {

        // given
        final int[] primeNumbers = new int[]{62, 3, 25, 2, 78, 7, 44, 28, 19, 774};
        // when
        final int result = firstPrimeFinder.find(primeNumbers);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void findShouldThrowExceptionIfAnyNumberIsNotPositiveAcceptanceCriteria() {
        // given
        final int[] primeNumbers = new int[]{62, 3, 25, 2, 78, -7, 44, 28, -19, 774};
        // when
        Assertions.assertThrows(IllegalArgumentException.class, () -> firstPrimeFinder.find(primeNumbers));
    }

}
