package dms.pastor.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectUtilsTest {

    @Test
    public void shouldReturnFalseIfYouPassNullToAllObjectsNull() {
        // when
        final boolean result = ObjectUtils.areAllObjectsNull(( Object[]) null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseIfAtLeastOneObjectIsNull() {
        // when
        final boolean result = ObjectUtils.areAllObjectsNull("1", null, "", "Awesome");

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturTrueIfAllObjectsYouPassAreNull() {
        // when
        final boolean result = ObjectUtils.areAllObjectsNull(null, null, null);

        // then
        assertThat(result).isTrue();
    }

}