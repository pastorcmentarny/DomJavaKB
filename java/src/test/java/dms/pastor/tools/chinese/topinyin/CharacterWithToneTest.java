package dms.pastor.tools.chinese.topinyin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 04/01/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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
