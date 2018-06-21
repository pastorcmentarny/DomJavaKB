package dms.pastor.tools.nanobackup.backup;

import org.junit.Test;

import javax.swing.*;

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
public class UpdateInfoTest {

    @Test
    public void shouldUpdateInfo() {
        // given
        final JTextArea textArea = new JTextArea();
        UpdateInfo updateInfo = new UpdateInfo(textArea);

        // when
        updateInfo.run();
        final String result = textArea.getText();

        // then
        assertThat(result).isNotEmpty();
    }

}