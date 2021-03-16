package dms.pastor.tools.nanobackup;

import dms.pastor.utils.file.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class NanoBackupApplicationTest {

    @BeforeEach
    public void setUp() {
        FileUtils.unlockFile();
    }

    @AfterEach
    public void tearDown() {
        FileUtils.unlockFile();

    }

    @Disabled("Flaky test")
    @Test
    public void shouldRunApplication() {
        // given
        FileUtils.lock();
        // when
        NanoBackupApplication.main(new String[0]);
    }

}