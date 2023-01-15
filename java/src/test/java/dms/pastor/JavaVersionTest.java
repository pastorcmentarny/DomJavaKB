package dms.pastor;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaVersionTest {


    @Test
    public void shouldRunTestOnSpecificVersionOfJava() {
        // given
        String latestJavaVersion = "17.0.5";

        // when
        final var result = System.getProperty("java.version");

        // then
        assertThat(result).isEqualTo(latestJavaVersion);

        // debug
        System.out.println(result);
    }
}
