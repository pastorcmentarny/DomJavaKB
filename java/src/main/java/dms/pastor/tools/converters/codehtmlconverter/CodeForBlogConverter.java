package dms.pastor.tools.converters.codehtmlconverter;

import dms.pastor.utils.html.HtmlUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.StringUtils.WHITESPACE_CHAR;
import static dms.pastor.utils.html.HtmlUtils.BR_TAG;
import static java.lang.System.lineSeparator;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 */
class CodeForBlogConverter {

    private static final int NUMBER_OF_SPACES = 4;

    private StringBuilder codeGenerator;

    private static boolean contains4spaces(char[] charArray, int i) {
        for (int position = i; position <= i + 3; position++) {
            if (charArray[position] != WHITESPACE_CHAR) {
                return false;
            }
        }
        return true;
    }

    String convert(List<String> source) {
        codeGenerator = new StringBuilder(EMPTY_STRING);
        insertTagsToStartDisplayCode();
        generateCodeAsHtml(source);
        insertTagsToEndDisplayCode();
        return codeGenerator.toString();
    }

    String convertEach4SpacesToNsbpOnBeginningOfTheLine(String line) {
        int replaceCounter = count4SpacesInLineToReplace(line);

        StringBuilder newLine = new StringBuilder(EMPTY_STRING);
        String nsbp = HtmlUtils.getNbsp(NUMBER_OF_SPACES);
        newLine.append(nsbp.repeat(Math.max(0, replaceCounter)));

        if (NUMBER_OF_SPACES * replaceCounter > 0) {
            newLine.append(line.substring(NUMBER_OF_SPACES * replaceCounter));
        } else {
            newLine.append(line);
        }

        return newLine.toString();
    }

    private List<String> replaceSpaceWithNsbpInCode(List<String> source) {
        final Stream<String> stringStream = source.stream().map(line -> {
            String convertedLine = convertEach4SpacesToNsbpOnBeginningOfTheLine(line);
            return convertedLine + BR_TAG;
        });

        return stringStream.collect(Collectors.toList());
    }

    private void generateCodeAsHtml(List<String> source) {
        final List<String> linesAsHTML = replaceSpaceWithNsbpInCode(source);

        for (String line : linesAsHTML) {
            codeGenerator.append(line).append(lineSeparator());
        }
    }

    private void insertTagsToEndDisplayCode() {
        codeGenerator.append("</code>\n" + "</blockquote>\n");
    }

    private void insertTagsToStartDisplayCode() {
        codeGenerator.append("<blockquote>\n" + "<code>\n");
    }

    private int count4SpacesInLineToReplace(String line) {
        final char[] charArray = line.toCharArray();
        int replaceCounter = 0;
        for (int i = 0; i < line.length(); i += NUMBER_OF_SPACES) {
            if (i + NUMBER_OF_SPACES <= line.length()) {
                if (contains4spaces(charArray, i)) {
                    replaceCounter++;
                } else {
                    break;
                }
            }
        }
        return replaceCounter;
    }

}
