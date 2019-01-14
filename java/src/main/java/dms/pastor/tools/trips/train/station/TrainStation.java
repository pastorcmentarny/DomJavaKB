package dms.pastor.tools.trips.train.station;

import dms.pastor.tools.trips.common.options.State;
import dms.pastor.tools.trips.common.options.Status;

import java.time.LocalDate;

/**
 * Author Dominik Symonowicz
 * Created 23/05/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
 * Aberystwyth;;none;;none;;none;;X;;O;;N
 */
public class TrainStation {
    public static final String SEPARATOR = ";;";
    private final String name;
    private LocalDate passedDate;
    private LocalDate changedDate;
    private LocalDate visitedDate;
    private Status status;
    private State state;
    private boolean blogged;

    public TrainStation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
