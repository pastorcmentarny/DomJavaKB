package dms.pastor.tools.trips.train.options;

import dms.pastor.tools.trips.common.options.Option;
import dms.pastor.tools.trips.common.options.DisplayUndergroundStatisticOption;

import java.util.HashMap;
import java.util.Map;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-command-pattern
 * <p>
 */
public final class OptionsFactory {
    private final Map<Integer, Option> options;

    private OptionsFactory() {
        this.options = new HashMap<>();
    }

    public static OptionsFactory getOptions() {
        final OptionsFactory options = new OptionsFactory();

        // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
        options.addOptions(0, new DisplayUndergroundStatisticOption());
        return options;
    }

    private void addOptions(int input, Option option) {
        options.put(input, option);
    }

    public void displayAllAvailable() {
        System.out.println("0. Stats");
        System.out.println("9. Exit");
    }

}
