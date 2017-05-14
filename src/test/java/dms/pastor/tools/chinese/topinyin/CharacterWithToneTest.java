package dms.pastor.tools.chinese.topinyin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 04/01/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class CharacterWithToneTest {

    @Test
    public void fromStringShouldReturnWordWithTone() throws Exception {
        // given
        final String input = "ma(1)";
        final CharacterWithTone expectedResult = new CharacterWithTone("ma", 1);

        // when
        final CharacterWithTone characterWithTone = CharacterWithTone.fromString(input);

        // then
        assertThat(characterWithTone).isEqualTo(expectedResult);

    }
}
