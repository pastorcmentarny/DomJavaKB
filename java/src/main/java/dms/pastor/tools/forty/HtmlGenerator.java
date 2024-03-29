package dms.pastor.tools.forty;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static dms.pastor.utils.StringUtils.*;
import static dms.pastor.utils.file.TextFileUtils.loadFileFromResourceAsListOfStrings;
import static dms.pastor.utils.file.TextFileUtils.saveTextToFile;
import static java.lang.Integer.parseInt;

public class HtmlGenerator {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final int WHAT = 0;
    private static final int STATUS = 1;
    private static final int LOG_DATE = 0;
    private static final int LOG_MESSAGE = 1;
    private static final int ALL_STEPS = 2;
    private static final int CURRENT_STEP = 3;
    private static final String TR_TAG = "tr";
    private static final String DIV_TAG = "div";
    private static final String TD_TAG = "td";
    private static final String LI_TAG = "li";
    private static final String BODY_TAG = "body";
    private static final String ORDERED_LIST_TAG = "ol";
    private static final String H4_TAG = "h4";

    public String getDocType() {
        return "<!DOCTYPE html>" + NEW_LINE;
    }

    public String getHtmlStartTag() {
        return "<html lang=\"en\">" + NEW_LINE;
    }

    public String getStartTagFor(String what) {
        return "<" + what + ">" + NEW_LINE;
    }

    public String getEndFor(String what) {
        return "</" + what + ">" + NEW_LINE;
    }

    public String getStartTagWithClass(String what, String classData) {
        return "<" + what + " class=\"" + classData + "\">";
    }

    public String getHeadTag() {
        return """
                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta name="description" content="My bookmarks HQ">
                    <meta name="author" content="Dominik Symonowicz">
                    <meta http-equiv="refresh" content="30"/>
                    <title>40 thing to do at 40 years old.</title>
                    <link rel="stylesheet" href="{{ url_for('static', filename='css/style.css') }}">
                    <link rel="icon" href="{{ url_for('static', filename='favicon.ico') }}" type="image/x-icon"/>

                    <!--  JavaScripts -->
                    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                            crossorigin="anonymous"></script>
                    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
                          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
                            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
                            crossorigin="anonymous"></script>

                </head>""" + NEW_LINE;
    }

    public String getNavTag() {
        return """
                    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
                        <a class="navbar-brand" href="http://localhost:5000/">Dom's Gateway</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03"
                                aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                    </nav>
                """ + NEW_LINE;
    }


    public String generate() {
        stringBuilder.setLength(0);
        return stringBuilder.append(getDocType())
                .append(getHtmlStartTag())
                .append(getHeadTag())
                .append(getStartTagFor(BODY_TAG))
                .append(getNavTag())
                .append(generateMiniTitle())
                .append(getStartTagWithClass(DIV_TAG, "row"))
                .append(getStartTagWithClass("table", "table"))
                .append(getTHeadTag())
                .append(getStartTagFor("tbody"))
                .append(generate40things(loadProgressData()))
                .append(getEndFor("tbody"))
                .append(getEndFor("table"))
                .append(getEndFor(DIV_TAG))
                .append(getStartTagFor(DIV_TAG))
                .append(generateLogs())
                .append(getEndFor(DIV_TAG))
                .append(getEndFor("body"))
                .append(getEndFor("html"))
                .toString();
    }

    // just to use #40b440 as color :D
    private String generateMiniTitle() {
        return """
                <h2 style="color:#40b440">21 things to do at 41 year old</h2>
                """;
    }


    public String generate40things(List<String> todoList) {
        StringBuilder fortyList = new StringBuilder();
        for (int index = 0; index < todoList.size(); index++) {
            addOpenTagIfIsFirstElement(fortyList, index);
            System.out.println(todoList);
            String[] item = todoList.get(index).split(COLUMN_SEPARATOR);
            fortyList.append(TAB)
                    .append(getStartTagWithClass(TD_TAG, Status.getStatusFrom(item[STATUS]).getCssClass()))
                    .append(item[WHAT])
                    .append(addDetailsIfMultistage(item))
                    .append(getEndFor(TD_TAG));

            if (isNewRow(todoList, index)) {
                fortyList.append(getEndFor(TR_TAG)).append(NEW_LINE).append(getStartTagFor(TR_TAG)).append(NEW_LINE);
            } else if (isLastClosingTag(todoList, index)) {
                fortyList.append(getEndFor(TR_TAG));
            }

        }
        return fortyList.toString();
    }


    private String generateLogs() {
        List<String> logsList = loadLogData();
        Collections.reverse(loadLogData());
        StringBuilder logs = new StringBuilder();

        logs.append(getStartTagFor(H4_TAG))
                .append("Progress log:")
                .append(getEndFor(H4_TAG));
        logs.append(getStartTagFor(ORDERED_LIST_TAG));

        addLogLines(logsList, logs);
        logs.append(getEndFor(ORDERED_LIST_TAG));
        return logs.toString();
    }

    private void addLogLines(List<String> logsList, StringBuilder logs) {
        for (String entry : logsList) {
            String[] item = entry.split(COLUMN_SEPARATOR);

            logs.append(getStartTagFor(LI_TAG))
                    .append(getLogDate(item))
                    .append(" - ")
                    .append(item[LOG_MESSAGE])
                    .append(getEndFor(LI_TAG));
        }
    }

    private String getLogDate(String[] item) {
        return LocalDate.of(parseInt(item[LOG_DATE].substring(0, 4)), parseInt(item[LOG_DATE].substring(4, 6)), parseInt(item[LOG_DATE].substring(6))).toString();
    }

    private boolean isNewRow(List<String> todoList, int index) {
        return index % 4 == 3 && todoList.size() - 1 != index;
    }

    private String addDetailsIfMultistage(String[] item) {
        if (item.length == 4) {
            return " [%s/%s]".formatted(item[CURRENT_STEP], item[ALL_STEPS]);
        }
        return EMPTY_STRING;
    }

    private void addOpenTagIfIsFirstElement(StringBuilder fortyList, int index) {
        if (index == 0) {
            fortyList.append(getStartTagFor(TR_TAG)).append(NEW_LINE);
        }
    }

    private boolean isLastClosingTag(List<String> todoList, int index) {
        return index != 0 && todoList.size() - 1 == index;
    }

    private List<String> loadProgressData() {
        return loadFileFromResourceAsListOfStrings("forty-one.txt");
    }

    private List<String> loadLogData() {
        return loadFileFromResourceAsListOfStrings("forty-one-log.txt");
    }

    public boolean saveAsHtml(String path) {
        return saveTextToFile(stringBuilder.toString(), path);
    }

    @SuppressWarnings("SameReturnValue")
    private String getTHeadTag() {
        return """
                        <thead>
                        <tr>
                            <th scope="col">TO DO</th>
                            <th scope="col">while</th>
                            <th scope="col">Forty One</th>
                            <th scope="col">List</th>
                        </tr>
                        </thead>
                """;
    }
}
