package dms.pastor.tools.chinese.pinyin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class PinyinUtilsTest {

    @Test
    public void shouldReturnGetAllPinyinFromFirstToFourthToneWithoutNeutralTone() {
        // when
        final String allPinyinCharacterWithTones = PinyinUtils.getAllPinyinFromFirstToFourthToneWithoutNeutralTone();

        // then
        assertThat(allPinyinCharacterWithTones).isEqualTo("āáǎàēéěèōóǒòīíǐìūúǔù");

    }


}