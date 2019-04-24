package dms.pastor.utils;

import dms.pastor.utils.transformers.ToUncheckedExceptionTransformer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 03/01/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ToUncheckedExceptionTransformerTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowRuntimeExceptionWhenCheckedExceptionIsThrown() {
        // expect
        exception.expect(RuntimeException.class);
        List<String> urlsToCrawl = Arrays.asList("https://dominiksymonowicz.com", "whoops");
        // given
        // when
        urlsToCrawl.stream()
            .map(ToUncheckedExceptionTransformer.transformToUncheckedException(FileWriter::new))
            .forEach(fileWriter -> System.out.println(fileWriter.toString()));

        // then

    }

}