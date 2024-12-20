package dms.pastor.tasks.other;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static dms.pastor.tasks.other.CollectionExercises.convertListToMapUsingJava8;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CollectionExercisesTest {

    private static final int MAX_STRING_SIZE = 10;

    @Test
    public final void shouldReturnNullIfListIsNullTest() {
        // when
        final Map<Integer, String> integerStringMap = convertListToMapUsingJava8(null);

        // then
        assertThat(integerStringMap).isEmpty();
    }

    @Test
    public void shouldReturnMapWith3ElementsForListWith3ElementsTest() {
        // given
        List<String> stringArrayList = new ArrayList<>();
        final String stringOne = generateString(MAX_STRING_SIZE);
        final String stringTwo = generateString(MAX_STRING_SIZE);
        final String stringThree = generateString(MAX_STRING_SIZE);

        stringArrayList.add(stringOne);
        stringArrayList.add(stringTwo);
        stringArrayList.add(stringThree);

        // when
        final Map<Integer, String> integerStringMap = convertListToMapUsingJava8(stringArrayList);

        // then
        assertThat(integerStringMap.size()).isEqualTo(stringArrayList.size());
        assertThat(integerStringMap.get(1)).isEqualTo(stringOne);
        assertThat(integerStringMap.get(2)).isEqualTo(stringTwo);
        assertThat(integerStringMap.get(3)).isEqualTo(stringThree);
    }

}
