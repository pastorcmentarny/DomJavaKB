package dms.pastor.tools.trips.common.options;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.Config;
import dms.pastor.tools.trips.common.station.StationType;
import dms.pastor.tools.trips.common.station.Stations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
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

    private void addOptions(int input, Option option) {
        options.put(input, option);
    }

    public void selectOption(int option, Stations stations, StationType type) {
        if (options.containsKey(option)) {
            options.get(option).choose(stations,type);
        } else {
            throw new NotFoundException("Selected option " + option);
        }
    }

    public void displayAllAvailable() {
        options.forEach((commandCode, option) -> System.out.println(option.getCommandTitle(commandCode)));
        System.out.println("9. Exit");
    }

}
