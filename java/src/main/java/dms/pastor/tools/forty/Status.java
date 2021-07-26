package dms.pastor.tools.forty;

public enum Status {
    WORKING_ON("I did some progress,but recently there is no progress", "table-primary"),
    IN_PROGRESS("Currently in progress to complete", "table-info"),
    BLOCKED("Progress is blocked by external factors", "table-danger"),
    PAUSED("Progress was paused, to do other tasks", "table-warning"),
    TO_DO("I didn't start work on it.", "table-light"),
    FAILED("I didn't complete it", "table-dark"),

    DONE("Done :D", "table-success");
    private final String statusDescription;
    private final String cssClass;

    Status(String statusDescription, String cssClass) {
        this.statusDescription = statusDescription;
        this.cssClass = cssClass;
    }

    public static Status getStatusFrom(String statusAsText){
        return Status.valueOf(statusAsText);
    }

    public String getCssClass() {
        return cssClass;
    }
}
