package dms.pastor.utils.transformers;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class ToPrimitiveBooleanTest {

    @Test
    void fromBooleanObjectToPrimitiveBooleanShouldReturnFalseIfNull() {
        // when
        final var result = ToPrimitiveBoolean.from(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void fromBooleanObjectToPrimitiveBooleanShouldReturnTrueIfTrue() {
        // when
        final var result = ToPrimitiveBoolean.from(TRUE);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void fromBooleanObjectToPrimitiveBooleanShouldReturnFalseIfFalse() {
        // when
        final var result = ToPrimitiveBoolean.from(FALSE);

        // then
        assertThat(result).isFalse();
    }
}