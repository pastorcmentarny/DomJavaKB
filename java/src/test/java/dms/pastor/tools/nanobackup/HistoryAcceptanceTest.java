package dms.pastor.tools.nanobackup;

import org.junit.Test;

import static dms.pastor.utils.StringUtils.NEW_LINE;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 21/06/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
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