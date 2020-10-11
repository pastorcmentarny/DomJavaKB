package dms.pastor.examples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BooleanExampleTest {

    @Test
    void lookingForTruthShouldReturnFalseForNull() {
        // when
        final var result = BooleanExample.lookingForTruth(null);

        // then
        assertThat(result).isEqualTo("false");
    }

    @Test
    void lookingForTruthShouldReturnFalseForTrue() {
        // when
        final var result = BooleanExample.lookingForTruth(true);

        // then
        assertThat(result).isEqualTo("true");
    }

    @Test
    void lookingForTruthShouldReturnFalseForFalse() {
        // when
        final var result = BooleanExample.lookingForTruth(false);

        // then
        assertThat(result).isEqualTo("false");
    }
}