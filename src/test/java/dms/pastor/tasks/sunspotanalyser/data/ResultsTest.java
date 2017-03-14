package dms.pastor.tasks.sunspotanalyser.data;


import dms.pastor.domain.Result;
import dms.pastor.utils.RandomDataGenerator;
import org.junit.Assert;
import org.junit.Test;

import static dms.pastor.utils.RandomDataGenerator.generateString;
import static dms.pastor.utils.RandomDataGenerator.randomInteger;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Author Dominik Symonowicz
 * Created 22/04/2012
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ResultsTest {
    private Result result;


    @Test
    public void shouldCreateSuccessResultTest() throws Exception {
        // when
        result = new Result(true);

        // then
        Assert.assertThat(result.isSuccess(), is(true));
        Assert.assertThat(result.getMessage(), is("Success"));
    }

    @Test
    public void shouldCreateFailResultTest() throws Exception {
        // when
        result = new Result(false);

        // then
        Assert.assertThat(result.isFail(), is(true));
        Assert.assertThat(result.getMessage(), is("Fail"));
    }

    @Test
    public void shouldCreateSuccessResultWithMessageTest() throws Exception {
        // given
        final String message = generateString(20);

        // when
        result = new Result(true, message);

        // then
        Assert.assertThat(result.isSuccess(), is(true));
        Assert.assertThat(result.getMessage(), is(message));
    }

    @Test
    public void shouldCreateFailResultWithMessageTest() throws Exception {
        // given
        final String message = generateString();

        // when
        result = new Result(false, message);

        // then
        Assert.assertThat(result.isFail(), is(true));
        Assert.assertThat(result.getMessage(), is(message));
    }

    @Test
    public void shouldCreateSuccessResultWithMessageAndObjectTest() throws Exception {
        // given
        final String message = generateString();
        final Object object = new Object();

        // when
        result = new Result(true, message, object);

        // then
        Assert.assertThat(result.isSuccess(), is(true));
        Assert.assertThat(result.getMessage(), is(message));
        Assert.assertThat(result.getItem(), is(object));
    }

    @Test
    public void shouldCreateFailResultWithMessageAndObjectTest() throws Exception {
        // given
        final String message = generateString();
        final Object object = new Object();

        // when
        result = new Result(false, message, object);

        // then
        Assert.assertThat(result.isFail(), is(true));
        Assert.assertThat(result.getMessage(), is(message));
    }

    @Test
    public void shouldUpdateMessageTest() throws Exception {
        // given
        final String test = "Test";
        final String item = "Item";
        final String asString = "Result{" +
                "\n\tsuccess: true" +
                "\n\tmessage: " + test + '\'' +
                "\n\thasItem: " + item +
                "\n}";

        // when
        final Result result = new Result(false);
        result.setSuccess(true);
        result.setMessage(null);

        // then
        Assert.assertThat(result.getMessage(), is("Unknown"));

        // when
        result.setMessage(test);
        result.setItem(item);

        // then
        Assert.assertThat(result.getMessage(), is(test));
        Assert.assertThat(result.getItem() instanceof String, is(true));
        Assert.assertThat(result.toString(), is(asString));

    }

    @Test
    public void shouldGetNumberOfResultsTest() throws Exception {
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
