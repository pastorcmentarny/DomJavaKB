package dms.pastor.tools.nanobackup.backup;

import dms.pastor.tools.nanobackup.Constants;
import dms.pastor.tools.nanobackup.Settings;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static dms.pastor.tools.nanobackup.Constants.QUICK_MODE_FILENAME;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class EngineTest {


    private final Engine engine = new Engine();


    @Test
    public void shouldActivateQuickBackupMode() {
        // given
        final JTextField jTextField = new JTextField();
        final boolean delete = new File(QUICK_MODE_FILENAME).delete();
        if (delete) {
            System.out.printf("%s was deleted.%n", QUICK_MODE_FILENAME);
        }
        // when
        engine.activateQuickBackupMode(jTextField);

        // then
        assertThat(jTextField.getText()).endsWith(Constants.QUICK_MODE_FILENAME);
    }

    @Test
    public void shouldDeactivateQuickBackupMode() {
        // given
        final JTextField jTextField = new JTextField();
        final String sourceFilePath = generateString();
        Settings.getSettings().setSourceFilePath(sourceFilePath);

        // verify
        assertThat(new File(QUICK_MODE_FILENAME).exists()).isTrue();

        // when
        engine.deactivateQuickBackupMode(jTextField);

        // then
        assertThat(jTextField.getText()).endsWith(sourceFilePath);
    }

    @Test
    public void itselfHealthScan() {
        // when
        final String[] result = engine.itselfHealthScan();

        // then
        assertThat(result[0]).isEqualTo("OK");
    }

    @Test
    public void setInfoLabel() {

        // given
        final Color color = Color.BLACK;
        final String message = generateString();
        final JLabel infoLabel = new JLabel();
        // when
        engine.setInfoLabel(color, message, infoLabel);

        // then
        assertThat(infoLabel.getForeground()).isEqualTo(color);
        assertThat(infoLabel.getText()).isEqualTo(message);
    }

}
