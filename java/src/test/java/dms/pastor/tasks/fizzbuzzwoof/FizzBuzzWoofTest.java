package dms.pastor.tasks.fizzbuzzwoof;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FizzBuzzWoofTest {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String WOOF = "Woof";

    @Test
    public void getResultFor1shouldReturn1() {
        // when
        final String result = FizzBuzzWoof.getResultFor(1);

        // then
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void getResultFor2shouldReturn2() {
        // when
        final String result = FizzBuzzWoof.getResultFor(2);

        // then
        assertThat(result).isEqualTo("2");
    }

    @Test
    public void getResultFor3shouldReturnFizzFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(3);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ);
    }

    @Test
    public void getResultFor4shouldReturn4() {
        // when
        final String result = FizzBuzzWoof.getResultFor(4);

        // then
        assertThat(result).isEqualTo("4");
    }

    @Test
    public void getResultFor5shouldReturnBuzzBuzz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(5);

        // then
        assertThat(result).isEqualTo(BUZZ + BUZZ);
    }

    @Test
    public void getResultFor6shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(6);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor7shouldReturnWoofWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(7);

        // then
        assertThat(result).isEqualTo(WOOF + WOOF);
    }

    @Test
    public void getResultFor8shouldReturn8() {
        // when
        final String result = FizzBuzzWoof.getResultFor(8);

        // then
        assertThat(result).isEqualTo("8");
    }

    @Test
    public void getResultFor9shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(9);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor10shouldReturnBuzz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(10);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void getResultFor11shouldReturn11() {
        // when
        final String result = FizzBuzzWoof.getResultFor(11);

        // then
        assertThat(result).isEqualTo("11");
    }

    @Test
    public void getResultFor12shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(12);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor13shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(13);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor14shouldReturnWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(14);

        // then
        assertThat(result).isEqualTo(WOOF);
    }

    @Test
    public void getResultFor15shouldReturnFizzBuzzBuzz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(15);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ);
    }

    @Test
    public void getResultFor17shouldReturnWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(17);

        // then
        assertThat(result).isEqualTo(WOOF);
    }

    @Test
    public void getResultFor18shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(18);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor19shouldReturn19() {
        // when
        final String result = FizzBuzzWoof.getResultFor(19);

        // then
        assertThat(result).isEqualTo("19");
    }

    @Test
    public void getResultFor20shouldReturnBuzz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(20);

        // then
        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void getResultFor21shouldReturnFizzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(21);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor23shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(23);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor25shouldReturnBuzzBuzz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(25);

        // then
        assertThat(result).isEqualTo(BUZZ + BUZZ);
    }

    @Test
    public void getResultFor27shouldReturnFizzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(27);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor31shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(31);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor33shouldReturnFizzFizzFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(33);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + FIZZ);
    }

    @Test
    public void getResultFor35shouldReturnFizzBuzzBuzzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(35);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ + WOOF);
    }

    @Test
    public void getResultFor37shouldReturnFizzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(37);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor42shouldReturnFizzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(42);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF);
    }

    @Test
    public void getResultFor55shouldReturnBuzzBuzzBuzz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(55);

        // then
        assertThat(result).isEqualTo(BUZZ + BUZZ + BUZZ);
    }

    @Test
    public void getResultFor63shouldReturnFizzFizzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(63);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + WOOF);
    }

    @Test
    public void getResultFor70shouldReturnBuzzWoofWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(70);

        // then
        assertThat(result).isEqualTo(BUZZ + WOOF + WOOF);
    }

    @Test
    public void getResultFor77shouldReturnWoofWoofWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(77);

        // then
        assertThat(result).isEqualTo(WOOF + WOOF + WOOF);
    }

    @Test
    public void getResultFor99shouldReturnFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(99);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void getResultFor105shouldReturnFizzBuzzBuzzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(105);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ + WOOF);
    }

    @Test
    public void getResultFor210shouldReturnFizzBuzzWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(210);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + WOOF);
    }

    @Test
    public void getResultFor211shouldReturn211() {
        // when
        final String result = FizzBuzzWoof.getResultFor(211);

        // then
        assertThat(result).isEqualTo("211");
    }

    @Test
    public void getResultFor333shouldReturnFizzFizzFizzFizz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(333);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + FIZZ + FIZZ);
    }

    @Test
    public void getResultFor357shouldReturnFizzFizzBuzzWoofWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(357);

        // then
        assertThat(result).isEqualTo(FIZZ + FIZZ + BUZZ + WOOF + WOOF);
    }

    @Test
    public void getResultFor555shouldReturnFizzBuzzBuzzBuzzBuzz() {
        // when
        final String result = FizzBuzzWoof.getResultFor(555);

        // then
        assertThat(result).isEqualTo(FIZZ + BUZZ + BUZZ + BUZZ + BUZZ);
    }

    @Test
    public void getResultFor777shouldReturnWoofWoofWoofWoof() {
        // when
        final String result = FizzBuzzWoof.getResultFor(777);

        // then
        assertThat(result).isEqualTo(FIZZ + WOOF + WOOF + WOOF + WOOF);
    }

}
