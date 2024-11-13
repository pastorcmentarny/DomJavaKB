package dms.pastor.tools.trips.common.options;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.Config;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

import java.util.*;

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
        this.options = new TreeMap<>();
    }

    public static OptionsFactory getUndergroundOptions(Scanner scanner) {
        final OptionsFactory options = new OptionsFactory();

        // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
        options.addOptions(0, new DisplayUndergroundStatisticOption());
        options.addOptions(1, new DisplayStatusForAllStationsOption());
        options.addOptions(2, new DisplayStatusForSelectedStationOption(scanner));
        options.addOptions(3, new UpdateStationStatusToPassedOption(scanner));
        options.addOptions(4, new UpdateStationStatusToVisitedOption(scanner));
        options.addOptions(5, new BloggedOption(scanner));
        options.addOptions(6, new SaveOption());
        options.addOptions(7, new LoadStationOption());
        options.addOptions(8, new DisplayAllStationsNameOption());
        options.addOptions(13, new DisplayStatusForSpecificLineOption(scanner));
        if (Config.SHOW_HIDDEN_OPTIONS) {
            options.addOptions(101, new ClearThisYearOption());
        }
        return options;
    }

    public static OptionsFactory getOvergroundOptions(Scanner scanner) {
        final OptionsFactory options = new OptionsFactory();

        // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
        options.addOptions(0, new DisplayOvergroundStatisticOption());
        options.addOptions(11, new DisplayStatusForAllStationsOption());
        options.addOptions(12, new DisplayStatusForSelectedStationOption(scanner));
        options.addOptions(13, new DisplayAllStationsNameOption());
        options.addOptions(21, new UpdateStationStatusToPassedOption(scanner));
        options.addOptions(22, new UpdateStationStatusToVisitedOption(scanner));
        options.addOptions(23, new BloggedOption(scanner));
        options.addOptions(41, new SaveOption());
        options.addOptions(42, new LoadStationOption());
        if (Config.SHOW_HIDDEN_OPTIONS) {
            options.addOptions(101, new ClearThisYearOption());
        }
        return options;
    }

    private void addOptions(int input, Option option) {
        options.put(input, option);
    }

    public void selectOption(int option, Stations stations, StationType type) {
        if (options.containsKey(option)) {
            options.get(option).choose(stations, type);
        } else {
            throw new NotFoundException("Selected option " + option);
        }
    }

    public void displayAllAvailable() {
        Collections.sort(new ArrayList<>(options.keySet()));
        options.forEach((commandCode, option) -> System.out.println(option.getCommandTitle(commandCode)));
        System.out.println("9. Exit");
    }

}
