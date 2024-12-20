package dms.pastor.prototypes.dcs.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Author Dominik Symonowicz
 * Created 02/06/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@ExtendWith(MockitoExtension.class)
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