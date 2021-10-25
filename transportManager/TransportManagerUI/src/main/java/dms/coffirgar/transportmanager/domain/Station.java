package dms.coffirgar.transportmanager.domain;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Station {
    private final String name;
    private String status;
    private String passedDate;
    private String visitedDate;
    private String thisYearVisitedDate;
}
