package dms.pastor.spring.check.model.exception;

public class ResultNotFoundException extends RuntimeException {

    private static final String RESULT_NOT_FOUND_MESSAGE = "Result not found.";

    public ResultNotFoundException() {
        super(RESULT_NOT_FOUND_MESSAGE);
    }

    public ResultNotFoundException(String query) {
        super(RESULT_NOT_FOUND_MESSAGE + " Reason: " + query);
    }

}
