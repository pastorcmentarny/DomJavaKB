package dms.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

import static dms.coffirgar.transportmanager.configurations.Constants.EMPTY;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
    private String name;
    private String status;
    private String passedDate;
    private String visitedDate;
    private String thisYearVisitedDate;

    public static Station noStation(){
        return new Station(EMPTY,EMPTY,EMPTY,EMPTY,EMPTY);
    }
}
