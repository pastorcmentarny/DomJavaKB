package dms.pastor.utils.converters;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerCollectionToIntArrayConverterTest {
    final IntegerCollectionToIntArrayConverter converter = new IntegerCollectionToIntArrayConverter();

    @Test
    public void testConvertListToIntArray() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(8);
        numbers.add(13);
        int[] answer = new int[]{2, 3, 5, 8, 13};
        assertThat(converter.convert(numbers)).isEqualTo(answer);
    }

    @Test
    public void convertSetToIntArrayShouldReturnIntArray() {
        // given
        final Set<Integer> integerSet = Stream.of(1, 2, 3).collect(Collectors.toSet());
        int[] expectedIntArray = new int[]{1, 2, 3};
        // when
        final int[] ints = converter.convert(integerSet);

        // then
        assertThat(ints).isEqualTo(expectedIntArray);
    }
}