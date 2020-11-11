package dms.pastor.examples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RotateListExampleTest {

    @Test
    public void rotateListExample() {
        // given
        final String expectedResult = "Rotate by 2 day(s). Start: Wednesday Last day: Tuesday";
        // when
        final var result = RotateListExample.example();

        // then
        assertThat(result).isEqualTo(expectedResult);

        // debug
        System.out.println(expectedResult);
    }

}