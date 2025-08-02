package dms.pastor.tools.nanobackup.backup;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 21/06/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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