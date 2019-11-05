package dms.pastor.prototypes.dcs.utils;

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
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RunWith(MockitoJUnitRunner.class)
public class UserKeyboardReaderTest {

    @Mock
    private
    Scanner scanner;

    @Test
    public void getIntegerInputShouldReturnInteger() {
        // given
        int expectedValue = 1;
        given(scanner.nextInt()).willReturn(expectedValue);
        UserInputReader userKeyboardReader = new UserKeyboardReader(scanner);

        // when
        final int integer = userKeyboardReader.getIntegerInput();
        // then
        assertThat(integer).isEqualTo(expectedValue);

    }
}