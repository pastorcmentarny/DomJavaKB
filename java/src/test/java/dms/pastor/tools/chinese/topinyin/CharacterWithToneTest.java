package dms.pastor.tools.chinese.topinyin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 04/01/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CharacterWithToneTest {

    @Test
    public void fromStringShouldReturnWordWithTone() {
        // given
        final String input = "ma(1)";
        final CharacterWithTone expectedResult = new CharacterWithTone("ma", 1);

        // when
        final CharacterWithTone characterWithTone = CharacterWithTone.fromString(input);

        // then
        assertThat(characterWithTone).isEqualTo(expectedResult);

    }
}
