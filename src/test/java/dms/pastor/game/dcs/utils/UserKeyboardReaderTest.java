package dms.pastor.game.dcs.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Author Dominik Symonowicz
 * Created 02/06/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@RunWith(MockitoJUnitRunner.class)
public class UserKeyboardReaderTest {
    @Mock
    private
    Scanner scanner;

    @Test
    public void getIntegerInputShouldReturnInteger() throws Exception {
        // given
        final int expectedValue = 1;
        given(scanner.nextInt()).willReturn(expectedValue);
        UserKeyboardReader userKeyboardReader = new UserKeyboardReader(scanner);

        // when
        final int integer = userKeyboardReader.getIntegerInput();
        // then
        assertThat(integer).isEqualTo(expectedValue);

    }
}