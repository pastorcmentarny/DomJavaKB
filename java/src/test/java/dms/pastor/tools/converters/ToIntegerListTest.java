package dms.pastor.tools.converters;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ToIntegerListTest {


    @Test
    public void shouldThrowExceptionForInputTransformToListOfIntegersIsNull() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> ToIntegerList.transform(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("List with numbers cannot be null or empty.");

    }

    @Test
    public void shouldThrowExceptionForInputTransformToListOfIntegersIsEmpty() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> ToIntegerList.transform(emptyList()));

        // then
        assertThat(exception.getMessage()).isEqualTo("List with numbers cannot be null or empty.");

    }

    @Test
    void shouldTransformToListOfIntegers() {
        // given
        final var input = List.of("-1", "4");
        final List<Integer> expectedList = List.of(-1, 4);

        // when
        final List<Integer> result = ToIntegerList.transform(input);

        // then
        assertThat(result).isEqualTo(expectedList);
    }
}