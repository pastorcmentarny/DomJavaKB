package dms.pastor.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static dms.pastor.TestConfig.MAX_RANDOM_SIZE;
import static dms.pastor.utils.CollectionsUtils.*;
import static dms.pastor.utils.StringUtils.isStringBlank;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateArray;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 2015-11-11
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CollectionsUtilsTest {

    private static final String[] EMPTY_ARRAY = new String[0];


    @Test
    public void testEmptyArrayList() {
        Assert.assertThat(CollectionsUtils.emptyArrayList().isEmpty(), is(true));
        Assert.assertThat(CollectionsUtils.emptyArrayList().size(), is(0));
    }


    @Test
    public void testEmptyHashSet() {
        Set<Object> expectedObjectSet = new HashSet<>(0);
        Assert.assertThat("Empty Object HashSet", emptyHashSet(), is(expectedObjectSet));
        Assert.assertThat(emptyHashSet().isEmpty(), is(true));
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
        Assert.assertThat(isEmpty, is(true));
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


/* TODO check it -> change enum that is used as example
    @Test
    public void toListShouldReturnListOfEnumsValues() {
        // given
        final ConditionType[] enums = ConditionType.values();
        // when
        final List<ConditionType> result = CollectionsUtils.toList(enums);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(enums.length);

        // debug info
        result.forEach(System.out::println);

    }*/

}