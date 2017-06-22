package dms.pastor.tools.codehtmlconverter;

import dms.pastor.utils.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

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

/*     //TODO
    String filePath = "D:\\Dropbox\\dsProjects\\DomJavaKB\\src\\dms\\pastor\\tools\\codeToHTMLConverter\\CodeForBlogConverter.java";

    @Test
    public void acceptanceCriteria() throws Exception {
        // given
        FileTools.saveListToFile(generateSourceData(),filePath);
        CodeForBlogConverter converter = new CodeForBlogConverter();
        ArrayList<String> source =  FileTools.loadTextFileAsArrayOfStrings(filePath);
        final String convertedSource = converter.convert(source);
        System.out.println("Output:\n\n" + convertedSource);
    }*/

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
                StringUtils.getNbsp(4) +
                "public static void main(String[] args) {<br/>\n" +
                StringUtils.getNbsp(8) +
                "System.out.println(\"I AM HUNGRY\");<br/>\n" +
                StringUtils.getNbsp(4) +
                "}<br/>\n" +
                "}<br/>\n" +
                "</code>\n" +
                "</blockquote>\n";
    }

    private static List<String> generateSourceData() {
        List<String> data = new ArrayList<>();
        data.add("package dms.pastor.tools.codeToHTMLConverter;");
        data.add("");
        data.add("import org.junit.Before;");
        data.add("import org.junit.Test;");
        data.add("import java.util.ArrayList;");
        data.add("");
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

    @Before
    public void setUp() throws Exception {
        converter = new CodeForBlogConverter();

    }

    @Test
    public void shouldConvertCodeToHTMLTest() {
        List<String> source = generateSourceData();
        String answer = getResult();
        final String result = converter.convert(source);
        Assert.assertThat(result, is(answer));
    }

    @Test
    public void shouldConvert4SpaceToNbsp() {
        String line = "    ";
        String result = StringUtils.getNbsp(4);
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);
        Assert.assertThat(convertedLine, is(result));
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
        String line = "Test    ";
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);
        Assert.assertThat(convertedLine, is(line));
    }

    @Test
    public void shouldConvertFirst4SpacesToNbsp() {
        String line = "    Test    Test    ";
        String result = StringUtils.getNbsp(4) + "Test    Test    ";
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);
        Assert.assertThat(convertedLine, is(result));
    }

    @Test
    public void shouldNotConvertAny4SpacesToNbsp() {
        String line = "   Test    Test    ";//first has 3 spaces only
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);
        Assert.assertThat(convertedLine, is(line));
    }

    @Test
    public void shouldNotConvert4SpacesInTheMiddleToNbsp() {
        String line = "Test    Test";
        String convertedLine = converter.convertEach4SpacesToNsbpOnBeginningOfTheLine(line);
        Assert.assertThat(convertedLine, is(line));
    }
}
