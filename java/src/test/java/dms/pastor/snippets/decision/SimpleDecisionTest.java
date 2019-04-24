package dms.pastor.snippets.decision;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 19/04/2018
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class SimpleDecisionTest {
    private final List<Vote> voters = List.of(new IsMatureVoter(), new IsInternationalStudentVoter());

    @Test
    public void shouldReturnPositiveDecision() {
        // given
        final Citizen citizen = new Citizen("Terry", 20, false);

        // when
        final boolean decision = new SimpleDecision(voters, citizen).makeDecision();

        // then
        assertThat(decision).isTrue();
    }

    @Test
    public void shouldReturnNegativeDecision() {
        // given
        final String name = "Janice";
        final Citizen citizen = new Citizen(name, 15, true);
        final SimpleDecision decision = new SimpleDecision(voters, citizen);

        // when
        final boolean result = decision.makeDecision();

        // then
        assertThat(result).isFalse();
        assertThat(decision.getReasons()).isEqualToIgnoringNewLines(name + " was rejected due:\nYou need to be 18 years old.\n" +
            "You need be an international student.");
    }

}