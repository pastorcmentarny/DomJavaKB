package dms.pastor.tasks.analyser;

import static java.io.File.separator;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class AnalyserLauncher {

    @SuppressWarnings("AccessOfSystemProperties")
    static final String THIS_PROJECT_PATH = System.getProperty("user.dir") +
            separator + "src" + separator;
    private static final ProjectAnalyser ANALYSER = new ProjectAnalyser();

    private AnalyserLauncher() {
    }

    public static void main(String[] args) {

        String path = AnalyserLauncher.getPath(args);
        ANALYSER.analyse(path);
    }

    static String getPath(String[] args) {
        if (args == null || args.length != 1 || args[0] == null) {
            return THIS_PROJECT_PATH;
        }
        return args[0];
    }

}
