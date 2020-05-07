package dms.pastor.utils;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dms.pastor.TestConfig.MAX_RANDOM_SIZE;
import static dms.pastor.utils.CollectionsUtils.*;
import static dms.pastor.utils.StringUtils.isStringBlank;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateArray;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
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

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testConvertListToIntArray() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(8);
        numbers.add(13);
        int[] answer = new int[]{2, 3, 5, 8, 13};
        Assert.assertThat(CollectionsUtils.convertToIntArray(numbers), is(answer));
    }

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
        final boolean result = isListNotEmpty(stringList);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void convertSetToIntArrayShouldReturnIntArray() {
        // given
        final Set<Integer> integerSet = Stream.of(1, 2, 3).collect(Collectors.toSet());
        int[] expectedIntArray = new int[]{1, 2, 3};

        // when
        final int[] ints = convertToIntArray(integerSet);

        // then
        assertThat(ints).isEqualTo(expectedIntArray);
    }

    @Test
    public void convertStringArrayToSetShouldReturnStringSet() {
        // given
        final String stringOne = generateString();
        final String stringTwo = generateString();
        final String[] stringArray = {stringOne, stringTwo};
        Set<String> expectedStringSet = new HashSet<>();
        expectedStringSet.add(stringOne);
        expectedStringSet.add(stringTwo);

        // when
        final Set<String> stringSet = convertStringArrayToSet(stringArray);

        // then
        assertThat(stringSet).isEqualTo(expectedStringSet);
    }

    @Test
    public void toListShouldThrowIllegalArgumentExceptionIfEnumIsNull() {
        // expected
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Enum values cannot be null.");

        // when
        CollectionsUtils.toList(null);
    }


/* change enum that is used as example
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