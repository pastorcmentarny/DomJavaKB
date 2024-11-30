package dms.pastor.utils;

import dms.pastor.domain.exception.SomethingWentWrongException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PolishUtilsTest {

    @Test
    void getPolishWordFromNumberAcceptanceTest() {
        // given
        final String expectedResult = "minus dziewięćset dziewięćdziesiąt dziewięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(-999);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFromNumberThrowsExceptionForNumberTooBig() {
        // given
        final int tooBigNumber = 1000;

        // expect
        assertThrows(SomethingWentWrongException.class, () -> PolishUtils.getPolishWordFromNumber(tooBigNumber));

    }

    @Test
    void getPolishWordFromNumberThrowsExceptionForNumberTooSmall() {
        // given
        final int tooBigNumber = -2000;

        // expect
        assertThrows(SomethingWentWrongException.class, () -> PolishUtils.getPolishWordFromNumber(tooBigNumber));

    }

    @Test
    void getPolishWordReturnForMinus1Test() {
        // given
        final String expectedResult = "minus jeden";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(-1);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor0Test() {
        // given
        final String expectedResult = "zero";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(0);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor1Test() {
        // given
        final String expectedResult = "jeden";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(1);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor2Test() {
        // given
        final String expectedResult = "dwa";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(2);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor3Test() {
        // given
        final String expectedResult = "trzy";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(3);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor4Test() {
        // given
        final String expectedResult = "cztery";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(4);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor5Test() {
        // given
        final String expectedResult = "pięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(5);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor6Test() {
        // given
        final String expectedResult = "sześć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(6);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor7Test() {
        // given
        final String expectedResult = "siedem";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(7);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor8Test() {
        // given
        final String expectedResult = "osiem";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(8);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor9Test() {
        // given
        final String expectedResult = "dziewięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(9);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor10Test() {
        // given
        final String expectedResult = "dziesięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(10);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor11Test() {
        // given
        final String expectedResult = "jedenaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(11);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor12Test() {
        // given
        final String expectedResult = "dwanaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(12);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor13Test() {
        // given
        final String expectedResult = "trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(13);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor14Test() {
        // given
        final String expectedResult = "czternaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(14);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor15Test() {
        // given
        final String expectedResult = "piętnaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(15);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor16Test() {
        // given
        final String expectedResult = "szesnaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(16);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor17Test() {
        // given
        final String expectedResult = "siedemnaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(17);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor18Test() {
        // given
        final String expectedResult = "osiemnaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(18);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor19Test() {
        // given
        final String expectedResult = "dziewiętnaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(19);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor20Test() {
        // given
        final String expectedResult = "dwadzieścia";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(20);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor21Test() {
        // given
        final String expectedResult = "dwadzieścia jeden";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(21);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor30Test() {
        // given
        final String expectedResult = "trzydzieści";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(30);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor32Test() {
        // given
        final String expectedResult = "trzydzieści dwa";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(32);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor40Test() {
        // given
        final String expectedResult = "czterdzieści";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(40);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor43Test() {
        // given
        final String expectedResult = "czterdzieści trzy";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(43);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor50Test() {
        // given
        final String expectedResult = "pięćdziesiąt";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(50);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor60Test() {
        // given
        final String expectedResult = "sześćdziesiąt";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(60);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor70Test() {
        // given
        final String expectedResult = "siedemdziesiąt";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(70);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor80Test() {
        // given
        final String expectedResult = "osiemdziesiąt";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(80);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor90Test() {
        // given
        final String expectedResult = "dziewięćdziesiąt";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(90);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor100Test() {
        // given
        final String expectedResult = "sto";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(100);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor101Test() {
        // given
        final String expectedResult = "sto jeden";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(101);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor110Test() {
        // given
        final String expectedResult = "sto dziesięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(110);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor111Test() {
        // given
        final String expectedResult = "sto jedenaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(111);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor113Test() {
        // given
        final String expectedResult = "sto trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(113);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor120Test() {
        // given
        final String expectedResult = "sto dwadzieścia";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(120);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor123Test() {
        // given
        final String expectedResult = "sto dwadzieścia trzy";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(123);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor200Test() {
        // given
        final String expectedResult = "dwieście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(200);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor201Test() {
        // given
        final String expectedResult = "dwieście jeden";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(201);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor210Test() {
        // given
        final String expectedResult = "dwieście dziesięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(210);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor211Test() {
        // given
        final String expectedResult = "dwieście jedenaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(211);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor300Test() {
        // given
        final String expectedResult = "trzysta";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(300);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor303Test() {
        // given
        final String expectedResult = "trzysta trzy";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(303);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor310Test() {
        // given
        final String expectedResult = "trzysta dziesięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(310);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor313Test() {
        // given
        final String expectedResult = "trzysta trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(313);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor333Test() {
        // given
        final String expectedResult = "trzysta trzydzieści trzy";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(333);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor400Test() {
        // given
        final String expectedResult = "czterysta";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(400);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor413Test() {
        // given
        final String expectedResult = "czterysta trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(413);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor444Test() {
        // given
        final String expectedResult = "czterysta czterdzieści cztery";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(444);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor500Test() {
        // given
        final String expectedResult = "pięćset";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(500);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor513Test() {
        // given
        final String expectedResult = "pięćset trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(513);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor555Test() {
        // given
        final String expectedResult = "pięćset pięćdziesiąt pięć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(555);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor600Test() {
        // given
        final String expectedResult = "sześćset";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(600);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor613Test() {
        // given
        final String expectedResult = "sześćset trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(613);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor666Test() {
        // given
        final String expectedResult = "sześćset sześćdziesiąt sześć";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(666);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor700Test() {
        // given
        final String expectedResult = "siedemset";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(700);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor713Test() {
        // given
        final String expectedResult = "siedemset trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(713);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor777Test() {
        // given
        final String expectedResult = "siedemset siedemdziesiąt siedem";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(777);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor800Test() {
        // given
        final String expectedResult = "osiemset";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(800);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor813Test() {
        // given
        final String expectedResult = "osiemset trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(813);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor888Test() {
        // given
        final String expectedResult = "osiemset osiemdziesiąt osiem";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(888);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor900Test() {
        // given
        final String expectedResult = "dziewięćset";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(900);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }


    @Test
    void getPolishWordFor913Test() {
        // given
        final String expectedResult = "dziewięćset trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(913);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordFor987Test() {
        // given
        final String expectedResult = "dziewięćset osiemdziesiąt siedem";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(987);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordForMinus913Test() {
        // given
        final String expectedResult = "minus dziewięćset trzynaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(-913);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordForMinus987Test() {
        // given
        final String expectedResult = "minus dziewięćset osiemdziesiąt siedem";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(-987);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordForMinus1Test() {
        // given
        final String expectedResult = "minus jeden";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(-1);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getPolishWordForMinus12Test() {
        // given
        final String expectedResult = "minus dwanaście";

        // when
        final String result = PolishUtils.getPolishWordFromNumber(-12);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}