package dms.pastor.tasks.exercises.numbers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/04/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FirstPrimeFinderTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private FirstPrimeFinder firstPrimeFinder = new FirstPrimeFinder();

    @Test
    public void findShouldReturnPrimeNumberIfInputWithPrimeNumberAcceptanceCriteria() throws Exception {

        // given
        final int primeNumber = 7;
        final int expectedResult = 7;

        // when
        final int result = firstPrimeFinder.find(primeNumber);

        // then
        assertThat(expectedResult).isEqualTo(result);
    }

    @Test
    public void findShouldReturn0IfInputWithNonPrimeNumberAcceptanceCriteria() throws Exception {

        // given
        final int primeNumber = 4;

        // when
        final int result = firstPrimeFinder.find(primeNumber);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void findShouldReturn7IfInputWith7AcceptanceCriteria() throws Exception {

        // given
        final int primeNumber = 7;
        final int expectedLine = 7;

        // when
        final int result = firstPrimeFinder.find(primeNumber);

        // then
        assertThat(expectedLine).isEqualTo(result);
    }

    @Test
    public void findShouldReturn79ForInputThanSumWillHavePrimeNumberAcceptanceCriteria() throws Exception {

        // given
        final int[] primeNumbers = new int[]{4, 5, 17, 2, 51, 17, 32, 54, 2, 4, 6, 108};
        final int expectedLine = 79;

        // when
        final int result = firstPrimeFinder.find(primeNumbers);

        // then
        assertThat(expectedLine).isEqualTo(result);
    }

    @Test
    public void findShouldReturn0ForInputThanSumWillNotHavePrimeNumberAcceptanceCriteria() throws Exception {

        // given
        final int[] primeNumbers = new int[]{62, 3, 25, 2, 78, 7, 44, 28, 19, 774};

        // when
        final int result = firstPrimeFinder.find(primeNumbers);

        // then
        assertThat(result).isZero();
    }

    @Test
    public void findShouldThrowExceptionIfAnyNumberIsNotPositiveAcceptanceCriteria() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // given
        final int[] primeNumbers = new int[]{62, 3, 25, 2, 78, -7, 44, 28, -19, 774};

        // when
        firstPrimeFinder.find(primeNumbers);
    }

}
