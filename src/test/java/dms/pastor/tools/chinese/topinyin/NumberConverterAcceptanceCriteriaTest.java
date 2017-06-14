package dms.pastor.tools.chinese.topinyin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 03/01/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class NumberConverterAcceptanceCriteriaTest {

    private final NumberConverter numberConverter = new NumberConverter();

    @Test
    public void shouldConvertTextWithTonesAsNumberIntoPinyin() throws Exception {
        // given
        final String input = "ma ma(1) ma(2) ma(3) ma(4) " +
                "le le(1) le(2) le(3) le(4) " +
                "bo bo(1) bo(2) bo(3) bo(4) " +
                "yi yi(1) yi(2) yi(3) yi(4) " +
                "yu yu(1) yu(2) yu(3) yu(4) ";

        final String expectedResult = "ma mā má mǎ mà " +
                "le lē lé lě lè " +
                "bo bō bó bǒ bò " +
                "yi yī yí yǐ yì " +
                "yu yū yú yǔ yù";
        // when
        final String pinyin = numberConverter.convertToPinyin(input);

        // then
        assertThat(pinyin).isEqualTo(expectedResult);
    }
}
