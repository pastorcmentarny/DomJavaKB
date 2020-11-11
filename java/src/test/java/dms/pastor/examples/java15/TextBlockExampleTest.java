package dms.pastor.examples.java15;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextBlockExampleTest {

    @Test
    void getAutoGeneratedMultiLineString() {
        var expected = """
                Java
                \tfinally
                \tsupport
                \tmulti-line""";
        // when
        final var result = TextBlockExample.getAutoGeneratedMultiLineString();

        //then
        assertThat(result).isEqualTo(expected);
    }


}
