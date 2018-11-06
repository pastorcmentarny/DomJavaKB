package dms.pastor.tasks.sunspotanalyser.data;

import dms.pastor.domain.Result;
import dms.pastor.utils.randoms.RandomDataGenerator;
import org.junit.Test;

import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 22/04/2012
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ResultsTest {

    private Result result;

    @Test
    public void shouldCreateSuccessResultTest() {
        // when
        result = Result.<Object>success();

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getMessage()).isEqualTo("Success");
    }

    @Test
    public void shouldCreateFailResultTest() {
        // when
        result = Result.<Object>fail();

        // then
        assertThat(result.isFail()).isTrue();
        assertThat(result.getMessage()).isEqualTo("Fail");
    }

    @Test
    public void shouldCreateSuccessResultWithMessageTest() {
        // given
        final String message = generateString(20);

        // when
        result = Result.success(message);

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getMessage()).isEqualTo(message);
    }

    @Test
    public void shouldCreateFailResultWithMessageTest() {
        // given
        final String message = generateString();

        // when
        result = Result.<String>fail(message);

        // then
        assertThat(result.isFail()).isTrue();
        assertThat(result.getMessage()).isEqualTo(message);
    }

    @Test
    public void shouldCreateSuccessResultWithMessageAndObjectTest() {
        // given
        final String message = generateString();
        final Object object = new Object();

        // when
        result = new Result<>(true, message, object);

        // then
        assertThat(result.isSuccess()).isTrue();
        assertThat(result.getMessage()).isEqualTo(message);
        assertThat(result.getItem()).isEqualTo(object);
    }

    @Test
    public void shouldCreateFailResultWithMessageAndObjectTest() {
        // given
        final String message = generateString();
        final Object object = new Object();

        // when
        result = new Result<>(false, message, object);

        // then
        assertThat(result.isFail()).isTrue();
        assertThat(result.getMessage()).isEqualTo(message);
    }

    @Test
    public void shouldUpdateMessageTest() {
        // given
        final String test = "Test";
        final String item = "Item";
        final String asString = "Result{" +
                "\n\tsuccess: true" +
                "\n\tmessage: \'" + test + '\'' +
                "\n\thasItem: " + item +
                "\n}";

        // when
        Result<String> resultWithMessage = new Result<>(false, "Unknown", null);
        resultWithMessage.setSuccess();
        resultWithMessage.setMessage(null);

        // then
        assertThat(resultWithMessage.getMessage()).isEqualTo("Unknown");

        // when
        resultWithMessage.setMessage(test);
        resultWithMessage.setItem(item);

        // then
        assertThat(resultWithMessage.getMessage()).isEqualTo(test);
        assertThat(resultWithMessage.getItem()).isInstanceOf(String.class);
        assertThat(resultWithMessage.toString()).isEqualTo(asString);
    }

    @Test
    public void shouldGetNumberOfResultsTest() {
        // given
        final Results results = new Results();

        final int size = 6;
        for (int i = 0; i < size; i++) {
            results.addScore(new Score(RandomDataGenerator.randomPositiveInteger(), RandomDataGenerator.randomPositiveInteger(), RandomDataGenerator.randomPositiveInteger()));
        }

        // when
        final int resultSize = results.getResultSize();

        // then
        assertThat(resultSize).isEqualTo(size);
    }
}
