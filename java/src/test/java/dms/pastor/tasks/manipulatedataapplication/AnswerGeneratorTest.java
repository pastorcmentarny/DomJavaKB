package dms.pastor.tasks.manipulatedataapplication;

import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static dms.pastor.TestConfig.PATH;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class AnswerGeneratorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private AnswerGenerator answers;

    @Before
    public void setUp() throws Exception {
        answers = new AnswerGenerator(PATH + "manipulate-data.txt");
    }

    @Test
    public void acceptanceCriteria() {
        String result = "Number of male: 5. Average age of people is: 27. Jeff Briton is 29 day(s) older than Tom Sawyer.";

        final String answerGenerated = answers.generate();
        Assert.assertThat(answerGenerated, is(result));
    }

    @Test
    public void shouldThrowExceptionIfPersonNotFound() {
        // except
        exception.expect(Exception.class);

        // when
        answers.getPerson(RandomDataGenerator.generateString());
    }

}