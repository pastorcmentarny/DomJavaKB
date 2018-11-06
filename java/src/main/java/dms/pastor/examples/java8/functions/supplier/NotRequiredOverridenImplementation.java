package dms.pastor.kb.java8.functions.supplier;

public final class NotRequiredOverridenImplementation implements NotRequiredInterface {

    private static final String NOT_REQUIRED = "Overridden not required implementation ";

    @Override
    public String notRequired() {
        return NOT_REQUIRED;
    }
}
