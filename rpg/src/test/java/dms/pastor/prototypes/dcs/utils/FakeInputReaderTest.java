package dms.pastor.prototypes.dcs.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 02/06/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FakeInputReaderTest {

    @Test
    public void getIntegerInputShouldReturnZero() {
        // given
        UserInputReader fakeInputReader = new FakeInputReader();

        // when
        final int fakeInput = fakeInputReader.getIntegerInput();

        // then
        assertThat(fakeInput).isEqualTo(0);
    }
}