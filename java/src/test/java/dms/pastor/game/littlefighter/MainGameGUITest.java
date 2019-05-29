package dms.pastor.game.littlefighter;

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

    @Test //TODO add ability to close window
    public void runApplicationWithoutCrashAcceptanceTest() throws Exception {
        // given

        // when
        MainGameGUI.main(null);

        Thread.sleep(1000);

        // then no error occurred
    }

}