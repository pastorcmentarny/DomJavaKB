package dms.pastor.learn.basics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Java11StringNewMethodsExampleTest {


    private static final String WORD = "ufo";

    @Test
    void shouldRepeatZeroTimes() {

        var result = WORD.repeat(0);
        assertThat(result).isEqualTo("");
    }

    @Test
    void shouldRepeatOneTime() {
        var result = WORD.repeat(1);
        assertThat(result).isEqualTo(WORD);
    }

    @Test
    void shouldRepeatFiveTimes() {
        var result = WORD.repeat(5);
        assertThat(result).isEqualTo("ufoufoufoufoufo");
    }

}