package dms.pastor.utils.string;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import static dms.pastor.utils.StringUtils.WHITESPACE;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 06/11/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ToStringUtilsTest {

    @Test
    public void linkedHashSetToStringShouldReturnEmptyStringForNullInput() {
        // when
        final String result = ToStringUtils.toString((LinkedHashSet<String>) null);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void linkedHashSetToStringShouldReturnEmptyForEmptySet() {
        // given
        LinkedHashSet<String> characterSet = new LinkedHashSet<>();

        // when
        final String result = ToStringUtils.toString(characterSet);

        // then
        assertThat(result).isEmpty();

    }

    @Test
    @Ignore // not implement yet and it is here due accidental middle of the night merge  //TODO fix new line problem
    public void linkedHashSetToStringShouldReturnLinkedHashSetAsString() {
        // given
        final String stringOne = generateString();
        final String stringTwo = generateString();
        LinkedHashSet<String> characterSet = new LinkedHashSet<>();
        characterSet.add(stringOne);
        characterSet.add(stringTwo);

        // when
        final String result = ToStringUtils.toString(characterSet);

        // then
        assertThat(result).isEqualToIgnoringCase(stringOne + System.lineSeparator() + stringTwo);

    }

    @Test
    public void intArrayToStringShouldReturnEMptyStringForEmptyArray() throws Exception {
        // given
        int[] intValues = new int[]{};

        // when
        final String result = ToStringUtils.toString(intValues, WHITESPACE);

        // then
        assertThat(result).isEmpty();

    }


    @Test
    public void intArrayToStringAcceptanceTest() throws Exception {
        // given
        final String expectedString = "[ 1 2 3 5 8 13 ]";
        int[] intValues = new int[]{1, 2, 3, 5, 8, 13};

        // when
        final String result = ToStringUtils.toString(intValues, WHITESPACE);

        // then
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    public void toStringShouldReturnStringWithArray() throws Exception {
        // given
        final List<String> list = Arrays.asList("Garlic", "Coriander", "Cheese");

        // when
        final String result = ToStringUtils.toString(list);

        // then
        assertThat(result).isEqualTo("Garlic,Coriander,Cheese");
    }

}
