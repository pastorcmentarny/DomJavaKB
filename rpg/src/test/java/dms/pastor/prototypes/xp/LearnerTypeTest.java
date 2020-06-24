package dms.pastor.prototypes.xp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LearnerTypeTest {

    @Test
    public void getModifierForCleverLearnerShould107() {
        // when
        final var modifier = LearnerType.GENIUS_LEARNER.getModifier();

        // then
        assertThat(modifier).isEqualTo(1.07f);

    }

}