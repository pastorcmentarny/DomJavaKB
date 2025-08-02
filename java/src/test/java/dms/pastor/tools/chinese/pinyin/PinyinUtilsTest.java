package dms.pastor.tools.chinese.pinyin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 08/10/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
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