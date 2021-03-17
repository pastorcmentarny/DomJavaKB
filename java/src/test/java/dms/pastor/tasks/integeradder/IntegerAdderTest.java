package dms.pastor.tasks.integeradder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static dms.pastor.TestConfig.BASE_PATH;
import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IntegerAdderTest {

    private static final String PATH = BASE_PATH + "adder" + separator;
    private static final String DEMO_FILE_1 = PATH + "test1.txt";
    private static final String DEMO_FILE_2 = PATH + "test2.txt";
    private static final String DEMO_FILE_3 = PATH + "test3.txt";
    private static final String DEMO_FILE_4 = PATH + "test4.txt";
    private static final String DEMO_FILE_5 = PATH + "test5.txt";


    private IntegerAdder adder;

    @BeforeEach
    public void setUp() {
        adder = new IntegerAdder();
    }

    @Test
    public void testAdd() throws Exception {
        final int result = adder.add(DEMO_FILE_1);
        assertThat(result).isEqualTo(36);
    }

    @Test
    public void testCalculateTotalSum() throws Exception {
        // given
        String[] paths = new String[]{DEMO_FILE_1};

        // when
        int sum = adder.calculateTotalSum(paths);

        // then
        assertThat(sum).isEqualTo(36);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionTest() {
        // when
        final var exception = assertThrows(IllegalArgumentException.class, () -> adder.calculateTotalSum(null));

        // then
        assertThat(exception.getMessage()).isEqualTo("You need provide arguments that are numbers to add");
    }

    @Test
    public void basicTest() throws IOException {
        // given
        String[] paths = new String[]{DEMO_FILE_1, DEMO_FILE_2, DEMO_FILE_3};

        // when
        int sum = adder.calculateTotalSum(paths);

        // when
        assertThat(sum).isEqualTo(47);
    }

    @Test
    public void testAddThrowsExceptionForNullInsteadOfPath() {
        assertThrows(IllegalArgumentException.class, () -> adder.add(null));
    }

    @Test
    public void testAddThrowsExceptionForInvalidPath() {
        assertThrows(IllegalArgumentException.class, () -> adder.add("FakePath"));
    }

    @Test
    public void addTooBigNumbersShouldThrowException() {
        // when
        assertThrows(IllegalArgumentException.class, () -> adder.add(DEMO_FILE_4));
    }

    @Test
    public void addNegativeNumbersShouldThrowException() {
        // when
        assertThrows(IllegalArgumentException.class, () -> adder.add(DEMO_FILE_5));
    }

}
