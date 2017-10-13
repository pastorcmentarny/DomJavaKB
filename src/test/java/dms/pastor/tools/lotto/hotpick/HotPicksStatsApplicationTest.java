package dms.pastor.tools.lotto.hotpick;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static dms.pastor.TestConfig.PATH;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 11/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HotPicksStatsApplicationTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(printStream);
    }

    @Test
    public void shouldGenerateWiningNumbers() throws Exception {
        // when
        HotPicksStatsApplication.main(new String[]{PATH + "lotto-hotpicks-draw-history.csv"});

        // then
        assertThat(outputStream.toString()).contains("Application ends his life peacefully. Until next time!");
    }

    @Test
    public void shouldThrowExceptionIfProgramStartsWithoutGivenPathToFile() {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Path not provided. Please add path to file as argument when you run this program.");

        // when
        HotPicksStatsApplication.main(null);

    }

}