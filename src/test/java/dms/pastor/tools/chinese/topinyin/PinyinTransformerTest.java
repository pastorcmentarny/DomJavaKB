package dms.pastor.tools.chinese.topinyin;

import org.junit.Test;

import static dms.pastor.tools.chinese.topinyin.PinyinTransformer.transformToPinyin;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 07/04/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PinyinTransformerTest {

    @Test
    public void transformToPinyinShouldReturnEmptyIfCharacterWithWordIsNull() throws Exception {
        // when
        final String pinyin = transformToPinyin(null);

        // then
        assertThat(pinyin).isEmpty();
    }

    @Test
    public void transformToPinyinShouldReturnEmptyIfCharacterWithWordIsUnknown() throws Exception {
        // given
        final String randomText = generateString(250);
        final CharacterWithTone characterWithTone = CharacterWithTone.fromString(randomText);

        // when
        final String pinyin = transformToPinyin(characterWithTone);

        // then
        assertThat(pinyin).isEqualTo(randomText);
    }

    @Test
    public void transformToPinyinShouldReturnMaWithFirstToneForMa1() throws Exception {
        // given
        final CharacterWithTone characterWithTone = CharacterWithTone.fromString("ma(2)");
        final String result = "má";

        // when
        final String pinyin = transformToPinyin(characterWithTone);

        // then
        assertThat(pinyin).isEqualTo(result);
    }
}
