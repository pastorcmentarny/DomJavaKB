package dms.coffirgar.transportmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Map;

import static dms.coffirgar.transportmanager.configurations.Constants.*;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class DataResponse {

    private String result;
    private String description;
    private Map<String, String> data;

    //FIXME
    public String getResult() {
        return result;
    }

    //FIXME
    public String getDescription() {
        return description;
    }

    //FIXME
    public Map<String, String> getData() {
        return data;
    }

    public static DataResponse ok(Map<String, String> data) {
        return new DataResponse(OK, EMPTY, data);
    }

    public static DataResponse error(String errorMessage) {
        return new DataResponse(ERROR, "Something went badly wrong and we got this sad error message: " + errorMessage, Collections.emptyMap());
    }
}

