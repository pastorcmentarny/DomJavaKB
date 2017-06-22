package dms.pastor.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;

import static dms.pastor.domain.Treasure.getRandomTreasure;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * INFORMATION: Happy path only
 */
@SuppressWarnings("resource") // not need to use try with resources for this test
public class LegendaryServiceTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;
    private final LegendaryService legendaryService = new LegendaryService();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(original);
    }

    @Test
    public void shouldCreateTest() throws Exception {
        // given
        final UUID id = randomUUID();
        final Treasure treasure = getRandomTreasure();

        // when
        legendaryService.create(id, treasure);

        // then
        assertThat(outputStream.toString()).contains("Created treasure " + treasure.getName() + " with id: " + id.toString());
    }

    @Test
    public void shouldExecuteMethodTest() throws Exception {
        // given
        final int size = 8;

        // when
        final String start = generateString(size);
        final String end = generateString(size);
        final String result = legendaryService.method(start, end, size);

        // then
        assertThat(result).isEqualTo(start + "01234567" + end);
    }
}
