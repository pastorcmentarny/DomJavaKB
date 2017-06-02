package dms.pastor.game.dcs.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 02/06/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FakeInputReaderTest {

    @Test
    public void getIntegerInputShouldReturnZero() throws Exception {
        // given
        UserInputReader fakeInputReader = new FakeInputReader();

        // when
        final int fakeInput = fakeInputReader.getIntegerInput();

        // then
        assertThat(fakeInput).isEqualTo(0);
    }
}