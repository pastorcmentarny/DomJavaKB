package dms.pastor.tasks.integeradder;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static dms.pastor.TestConfig.BASE_PATH;
import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private IntegerAdder adder;

    @Before
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
        String[] paths = new String[]{DEMO_FILE_1};
        int sum = adder.calculateTotalSum(paths);
        assertThat(sum).isEqualTo(36);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You need provide arguments that are numbers to add");

        // when
        adder.calculateTotalSum(null);
    }

    @Test
    public void basicTest() throws IOException {
        String[] paths = new String[]{DEMO_FILE_1, DEMO_FILE_2, DEMO_FILE_3};
        int sum = adder.calculateTotalSum(paths);
        assertThat(sum).isEqualTo(47);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsExceptionForNullInsteadOfPath() throws IOException {
        adder.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsExceptionForInvalidPath() throws IOException {
        adder.add("FakePath");
    }

    @Ignore
    @Test
    public void addTooBigNumbersShouldThrowException() throws IOException {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Out od range");

        // when
        adder.add(DEMO_FILE_4);
    }
    //TODO test for too large int and negative
}
