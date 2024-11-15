package dms.pastor.tasks.manipulatedataapplication;

import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dms.pastor.TestConfig.PATH;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AnswerGeneratorTest {

    private AnswerGenerator answers;

    @BeforeEach
    public void setUp() throws Exception {
        answers = new AnswerGenerator(PATH + "manipulate-data.txt");
    }

    @Test
    public void acceptanceCriteria() {
        String result = "Number of male: 5. Average age of people is: 27. Jeff Briton is 29 day(s) older than Tom Sawyer.";

        final String answerGenerated = answers.generate();
        assertThat(answerGenerated).isEqualTo(result);
    }

    @Test
    public void shouldThrowExceptionIfPersonNotFound() {
        // when
        Assertions.assertThrows(PersonNotFoundException.class, () -> answers.getPerson(RandomDataGenerator.generateString()));
    }

}