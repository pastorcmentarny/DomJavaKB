package dms.pastor.tasks.fifinder;

/**
 * Author Dominik Symonowicz
 * Created 03/11/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Initials {
    private static final char DOT = '.';
    private static final String SPACE = " ";
    private static final String DASH = "-";

    private final Name fullName;
    private String initials = "";

    public Initials(Name fullName) {
        this.fullName = fullName;
    }

    public String getInitials() {

        createInitialsFromFirstName();
        createInitialsFromMiddleNames();
        createInitialsFromLastNames();

        return initials;
    }

    public String getInitialsFromFirstAndLastNameOnly() {

        createInitialsFromFirstName();
        createSingleInitialFromLastNames();

        return initials;
    }

    // it is too few concatenation to have negative effect on performance
    @SuppressWarnings("StringConcatenationInLoop")
    private void createInitialsFromLastNames() {
        if (isNotNull(fullName.getLast())) {
            final String splitBy = fullName.getLast().contains(DASH) ? DASH : SPACE;
            initials = addSpace();
            for (String last : fullName.getLast().split(splitBy)) {
                initials = addSpace();
                initials += getFirstCharacterCapitalized(last) + DOT;
            }
        }
    }

    // it is too few concatenation to have negative effect on performance
    private void createSingleInitialFromLastNames() {
        if (isNotNull(fullName.getLast())) {
            initials = addSpace();
            initials += getFirstCharacterCapitalized(fullName.getLast()) + DOT;
        }
    }

    // it is too few concatenation to have negative effect on performance
    @SuppressWarnings("StringConcatenationInLoop")
    private void createInitialsFromMiddleNames() {
        if (isNotNull(fullName.getMiddles())) {
            for (String name : fullName.getMiddles().split(SPACE)) {
                initials += getFirstCharacterCapitalized(name) + DOT;
                initials = addSpace();
            }
            initials = removeSpace();
        }
    }

    private void createInitialsFromFirstName() {
        if (isNotNull(fullName.getFirst())) {
            initials += getFirstCharacterCapitalized(fullName.getFirst()) + DOT;
            if (isNotNull(fullName.getMiddles())) {
                initials = addSpace();
            }
        }
    }

    private String addSpace() {
        initials += SPACE;
        return initials;
    }

    private String removeSpace() {
        initials = initials.substring(0, initials.length() - 1);
        return initials;
    }


    private String getFirstCharacterCapitalized(String string) {
        return string.substring(0, 1).toUpperCase();
    }

    private boolean isNotNull(String value) {
        return value != null;
    }
}
