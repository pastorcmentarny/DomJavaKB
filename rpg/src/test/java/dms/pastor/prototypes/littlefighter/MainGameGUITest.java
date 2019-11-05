package dms.pastor.prototypes.littlefighter;

import org.junit.Test;

/**
 * Author Dominik Symonowicz
 * Created 27/04/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class MainGameGUITest {

    @Test
    public void runApplicationWithoutCrashAcceptanceTest() throws Exception {
        // given

        // when
        final MainGameGUI aboutGui = new MainGameGUI();
        aboutGui.setVisible(true);

        Thread.sleep(1000);

        // then no error occurred
        aboutGui.closeWindow();

    }

}