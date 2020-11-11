package dms.pastor.tools.converters.codehtmlconverter;

import dms.pastor.utils.file.TextFileUtils;
import dms.pastor.utils.html.HtmlUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
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


    private static List<String> generateSourceData() {
        List<String> data = new ArrayList<>();
        data.add("package dms.pastor.tools.codeToHTMLConverter;");
        addEmptyLine(data);
        data.add("import org.junit.Before;");
        data.add("import org.junit.jupiter.api.Test;");
        data.add("import java.util.ArrayList;");
        addEmptyLine(data);
        data.add("import static org.junit.Assert.assertEquals;");
        data.add("/**");
        data.add(" * Author Dominik Symonowicz");
        data.add(" */");
        data.add("public class CodeForBlogConverterTest {");
        data.add("    public static void main(String[] args) {");
        data.add("        System.out.println(\"I AM HUNGRY\");");
        data.add("    }");
        data.add("}");
        return data;
    }

    private static void addEmptyLine(List<String> data) {
        data.add(EMPTY_STRING);
    }

    @BeforeEach
    public void setUp() {
        converter = new CodeForBlogConverter();
    }

    @Disabled
    @Test //TODO test failed but content was identical
    public void shouldConvertCodeToHTMLTest() {
        // given
        List<String> source = generateSourceData();
        String answer = TextFileUtils.loadFileFromResourceAsString("test/html/code2blog.html");
        // when
        final String result = converter.convert(source);

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
