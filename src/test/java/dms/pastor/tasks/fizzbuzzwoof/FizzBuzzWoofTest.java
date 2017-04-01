package dms.pastor.tasks.fizzbuzzwoof;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 *
 */
public class FizzBuzzWoofTest {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String WOOF = "Woof";

    @Test
    public void getResultFor1shouldReturn1() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(1);

        // then
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void getResultFor2shouldReturn2() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(2);

        // then
        assertThat(result).isEqualTo("2");
    }

    @Test
    public void getResultFor3shouldReturnFizzFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(3);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ);
    }

    @Test
    public void getResultFor4shouldReturn4() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(4);

        // then
        assertThat(result).isEqualTo("4");
    }

    @Test
    public void getResultFor5shouldReturnBuzzBuzz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(5);

        // then
        assertThat(result).isEqualTo(BUZZ + BUZZ);
    }

    @Test
    public void getResultFor6shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(6);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor7shouldReturnWoofWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(7);

        // then
        assertThat(result).isEqualTo(WOOF + WOOF);
    }

    @Test
    public void getResultFor8shouldReturn8() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(8);

        // then
        assertThat(result).isEqualTo("8");
    }

    @Test
    public void getResultFor9shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(9);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor10shouldReturnBuzz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(10);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void getResultFor11shouldReturn11() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(11);

        // then
        assertThat(result).isEqualTo("11");
    }

    @Test
    public void getResultFor12shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(12);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor13shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(13);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor14shouldReturnWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(14);

        // then
        assertThat(result).isEqualTo(WOOF);
    }

    @Test
    public void getResultFor15shouldReturnFizzBuzzBuzz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(15);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ);
    }

    @Test
    public void getResultFor17shouldReturnWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(17);

        // then
        assertThat(result).isEqualTo(WOOF);
    }

    @Test
    public void getResultFor18shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(18);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor19shouldReturn19() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(19);

        // then
        assertThat(result).isEqualTo("19");
    }

    @Test
    public void getResultFor20shouldReturnBuzz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(20);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void getResultFor21shouldReturnFizzWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(21);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor23shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(23);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor25shouldReturnBuzzBuzz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(25);

        // then
        assertThat(result).isEqualTo(BUZZ + BUZZ);
    }

    @Test
    public void getResultFor27shouldReturnFizzWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(27);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor31shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(31);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor33shouldReturnFizzFizzFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(33);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + FIZZ);
    }

    @Test
    public void getResultFor35shouldReturnFizzBuzzBuzzWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(35);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ + WOOF);
    }

    @Test
    public void getResultFor37shouldReturnFizzWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(37);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor42shouldReturnFizzWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(42);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor55shouldReturnBuzzBuzzBuzz() throws Exception {

        // when
        final String result = FizzBuzzWoof.getResultFor(55);

        // then
        assertThat(result).isEqualTo(BUZZ + BUZZ + BUZZ);
    }

    @Test
    public void getResultFor63shouldReturnFizzFizzWoof() throws Exception {

        // when
        final String result = FizzBuzzWoof.getResultFor(63);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + WOOF);
    }

    @Test
    public void getResultFor70shouldReturnBuzzWoofWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(70);

        // then
        assertThat(result).isEqualTo(BUZZ + WOOF + WOOF);
    }

    @Test
    public void getResultFor77shouldReturnWoofWoofWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(77);

        // then
        assertThat(result).isEqualTo(WOOF + WOOF + WOOF);
    }

    @Test
    public void getResultFor99shouldReturnFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(99);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor105shouldReturnFizzBuzzBuzzWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(105);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ + WOOF);
    }

    @Test
    public void getResultFor210shouldReturnFizzBuzzWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(210);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + WOOF);
    }

    @Test
    public void getResultFor211shouldReturn211() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(211);

        // then
        assertThat(result).isEqualTo("211");
    }

    @Test
    public void getResultFor333shouldReturnFizzFizzFizzFizz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(333);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + FIZZ + FIZZ);
    }

    @Test
    public void getResultFor357shouldReturnFizzFizzBuzzWoofWoof() throws Exception {

        // when
        final String result = FizzBuzzWoof.getResultFor(357);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + BUZZ + WOOF + WOOF);
    }

    @Test
    public void getResultFor555shouldReturnFizzBuzzBuzzBuzzBuzz() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(555);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ + BUZZ + BUZZ);
    }

    @Test
    public void getResultFor777shouldReturnWoofWoofWoofWoof() throws Exception {
        // when
        final String result = FizzBuzzWoof.getResultFor(777);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF + WOOF + WOOF + WOOF);
    }

}
