package dms.pastor.learn.basics;

import org.junit.Test;

public class Java11StringNewMethodsExampleTest {

    @Test
    void shouldRepeatZeroTimes() {
        var string = "foo";
        var result = string.repeat(0);
        assertThat(result).isEqualTo("");
    }
}