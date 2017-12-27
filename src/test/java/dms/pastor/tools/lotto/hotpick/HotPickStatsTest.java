package dms.pastor.tools.lotto.hotpick;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.tools.lotto.hotpick.HotPickDrawBuilder.hotPickDrawBuilder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("resource")
public class HotPickStatsTest {

    private final OutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream printStream;

    private static final HotPickDraw HOT_PICK_DRAW_1 = hotPickDrawBuilder()
            .ball1(1)
            .ball2(2)
            .ball3(3)
            .ball4(4)
            .ball5(5)
            .ball6(6)
            .build();

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUp() {
        System.setOut(printStream);
    }

    @Test
    public void shouldDisplayStatistic() {
        // given
        List<HotPickDraw> hotPickDrawList = new ArrayList<>();
        hotPickDrawList.add(HOT_PICK_DRAW_1);
        final HotPicksAnalyser analyser = new HotPicksAnalyser(hotPickDrawList);

        // when
        HotPickStats.displayStatistic(analyser);

        // then
        assertThat(outputStream.toString()).contains("1: 1");
        assertThat(outputStream.toString()).contains("2: 1");
        assertThat(outputStream.toString()).contains("3: 1");
        assertThat(outputStream.toString()).contains("4: 1");
        assertThat(outputStream.toString()).contains("5: 1");
        assertThat(outputStream.toString()).contains("6: 1");
        assertThat(outputStream.toString()).contains("Most drawn number is 1 and these number was drawn that times 1,2,3,4,5,6");
        assertThat(outputStream.toString()).contains("Least drawn number is 0 and these number was drawn that times 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59");
        assertThat(outputStream.toString()).contains("Is most and least common number were played together? false");
    }
}