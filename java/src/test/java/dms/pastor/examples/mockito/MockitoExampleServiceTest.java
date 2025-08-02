package dms.pastor.examples.mockito;

import dms.pastor.domain.Treasure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;

import static dms.pastor.domain.Treasure.getRandomTreasure;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * <p>
 * INFORMATION: Happy path only
 */
// not need to use try with resources for this test
public class MockitoExampleServiceTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.out;
    private final MockitoExampleService legendaryService = new MockitoExampleService();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(original);
    }

    @Test
    public void shouldCreateTest() {
        // given
        final UUID id = randomUUID();
        final Treasure treasure = getRandomTreasure();

        // when
        legendaryService.create(id, treasure);

        // then
        assertThat(outputStream.toString()).contains("Created treasure " + treasure.name() + " with id: " + id);
    }

    @Test
    public void shouldExecuteMethodTest() {
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
