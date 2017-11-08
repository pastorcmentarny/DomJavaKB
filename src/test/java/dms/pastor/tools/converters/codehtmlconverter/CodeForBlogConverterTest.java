package dms.pastor.tools.converters.codehtmlconverter;

import dms.pastor.utils.HtmlUtils;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp() throws Exception {
        converter = new CodeForBlogConverter();
    }

    @Test
    public void shouldConvertCodeToHTMLTest() {
        // given
        List<String> source = generateSourceData();
        String answer = getResult();

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

    private static String getResult() {
        return "<blockquote>\n" +
                "<code>\n" + "package dms.pastor.tools.codeToHTMLConverter;<br/>" + '\n' +
                "<br/>" + '\n' +
                "import org.junit.Before;<br/>" + '\n' +
                "import org.junit.Test;<br/>" + '\n' +
                "import java.util.ArrayList;<br/>" + '\n' +
                "<br/>" + '\n' +
                "import static org.junit.Assert.assertEquals;<br/>" + '\n' +
                "/**<br/>\n" +
                " * Author Dominik Symonowicz<br/>\n" +
                " */<br/>\n" +
                "public class CodeForBlogConverterTest {<br/>\n" +
                HtmlUtils.getNbsp(4) +
                "public static void main(String[] args) {<br/>\n" +
                HtmlUtils.getNbsp(8) +
                "System.out.println(\"I AM HUNGRY\");<br/>\n" +
                HtmlUtils.getNbsp(4) +
                "}<br/>\n" +
                "}<br/>\n" +
                "</code>\n" +
                "</blockquote>\n";
    }

    private static List<String> generateSourceData() {
        List<String> data = new ArrayList<>();
        data.add("package dms.pastor.tools.codeToHTMLConverter;");
        addEmptyLine(data);
        data.add("import org.junit.Before;");
        data.add("import org.junit.Test;");
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

}
