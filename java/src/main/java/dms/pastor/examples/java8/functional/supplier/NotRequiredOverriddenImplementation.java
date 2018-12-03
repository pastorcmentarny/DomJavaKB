package dms.pastor.examples.java8.functional.supplier;

public final class NotRequiredOverriddenImplementation implements NotRequiredInterface {

    private static final String NOT_REQUIRED = "Overridden not required implementation ";

    @Override
    public String notRequired() {
        return NOT_REQUIRED;
    }
}
