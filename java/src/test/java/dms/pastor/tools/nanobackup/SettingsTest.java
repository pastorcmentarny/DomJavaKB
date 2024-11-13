package dms.pastor.tools.nanobackup;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 19/06/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SettingsTest {

    @Test
    public void shouldReturnMessageHistoryDimension() {
        // when
        final Dimension result = Settings.getDimensionFor("MESSAGE_HISTORY_DIMENSION");

        // then
        assertThat(result.getWidth()).isEqualTo(425);
        assertThat(result.getHeight()).isEqualTo(550);
    }

    @Test
    public void shouldReturnBackupGuiDimension() {
        // when
        final Dimension result = Settings.getDimensionFor("backupGui");

        // then
        assertThat(result.getHeight()).isEqualTo(200);
        assertThat(result.getWidth()).isEqualTo(500);
    }

    @Test
    public void shouldReturnNoDimensionForUnknownDimensionName() {
        // when
        final Dimension result = Settings.getDimensionFor(generateString());

        // then
        assertThat(result).isEqualTo(new Dimension(0, 0));

    }

    @Test
    public void shouldSetPropertiesWithoutSave() {
        // given
        final Settings settings = Settings.getSettings();

        // check
        settings.createDefaultSettings();
        assertThat(settings.isQuickBackup()).isFalse();

        // set
        settings.setQuickBackup(true);

        // when
        settings.setProperties(false);

        // then
        assertThat(settings.isQuickBackup()).isTrue();
    }

    @Test
    public void shouldDisplayCurrentSettings() {
        // given
        final Settings settings = Settings.getSettings();
        settings.setConfirmOnExit(false);
        final String where = generateString();

        // when
        final String result = settings.displayCurrentSettings(where);

        // then make sure is not blank but i don't c
        assertThat(result).isNotBlank();
        assertThat(result).contains("ConfirmOnExit: false");
        assertThat(result).contains(where);

    }
}