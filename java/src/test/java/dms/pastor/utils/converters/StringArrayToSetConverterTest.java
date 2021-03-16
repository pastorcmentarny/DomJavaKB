package dms.pastor.utils.converters;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

public class StringArrayToSetConverterTest {
    final StringArrayToSetConverter converter = new StringArrayToSetConverter();

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
        final Set<String> stringSet = converter.convert(stringArray);

        // then
        assertThat(stringSet).isEqualTo(expectedStringSet);
    }
}