package dms.pastor.tools.forty;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HtmlGeneratorTest {
    private static final String TEST = "TEST";

    private final HtmlGenerator htmlGenerator = new HtmlGenerator();

    @Test
    void getDocTypeAcceptanceTest() {
        // when
        final var result = htmlGenerator.getDocType();

        // then
        assertThat(result).startsWith("<!DOCTYPE html>");
    }

    @Test
    void getHtmlStartTagAcceptanceTest() {
        // when
        final var result = htmlGenerator.getHtmlStartTag();

        // then
        assertThat(result).startsWith("<html lang=\"en\">");
    }

    @Test
    void getStartTagForAcceptanceTest() {
        // when
        final var result = htmlGenerator.getStartTagFor(TEST);

        // then
        assertThat(result).startsWith("<TEST>");
    }

    @Test
    void getEndForAcceptanceTest() {
        // when
        final var result = htmlGenerator.getEndFor(TEST);

        // then
        assertThat(result).startsWith("</TEST>");
    }

    @Test
    void getStartTagWithClassAcceptanceTest() {
        // when
        final var result = htmlGenerator.getStartTagWithClass(TEST, TEST);

        // then
        assertThat(result).startsWith("<TEST class=\"TEST\">");
    }

    @Test
    void getHeadTagAcceptanceTest() {
        // when
        final var result = htmlGenerator.getHeadTag();

        // then is not blank , I don't care about content
        assertThat(result).isNotBlank();
    }

    @Test
    void getNavTagAcceptanceTest() {
        // when
        final var result = htmlGenerator.getNavTag();

        // then
        assertThat(result).startsWith("    <nav class=\"navbar navbar-expand-sm navbar-dark bg-dark\">");
    }


    @Test
    void generate40ThingsAcceptanceTest() {
        // given
        final var expectedResult = """
                <tr>
                    <td class="table-info">Learn Kotlin</td>
                    <td class="table-light">Learn Go</td>
                    <td class="table-light">Learn Haskell</td>
                    <td class="table-light">Learn Rust</td>
                </tr>
                <tr>
                    <td class="table-danger">Run in four 10km race</td>
                    <td class="table-danger">Run 1460km</td>
                    <td class="table-light">Walk 50000 steps</td>
                    <td class="table-warning">Run at least 2km per day [1/365]</td>
                </tr>""";

        final List<String> eightThingsList = new ArrayList<>();
        eightThingsList.add("Learn Kotlin;;IN_PROGRESS");
        eightThingsList.add("Learn Go;;TO_DO");
        eightThingsList.add("Learn Haskell;;TO_DO");
        eightThingsList.add("Learn Rust;;TO_DO");
        eightThingsList.add("Run in four 10km race;;BLOCKED");
        eightThingsList.add("Run 1460km;;BLOCKED");
        eightThingsList.add("Walk 50000 steps;;TO_DO");
        eightThingsList.add("Run at least 2km per day [1/365];;PAUSED");

        // when
        final var result = htmlGenerator.generate40things(eightThingsList);

        // then
        assertThat(result.trim()).isEqualToIgnoringNewLines(expectedResult);
    }
}