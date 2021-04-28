package dms.pastor;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaVersionTest {


    @Test //Update me, when ne
    public void shouldRunTestOnSpecificVersionOfJava() {
        // given
        String latestJavaVersion = "16.0.1";

        // when
        final var result = System.getProperty("java.version");

        // then
        assertThat(result).isEqualTo(latestJavaVersion);

        // debug
        System.out.println(result);
    }
}
