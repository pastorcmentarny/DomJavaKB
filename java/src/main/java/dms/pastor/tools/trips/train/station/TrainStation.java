package dms.pastor.tools.trips.train.station;

import dms.pastor.domain.exception.NotImplementYetException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 23/05/2018
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 *         NOT_VISITED("X"),
 *     PASSED("P"),
 *     STOPPED("S"),
 *     CHANGED_AT("C");
 *     VISITED("V"),
 * City;;Code;;Date-passed;;date-stopped-at;;date-change-at;;date-visited;;X;;O;;N
 *
 */
@Getter
@ToString
@AllArgsConstructor
public class TrainStation {
    private static final String AT = " at ";
    private final String name;
    private StationProgressStatus stationProgressStatus;
    private StationStatus stationStatus;
    private LocalDate passedDate;
    private LocalDate stoppedDate;
    private LocalDate changeAtDate;
    private LocalDate visitedDate;
    private LocalDate thisYearVisitedDate;
    private boolean blogged;


    @SuppressWarnings("UnnecessaryDefault") //default used in case if add new
    private String getProgressStatusDateToDisplay() {
        return switch (stationProgressStatus) {
            case STOPPED -> AT + getStoppedDate();
            case CHANGED_AT -> AT + getChangeAtDate();
            case VISITED -> AT + getVisitedDate();
            case PASSED -> AT + getPassedDate();
            case NOT_VISITED -> EMPTY_STRING;
            default -> throw new NotImplementYetException();
        };
    }
}
