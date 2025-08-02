package dms.pastor.tools.chinese.topinyin;

import org.junit.jupiter.api.Test;

import static dms.pastor.tools.chinese.topinyin.PinyinTransformer.transformToPinyin;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 07/04/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class PinyinTransformerTest {

    @Test
    public void transformToPinyinShouldReturnEmptyIfCharacterWithWordIsNull() {
        // when
        final String pinyin = transformToPinyin(null);

        // then
        assertThat(pinyin).isEmpty();
    }

    @Test
    public void transformToPinyinShouldReturnEmptyIfCharacterWithWordIsUnknown() {
        // given
        final String randomText = generateString(250);
        final CharacterWithTone characterWithTone = CharacterWithTone.fromString(randomText);

        // when
        final String pinyin = transformToPinyin(characterWithTone);

        // then
        assertThat(pinyin).isEqualTo(randomText);
    }

    @Test
    public void transformToPinyinShouldReturnMaWithFirstToneForMa1() {
        // given
        final CharacterWithTone characterWithTone = CharacterWithTone.fromString("ma(2)");
        final String result = "má";

        // when
        final String pinyin = transformToPinyin(characterWithTone);

        // then
        assertThat(pinyin).isEqualTo(result);
    }
}
