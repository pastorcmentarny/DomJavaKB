package dms.pastor.tools.nanobackup;

import org.junit.jupiter.api.Test;

import static dms.pastor.utils.StringUtils.NEW_LINE;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 21/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class HistoryAcceptanceTest {

    @Test
    public void shouldAddMessage() {
        // given
        final History historyGUI = History.getHistoryGUI();
        final String message = generateString();
        historyGUI.clearMessages();

        // when
        historyGUI.addMessage(message);
        historyGUI.showHistoryOfMessages();
        historyGUI.closeWindow();

        // then
        assertThat(historyGUI.getMessages()).isEqualTo(message + NEW_LINE);
    }

}