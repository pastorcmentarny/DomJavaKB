package dms.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static dms.coffirgar.transportmanager.configurations.Constants.EMPTY;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {

    private String name;
    private String status;
    private String passedDate;
    private String visitedDate;
    private String visitedThisYearDate;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getPassedDate() {
        return passedDate;
    }

    public String getVisitedDate() {
        return visitedDate;
    }

    public String getVisitedThisYearDate() {
        return visitedThisYearDate;
    }

    public static Station noStation() {
        return new Station(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY);
    }
}
