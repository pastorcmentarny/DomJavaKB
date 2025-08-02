package dms.pastor.tasks.fifinder;

import static dms.pastor.utils.StringUtils.*;

/**
 * Author Dominik Symonowicz
 * Created 03/11/2016
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class Initials {

    private static final char DOT = '.';
    private static final String DASH = "-";

    private final Name fullName;
    private String initials = EMPTY_STRING;

    Initials(Name fullName) {
        this.fullName = fullName;
    }

    String getInitials() {

        createInitialsFromFirstName();
        createInitialsFromMiddleNames();
        createInitialsFromLastNames();

        return initials;
    }

    String getInitialsFromFirstAndLastNameOnly() {

        createInitialsFromFirstName();
        createSingleInitialFromLastNames();

        return initials;
    }

    // it is too few concatenation to have negative effect on performance
    @SuppressWarnings("StringConcatenationInLoop")
    private void createInitialsFromLastNames() {
        if (isNotNull(fullName.last())) {
            final String splitBy = fullName.last().contains(DASH) ? DASH : WHITESPACE;
            initials = addSpace();
            for (String last : fullName.last().split(splitBy)) {
                initials = addSpace();
                initials += capitalizeFirstCharacter(last) + DOT;
            }
        }
    }

    // it is too few concatenation to have negative effect on performance
    private void createSingleInitialFromLastNames() {
        if (isNotNull(fullName.last())) {
            initials = addSpace();
            initials += capitalizeFirstCharacter(fullName.last()) + DOT;
        }
    }

    // it is too few concatenation to have negative effect on performance
    @SuppressWarnings("StringConcatenationInLoop")
    private void createInitialsFromMiddleNames() {
        if (isNotNull(fullName.middles())) {
            for (String name : fullName.middles().split(WHITESPACE)) {
                initials += capitalizeFirstCharacter(name) + DOT;
                initials = addSpace();
            }
            initials = removeSpace();
        }
    }

    private void createInitialsFromFirstName() {
        if (isNotNull(fullName.first())) {
            initials += capitalizeFirstCharacter(fullName.first()) + DOT;
            if (isNotNull(fullName.middles())) {
                initials = addSpace();
            }
        }
    }

    private String addSpace() {
        initials += WHITESPACE;
        return initials;
    }

    private String removeSpace() {
        initials = initials.substring(0, initials.length() - 1);
        return initials;
    }

    private boolean isNotNull(String value) {
        return value != null;
    }
}
