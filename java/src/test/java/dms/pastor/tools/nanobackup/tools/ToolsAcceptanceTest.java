package dms.pastor.tools.nanobackup.tools;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 21/04/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class ToolsAcceptanceTest {

    @Test
    public void getRandomColorAcceptanceTest() {
        // when
        final Color result = Tools.getRandomColor();

        // then
        assertThat(result.getBlue()).isLessThanOrEqualTo(128);
        assertThat(result.getRed()).isLessThanOrEqualTo(128);
        assertThat(result.getGreen()).isLessThanOrEqualTo(128);
    }

    @Test
    public void getCurrentTime() {
        // when
        final String currentTime = Tools.getCurrentTime();

        // then
        assertThat(currentTime).contains(String.valueOf(LocalTime.now().getHour()));
    }

    @Test
    public void shouldChangeToYellowStatusIfrResultIsOkTest() {
        // given
        final List<String> result = new ArrayList<>();
        result.add("OK");

        // when
        Tools.changeToYellowStatus(result);

        assertThat(result.get(0)).isEqualTo("WARNING");
    }

    @Test
    public void shouldNotChangeToYellowStatusIfrResultIsErrorTest() {
        // given
        final String result = "ERROR";
        final List<String> resultList = Collections.singletonList(result);

        // when
        Tools.changeToYellowStatus(resultList);

        assertThat(resultList.get(0)).isEqualTo(result);
    }

}
