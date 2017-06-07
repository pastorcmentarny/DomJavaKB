package dms.pastor.tasks.fifinder;

import org.junit.Test;

import static dms.pastor.tasks.fifinder.NameBuilder.nameBuilder;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 04/11/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class InitialsTest {
    private static final char SPACE = ' ';
    private static final String FIRST_NAME = "Jessica";
    private static final String MIDDLE_NAME = "Sophie";
    private static final String MIDDLE_NAMES = MIDDLE_NAME + " Marie";
    private static final String LAST_NAME = "Abernathy";
    private static final String SECOND_LAST_NAME = "Tremaine";
    private static final String LAST_NAMES_WITH_DASH = LAST_NAME + '-' + SECOND_LAST_NAME;
    private static final String LAST_NAMES_WITH_SPACE = LAST_NAME + SPACE + SECOND_LAST_NAME;
    private static final String FIRST_NAME_INITIAL = "J.";
    private static final String MIDDLE_NAME_INITIAL = "S.";
    private static final String LAST_NAME_INITIAL = "  A.";
    private static final String MIDDLE_NAMES_INITIALS = "S. M.";
    private static final String LAST_NAMES_INITIALS = "  A. T.";
    private Initials i;

    @Test
    public void getInitialsAcceptanceCriteriaTest() throws Exception {
        // given
        Name name = nameBuilder()
                .first(FIRST_NAME)
                .middles(MIDDLE_NAMES)
                .last(LAST_NAMES_WITH_DASH)
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then it should return first character of first and middle names then double space and first character of surnames
        assertThat(initials).isEqualTo("J. S. M.  A. T.");
    }

    @Test
    public void getInitialsFromFirstAndLastNameAcceptanceCriteriaTest() throws Exception {
        // given
        Name name = nameBuilder()
                .first(FIRST_NAME)
                .middles(MIDDLE_NAMES)
                .last(LAST_NAMES_WITH_DASH)
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitialsFromFirstAndLastNameOnly();

        // then it should return first character of first and middle names then double space and first character of surnames
        assertThat(initials).isEqualTo("J.  A.");
    }

    @Test
    public void shouldReturnEmptyStringIfFirstMiddleAndLastNameIsNull() throws Exception {
        // given
        final Name name = nameBuilder()
                .first(null)
                .middles(null)
                .last(null)
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEmpty();
    }

    @Test
    public void shouldReturnInitialsForFirstNameOnly() throws Exception {
        // given
        final Name name = nameBuilder()
                .first(FIRST_NAME)
                .withoutMiddleName()
                .withoutLastName()
                .build();
        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo(FIRST_NAME_INITIAL);
    }

    @Test
    public void shouldReturnInitialsForMiddleNameOnly() throws Exception {
        // given
        final Name name = nameBuilder()
                .withoutFirstName()
                .middles(MIDDLE_NAME)
                .withoutLastName()
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo(MIDDLE_NAME_INITIAL);
    }

    @Test
    public void shouldReturnInitialsForMiddleNamesOnly() throws Exception {
        // given
        final Name name = nameBuilder()
                .withoutFirstName()
                .middles(MIDDLE_NAMES)
                .withoutLastName()
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo(MIDDLE_NAMES_INITIALS);
    }

    @Test
    public void shouldHaveSpaceBetweenFirstAndMiddleName() throws Exception {
        // given
        final Name name = nameBuilder()
                .first(FIRST_NAME)
                .middles(MIDDLE_NAMES)
                .last(null)
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo("J. S. M.");
    }

    @Test
    public void shouldReturnInitialsForLastNameOnly() throws Exception {
        // given
        final Name name = nameBuilder()
                .withoutFirstName()
                .withoutMiddleName()
                .last(LAST_NAME)
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo(LAST_NAME_INITIAL);
    }

    @Test
    public void shouldReturnInitialsForLastNamesWithSpaceOnly() throws Exception {
        // given
        final Name name = nameBuilder()
                .withoutFirstName()
                .withoutMiddleName()
                .last(LAST_NAMES_WITH_SPACE)
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo(LAST_NAMES_INITIALS);
    }

    @Test
    public void shouldReturnInitialsForLastNamesWithDashOnly() throws Exception {
        // given
        final Name name = nameBuilder()
                .withoutFirstName()
                .withoutMiddleName()
                .last(LAST_NAMES_WITH_DASH)
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo(LAST_NAMES_INITIALS);
    }

    @Test
    public void shouldReturnInitialsForFirstNameOnlyWithCapitalLetter() throws Exception {
        // given
        final Name name = nameBuilder()
                .first(FIRST_NAME.toLowerCase())
                .withoutMiddleName()
                .withoutLastName()
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo(FIRST_NAME_INITIAL);
    }

    @Test
    public void shouldReturnFirstCharacterOfFirstAndLastName() throws Exception {
        // given
        final Name name = nameBuilder()
                .first(FIRST_NAME)
                .last(LAST_NAME)
                .withoutMiddleName()
                .build();

        i = new Initials(name);

        // when
        final String initials = i.getInitials();

        // then
        assertThat(initials).isEqualTo("J.  A.");
    }
}