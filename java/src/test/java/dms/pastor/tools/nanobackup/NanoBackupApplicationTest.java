package dms.pastor.tools.nanobackup;

import dms.pastor.utils.file.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class NanoBackupApplicationTest {

    @Before
    public void setUp() {
        FileUtils.unlockFile();
    }

    @After
    public void tearDown() {
        FileUtils.unlockFile();

    }

    @Ignore("Flaky test")
    @Test
    public void shouldRunApplication() {
        // given
        FileUtils.lock();

        // when
        NanoBackupApplication.main(new String[0]);
    }

}