package dms.pastor.tools.trips.train.station;

//status X -> P -> S -> C -> V
public enum StationProgressStatus {
    NOT_VISITED("X"),
    PASSED("P"),
    VISITED("V"),
    STOPPED("S"),
    CHANGED_AT("C");

    StationProgressStatus(String statusCode) {
    }
}
