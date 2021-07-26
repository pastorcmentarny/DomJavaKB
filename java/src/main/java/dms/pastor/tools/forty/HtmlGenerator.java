package dms.pastor.tools.forty;

import dms.pastor.utils.file.TextFileUtils;

import java.util.ArrayList;
import java.util.List;

import static dms.pastor.utils.StringUtils.NEW_LINE;

public class HtmlGenerator {
    private static final StringBuilder stringBuilder = new StringBuilder("");
    private static final int WHAT = 0;
    private static final int STATUS = 1;
    private static final String TAB = "    ";
    private static final int LOG_DATE = 0;
    private static final int LOG_MESSAGE = 1;

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
                    <title>40 thing to do before 40 years old.</title>
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
                .append(getStartTagFor("body"))
                .append(getNavTag())
                .append(getStartTagWithClass("div", "row"))
                .append(getStartTagWithClass("table", "table"))
                .append(getTHeadTag())
                .append(getStartTagFor("tbody"))
                .append(generate40things(loadData()))
                .append(getEndFor("tbody"))
                .append(getEndFor("table"))
                .append(getEndFor("div"))
                .append(getStartTagFor("div"))
                .append(generateLogs())
                .append(getEndFor("div"))
                .append(getEndFor("body"))
                .append(getEndFor("html"))
                .toString();
    }

    //TODO implement
    private String generateLogs() {
        List<String> logsList = new ArrayList<>();
        logsList.add("20210726;;read 5 books to J");
        logsList.add("20210708;;Buy trees to donate");
        StringBuilder logs = new StringBuilder("");
        logs.append(getStartTagFor("h4"))
                .append("Progress log:")
                .append(getEndFor("h4"));
        logs.append(getStartTagFor("ol"));
        for (String entry : logsList) {
            String[] item = entry.split(";;");
            logs.append(getStartTagFor("li"))
                    .append(item[LOG_DATE])
                    .append(" - ")
                    .append(item[LOG_MESSAGE])
                    .append(getEndFor("li"));
        }
        logs.append(getEndFor("ol"));
        return logs.toString();
    }

    public String generate40things(List<String> todoList) {
        StringBuilder fortyList = new StringBuilder("");
        for (int i = 0; i < todoList.size(); i++) {
            addOpenTagIfIsFirstElement(fortyList, i);

            String[] item = todoList.get(i).split(";;");
            fortyList.append(TAB)
                    .append(getStartTagWithClass("td", Status.getStatusFrom(item[STATUS]).getCssClass()))
                    .append(item[WHAT])
                    .append(getEndFor("td"));

            if (i % 4 == 3 && todoList.size() - 1 != i) {
                fortyList.append("</tr>" + NEW_LINE + "<tr>" + NEW_LINE);
            } else if (isLastClosingTag(todoList, i)) {
                fortyList.append("</tr>");
            }

        }
        return fortyList.toString();
    }

    private void addOpenTagIfIsFirstElement(StringBuilder fortyList, int i) {
        if (i == 0) {
            fortyList.append("<tr>").append(NEW_LINE);
        }
    }

    private boolean isLastClosingTag(List<String> todoList, int i) {
        return i != 0 && todoList.size() - 1 == i;
    }

    private List<String> loadData() {
        return TextFileUtils.loadFileFromResourceAsListOfStrings("fortyB440.txt");
    }

    public boolean saveAsHtml() {
        return TextFileUtils.saveTextToFile(stringBuilder.toString(), "B:\\GitHub\\denva\\src\\templates\\40b440.html");
    }

    private String getTHeadTag() {
        return """
                        <thead>
                        <tr>
                            <th scope="col">Forty(40)</th>
                            <th scope="col">Before(b4)</th>
                            <th scope="col">Forty(40)</th>
                            <th scope="col">List</th>
                        </tr>
                        </thead>
                """;
    }
}
