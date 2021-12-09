package dms.pastor.utils;


import dms.pastor.domain.StatusType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static dms.pastor.TestConfig.MAX_RANDOM_SIZE;
import static dms.pastor.utils.CollectionsUtils.*;
import static dms.pastor.utils.StringUtils.isStringBlank;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateArray;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 2015-11-11
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CollectionsUtilsTest {

    private static final String[] EMPTY_ARRAY = new String[0];


    @Test
    public void testEmptyArrayList() {
        assertThat(CollectionsUtils.emptyArrayList().isEmpty()).isEqualTo(true);
        assertThat(CollectionsUtils.emptyArrayList().size()).isEqualTo(0);
    }


    @Test
    public void testEmptyHashSet() {
        Set<Object> expectedObjectSet = new HashSet<>(0);
        assertThat(emptyHashSet()).isEqualTo(expectedObjectSet);
        assertThat(emptyHashSet().isEmpty()).isEqualTo(true);
    }

    @SuppressWarnings("ConstantConditions") //because this is purpose of test
    @Test
    public void isStringArrayEmptyShouldReturnFalseForNullArrayTest() {
        // when
        final boolean isEmpty = isStringArrayEmpty(null);

        // then
        assertThat(isEmpty).isTrue();
    }

    @Test
    public void isStringArrayEmptyShouldReturnFalseForEmptyArrayTest() {
        // when
        final boolean isEmpty = isStringArrayEmpty(EMPTY_ARRAY);

        // then
        assertThat(isEmpty).isEqualTo(true);
    }

    @Test
    public void isStringArrayEmptyShouldReturnTrueForNonEmptyArrayTest() {
        // given
        Random random = new Random();
        final int size = random.nextInt(MAX_RANDOM_SIZE);
        final String[] array = generateArray(size);

        // when
        final boolean isEmpty = isStringArrayEmpty(array);

        // then
        assertThat(isEmpty).isFalse();
        Arrays.stream(array).forEach(element -> assertThat(isStringBlank(element)).isFalse());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void shouldReturnFalseIfListIsNullTest() {
        // when
        final boolean result = isListNotEmpty(null);

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnFalseIfListIsEmpty() {
        // when
        final boolean result = isListNotEmpty(emptyList());

        // then
        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnTrueIfListContainsElements() {
        // given
        final List<String> stringList = Arrays.asList("Dom", "is", "hungry");

        // when
        final boolean result = isListNotEmpty(Collections.singletonList(stringList));

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void toListShouldThrowIllegalArgumentExceptionIfEnumIsNull() {
        // when
        final var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> CollectionsUtils.toList(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("Enum values cannot be null.");
    }


    @Test
    public void toListShouldReturnListOfEnumsValues() {
        // given
        final StatusType[] enums = StatusType.values();

        // when
        final List<StatusType> result = CollectionsUtils.toList(enums);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(enums.length);

        // debug info
        result.forEach(System.out::println);
    }

    @Test
    void returnShuffledListAsNewCollectionAcceptanceTest() {
        // given
        final List<String> input = List.of("A", "B", "C", "K", "L", "M", "X", "Y", "Z");

        // when
        final Collection<String> result = CollectionsUtils.returnShuffledListAsNewCollection(input);

        //debug
        System.out.println(input);
        System.out.println(result);

        // then
        assertThat(result.size()).isEqualTo(input.size());
        assertThat(result).isNotEqualTo(input);
        assertThat(input.get(0)).isEqualTo("A");
        assertThat(input.get(1)).isEqualTo("B");
        assertThat(input.get(2)).isEqualTo("C");
        assertThat(input.get(3)).isEqualTo("K");
        assertThat(input.get(4)).isEqualTo("L");
        assertThat(input.get(5)).isEqualTo("M");
        assertThat(input.get(6)).isEqualTo("X");
        assertThat(input.get(7)).isEqualTo("Y");
        assertThat(input.get(8)).isEqualTo("Z");
    }


    @Test
    void returnShuffledListAsNewCollectionReturnNullIfCollectionIsNullTest() {

        // when
        final List<String> result = returnShuffledListAsNewCollection(null);

        // then
        assertThat(result).isNull();
    }

    @Test
    void returnShuffledListAsNewCollectionReturnEmptyIfCollectionIsEmptyTest() {

        // when
        final List<String> result = returnShuffledListAsNewCollection(new ArrayList<>(0));

        // then
        assertThat(result).isEmpty();
    }
}