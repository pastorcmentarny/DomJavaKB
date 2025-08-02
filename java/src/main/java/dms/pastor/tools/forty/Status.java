package dms.pastor.tools.forty;

import lombok.Getter;

@SuppressWarnings("unused") //it is used due to tranformation from file
public enum Status {
    WORKING_ON("I did some progress,but recently there is no progress", "table-primary"),
    IN_PROGRESS("Currently in progress to complete", "table-info"),
    BLOCKED("Progress is blocked by external factors", "table-danger"),
    PAUSED("Progress was paused, to do other tasks", "table-warning"),
    TO_DO("I didn't start work on it.", "table-light"),
    FAILED("I didn't complete it", "table-secondary"),
    ABANDONED("I decided to not doing", "table-dark"),
    DONE("Done :D", "table-success");
    @Getter
    private final String cssClass;

    Status(String statusDescription, String cssClass) {
        this.cssClass = cssClass;
    }

    public static Status getStatusFrom(String statusAsText) {
        return Status.valueOf(statusAsText);
    }


}
