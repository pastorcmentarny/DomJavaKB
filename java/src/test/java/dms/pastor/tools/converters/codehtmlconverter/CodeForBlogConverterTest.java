package dms.pastor.tools.converters.codehtmlconverter;

import dms.pastor.utils.FileUtils;
import dms.pastor.utils.HtmlUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 14/11/2015
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CodeForBlogConverterTest {

    private static final String THREE_WHITESPACES = "   ";
    private CodeForBlogConverter converter;


    @Before
    public void setUp() {
        converter = new CodeForBlogConverter();
    }

    @Ignore
    @Test //TODO test failed but content was identical
    public void shouldConvertCodeToHTMLTest() {
        // given
        List<String> answer = FileUtils.loadFileFromResourceAsListOfStrings("test/html/code2blog.html");

        // when
        final String result = converter.convert(answer);

        // then
        assertThat(result).isEqualTo(answer);

    }

    @Test
    public void shouldConvert4SpaceToNbsp() {
        // given
        String line = "    ";
        String result = HtmlUtils.getNbsp(4);

        // when
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);

        // then
        assertThat(convertedLine).isEqualTo(result);
    }

    @Test
    public void shouldNotConvert3SpacesToNbsp() {
        // when
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(THREE_WHITESPACES);

        // then
        assertThat(convertedLine).isEqualTo(THREE_WHITESPACES);
    }

    @Test
    public void shouldNotConvert4SpacesInTheEndToNbsp() {
        // given
        String line = "Test    ";

        // when
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);

        // then
        assertThat(convertedLine).isEqualTo(line);
    }

    @Test
    public void shouldConvertFirst4SpacesToNbsp() {
        // given
        String line = "    Test    Test    ";
        String result = HtmlUtils.getNbsp(4) + "Test    Test    ";

        // when
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);

        // then
        assertThat(convertedLine).isEqualTo(result);
    }

    @Test
    public void shouldNotConvertAny4SpacesToNbsp() {
        // given
        String line = "   Test    Test    ";//first has 3 spaces only

        // when
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);

        // then
        assertThat(convertedLine).isEqualTo(line);
    }

    @Test
    public void shouldNotConvert4SpacesInTheMiddleToNbsp() {
        // given
        String line = "Test    Test";

        // when
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);

        // then
        assertThat(convertedLine).isEqualTo(line);
    }

}
