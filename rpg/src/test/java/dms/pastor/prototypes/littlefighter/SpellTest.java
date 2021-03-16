package dms.pastor.prototypes.littlefighter;

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
public class SpellTest {
    @Test
    @Disabled //java.awt.HeadlessException
    public void spellUIAppearsWithoutCrashAcceptanceTest() throws Exception {
        // when
        final Spell spell = new Spell();
        spell.setVisible(true);

        Thread.sleep(1000);

        // then no error occurred
        spell.closeWindow();
    }
}
