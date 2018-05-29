package dms.pastor.tools.trips.tube.options;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.tools.trips.common.options.Option;
import dms.pastor.tools.trips.tube.station.Stations;

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

    public static OptionsFactory getOptions(Scanner scanner) {
        final OptionsFactory options = new OptionsFactory();

        // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
        options.addOptions(0, new DisplayStatisticOption());
        options.addOptions(1, new DisplayStatusForAllStationsOption());
        options.addOptions(2, new DisplayStatusForOption(scanner));
        options.addOptions(3, new UpdateStationStatusToPassedOption(scanner));
        options.addOptions(4, new UpdateStationStatusToVisitedOption(scanner));
        options.addOptions(6, new SaveOption());
        options.addOptions(7, new LoadStationOption());
        options.addOptions(8, new DisplayAllStationsNameOption());

        return options;
    }

    private void addOptions(int input, Option option) {
        options.put(input, option);
    }

    public void selectOption(int option, Stations stations) {
        if (options.containsKey(option)) {
            options.get(option).choose(stations);
        } else {
            throw new NotFoundException("Selected option " + option);
        }
    }

    //TODO improve it
    public void displayAllAvailable() {
        System.out.println("0. Stats");
        System.out.println("1. Current Status for all station");
        System.out.println("2. Current Status for selected station");
        System.out.println("3. Update Status to Passed for station");
        System.out.println("4. Update Status to Visited for station");
        System.out.println("6. Save changes (with Backup)");
        System.out.println("7. Discard unsaved changes");
        System.out.println("8. Display list of all stations");
        System.out.println("9. Exit");
    }

}
