package dms.pastor.tools.trips.train.station;

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
 */
public class TrainStation {//} implements Station {
    public static final String SEPARATOR = ";;";
    private final String name;
    private Status status;
    private LocalDate passedDate;
    private LocalDate visitedDate;
    private LocalDate thisYearVisitedDate;
    private boolean blogged;

    public TrainStation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
